class Solution {

    public int bestRotation(int[] nums) {

        int n = nums.length;
        int[] change = new int[n];

        for (int i = 0; i < n; i++) {

            int bad = (i - nums[i] + 1 + n) % n;
            change[bad]--;
        }

        int score = 0;

        for (int x : nums)
            if (x == 0)
                score++;

        int maxScore = score;
        int ans = 0;

        for (int k = 1; k < n; k++) {

            score += 1;
            score += change[k];

            if (score > maxScore) {
                maxScore = score;
                ans = k;
            }
        }

        return ans;
    }
}