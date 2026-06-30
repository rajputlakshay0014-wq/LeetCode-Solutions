import java.util.*;

class Solution {

    List<Integer>[] merged;
    long[] len;
    int n;
    long[] dp;

    public long minMergeCost(int[][] lists) {

        n = lists.length;

        int totalMasks = 1 << n;

        merged = new ArrayList[totalMasks];
        len = new long[totalMasks];

        for (int i = 0; i < n; i++) {
            merged[1 << i] = new ArrayList<>();

            for (int x : lists[i]) {
                merged[1 << i].add(x);
            }

            len[1 << i] = lists[i].length;
        }

        for (int mask = 1; mask < totalMasks; mask++) {

            if (merged[mask] != null) continue;

            int bit = mask & -mask;
            int rest = mask ^ bit;

            merged[mask] = merge(
                    merged[bit],
                    merged[rest]
            );

            len[mask] = len[bit] + len[rest];
        }

        dp = new long[totalMasks];
        Arrays.fill(dp, -1);

        return solve(totalMasks - 1);
    }

    private long solve(int mask) {

        if ((mask & (mask - 1)) == 0)
            return 0;

        if (dp[mask] != -1)
            return dp[mask];

        long ans = Long.MAX_VALUE;

        for (int sub = (mask - 1) & mask;
             sub > 0;
             sub = (sub - 1) & mask) {

            int other = mask ^ sub;

            if (other == 0) continue;

            long cost =
                    solve(sub)
                  + solve(other)
                  + mergeCost(sub, other);

            ans = Math.min(ans, cost);
        }

        return dp[mask] = ans;
    }

    private long mergeCost(int a, int b) {

        long la = len[a];
        long lb = len[b];

        int ma = median(merged[a]);
        int mb = median(merged[b]);

        return la + lb + Math.abs((long)ma - mb);
    }

    private int median(List<Integer> arr) {

        int m = (arr.size() - 1) / 2;
        return arr.get(m);
    }

    private ArrayList<Integer> merge(
            List<Integer> a,
            List<Integer> b) {

        ArrayList<Integer> res =
                new ArrayList<>(a.size() + b.size());

        int i = 0;
        int j = 0;

        while (i < a.size() && j < b.size()) {

            if (a.get(i) <= b.get(j))
                res.add(a.get(i++));
            else
                res.add(b.get(j++));
        }

        while (i < a.size())
            res.add(a.get(i++));

        while (j < b.size())
            res.add(b.get(j++));

        return res;
    }
}