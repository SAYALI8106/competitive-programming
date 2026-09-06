class Solution {
    public int findMin(int[] nums) {
        // int min = nums[0];

        // // brute force
        // // T(C) = O(n)
        // // S(C) = O(1)
        // for(int i = 0; i < nums.length; i++){
        //     if(nums[i]< min) min = nums[i];
        // }

        // return min;

        //  optimal approach
        // T(C) = O(log n)
        // S(C) = O(1)

        int ans = Integer.MAX_VALUE;

        if (nums.length == 1)
            return nums[0];

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (nums[low] <= nums[mid]) {
                ans = Math.min(ans, nums[low]);
                low = mid + 1;
            } else {
                ans = Math.min(ans, nums[mid]);
                high = mid - 1;
            }
        }

        return ans;
    }
}
//         0 1 2 3 4
// nums = [3,4,5,1,2]   start = 3    end = 4,3,2
// mid = 0+4/2 = 2,    3+4/2 = 3,   3+3/2 = 3
// 

//  0  1  2  3
// [11,13,15,17]   low = 0 , high = 3, 1,0  
// mid = 0+3/2 = 1,    0+1/2 = 0,  0+0/2 = 0, 