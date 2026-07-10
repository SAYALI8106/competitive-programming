class Solution {
    public int[] twoSum(int[] nums, int target) {
        // brute force
        // time -> O(n^2)
        // space -> O(1)
        // for (int i = 0; i < nums.length; i++) {
        //     for (int j = i+1; j < nums.length; j++) {
        //         if (nums[i] + nums[j] == target) {
        //             return new int[] { i, j };
        //         }
        //     }
        // }
        // return new int[] { -1, -1 };

        // better 
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[] { i, map.get(complement) };
            }

            map.put(nums[i], i);
        }

        return new int[] { -1, -1 };

        // optimal - only if chnaging order is not concern (better approach for returning indexes)

    }
}
