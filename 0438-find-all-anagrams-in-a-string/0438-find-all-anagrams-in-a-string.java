import java.util.*;

class Solution {

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();

        // Edge case
        if (s.length() < p.length()) {
            return result;
        }

        int[] pCount = new int[26];
        int[] sCount = new int[26];

        // Fill frequency arrays
        for (int i = 0; i < p.length(); i++) {

            pCount[p.charAt(i) - 'a']++;

            sCount[s.charAt(i) - 'a']++;
        }

        // Check first window
        if (Arrays.equals(pCount, sCount)) {
            result.add(0);
        }

        // Sliding window
        for (int i = p.length(); i < s.length(); i++) {

            // Add new character
            sCount[s.charAt(i) - 'a']++;

            // Remove old character
            sCount[s.charAt(i - p.length()) - 'a']--;

            // Compare arrays
            if (Arrays.equals(pCount, sCount)) {
                result.add(i - p.length() + 1);
            }
        }

        return result;
    }
}