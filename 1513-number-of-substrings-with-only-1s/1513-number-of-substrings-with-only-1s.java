class Solution {
    public int numSub(String s) {

        long mod = 1000000007;
        long count = 0;
        long ones = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '1') {
                ones++;
                count += ones;
            } else {
                ones = 0;
            }
        }

        return (int)(count % mod);
    }
}