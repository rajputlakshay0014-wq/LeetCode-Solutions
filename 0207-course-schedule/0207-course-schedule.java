import java.util.*;

class Solution {

    public boolean canFinish(int numCourses,
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

        int count = 0;

        while (!q.isEmpty()) {

            int cur = q.poll();

            count++;

            for (int next : graph[cur]) {

                indegree[next]--;

                if (indegree[next] == 0)
                    q.offer(next);
            }
        }

        return count == numCourses;
    }
}