package LinkedList;

public class AddingLinkedList {
	
	public Node addLists(Node first, Node second) {
		int sum = 0 , carry = 0;
		Node head = null;
		Node tail = null;
		Node temp = null;
		while(first != null || second != null) {
			sum = carry + ((first!=null)?first.data:0) + ((second!=null)?second.data:0);
			
			carry = (sum>=10) ? 1:0;
			
			sum = sum % 10;
			
			temp = new Node(sum);
			
			if(head==null) {
				head = temp;
			} else {
				tail.next = temp;
			}
			tail = temp;
			
			if(first!=null) {
				first = first.next;
			}
			if(second!=null) {
				second = second.next;
			}
			
		}
		if (carry>0) {
			temp.next = new Node(carry);
		}
		return head;
	}
	
	public void printList(Node node) {
		while(node!=null) {
			System.out.println(node.data + " ");
			node = node.next;
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
