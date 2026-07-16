class Solution {
    public List<Integer> getRow(int rowIndex) {
        // time -> O(n^2)
        // space -> O(n^2)
        // List<List<Integer>> triangle = new ArrayList<>();

        // for (int i = 0; i <= rowIndex; i++) {
        //     List<Integer> row = new ArrayList<>(Collections.nCopies(i + 1, 1));

        //     for (int j = 1; j < i; j++) {
        //         row.set(j,triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j));
        //     }

        //     triangle.add(row);
        // }

        // return triangle.get(rowIndex);

        //  time -> O(n^2)
        // space -> O(n)
        List<Integer> row = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++) {

            long res = findnCr(rowIndex, i);
            row.add((int) res);
        }

        return row;

    }

    public long findnCr(int r, int c) {

        long res = 1;

        for (int i = 0; i < c; i++) {
            res = res * (r - i);
            res = res / (i + 1);
        }

        return res;
    }
}

// n!/(n! * (n-r)!)

// 10!---===10*9*8 3!*(7!)3*2*
// 1
