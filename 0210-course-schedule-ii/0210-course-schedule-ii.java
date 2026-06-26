import java.util.*;

class Solution {

    public int[] findOrder(int numCourses,
                           int[][] prerequisites) {

        List<Integer>[] graph =
                new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++)
            graph[i] = new ArrayList<>();

        int[] indegree = new int[numCourses];

        for (int[] p : prerequisites) {
            graph[p[1]].add(p[0]);
            indegree[p[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0)
                q.offer(i);
        }

        int[] ans = new int[numCourses];
        int idx = 0;

        while (!q.isEmpty()) {

            int cur = q.poll();

            ans[idx++] = cur;

            for (int next : graph[cur]) {

                indegree[next]--;

                if (indegree[next] == 0)
                    q.offer(next);
            }
        }

        return idx == numCourses ? ans : new int[0];
    }
}