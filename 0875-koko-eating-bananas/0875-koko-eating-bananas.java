class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        // TC: O(max[piles]*n)
        // SC: O(1)

        // int max = 0;
        // int k = 0;

        // for(int pile: piles){
        //     max = Math.max(max,pile);
        // }

        // for(int i = 1; i <=max; i++){
        //     int totalHours = 0;

        //     for(int pile: piles){
        //         totalHours+= Math.ceil((double)pile/i);
        //     }

        //     if(totalHours<=h){
        //      k = i;
        //      break;
        //     }
        // }

        // return k;

        // TC: O(max[piles]*log N)
        // SC: O(1)
        
        int max = 0;
        int k = 0;

        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        int low = 1;
        int high = max;

        while (low <= high) {

            int mid = (low + high) / 2;

            int totalHours = 0;

            for (int pile : piles) {
                totalHours += Math.ceil((double) pile / mid);
            }

            if (totalHours <= h) {
                k = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return k;
    }
}

// piles = [3,6,7,11], h = 8  
// i = 1,2,3,4        i < =11,    if(totalHours<=h) k = 8 
// 3+6+7+11= 27  is 27<=8 -> NO
// 2+3+4+6= 15 is 15<=8 no
//  1+2+3+10= 16
//  1+2+2+3= 8
// totalHours = 27, 15,16,8
// final answer k = 8

// [3,6,7,11]
// i = 1,2,3      i <=11
// totalHours = (3+6+7+11= 27), (14), (9)
// k = 0,