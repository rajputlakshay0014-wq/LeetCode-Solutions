class Solution {

    class TrieNode {
        TrieNode[] child = new TrieNode[26];
        String word;
    }

    List<String> res = new ArrayList<>();

    public List<String> findWords(char[][] board,
                                  String[] words) {

        TrieNode root = buildTrie(words);

        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                dfs(board,i,j,root);
            }
        }

        return res;
    }

    private void dfs(char[][] board,
                     int i,int j,
                     TrieNode node) {

        if(i<0||j<0||
           i>=board.length||
           j>=board[0].length)
            return;

        char c = board[i][j];

        if(c=='#' || node.child[c-'a']==null)
            return;

        node = node.child[c-'a'];

        if(node.word != null){
            res.add(node.word);
            node.word = null;
        }

        board[i][j] = '#';

        dfs(board,i+1,j,node);
        dfs(board,i-1,j,node);
        dfs(board,i,j+1,node);
        dfs(board,i,j-1,node);

        board[i][j] = c;
    }

    private TrieNode buildTrie(String[] words){

        TrieNode root = new TrieNode();

        for(String word : words){

            TrieNode cur = root;

            for(char c : word.toCharArray()){

                if(cur.child[c-'a']==null)
                    cur.child[c-'a'] = new TrieNode();

                cur = cur.child[c-'a'];
            }

            cur.word = word;
        }

        return root;
    }
}