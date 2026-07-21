class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // time -> O(n^2)
        // space -> O(1)

        // if (n == 0)
        //     return;

        for (int i = 0; i < n; i++) {
            int insertPos = 0;
            while (insertPos < m && nums1[insertPos] <= nums2[i])
                insertPos++;

            for (int j = m; j > insertPos; j--) {
                nums1[j] = nums1[j - 1];
            }

            nums1[insertPos] = nums2[i];
            m++;
        }
    }
}

// Input: nums1 = [1,2,2,3,0,0], m = 3, nums2 = [2,5,6], n = 3
// i = 3  
//  j = 0