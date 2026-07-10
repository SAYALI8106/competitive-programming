class Solution {
    public void moveZeroes(int[] nums) {
        // int count =0;
        // int j =0;
        // for(int i =0; i <  nums.length; i++){
        //     if(nums[i]==0){
        //       count++;
        //     }else{
        //         nums[j++]=nums[i];
        //     }
        // }

        // while(count!=0){
        //  nums[j++]= 0;
        //  count--;
        // }

        int j = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                j = i;
                break;
            }
        }
        if (j == -1)
            return;
        for (int i = j + 1; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
    }
}

// nums = [0,1,0,3,12]
// [1,1,0]