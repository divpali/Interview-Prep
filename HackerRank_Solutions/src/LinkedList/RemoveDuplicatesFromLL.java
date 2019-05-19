package LinkedList;

public class RemoveDuplicatesFromLL {

	public class LLNode {
	    LLNode next;
	    int data;

	    LLNode(int data){
	        this.data = data;
	    }
	}
	
    void findDuplicates(LLNode head){
        LLNode current = head;
        while(current!=null){
            LLNode runner = head;
            if (runner.next!=null && current.data == runner.next.data){
                runner.next = runner.next.next;
                runner.next = null;
            }
            runner = runner.next;
        }
        current = current.next;
    }

}
