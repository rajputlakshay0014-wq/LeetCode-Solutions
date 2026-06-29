import java.util.*;

class Solution {

    public int minimumEffortPath(int[][] heights) {

        int m = heights.length;
        int n = heights[0].length;

        int[][] effort = new int[m][n];

        for (int[] row : effort) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> a[2] - b[2]);

        pq.offer(new int[]{0, 0, 0});

        effort[0][0] = 0;

        int[][] dir = {
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1}
        };

        while (!pq.isEmpty()) {

            int[] cur = pq.poll();

            int r = cur[0];
            int c = cur[1];
            int diff = cur[2];

            if (r == m - 1 && c == n - 1)
                return diff;

            for (int[] d : dir) {

                int nr = r + d[0];
                int nc = c + d[1];

                if (nr < 0 || nc < 0 ||
                    nr >= m || nc >= n)
                    continue;

                int newEffort =
                        Math.max(diff,
                                Math.abs(
                                        heights[r][c] -
                                        heights[nr][nc]
                                ));

                if (newEffort < effort[nr][nc]) {

                    effort[nr][nc] = newEffort;

                    pq.offer(
                            new int[]{
                                    nr,
                                    nc,
                                    newEffort
                            });
                }
            }
        }

        return 0;
    }
}