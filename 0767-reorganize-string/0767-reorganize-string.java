import java.util.*;

class Solution {
    public String reorganizeString(String s) {

        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> b[1] - a[1]);

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                pq.offer(new int[]{i, freq[i]});
            }
        }

        StringBuilder sb = new StringBuilder();

        while (pq.size() >= 2) {

            int[] first = pq.poll();
            int[] second = pq.poll();

            sb.append((char)(first[0] + 'a'));
            sb.append((char)(second[0] + 'a'));

            if (--first[1] > 0) pq.offer(first);
            if (--second[1] > 0) pq.offer(second);
        }

        if (!pq.isEmpty()) {

            int[] last = pq.poll();

            if (last[1] > 1) return "";

            sb.append((char)(last[0] + 'a'));
        }

        return sb.toString();
    }
}