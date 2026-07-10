class Solution {
    public int[] rearrangeArray(int[] nums) {
        // int n = nums.length;
        // int positiveArr[] = new int[n/2];

        // int idx = 0;
        // for (int i = 0; i < n; i++) {
        //     if (nums[i] > 0) {
        //         positiveArr[idx++] = nums[i];
        //     }
        // }

        // int negativeArr[] = new int[n/2];

        // idx = 0;
        // for (int i = 0; i < n; i++) {
        //     if (nums[i] < 0) {
        //         negativeArr[idx++] = nums[i];
        //     }
        // }

        // idx = 0;
        // for (int i = 0; i < n; i += 2) {
        //     nums[i] = positiveArr[idx++];
        // }

        // idx = 0;
        // for (int i = 1; i < n; i += 2) {
        //     nums[i] = negativeArr[idx++];
        // }

        // return nums;

        // brute force
        // time -> O(n+n/2) -> O(n)
        // space -> O(n/2+n/2)-> O(n)
        // List<Integer> pos = new ArrayList<>();
        // List<Integer> neg = new ArrayList<>();

        // for (int i = 0; i < nums.length; i++) {
        //     if (nums[i] > 0) {
        //         pos.add(nums[i]);
        //     } else {
        //         neg.add(nums[i]);
        //     }
        // }

        // for (int i = 0; i < nums.length / 2; i++) {
        //     nums[2 * i] = pos.get(i);
        //     nums[2 * i + 1] = neg.get(i);
        // }

        // return nums;

        // Optimal approch
        // Time -> O(n)
        // Space -> O(n)
        int ans[] = new int[nums.length];
        int pos = 0;
        int neg = 1;

        for(int i = 0; i < nums.length; i++){
            if(nums[i]>0){
                ans[pos]=nums[i];
                pos+=2;
            }else{
                ans[neg]=nums[i];
                neg+=2;
            }
        }

        return ans;
    }
}