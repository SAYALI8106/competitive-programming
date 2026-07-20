class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int i = 0;
        int n = intervals.length;
        List<List<Integer>> list = new ArrayList<>();
        while (i < n) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            int j = i + 1;
            while (j < n && intervals[j][0] <= end) {
                end = Math.max(end, intervals[j][1]);
                j++;
            }

            list.add(Arrays.asList(start, end));

            i = j;

        }

        int[][] res = new int[list.size()][2];

        for (int k = 0; k < list.size(); k++) {
            res[k][0] = list.get(k).get(0);
            res[k][1] = list.get(k).get(1);
        }

        return res;
    }
}