class Solution {
    public int subarraySum(int[] nums, int k) {
        // int count = 0;
        // int sum = 0;
        // HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        // for (int i = 0; i < nums.length; i++) {
        //     sum += nums[i];
        //     if (sum == k) {
        //         count++;
        //     }

        //     int remaining = sum - k;

        //     if (prefixSumMap.containsKey(remaining)) {
        //         count += prefixSumMap.get(remaining);
        //     }

        //     prefixSumMap.put(sum, prefixSumMap.getOrDefault(sum, 0) + 1);

        // }
        // return count;

        int count = 0;
        for(int i = 0; i < nums.length; i++){
            int sum = 0;
            for(int j = i; j < nums.length; j++){
               sum+= nums[j];
               if(sum==k){
                count++;
               }
            }
        }

        return count;
    }
}

//  0 1 2 3 4 5 6 7 8 9
// [0,0,0,0,0,0,0,0,0,0]  k=0   sum=0 count = 3  i=1
// {
// 0->1,

// }
// 0 1 2
// 1,1,1  k = 2  sum =3  count =2 i =2  remaining =1
// {
//   1->1
//   2->1
// }