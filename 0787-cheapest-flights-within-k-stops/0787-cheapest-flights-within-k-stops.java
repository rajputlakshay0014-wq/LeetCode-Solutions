import java.util.*;

class Solution {

    public int findCheapestPrice(int n, int[][] flights,
                                 int src, int dst, int k) {

        List<int[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] f : flights) {
            graph[f[0]].add(new int[]{f[1], f[2]});
        }

        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{src, 0});
        cost[src] = 0;

        int stops = 0;

        while (!q.isEmpty() && stops <= k) {

            int size = q.size();

            int[] temp = cost.clone();

            while (size-- > 0) {

                int[] cur = q.poll();

                int node = cur[0];
                int price = cur[1];

                for (int[] nei : graph[node]) {

                    int next = nei[0];
                    int wt = nei[1];

                    if (price + wt < temp[next]) {

                        temp[next] = price + wt;
                        q.offer(new int[]{next, temp[next]});
                    }
                }
            }

            cost = temp;
            stops++;
        }

        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }
}