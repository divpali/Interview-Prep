package Hackerrank;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class AutoComplete {
	
	//TrieNode
	class TrieNode {
		Map<Character, TrieNode> children;
		boolean isLeafNode;
		String value;

		TrieNode(String value) {
			children = new HashMap<>();
			isLeafNode = false;
			this.value = value;
		}
	}

	private static final int Map = 0;
	
	TrieNode root;
	
	public AutoComplete() {
		this.root = new TrieNode("");
	}
	
	protected void add(TrieNode node, char c) {
        String val;
        if (node.value == null) {
            val = Character.toString(c);
        } else {
            val = node.value + c;
        }
        node.children.put(c, new TrieNode(val));
    }
	
	public void insert(String word) {
        if (word == null) {
            throw new IllegalArgumentException("Cannot add null to a Trie");
        }
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (!node.children.containsKey(c)) {
                add(node, c);
            }
            node = node.children.get(c);
        }
        node.isLeafNode = true;
    }
	
	public String find(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (!node.children.containsKey(c)) {
                return "";
            }
            node = node.children.get(c);
        }
        return node.value;
    }
	
	public Collection<String> autoComplete(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            if (!node.children.containsKey(c)) {
                return Collections.emptyList();
            }
            node = node.children.get(c);
        }
        return allPrefixes(node);
    }

    protected Collection<String> allPrefixes(TrieNode node) {
        List<String> results = new ArrayList<String>();
        if (node.isLeafNode) {
            results.add(node.value);
        }
        for (Entry<Character, TrieNode> entry : node.children.entrySet()) {
            TrieNode child = entry.getValue();
            Collection<String> childPrefixes = allPrefixes(child);
            results.addAll(childPrefixes);
        }
        return results;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AutoComplete a = new AutoComplete();
		a.insert("test");
		a.insert("tests");
		a.insert("testing");
		a.insert("tes");
		
		System.out.println("auto complete feature");
		Collection<String> res = a.autoComplete("test");
		Iterator<String> i = res.iterator();
        while (i.hasNext()) {
			System.out.println(i.next());			
		}
	}

}
