class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {

        backtrack(1, n, k, new ArrayList<>());

        return result;
    }

    private void backtrack(int start,
                           int n,
                           int k,
                           List<Integer> current) {

        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i <= n; i++) {

            current.add(i);

            backtrack(i + 1, n, k, current);

            current.remove(current.size() - 1);
        }
    }
}