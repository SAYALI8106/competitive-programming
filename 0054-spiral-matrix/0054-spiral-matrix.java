class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        // time -> O(m*n)
        // space -> 0(1)
        List<Integer> spiral = new ArrayList<>();
        int top = 0;
        int left = 0;
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;
        while (left <= right && top <= bottom) {
            // traverse top row from left to right
            for (int i = left; i <= right; i++) {
                spiral.add(matrix[top][i]);
            }
            top++; // move the top boundary downwards

            // traverse right col from top to bottom
            for (int i = top; i <= bottom; i++) {
                spiral.add(matrix[i][right]);
            }
            right--; // move right boundary leftward

            // Traverse bottom row from right to left
            if (bottom >= top) {
                for (int i = right; i >= left; i--) {
                    spiral.add(matrix[bottom][i]);
                }
                bottom--; // move the bottom boundary upward
            }

            // Traverse left col from bottom to top
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    spiral.add(matrix[i][left]);
                }
                left++; // move the left boundary rightward
            }
        }
        return spiral;

    }
}

//        0 1 2 
// 0      1 2 3 
// 1      4 5 6
// 2      7 8 9
// [0,0][0,1][0,2]
// [1,2][2,9][2,1][2,0]
// [1,0][1,1]