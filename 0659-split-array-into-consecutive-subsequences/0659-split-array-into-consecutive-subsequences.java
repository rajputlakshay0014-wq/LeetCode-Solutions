class Solution {
    public boolean isPossible(int[] nums) {

        HashMap<Integer, Integer> freq = new HashMap<>();
        HashMap<Integer, Integer> end = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for (int num : nums) {

            if (freq.get(num) == 0)
                continue;

            freq.put(num, freq.get(num) - 1);

            if (end.getOrDefault(num - 1, 0) > 0) {

                end.put(num - 1, end.get(num - 1) - 1);
                end.put(num, end.getOrDefault(num, 0) + 1);

            } else if (freq.getOrDefault(num + 1, 0) > 0 &&
                       freq.getOrDefault(num + 2, 0) > 0) {

                freq.put(num + 1, freq.get(num + 1) - 1);
                freq.put(num + 2, freq.get(num + 2) - 1);

                end.put(num + 2, end.getOrDefault(num + 2, 0) + 1);

            } else {
                return false;
            }
        }

        return true;
    }
}