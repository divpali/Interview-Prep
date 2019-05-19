package Hackerrank;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

/*
We're going to make our own Contacts application! The application must perform two types of operations:

add name, where  is a string denoting a contact name. This must store  as a new contact in the application.
find partial, where  is a string denoting a partial name to search the application for. It must count the number of contacts starting with  and print the count on a new line.
Given  sequential add and find operations, perform each operation in order.

 */

public class PhoneDirectory {

	class TrieNode {
		Map<Character, TrieNode> children;
		boolean isLeafNode;
		int count;

		TrieNode() {
			children = new HashMap<>();
			isLeafNode = false;
			count = 0;
		}
	}

	TrieNode root;

	public PhoneDirectory() {
		root = new TrieNode();
	}

	public void insert(String word) {
		TrieNode current = root;
		current.count += 1;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			TrieNode node = current.children.get(ch);
			if (node == null) {
				node = new TrieNode();
				current.children.put(ch, node);
			}
			current = node;
			current.count += 1;
		}
		// mark the current nodes endOfWord as true
		current.isLeafNode = true;
	}

	public TrieNode searchNode(String str) {
		TrieNode curr = root;
		TrieNode node = null;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (root.children.containsKey(ch)) {
				node = root.children.get(ch);
				root.children = node.children;
			} else {
				return null;
			}
		}
		return node;
	}

	public boolean searchCompleteWord(String word) {
		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			TrieNode node = current.children.get(ch);
			// if node does not exist for given char then return false
			if (node == null) {
				return false;
			}
			current = node;
		}

		// return true of current's endOfWord is true else return false.
		return current.isLeafNode;
	}

	public boolean searchPrefix(String str) {
		String s = "";
		TrieNode curr = root;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			if (curr.children.containsKey(ch)) {
				System.out.println("contains " + ch + " with count " + curr.count);
				s = s + ch;
			}

			curr = curr.children.get(ch);

			if (curr == null) {
				return false;
			}

		}
		System.out.println(s + " is present");
		// bfs
//		return curr.count;
		return (str.equals(s)) ? true : false;
	}

	public static void main(String[] args) {
		PhoneDirectory s = new PhoneDirectory();
		s.insert("abc");
		s.insert("abdb");
		s.insert("cd");
		s.insert("pqr");

		System.out.println(s.searchPrefix("ab"));

		System.out.println(s.searchCompleteWord("ha"));
		System.out.println(s.searchPrefix("abdb"));
		System.out.println(s.searchPrefix("pq"));
		System.out.println(s.searchPrefix("xy"));

		TrieNode node = s.searchNode("hac");

	}

}
