class Solution {
    public int leastInterval(char[] tasks, int n) {

        int[] freq = new int[26];

        int maxFreq = 0;

        for (char c : tasks) {
            freq[c - 'A']++;
            maxFreq = Math.max(maxFreq, freq[c - 'A']);
        }

        int countMax = 0;

        for (int f : freq) {
            if (f == maxFreq) {
                countMax++;
            }
        }

        return Math.max(tasks.length,
                (maxFreq - 1) * (n + 1) + countMax);
    }
}