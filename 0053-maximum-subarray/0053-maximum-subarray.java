class Solution {
    public int maxSubArray(int[] nums) {
        // brute force
        // time -> O(n^3)
        // space -> O(1)
        // int maxSum = Integer.MIN_VALUE;
        // for (int startIndex = 0; startIndex < nums.length; startIndex++) {

        //     for (int endIndex = startIndex; endIndex < nums.length; endIndex++) {
        //         int currSum = 0;
        //         for (int i = startIndex; i <= endIndex; i++) {
        //             currSum += nums[i];
        //         }
        //         maxSum = Math.max(maxSum, currSum);
        //     }

        // }

        // return maxSum;

        // better approach
        // time -> O(n^2)
        // space -> O(1)
        // int maxSum = Integer.MIN_VALUE;
        // for (int i = 0; i < nums.length; i++) {
        //     int currSum = 0;
        //     for (int j = i; j < nums.length; j++) {
        //         currSum += nums[j];
        //         maxSum = Math.max(maxSum, currSum);
        //     }
        // }

        // return maxSum;

        // Optimal approach - using Kadane's Algorithm
        // time -> O(n)
        // space -> O(1)
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum > maxSum) {
                maxSum = sum;
            }

            if (sum < 0) {
                sum = 0;
            }
        }

        return maxSum;
    }
}