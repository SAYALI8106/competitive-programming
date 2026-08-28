class Solution {
    public int[] searchRange(int[] nums, int target) {
        // int startIdx = -1;
        // int endIdx = -1;
        // int n = nums.length;

        // for (int i = 0; i < n; i++) {
        //     if (nums[i] == target && startIdx == -1) {
        //         startIdx = i;
        //     }

        //     if (nums[i] == target) {
        //         endIdx = i;
        //     }
        // }

        // return new int[] { startIdx, endIdx };

        int low = 0;
        int high = nums.length - 1;
        int startIdx = -1;
        int endIdx = -1;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (nums[mid] == target) {
                startIdx = mid;
                high = mid - 1;
            }else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        // Reset
        low = 0;
        high = nums.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (nums[mid] == target) {
                endIdx = mid;
                low = mid + 1;
            }else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return new int[] { startIdx, endIdx };
    }
}

// nums = [5,7,7,8,8,10], target = 8
// low = 0,3   high = 5    mid = 2,4  
// startIdx =-1,  endIdx = -1,4