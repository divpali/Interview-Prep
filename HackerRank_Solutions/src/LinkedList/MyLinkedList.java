package LinkedList;

class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
	}
}

public class MyLinkedList {

	Node head;
	Node tail;
	static Node head1;
	static Node head2;

	/*
	 * grab interview
	 */
	public int createList(int[] A) {
		Node node = new Node(A[0]);
		head = node; // A[0] == 1
		tail = node; // A[0] == 1

		// A[1] = 4 --> A[4] = 2 --> A[2] = -1
		while (A[tail.data] != -1) {
			tail.next = new Node(A[tail.data]); // 1 -> 4
			tail = tail.next;
		}
		tail = new Node(A[tail.data]);

		Node n = head;
		int count = 1;
		while (n != null) {
			count++;
			n = n.next;
		}
		return count;

	}

	// add node to given linked list
	public void addNode(int data) {
		Node nodeToAdd = new Node(data);
		if (tail == null) {
			tail = nodeToAdd;
			head = nodeToAdd;
		} else {
			tail.next = nodeToAdd;
			tail = nodeToAdd;
		}
	}

	// Middle of a given linked list
	public int printMiddleElement() {
		Node slow = head;
		Node fast = head;

		if (head != null) {
			while (fast != null && fast.next != null) {
				fast = fast.next.next;
				slow = slow.next;
			}
		}

		return slow.data;
	}

	// Delete Middle of Linked List
	public void deleteMiddleElement() {
		Node slow = head;
		Node fast = head;
		Node previous = head;

		if (head != null) {
			while (fast != null && fast.next != null) {
				fast = fast.next.next;
				previous = slow;
				slow = slow.next;
			}
		}
		previous.next = slow.next;
	}

	// Remove duplicates from Linked List
	public void removeDuplicateFromLinkedList() {
		Node currentNode = head;
		while (currentNode.next != null) {
			if (currentNode.data == currentNode.next.data) {
				currentNode.next = currentNode.next.next;
			} else {
				currentNode = currentNode.next;
			}
		}
	}

	// reverse linked list
	public void reverseLL() {
		Node node = head;
		Node p1, p2, p3;
		p1 = p2 = null;
		p3 = node;
		while (p3 != null) {
			p1 = p2;
			p2 = p3;
			p3 = p3.next;
			p2.next = p1;
		}
		head = p2;
	}

	// Add 1 to a number represented as linked list
	public Node addToLinkedList(Node node1, Node node2) {
		reverseLL(); // 9->9->9->1
		Node nodeToTraverse = head;
		System.out.println(nodeToTraverse.data);
		int sum = 0;
		int carry = 0;
		Node res = null;
		while (nodeToTraverse != null) {
			sum += carry + nodeToTraverse.data + 1;

			carry = (sum >= 10) ? 1 : 0;
			sum = sum % 10;

			// create node of sum
			Node newListNode = new Node(sum);

			// if this is first node then set it as head
			if (res == null) {
				res = newListNode;
			} else {
				res.next = newListNode;
			}
		}

		if (carry > 0) {
			res.next = new Node(carry);
		}
		return res;

	}

	// reverse groups of nodes in linked list
	public Node reveseGrps(Node head, int k) {
		int x = k;
		Node node = head;
		Node p1, p2, p3;
		p1 = p2 = null;
		p3 = node;
		while (p3 != null && x > 0) {
			p1 = p2;
			p2 = p3;
			p3 = p3.next;
			p2.next = p1;
			x--;
		}
		if (p3 != null) {
			head.next = reveseGrps(p3, k);
		}
		return p2;

	}

	public void deleteNode(Node headNode, int key) {
		if (headNode == null) {
			return;
		}

		Node node = find(headNode, key);
		node.data = node.next.data;
		node.next = node.next.next;

	}

	private Node find(Node headNode, int key) {
		// TODO Auto-generated method stub
		while (headNode.data != key) {
			headNode = headNode.next;
		}
		return headNode;

	}

	public void display(Node head) {
		Node n = head;
		while (n != null) {
			System.out.print("->" + n.data);
			n = n.next;
		}
	}

	// 4->3->5->7->8->3->4
	// p1 p2
	public Node findNthNodeFromEnd(Node headNode, int k) {
		if (headNode == null) {
			return null;
		}

		Node p1 = headNode;
		Node p2 = headNode;
		int count = 1;

		while (count != k + 1) {
			p2 = p2.next;
			count++;
		}

		while (p2 != null) {
			p1 = p1.next;
			p2 = p2.next;
		}

		return p1.next;
	}

	/*
	 * ======================================================================== Swap
	 * Nth node with head
	 * ========================================================================
	 */
	// 1->2->3->4->5->6->7->8
	// n=4
	public void swapNthNodeWithHead(Node headNode, int n) {
		if (headNode == null || headNode.next == null) {
			return;
		}
		Node current = headNode;
		int count = 1;
		while (count != n - 1) {
			current = current.next; // 3
			count++;
		}
		Node dummy = current.next; // 4
		current.next = current.next.next; // 5
		dummy.next = headNode;
		head = dummy;

		while (dummy != null) {
			System.out.println(dummy.data);
			dummy = dummy.next;
		}

	}

	/*
	 * ========================================================================
	 * Traverse linked list
	 * ========================================================================
	 */
	private void traverse() {
		Node nodeToTraverse = head;
		while (nodeToTraverse != null) {
			System.out.println(nodeToTraverse.data);
			nodeToTraverse = nodeToTraverse.next;
		}

	}

	/*
	 * ======================================================================== Sort
	 * Linked List
	 * ========================================================================
	 */
	// 1->4->5
	// 2->3->6
	// 0->
	public Node sortedMerge(Node nodeA, Node nodeB) {
		Node result = null;

		if (nodeA == null) {
			return nodeB;
		}
		if (nodeB == null) {
			return nodeA;
		}

		if (nodeA.data <= nodeB.data) {
			result = nodeA;
			result.next = sortedMerge(nodeA.next, nodeB);
		} else {
			result = nodeB;
			result.next = sortedMerge(nodeA, nodeB.next);
		}
		return result;
	}

	public Node mergeSort(Node headNode) {
		if (headNode == null || headNode.next == null) {
			return headNode;
		}

		Node middleNode = getMiddleNodeOfLinkedList(headNode);
		Node middleNodeNext = middleNode.next;

		middleNode.next = null;

		Node left = mergeSort(headNode);
		Node right = mergeSort(middleNodeNext);

		Node result = sortedMerge(left, right);
		return result;

	}

	private Node getMiddleNodeOfLinkedList(Node headNode) {
		// TODO Auto-generated method stub
		Node slowNode = headNode;
		Node fastNode = headNode.next;
		while (fastNode != null) {
			fastNode = fastNode.next;
			if (fastNode != null) {
				slowNode = slowNode.next;
				fastNode = fastNode.next;
			}
		}
		return slowNode;
	}

	/*
	 * ========================================================================
	 * Insert node to head
	 * ========================================================================
	 */
	// insert Node in head
	public void insertNodeToHead(int data) {
		Node nodeToAddInHead = new Node(data);
		nodeToAddInHead.next = head;
		head = nodeToAddInHead;
	}

	/*
	 * ========================================================================
	 * Insert node after kth element
	 * ========================================================================
	 */
	// insert Node after kth element
	public void insertNodeAfterKthElement(int data, int k) {
		Node nodeToAdd = new Node(data); // 20
		Node nodeTofind = new Node(k); // 13
		Node nodeToTraverse = head;

		while (nodeToTraverse.data != nodeTofind.data) {
			nodeToTraverse = nodeToTraverse.next;
		}
		nodeToAdd.next = nodeToTraverse.next;
		nodeToTraverse.next = nodeToAdd;
	}

	/*
	 * ========================================================================
	 * Print middle node
	 * ========================================================================
	 */
	// print middle Node
	public int printMiddleNode() {
		Node slow_ptr = head;
		Node fast_ptr = head;

		if (head != null) {
			while (fast_ptr != null && fast_ptr.next != null) {
				slow_ptr = slow_ptr.next;
				fast_ptr = fast_ptr.next.next;
			}
		}
		return slow_ptr.data;
	}

	// find kth to last element
	public int findKthToLastElement(int k) {
		int length = lengthOfLinkedList();
		int result = length - k;
		int count = 1;
		Node nodeToTraverse = head;
		while (nodeToTraverse != null && count != result) {
			nodeToTraverse = nodeToTraverse.next;
			count++;
		}
		return nodeToTraverse.data;
	}

	private int lengthOfLinkedList() {
		int count = 0;
		Node nodeToTravserse = head;
		while (nodeToTravserse.next != null) {
			nodeToTravserse = nodeToTravserse.next;
//            System.out.println(nodeToTravserse.data);
			count++;
		}
		System.out.println("linked list size : " + count);
		return count;
	}

	// reverse a linked list
	// a -> b -> c -> d
	public void reverseLinkedList() {
		Node node = head;
		Node p1, p2, p3;
		p1 = p2 = null;
		p3 = node;
		while (p3 != null) {
			p1 = p2;
			p2 = p3;
			p3 = p3.next;
			p2.next = p1;
		}
		node = p2;

	}

	/*
	 * ========================================================================
	 * Remove duplicate elements from linked list
	 * ========================================================================
	 */
	// remove duplicate elements from linked list
	public void removeDuplicates() {
		Node current = head;
		while (current != null) {
			Node runner = current;
			while (runner.next != null) {
				if (runner.next.data == current.data) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			current = current.next;
		}
	}

	// delete middle Node
	public int findMiddleNode() {
		Node slow_node = head;
		Node fast_node = head;
		while (fast_node != null && fast_node.next != null) {
			slow_node = slow_node.next;
			fast_node = fast_node.next.next;
		}
		return slow_node.data;
	}

	// find a loop in linked list
	public boolean findALoop() {
		Node slow_node = head;
		Node fast_node = head;
		while (fast_node != null && fast_node.next != null) {
			slow_node = slow_node.next;
			fast_node = fast_node.next.next;
			if (slow_node.next.data != fast_node.next.next.data) {
				return false;
			} else {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		MyLinkedList ll = new MyLinkedList();
		int[] A = { 1, 4, -1, 3, 2 };
		int res = ll.createList(A);
		System.out.println(res);

		/*
		 * ll.addNode(10); ll.addNode(100); ll.addNode(13); ll.addNode(1);
		 * ll.addNode(0); ll.addNode(20); ll.addNode(25); ll.addNode(33); ll.traverse();
		 * 
		 * ll.reverseLL(); System.out.println("traverse list"); ll.traverse();
		 * 
		 * 
		 * int mid = ll.printMiddleElement(); System.out.println(mid);
		 * 
		 * ll.deleteMiddleElement();
		 * 
		 * MyLinkedList llDup = new MyLinkedList(); llDup.addNode(10);
		 * llDup.addNode(10); llDup.addNode(13); llDup.addNode(13); llDup.addNode(20);
		 * llDup.addNode(20); llDup.addNode(20); llDup.addNode(33);
		 * llDup.removeDuplicateFromLinkedList();
		 */

		MyLinkedList ll2 = new MyLinkedList();
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		head.next.next.next.next.next.next = new Node(7);
		head.next.next.next.next.next.next.next = new Node(8);
		System.out.println("");
		System.out.println("reverse list in groups");
		Node x = ll2.reveseGrps(head, 3);
		ll2.display(x);

		System.out.println(" ");
		System.out.println("Delete node");
		ll2.deleteNode(head, 5);
		ll2.display(x);

		System.out.println(" ");
		Node node = ll2.findNthNodeFromEnd(head, 3);
		System.out.println("nth node from end : " + node.data);

		Node head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = new Node(4);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(6);
		head1.next.next.next.next.next.next = new Node(7);
		head1.next.next.next.next.next.next.next = new Node(8);
		System.out.println(" ");
		ll2.swapNthNodeWithHead(head1, 4);

		System.out.println(" ");

		System.out.println("Merge two lists: ");
		MyLinkedList ll3 = new MyLinkedList();
		Node headA = new Node(1);
		headA.next = new Node(4);
		headA.next.next = new Node(5);

		Node headB = new Node(2);
		headB.next = new Node(3);
		headB.next.next = new Node(6);

		Node nodeTra = ll3.sortedMerge(headA, headB);
		ll3.display(nodeTra);

		System.out.println(" ");
		System.out.println("Merge sort a linked list");
		MyLinkedList ll4 = new MyLinkedList();
		Node node3 = new Node(10);
		node3.next = new Node(100);
		node3.next.next = new Node(13);
		node3.next.next.next = new Node(1);
		node3.next.next.next.next = new Node(0);
		node3.next.next.next.next.next = new Node(20);
		node3.next.next.next.next.next.next = new Node(35);
		node3.next.next.next.next.next.next.next = new Node(33);
		Node middleNode = ll4.getMiddleNodeOfLinkedList(node3);
		System.out.println("middle element of linkedlist = " + middleNode.data);
		System.out.println(" ");
		System.out.println(" Sorted linkedlist:");
		Node resultNode = ll4.mergeSort(node3);
		ll4.display(resultNode);

		System.out.println("Done");
	}

}
