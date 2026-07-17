class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //  time -> O(n^3)
        //  here we are not considering the time complexity of sorting as we are just sorting 3 elements every time.
        // Sorting 3 elements is O(1).
        // HashSet insertion is O(1) on average.
        // space -> O(k)
        // where k is the number of unique triplets stored in the HashSet.
        // Set<List<Integer>> st = new HashSet<>();
        // for (int i = 0; i < nums.length; i++) {
        //     for (int j = i + 1; j < nums.length; j++) {
        //         for (int k = j + 1; k < nums.length; k++) {
        //             if (nums[i] + nums[j] + nums[k] == 0) {
        //                 List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
        //                 Collections.sort(temp);
        //                 st.add(temp);
        //             }
        //         }
        //     }

        // }

        // return new ArrayList<>(st);

        Set<List<Integer>> st = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                int complement = -(nums[i] + nums[j]);
                if (set.contains(complement)) {
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], complement);
                    Collections.sort(temp);
                    st.add(temp);
                }
                set.add(nums[j]);
            }

        }

        return new ArrayList<>(st);
    }
}