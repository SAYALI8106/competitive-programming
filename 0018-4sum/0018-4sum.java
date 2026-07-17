class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // time ->O(n^4)
        // space -> O(n)
        // Set<List<Integer>> set = new HashSet<>();
        // int n = nums.length;
        // for (int a = 0; a < n; a++) {
        //     for (int b = a + 1; b < n; b++) {
        //         for (int c = b + 1; c < n; c++) {
        //             for (int d = c + 1; d < n; d++) {
        //                 if (nums[a] + nums[b] + nums[c] + nums[d] == target) {
        //                     List<Integer> temp = Arrays.asList(nums[a], nums[b], nums[c], nums[d]);
        //                     Collections.sort(temp);
        //                     set.add(temp);

        //                 }
        //             }
        //         }
        //     }
        // }

        // return new ArrayList<>(set);

        // Time Complexity: O(n^3)
        // Space Complexity: O(n) auxiliary + O(k) for storing the answer,
        // where k is the number of unique quadruplets.
        Set<List<Integer>> set = new HashSet<>();
        int n = nums.length;
        for (int a = 0; a < n; a++) {
            for (int b = a + 1; b < n; b++) {
                Set<Long> st = new HashSet<>();
                for (int c = b + 1; c < n; c++) {
                    long complement = (long) target - nums[a] - nums[b] - nums[c];
                    if (st.contains(complement)) {
                        List<Integer> temp = Arrays.asList(nums[a], nums[b], nums[c], (int) complement);
                        Collections.sort(temp);
                        set.add(temp);
                    }

                    st.add((long) nums[c]);
                }
            }
        }

        return new ArrayList<>(set);
    }
}