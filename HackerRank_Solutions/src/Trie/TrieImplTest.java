package Trie;

import Trie.TrieImpl;

public class TrieImplTest {

    public static void main(String[] args){
        TrieImpl t = new TrieImpl();
        t.addWord("Divya");
        t.addWord("Diya");
        t.addWord("Dia");
        t.addWord("Rama");
        t.addWord("Raju");

        boolean val = t.search("Diya");
        System.out.println(val);

        System.out.println("Done");
    }
}
