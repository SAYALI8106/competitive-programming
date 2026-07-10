class Solution {
    public int maxProfit(int[] prices) {
        // brute force
        // time --> O(n^2)
        // space --> O(1)
        // // Initialize max profit to 0
        //     int maxProfit = 0;

        //     // Loop through each day as a potential buy day
        //     for (int i = 0; i < prices.length; i++) {
        //         // Loop through each future day as a potential sell day
        //         for (int j = i + 1; j < prices.length; j++) {
        //             // Calculate profit
        //             int profit = prices[j] - prices[i];

        //             // Update max profit if higher
        //             maxProfit = Math.max(maxProfit, profit);
        //         }
        //     }

        //     // Return the maximum profit
        //     return maxProfit;

        // DP on Stocks
        //  time -> O(n)
        // space -> O(1)
        int maxProfit = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - min);
            }
        }

        return maxProfit;
    }
}