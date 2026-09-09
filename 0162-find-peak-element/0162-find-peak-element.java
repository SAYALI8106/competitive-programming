class Solution {
    public int findPeakElement(int[] nums) {
        //     int n = nums.length;

        //     if (n == 1)
        //         return 0;

        //     if (nums[0] > nums[1])
        //         return 0;

        //    if (nums[n - 1] > nums[n - 2])
        //         return n - 1;

        //     for (int i = 1; i < n - 1; i++) {
        //         if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1])
        //             return i;
        //     }

        //     return -1;

        // TC: O(log N)
        // SC: O(1)
        int n = nums.length;

        if (n == 1)
            return 0;

        if (nums[0] > nums[1])
            return 0;

        if (nums[n - 1] > nums[n - 2])
            return n - 1;

        int low = 1;
        int high = n - 2;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
                return mid;
            else if (nums[mid] > nums[mid - 1])
                low = mid + 1;
            else
                high = mid - 1;
        }

        return -1;
    }
}

//         0 1 2 3 4 5 6
// nums = [1,2,1,3,5,6,4]
// low = 0,4      high = 6,        mid = 0+6/2= 3,   4+6/2=5
// ans = 5

//  0 1 2 3
// [1,2,3,1]
// low = 0   high = 3,        mid=0+3/2=1,
// ans = 2

//  0 1 2 3 4
// [1,2,1,3,2]
// low = 0,   high =4,    mid=0+4/2=2