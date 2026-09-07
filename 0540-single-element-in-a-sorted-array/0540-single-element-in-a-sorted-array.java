class Solution {
    public int singleNonDuplicate(int[] nums) {

        // brute force
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

        // brute force better approach
        // TC: O(n)
        // SC: O(1)

        int n = nums.length;
        if (n == 1)
            return nums[0];

        for (int i = 0; i < n; i++) {
            if (i == 0 && nums[i] != nums[i + 1])
                return nums[i];
            else if (i == (n - 1) && nums[i] != nums[i - 1])
                return nums[i];
            else if (i > 0 && i < n-1 && nums[i] != nums[i - 1] && nums[i] != nums[i + 1])
                return nums[i];
        }

        return -1;
    }
}

// i = 1    
// freq = 2
// j = 1
//         0 1 2 3 4 5 6 7 8
// nums = [1,1,2,3,3,4,4,8,8] 

// i = 0  
