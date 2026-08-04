class Solution {

    int MOD = 1000000007;

    public int sumSubseqWidths(int[] nums) {

        Arrays.sort(nums);

        int n = nums.length;

        long[] pow = new long[n];

        pow[0] = 1;

        for (int i = 1; i < n; i++) {
            pow[i] = (pow[i - 1] * 2) % MOD;
        }

        long ans = 0;

        for (int i = 0; i < n; i++) {

            ans = (ans +
                    nums[i] * (pow[i] - pow[n - i - 1])) % MOD;
        }

        ans = (ans + MOD) % MOD;

        return (int) ans;
    }
}