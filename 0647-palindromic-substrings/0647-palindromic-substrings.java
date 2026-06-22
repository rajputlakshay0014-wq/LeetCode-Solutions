class Solution {

    int count = 0;

    public int countSubstrings(String s) {

        for (int i = 0; i < s.length(); i++) {

            // Odd length palindrome
            expand(s, i, i);

            // Even length palindrome
            expand(s, i, i + 1);
        }

        return count;
    }

    private void expand(String s, int left, int right) {

        while (left >= 0 &&
               right < s.length() &&
               s.charAt(left) == s.charAt(right)) {

            count++;

            left--;
            right++;
        }
    }
}