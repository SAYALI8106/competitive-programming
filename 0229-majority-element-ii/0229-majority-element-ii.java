class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // time -> O(n^2)
        // space -> O(n)
        // there can't be more than two elements in an array that appears more than n/3 times
        // List<Integer> list = new ArrayList<>();
        // int n = nums.length;
        // for (int i = 0; i < n; i++) {
        //     int count = 1;
        //     for (int j = i + 1; j < n; j++) {
        //         if (nums[i] == nums[j]) {
        //             count++;
        //         }
        //     }

        //     if (count > n / 3) {
        //         if (!list.contains(nums[i])) {
        //             list.add(nums[i]);
        //         }
        //     }

        //     if(list.size()==2) break;
        // }

        // return list;

        // time -> O(n)
        // space -> O(n)
        
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.get(nums[i]) > n / 3) {
                if (!list.contains(nums[i])) {
                    list.add(nums[i]);
                }
            }
            if (list.size() == 2)
                break;
        }

        return list;
    }
}