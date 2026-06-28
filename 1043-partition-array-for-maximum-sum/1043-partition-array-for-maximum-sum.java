class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {

        int n = arr.length;
        int[] dp = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {

            int max = 0;
            int best = 0;

            for (int j = i; j < Math.min(n, i + k); j++) {

                max = Math.max(max, arr[j]);

                int len = j - i + 1;

                best = Math.max(best,
                        max * len + dp[j + 1]);
            }

            dp[i] = best;
        }

        return dp[0];
    }
}