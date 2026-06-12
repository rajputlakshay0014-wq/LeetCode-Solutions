class Solution {

    public String longestPalindrome(String s) {

        String ans = "";

        for(int i = 0; i < s.length(); i++) {

            String odd = expand(s, i, i);

            if(odd.length() > ans.length()) {
                ans = odd;
            }

            String even = expand(s, i, i + 1);

            if(even.length() > ans.length()) {
                ans = even;
            }
        }

        return ans;
    }

    private String expand(String s, int left, int right) {

        while(left >= 0 &&
              right < s.length() &&
              s.charAt(left) == s.charAt(right)) {

            left--;
            right++;
        }

        return s.substring(left + 1, right);
    }
}