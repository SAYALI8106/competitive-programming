class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        // brute force
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

        // better approach
        // Time Complexity: O(n²)

        // Reason:
        // - Outer loop runs n times.
        // - Inner loop runs approximately n times.
        // - HashSet add() and contains() are O(1) on average.
        // - Sorting each triplet of 3 elements is O(1).

        // Space Complexity:
        // O(n + k)

        // where
        // n = maximum size of the temporary HashSet
        // k = number of unique triplets stored in the answer HashSet.

        // Set<List<Integer>> st = new HashSet<>();

        // for (int i = 0; i < nums.length; i++) {
        //     Set<Integer> set = new HashSet<>();
        //     for (int j = i + 1; j < nums.length; j++) {
        //         int complement = -(nums[i] + nums[j]);
        //         if (set.contains(complement)) {
        //             List<Integer> temp = Arrays.asList(nums[i], nums[j], complement);
        //             Collections.sort(temp);
        //             st.add(temp);
        //         }
        //         set.add(nums[j]);
        //     }

        // }

        // return new ArrayList<>(st);

        // Optimal approach
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    list.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1])
                        left++;
                    while (left < right && nums[right] == nums[right + 1])
                        right--;

                }
            }

        }

        return list;
    }
}

// [-1,0,1,2,-1,-4]
// [-4,-1,-1,0,1,2]