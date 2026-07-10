class Solution {
    public int singleNumber(int[] nums) {
        // brute force 
        // time -> O(n^2) not satisfied
        // space -> O(1) satisfied
        // for (int i = 0; i < nums.length; i++) {
        //     int count = 0;
        //     for (int j = 0; j < nums.length; j++) {
        //         if (nums[i] == nums[j]) {
        //             count++;
        //         }
        //     }
        //     if (count == 1)
        //         return nums[i];
        // }
        // return -1;

        // Better approach
        // Time -> O(n) satisfied
        // Space -> O(n) not satisfied
        // Note: Since every element except one appears twice,
        // the HashMap stores only the distinct elements.
        // Therefore, it contains about (n + 1) / 2 entries in this problem.
        // However, in Big-O notation, O((n + 1) / 2) simplifies to O(n).

        // HashMap<Integer, Integer> map = new HashMap<>();
        // for (int num : nums) {
        //     map.put(num, map.getOrDefault(num, 0) + 1);
        // }

        // for (int i = 0; i < nums.length; i++) {
        //     if (map.get(nums[i]) == 1)
        //         return nums[i];
        // }

        // return -1;

        // Optimal approach
        // Time -> O(n)
        // Space -> O(1)

        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
        }
        return xor;
    }
}
