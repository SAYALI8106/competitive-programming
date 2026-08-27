class Solution {
    public int maxProduct(int[] nums) {
        // Brute force
        // time -> O(n^2)
        // space -> O(n)
        // Initialize the answer with the first element
        // int maxProd = nums[0];

        // // Outer loop picks the starting index
        // for (int i = 0; i < nums.length; i++) {
        //     // Initialize current product to 1
        //     int prod = 1;

        //     // Inner loop picks the ending index
        //     for (int j = i; j < nums.length; j++) {
        //         // Multiply current number to product
        //         prod *= nums[j];

        //         // Update maximum product if needed
        //         maxProd = Math.max(maxProd, prod);
        //     }
        // }

        // // Return the result
        // return maxProd;

        // optimal approach
        // time -> O(n)
        // space -> O(1)

        // int max1 = nums[0];
        // int curr = 1;

        // for (int i = 0; i < nums.length; i++) {

        //     if (curr == 0) {
        //         curr = 1;
        //     }

        //     curr *= nums[i];
        //     max1 = Math.max(max1, curr);
        // }

        // int max2 = nums[nums.length - 1];
        // curr = 1;

        // for (int i = nums.length - 1; i >= 0; i--) {

        //     if (curr == 0) {
        //         curr = 1;
        //     }

        //     curr *= nums[i];
        //     max2 = Math.max(max2, curr);
        // }

        // return Math.max(max1, max2);

        int pre, suff;
        pre = suff = 1;
        int ans = Integer.MIN_VALUE;
        int n = nums.length;

        for (int i = 0; i < n; i++) {

            if (pre == 0) {
                pre = 1;
            }

            if (suff == 0) {
                suff = 1;
            }

            pre *= nums[i];
            suff *= nums[n - i - 1];

            ans = Math.max(ans, Math.max(pre, suff));
        }

        return ans;

    }
}

// [-2,0,-1]
// curr = -2
// max1 = -2