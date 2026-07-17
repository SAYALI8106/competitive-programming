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

        // Time Complexity: O(n^3*logm)
        // Space Complexity: O(n) auxiliary + O(k) for storing the answer,
        // where k is the number of unique quadruplets.

        // Set<List<Integer>> set = new HashSet<>();
        // int n = nums.length;
        // for (int a = 0; a < n; a++) {
        //     for (int b = a + 1; b < n; b++) {
        //         Set<Long> st = new HashSet<>();
        //         for (int c = b + 1; c < n; c++) {
        //             long complement = (long) target - nums[a] - nums[b] - nums[c];
        //             if (st.contains(complement)) {
        //                 List<Integer> temp = Arrays.asList(nums[a], nums[b], nums[c], (int) complement);
        //                 Collections.sort(temp);
        //                 set.add(temp);
        //             }

        //             st.add((long) nums[c]);
        //         }
        //     }
        // }

        // return new ArrayList<>(set);

        // Optimal approach
        // time -> O(n^3)+ O(nlogn)
        // space -> O(k)  //space to store the quads not to solve the problem
        List<List<Integer>> list = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;

                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[left], nums[right]);
                        list.add(temp);
                        left++;
                        right--;

                        while (left < right && nums[left] == nums[left - 1])
                            left++;
                        while (left < right && nums[right] == nums[right + 1])
                            right--;
                    }
                }
            }
        }

        return list;
    }
}