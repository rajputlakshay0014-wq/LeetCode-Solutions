import java.util.*;

class Solution {

    public int minCostConnectPoints(int[][] points) {

        int n = points.length;

        boolean[] visited = new boolean[n];

        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> a[1] - b[1]);

        pq.offer(new int[]{0, 0});

        int cost = 0;
        int edges = 0;

        while (edges < n) {

            int[] cur = pq.poll();

            int node = cur[0];
            int wt = cur[1];

            if (visited[node]) continue;

            visited[node] = true;

            cost += wt;
            edges++;

            for (int i = 0; i < n; i++) {

                if (!visited[i]) {

                    int dist =
                            Math.abs(points[node][0] - points[i][0]) +
                            Math.abs(points[node][1] - points[i][1]);

                    pq.offer(new int[]{i, dist});
                }
            }
        }

        return cost;
    }
}