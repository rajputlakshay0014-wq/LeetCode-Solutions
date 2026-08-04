class Solution {

    public int reachableNodes(int[][] edges, int maxMoves, int n) {

        List<int[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        for (int[] e : edges) {

            graph[e[0]].add(new int[]{e[1], e[2]});
            graph[e[1]].add(new int[]{e[0], e[2]});
        }

        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> b[1] - a[1]);

        pq.offer(new int[]{0, maxMoves});

        Map<Integer, Integer> dist = new HashMap<>();

        while (!pq.isEmpty()) {

            int[] cur = pq.poll();

            int node = cur[0];
            int move = cur[1];

            if (dist.containsKey(node))
                continue;

            dist.put(node, move);

            for (int[] next : graph[node]) {

                int nei = next[0];
                int cost = next[1];

                int remain = move - cost - 1;

                if (remain >= 0 && !dist.containsKey(nei)) {
                    pq.offer(new int[]{nei, remain});
                }
            }
        }

        int ans = dist.size();

        for (int[] e : edges) {

            int a = dist.getOrDefault(e[0], 0);

            int b = dist.getOrDefault(e[1], 0);

            ans += Math.min(e[2], a + b);
        }

        return ans;
    }
}