class Solution {

    public int longestSubstring(String s, int k) {
        return solve(s, 0, s.length(), k);
    }

    private int solve(String s, int start, int end, int k) {

        if (end - start < k) {
            return 0;
        }

        int[] freq = new int[26];

        for (int i = start; i < end; i++) {
            freq[s.charAt(i) - 'a']++;
        }

        for (int mid = start; mid < end; mid++) {

            if (freq[s.charAt(mid) - 'a'] < k) {

                int next = mid + 1;

                while (next < end &&
                       freq[s.charAt(next) - 'a'] < k) {
                    next++;
                }

                return Math.max(
                        solve(s, start, mid, k),
                        solve(s, next, end, k)
                );
            }
        }

        return end - start;
    }
}