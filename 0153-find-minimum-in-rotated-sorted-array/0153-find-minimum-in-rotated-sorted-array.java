class Solution {
    public int findMin(int[] nums) {
        int min = nums[0];

        // brute force
        // T(C) = O(n)
        // S(C) = O(1)
        for(int i = 0; i < nums.length; i++){
            if(nums[i]< min) min = nums[i];
        }

        return min;
    }
}