class Solution {
    public void nextPermutation(int[] nums) {
        int idx = -1;
        // find the breaking point where the current digit is smaller than the next number
        // find the first decreasing element from the end
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                idx = i;
                break;
            }
        }

        // if no such element found reverse it and give the 1st permutation
        if (idx == -1) {
            reverse(0, nums.length - 1, nums);
            return;
        }

        // find the greater element 
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > nums[idx]) {
                int t = nums[idx];
                nums[idx] = nums[i];
                nums[i] = t;
                break;
            }
        }

        // reverse the rest part after index
        reverse(idx + 1, nums.length - 1, nums);

    }

    public void reverse(int start, int end, int nums[]) {
        while (start <= end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}

// [1,2,4,3]
// [1,2|,4,3]   breaking point idx = 1
// [1,3,4,2]     swap it with the element greater than it
// [1,3,2,4]    reverse the remaining array