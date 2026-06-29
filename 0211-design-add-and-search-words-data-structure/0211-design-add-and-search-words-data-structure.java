class WordDictionary {

    class Node{
        Node[] child=new Node[26];
        boolean end;
    }

    Node root;

    public WordDictionary() {
        root=new Node();
    }

    public void addWord(String word) {

        Node curr=root;

        for(char ch:word.toCharArray()){

            int idx=ch-'a';

            if(curr.child[idx]==null)
                curr.child[idx]=new Node();

            curr=curr.child[idx];
        }

        curr.end=true;
    }

    public boolean search(String word) {
        return dfs(word,0,root);
    }

    private boolean dfs(String word,int pos,Node node){

        if(node==null)
            return false;

        if(pos==word.length())
            return node.end;

        char ch=word.charAt(pos);

        if(ch=='.'){

            for(Node next:node.child){

                if(dfs(word,pos+1,next))
                    return true;
            }

            return false;
        }

        return dfs(word,pos+1,node.child[ch-'a']);
    }
}