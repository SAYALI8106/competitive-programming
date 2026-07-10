class Solution {
    public void rotate(int[] nums, int k) {

        //  brute force
        //     int temp[]= new int[nums.length];

        //    for(int i=0; i< nums.length; i++){
        //     temp[(i+k)%nums.length]= nums[i];
        //    }

        //    for(int i =0; i< nums.length; i++){
        //     nums[i]= temp[i];
        //    }

        //  better approach
        // int n = nums.length;
        // k = k % n;  
        //  int temp[] = new int[k];    // temp = 5,6,7
        // for (int i = 0; i < k; i++) {
        //     temp[i] = nums[n - k + i];
        // }

        // for (int i = n-k-1; i >= 0 ; i--) {        // 0 1 2 3 4 5 6   
        //     nums[i+k] = nums[i];          //         [1,2,3,4,5,6,7] i= 3

        // }

        // for (int i = 0; i < k; i++) {
        //     nums[i] = temp[i];
        // }
        // optimal approach
        if (nums.length >= 1) {
            k = k % nums.length;
        }

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int nums[], int low, int high) {
        while (low < high) {
            int temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;
            low++;
            high--;
        }
    }
}
//         0 1 2 3 4 5 6   n = 7
// nums = [1,2,3,4,5,6,7], k = 3

// [7,6,5,4,3,2,1]
//  0 1 2 3 4 5 6
// [5,6,7,1,2,3,4]
