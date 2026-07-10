class Solution {

    // public boolean linearSearch(int nums[], int key) {

    //     for (int i = 0; i < nums.length; i++) {
    //         if (nums[i] == key)
    //             return true;
    //     }

    //     return false;
    // }

    public int longestConsecutive(int[] nums) {
        //     // brute force
        //     // time -> O(n^2)
        //     // space -> O(1)
        //     if (nums.length == 0)
        //         return 0;
        //     int max = 1;

        //     for (int i = 0; i < nums.length; i++) {
        //         int x = nums[i];
        //         int cnt = 1;
        //         while (linearSearch(nums, x + 1)) {
        //             x += 1;
        //             cnt++;
        //         }

        //         max = Math.max(max, cnt);
        //     }

        //     return max;

        // better approach 
        // time -> O(n log n)
        // space -> O(1)
        // if (nums.length == 0) {
        //     return 0;
        // }

        // Arrays.sort(nums);
        // int lastSmaller = Integer.MIN_VALUE;
        // int maxLen = 1;
        // int cnt = 0;
        // for (int i = 0; i < nums.length; i++) {
        //     if (nums[i] - 1 == lastSmaller) {
        //         cnt++;
        //         lastSmaller = nums[i];
        //     } else if (nums[i] != lastSmaller) {
        //         cnt = 1;
        //         lastSmaller = nums[i];
        //     }

        //     maxLen = Math.max(maxLen, cnt);
        // }

        // return maxLen;

        // Optimal approach
        // time --> O(n)
        // space -> O(n)
        if (nums.length == 0)
            return 0;
        HashSet<Integer> set = new HashSet<>();
        int longest = 1;

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        for (int num : set) {
            int cnt = 1;
            int x = num;
            if (!set.contains(num - 1)) {
                while (set.contains(x + 1)) {
                    x = x + 1;
                    cnt = cnt + 1;
                }
            }

            longest = Math.max(longest, cnt);
        }

        return longest;
    }
}

// [0,3,7,2,5,8,4,6,0,1]
//  i = 1               lastSmaller = 0   maxLen = 1      cnt = 1
// nums[i] - 1 == lastSmaller
// -1 = 0
//  0 1 2 3 4 5 6 7 8 9                   
// [0,0,1,2,3,4,5,6,7,8]   