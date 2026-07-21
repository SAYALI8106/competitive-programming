class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // brute force
        // time -> O(n^2)
        // space -> O(1)

        // if (n == 0)
        //     return;

        // for (int i = 0; i < n; i++) {
        //     int insertPos = 0;
        //     while (insertPos < m && nums1[insertPos] <= nums2[i])
        //         insertPos++;

        //     for (int j = m; j > insertPos; j--) {
        //         nums1[j] = nums1[j - 1];
        //     }

        //     nums1[insertPos] = nums2[i];
        //     m++;
        // }

        // optimal approach
        // time -> O(m+n)
        // space -> O(1)

        int k = m + n - 1;
        int i = m - 1;
        int j = n - 1;

        if (n == 0)
            return;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }

    }
}
// i = 2 j = 0   k = 3
//                 0 1 2 3 4 5                   0 1 2
// Input: nums1 = [1,2,3,0,5,6], m = 3, nums2 = [2,5,6], n = 3
// i = 3  
//  j = 

//nums1 = [0] m =0 nums2 = [1] n = 1

// Output
// [0]
// Expected
// [1]