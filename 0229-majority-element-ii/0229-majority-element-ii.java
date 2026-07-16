class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // brute force
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

        // better approach
        // time -> O(n)
        // space -> O(n)

        //     HashMap<Integer, Integer> map = new HashMap<>();
        //     List<Integer> list = new ArrayList<>();
        //     int n = nums.length;

        //     for (int i = 0; i < n; i++) {
        //         map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        //         if (map.get(nums[i]) > n / 3) {
        //             if (!list.contains(nums[i])) {
        //                 list.add(nums[i]);
        //             }
        //         }
        //         if (list.size() == 2)
        //             break;
        //     }

        //     return list;

        // optimal approach
        // time -> O(n)
        // space -> O(1)

        int cnt1 = 0;
        int cnt2 = 0;
        int ele1 = Integer.MIN_VALUE;
        int ele2 = Integer.MIN_VALUE;
        List<Integer> list = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (cnt1 == 0 && ele2 != nums[i]) {
                cnt1 = 1;
                ele1 = nums[i];
            } else if (cnt2 == 0 && ele1 != nums[i]) {
                cnt2 = 1;
                ele2 = nums[i];
            } else if (ele1 == nums[i]) {
                cnt1++;
            } else if (ele2 == nums[i]) {
                cnt2++;
            } else {
                cnt1--;
                cnt2--;
            }
        }

        cnt1 = 0;
        cnt2 = 0;
        for (int i = 0; i < n; i++) {
            if (ele1 == nums[i])
                cnt1++;
            if (ele2 == nums[i])
                cnt2++;
        }

        if (cnt1 > n / 3)
            list.add(ele1);
        if (cnt2 > n / 3)
            list.add(ele2);

        return list;
    }
}