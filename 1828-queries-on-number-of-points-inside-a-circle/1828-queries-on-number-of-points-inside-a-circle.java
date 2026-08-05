class Solution {

    public int[] countPoints(int[][] points, int[][] queries) {

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int cx = queries[i][0];
            int cy = queries[i][1];
            int r = queries[i][2];

            int count = 0;

            for (int[] point : points) {

                int dx = point[0] - cx;
                int dy = point[1] - cy;

                if (dx * dx + dy * dy <= r * r) {
                    count++;
                }
            }

            ans[i] = count;
        }

        return ans;
    }
}