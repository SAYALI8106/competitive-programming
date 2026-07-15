class Solution {
    public void rotate(int[][] matrix) {
        // brute force
        // time -> O(n^2)
        // space -> O(n^2)
        // int n = matrix.length;
        // int[][] rotated = new int[n][n];

        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < n; j++) {
        //         rotated[j][n - 1 - i] = matrix[i][j];
        //     }
        // }

        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < n; j++) {
        //         matrix[i][j] = rotated[i][j];
        //     }
        // }

        //  optimal approach
        // time --> O(n/2*n/2)
        // space --> O(1)
        int n = matrix.length;

        // Step 1: Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row

        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }
}
// swap
// 1  4  7
// 2  5  8
// 3  6  9

// reverse each row
// 7 4 1
// 8 5 2
// 9 6 3