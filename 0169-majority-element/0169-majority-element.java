class Solution {
    public int majorityElement(int[] nums) {
        // brute force
        // time-> O(n^2) 
        // space -> O(1)

        // int n = nums.length;
        // for (int i = 0; i < n; i++) {
        //     int count = 0;
        //     for (int j = 0; j < n; j++) {
        //         if (nums[i] == nums[j]) {
        //             count++;
        //         }
        //     }

        //     if (count > (n / 2)) {
        //         return nums[i];

        //     }
        // }

        // return -1;

        // time -> O(nlogn)
        // space -> O(n)
        // HashMap<Integer, Integer> majorityMap = new HashMap<>();
        // int n = nums.length;
        // for (int i = 0; i < n; i++) {
        //     majorityMap.put(nums[i], majorityMap.getOrDefault(nums[i], 0) + 1);
        // }

        // for (int i = 0; i < n; i++) {
        //     if (majorityMap.get(nums[i]) > (n / 2)) {
        //         return nums[i];
        //     }
        // }

        // return -1;

        // time -> O(n)  using Moore's voting algorithm
        // space -> O(1)
        int cnt = 0;
        // candidate element
        int el = 0;
        int n = nums.length;

        // Step 1: Find the potential majority element
        for (int i = 0; i < n; i++) {
            if (cnt == 0) {
                cnt++;
                el = nums[i];
            } else if (nums[i] == el) {
                cnt++;
            } else {
                cnt--;
            }
        }

        // Step 2: Verify the candidate
        int cnt1 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == el) {
                cnt1++;
            }
        }

        // Return the element if it's a majority
        if (cnt1 > (n / 2))
            return el;

        // Return when no majority element found
        return -1;
    }
}

// i=0   j=0
// [3,2,3]   n = 3    n/2 = 3/2 = 1

//  0 1 2 
// [3,2,3] 
//  0 1 2
// [2,3,3]
//  n = 3  i=1    n/2 = 3/2= 1
// majority = 2,    curr = 0 ,  max = 1