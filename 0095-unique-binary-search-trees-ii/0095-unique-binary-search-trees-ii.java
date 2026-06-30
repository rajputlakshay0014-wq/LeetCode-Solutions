class Solution {

    public List<TreeNode> generateTrees(int n) {

        if (n == 0) {
            return new ArrayList<>();
        }

        return build(1, n);
    }

    private List<TreeNode> build(int start, int end) {

        List<TreeNode> result = new ArrayList<>();

        if (start > end) {
            result.add(null);
            return result;
        }

        for (int rootVal = start; rootVal <= end; rootVal++) {

            List<TreeNode> leftTrees =
                    build(start, rootVal - 1);

            List<TreeNode> rightTrees =
                    build(rootVal + 1, end);

            for (TreeNode left : leftTrees) {

                for (TreeNode right : rightTrees) {

                    TreeNode root =
                            new TreeNode(rootVal);

                    root.left = left;
                    root.right = right;

                    result.add(root);
                }
            }
        }

        return result;
    }
}