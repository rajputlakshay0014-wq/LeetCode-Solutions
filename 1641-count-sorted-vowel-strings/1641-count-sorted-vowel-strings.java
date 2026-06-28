class Solution {
    public int countVowelStrings(int n) {

        int[] dp = {1, 1, 1, 1, 1};

        for (int i = 1; i < n; i++) {
            for (int j = 3; j >= 0; j--) {
                dp[j] += dp[j + 1];
            }
        }

        int ans = 0;

        for (int x : dp) {
            ans += x;
        }

        return ans;
    }
}