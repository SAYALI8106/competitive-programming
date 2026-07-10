class Solution {
    public void sortColors(int[] nums) {
        // brute force approach
        // time - O(n^2)
        // space -> O(1)
        // for (int i = 0; i < nums.length; i++) {
        //     for (int j = 1; j < nums.length; j++) {
        //         if (nums[j - 1] > nums[j]) {
        //             int temp = nums[j - 1];
        //             nums[j - 1] = nums[j];
        //             nums[j] = temp;
        //         }
        //     }
        // }

        // better approach
        // time -> O(n)
        // space -> O(1)
        // int count0 = 0;
        // int count1 = 0;
        // int count2 = 0;

        // for (int i = 0; i < nums.length; i++) {
        //     if (nums[i] == 0)
        //         count0++;
        //     if (nums[i] == 1)
        //         count1++;
        //     if (nums[i] == 2)
        //         count2++;
        // }

        // int index = 0;
        // while (count0-- > 0)
        //     nums[index++] = 0;
        // while (count1-- > 0)
        //     nums[index++] = 1;
        // while (count2-- > 0)
        //     nums[index++] = 2;

        // Optimal approach - Dutch National Flag algorithm
        // Time -> O(n)
        // Space -> O(1)
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                int temp = nums[mid];
                nums[mid] = nums[low];
                nums[low] = temp;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }
}

//  0 1 2
// [0,1,2]  low=1  mid=2  high=1