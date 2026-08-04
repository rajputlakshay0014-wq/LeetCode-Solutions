class Solution {

    static class TrieNode {
        TrieNode[] child = new TrieNode[2];
    }

    TrieNode root = new TrieNode();

    public int findMaximumXOR(int[] nums) {

        for (int num : nums) {
            insert(num);
        }

        int ans = 0;

        for (int num : nums) {
            ans = Math.max(ans, query(num));
        }

        return ans;
    }

    private void insert(int num) {

        TrieNode node = root;

        for (int i = 31; i >= 0; i--) {

            int bit = (num >> i) & 1;

            if (node.child[bit] == null) {
                node.child[bit] = new TrieNode();
            }

            node = node.child[bit];
        }
    }

    private int query(int num) {

        TrieNode node = root;

        int ans = 0;

        for (int i = 31; i >= 0; i--) {

            int bit = (num >> i) & 1;

            int want = bit ^ 1;

            if (node.child[want] != null) {

                ans |= (1 << i);
                node = node.child[want];

            } else {

                node = node.child[bit];
            }
        }

        return ans;
    }
}