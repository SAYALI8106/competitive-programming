class Solution {
    public void setZeroes(int[][] matrix) {

        // brute force
        // time -> O(m*n(m+n))
        // space-> O(1)
        // int m = matrix.length;
        // int n = matrix[0].length;

        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < n; j++) {
        //         if (matrix[i][j] == 0) {
        //             // mark entire row to -1 except 0
        //             for (int col = 0; col < n; col++) {
        //                 if (matrix[i][col] != 0) {
        //                     matrix[i][col] = -1;
        //                 }
        //             }
        //             // mark entire col to -1 except 0
        //             for (int row = 0; row < m; row++) {
        //                 if (matrix[row][j] != 0) {
        //                     matrix[row][j] = -1;
        //                 }
        //             }
        //         }
        //     }
        // }

        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < n; j++) {
        //         if (matrix[i][j] == -1) {
        //             matrix[i][j] = 0;
        //         }
        //     }
        // }

        // better approach
        // time -> O(m*n)
        // space -> O(m+n)
        
        int m = matrix.length;
        int n = matrix[0].length;

        boolean rows[] = new boolean[m];
        boolean cols[] = new boolean[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rows[i] || cols[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}