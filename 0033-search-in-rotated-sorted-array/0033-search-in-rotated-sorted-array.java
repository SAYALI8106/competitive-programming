class Solution {
    public int search(int[] nums, int target) {
        // brute force
        // time -> O(n)
        // space -> O(1)
        // int idx =  0;

        // for(int i = 0; i < nums.length; i++){
        //     if(nums[i]== target) return i;
        // }

        // return -1;

        // optimal approach
        // time -> O(log n)
        // space -> O(1)

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (nums[mid] == target)
                return mid;

            // if left part is sorted
            if (nums[low] <= nums[mid]) {
                // if the target lies in the sorted left part
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                }
                // else in the righ part
                else {
                    low = mid + 1;
                }
            }
            // if right part is sorted
            else {

                // if the target lies in the sorted right part
                if (target <= nums[high] && target > nums[mid]) {
                    low = mid + 1;
                } // else in the left part
                else {
                    high = mid - 1;
                }

            }

        }

        return -1;
    }
}