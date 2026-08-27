class Solution {
    public int searchInsert(int[] nums, int target) {
        int idx = nums.length;
        int low = 0;
        int high = nums.length-1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] == target) {
                idx = mid;
                break;
            }

            if (nums[mid] > target) {
                idx = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return idx;
    }
}

// [1,3,5,6]   target = 7
// low = 0, 2, 3  high = 3   mid = 1,2
