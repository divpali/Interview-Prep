package DoublyLinkedList;

class Node {
	int data;
	Node prev;
	Node next;

	Node(int data) {
		this.data = data;
	}
}

public class Insertion {

	Node head;
	Node tail;

	// adding new node to a DLL
	public void insertHead(int new_data) {
		Node newNode = new Node(new_data);
		
		if (tail == null) {
			tail = newNode;
			head = newNode;
		} else {
			tail.next = newNode;
			newNode.prev = tail;
			newNode.next = null;
			tail = newNode;
		}
	}
	
	public void insertBeforeHead(int data) {
		Node newNode = new Node(data);
		Node current = head;
		head.prev = newNode; 
		newNode.next = current;
		head = newNode;
	}
	
	public void insertAfterAKey(int findKey, int insertKey) {
		Node newNode = new Node(insertKey);
		Node current = head;
		
		while(current!=null) {
			if (current.data == findKey) {
				newNode.next = current.next;
				newNode.prev = current.prev;
				current = newNode;
				break;
			}
			current = current.next;
		}
		
		if (newNode.next!=null) {
			newNode.next.prev = newNode;
		}
		traverse();
		
	}
	
	public void traverse() {
		while(head!=null) {
			System.out.println(head.data);
			head = head.next;
		}
	}
	
	//adding node at the end
	public void addingNodeAtTheEnd(int data) {
		Node node = new Node(data);
		node.next = null;
		if(tail == null) {
			head = node;
			tail = node;
			node.prev = null;
		} else {
			tail.next = node;
			node.prev = tail;
			tail = node;
		}
		
	}

	public static void main(String[] args) {
		Insertion n = new Insertion();
		/*
		 * n.insertHead(10); n.insertHead(20); n.insertHead(12);
		 * 
		 * n.insertBeforeHead(41); n.insertBeforeHead(42);
		 * 
		 * n.insertAfterAKey(20, 22); n.traverse();
		 */
		
		n.addingNodeAtTheEnd(10);
		n.addingNodeAtTheEnd(20);
		n.addingNodeAtTheEnd(30);
		n.traverse();

	}

}
