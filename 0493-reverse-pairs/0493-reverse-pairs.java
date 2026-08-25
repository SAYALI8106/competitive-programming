class Solution {

    public static int countPairs(int nums[], int low, int mid, int high) {
        int count = 0;
        int left = low;
        int right = mid + 1;

        for (int i = low; i <= mid; i++) {

            while (right <= high && (long) nums[i] > 2L * nums[right])
                right++;

            count += (right - (mid + 1));
        }

        return count;
    }

    public static void merge(int[] nums, int low, int mid, int high) {
        int left = low;
        int right = mid + 1;
        int idx = 0;
        int[] temp = new int[high - low + 1];

        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp[idx++] = nums[left++];
            } else {
                temp[idx++] = nums[right++];
            }
        }

        while (left <= mid) {
            temp[idx++] = nums[left++];
        }

        while (right <= high) {
            temp[idx++] = nums[right++];
        }

        for (int i = low; i <= high; i++) {
            nums[i] = temp[i - low];
        }

    }

    public static int mergeSort(int nums[], int low, int high) {
        int count = 0;
        if (low >= high)
            return count;

        int mid = (low + high) / 2;

        count += mergeSort(nums, low, mid);
        count += mergeSort(nums, mid + 1, high);
        count += countPairs(nums, low, mid, high);
        merge(nums, low, mid, high);

        return count;
    }

    public int reversePairs(int[] nums) {
        // brute force approach
        // time -> O(n^2)
        // space -> O(1)
        // int count = 0;
        // for (int i = 0; i < nums.length; i++) {
        //     for (int j = i + 1; j < nums.length; j++) {
        //         if ((long) nums[i] > 2L * nums[j])
        //             count++;
        //     }
        // }
        // return count;

        return mergeSort(nums, 0, nums.length - 1);
    }
}