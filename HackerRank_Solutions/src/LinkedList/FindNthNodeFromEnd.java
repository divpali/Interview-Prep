package LinkedList;

/*
 * quantcast interview
 */
public class FindNthNodeFromEnd {
	
	public static Node findNthNodeFromEnd1(Node headNode, int n) {
	    if(headNode== null) {
	      return null;
	    }
	    
	    Node p1 = headNode;
	    Node p2 = headNode;
	    
	    int count = 1;
	    
	    while(p1!=null) {
	      if(count==n+1) {
	        break;
	      }
	      count++;
	      p1 = p1.next;
	    }
	    
	    
	    if(count == n+1) {
	       while(p1!=null) {
	        p1 = p1.next;
	        p2 = p2.next;
	       }
	      return p2;
	        
	  }
	    return null;
	  }

	
	public static Node findNode(Node headNode, int n) {
		Node p1 = headNode;
		Node p2 = headNode;
		int count = 1;
		
		while(count <= n-1) {
			p2 = p2.next;
			count++;
		}
		
		while(p2.next==null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1.next;
	}
	
	//4 -> 3 -> 5 -> 9 -> 6
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node node = new Node(4);
	    node.next = new Node(3);
	    node.next.next = new Node(5);
	    node.next.next.next= new Node(9);
	    node.next.next.next.next = new Node(6);
	    
		/*
		 * Node node1 = findNthNodeFromEnd1(node, 3); System.out.println(node1.data);
		 */
	    Node node2 = findNode(node, 4);
	    System.out.println(node2.data);
	}

}
