class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();

        backtrack(candidates, target, 0, new ArrayList<>(), ans);

        return ans;
    }

    private void backtrack(int[] candidates,
                           int target,
                           int start,
                           List<Integer> temp,
                           List<List<Integer>> ans) {

        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            temp.add(candidates[i]);

            backtrack(candidates,
                     target - candidates[i],
                     i,
                     temp,
                     ans);

            temp.remove(temp.size() - 1);
        }
    }
}