class Solution {
    public boolean check(int[] nums) {
        int drops = 0;
        for (int i = 0; i < nums.length; i++) {
            int nextIndex = (i + 1) % nums.length;
            if (nums[i] <= nums[nextIndex]) {

            } else {
                drops++;
            }

            if(drops>1){
                return false;
            }
        }

      return true;
    }
}

