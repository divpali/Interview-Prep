package LinkedList;

public class KthNodeFromLast {

	Node head;
	Node tail;

	class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	// add new Node;
	public void add(int data) {
		Node nodeToAdd = new Node(data);
		if (tail == null) {
			tail = nodeToAdd;
			head = nodeToAdd;
		} else {
			tail.next = nodeToAdd;
			tail = nodeToAdd;
		}
	}

	public static void main(String[] args) {
		KthNodeFromLast l = new KthNodeFromLast();
		l.add(12);
		l.add(121);
		l.add(1);
		l.add(2);
		int k = 2;
		int length = l.traverseNode(k);
		System.out.println(length);
	}

	private int traverseNode(int k) {
		Node node = head;
		int count = 1;
		while (node.next != null) {
			node = node.next;
			count++;
		}
		return count;
	}
}
