package Trie;


public class TrieImpl {

    private final TrieNode root;

    public TrieImpl(){
        root = new TrieNode();
    }

    /*
        insert into trie
     */
    public void addWord(String s){
        TrieNode current = root;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            TrieNode node = current.children.get(ch);
            if (node == null){
                node = new TrieNode();
                current.children.put(ch,node);
            }
            current = node;
        }
        current.endOfWord = true;
    }

    /*
        search into trie
     */
    public boolean search(String s){
        TrieNode current = root;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            TrieNode node = current.children.get(ch);
            if (node == null){
                return false;
            }else {
                current = node;
            }
        }
        return current.endOfWord;
    }
}
