package Trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

    String key;
    int count;

    Map<Character, TrieNode> children;
    boolean endOfWord;

    TrieNode(){
        children = new HashMap<>();
        endOfWord = false;
    }
}
