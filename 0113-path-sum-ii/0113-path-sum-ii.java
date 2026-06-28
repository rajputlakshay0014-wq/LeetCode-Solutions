class Solution {

    List<List<Integer>> result =
            new ArrayList<>();

    public List<List<Integer>> pathSum(
            TreeNode root,
            int targetSum) {

        dfs(root,
            targetSum,
            new ArrayList<>());

        return result;
    }

    private void dfs(TreeNode root,
                     int targetSum,
                     List<Integer> path) {

        if (root == null) {
            return;
        }

        path.add(root.val);

        if (root.left == null &&
            root.right == null &&
            targetSum == root.val) {

            result.add(
                new ArrayList<>(path)
            );
        }

        dfs(root.left,
            targetSum - root.val,
            path);

        dfs(root.right,
            targetSum - root.val,
            path);

        path.remove(
            path.size() - 1
        );
    }
}