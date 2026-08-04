class Solution {

    public int balancedString(String s) {

        int n = s.length();

        int need = n / 4;

        int[] count = new int[128];

        for (char c : s.toCharArray())
            count[c]++;

        if (count['Q'] == need &&
            count['W'] == need &&
            count['E'] == need &&
            count['R'] == need)
            return 0;

        int left = 0;

        int ans = n;

        for (int right = 0; right < n; right++) {

            count[s.charAt(right)]--;

            while (left < n &&
                    count['Q'] <= need &&
                    count['W'] <= need &&
                    count['E'] <= need &&
                    count['R'] <= need) {

                ans = Math.min(ans, right - left + 1);

                count[s.charAt(left)]++;

                left++;
            }
        }

        return ans;
    }
}