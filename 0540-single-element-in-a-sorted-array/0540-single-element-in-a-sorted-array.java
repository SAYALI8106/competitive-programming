class Solution {
    public int singleNonDuplicate(int[] nums) {

        // brute force worst approach
        // TC = O(n^2)
        // SC = O(1)

        // if (nums.length == 1)
        //     return nums[0];

        // int single = -1;
        // for (int i = 0; i < nums.length; i++) {

        //     int frequency = 0;

        //     for (int j = 0; j < nums.length; j++) {
        //         if (nums[i] == nums[j]) {
        //             frequency++;
        //         }
        //     }

        //     if (frequency == 1) {
        //         single = nums[i];
        //         break;
        //     }

        // }

        // return single;

        // brute force better approach 1
        // TC: O(n)
        // SC: O(1)

        // int n = nums.length;
        // if (n == 1)
        //     return nums[0];

        // // for (int i = 0; i < n; i++) {
        // //     if (i == 0 && nums[i] != nums[i + 1])
        // //         return nums[i];
        // //     else if (i == (n - 1) && nums[i] != nums[i - 1])
        // //         return nums[i];
        // //     else if (i > 0 && i < n-1 && nums[i] != nums[i - 1] && nums[i] != nums[i + 1])
        // //         return nums[i];
        // // }

        // for (int i = 0; i < n; i++) {

        //     if (i == 0) {
        //         if (nums[i] != nums[i + 1]) {
        //             return nums[i];
        //         }
        //     }

        //     else if (i == (n - 1)) {
        //         if (nums[i] != nums[i - 1]) {
        //             return nums[i];
        //         }
        //     }

        //     else {
        //         if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1])
        //             return nums[i];
        //     }

        // }

        // return -1;

        // brute force better approach 2
        // TC: O(n)
        // SC: O(1)

        //     int n = nums.length;
        //     int ans = 0;

        //     for (int i = 0; i < n; i++) {
        //         ans = ans ^ nums[i];
        //     }

        //     return ans;

        // optimal approach 
        // TC: O(logN)
        // SC: O(1)
        int n = nums.length;

        if (n == 1)
            return nums[0];

        if (nums[0] != nums[1])
            return nums[0];

        if (nums[n - 1] != nums[n - 2])
            return nums[n - 1];

        int low = 1;
        int high = n - 2;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1])
                return nums[mid];

            if ((mid % 2 == 1 && nums[mid] == nums[mid - 1]) ||
                    (mid % 2 == 0 && nums[mid] == nums[mid + 1])) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}

// i = 1    
// freq = 2
// j = 1
//         0 1 2 3 4 5 6 7 8
// nums = [1,1,2,3,3,4,4,8,8] 

// mid = (0/8)2 = 4,  
// low = 0   high = 8

//   0 1 2 3 4 5 6 7
//  [3,3,7,7,10,11,11]
// low = 0 , high 7,   mid = 0+7/2 = 3

//  0 1 2  3  4  5  6
// [7,7,10,11,11,12,12]
// low = 1,   high = 5   mid = 1+5/2 = 3

//  0 1 2 3 4 5 6 7 8
// [1,1,2,3,3,4,4,8,8]
// low = 1   high = 7  mid = 1+7/2 = 4