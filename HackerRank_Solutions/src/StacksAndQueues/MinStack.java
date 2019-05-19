package StacksAndQueues;

/*
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
 */



public class MinStack {
	//-3, -3
    //0, -2
    //-2 , -2
    //val, min
	class Node {
	    int value;
	    int min;
	    Node next;
	     
	    Node(int x)
	    {
	        value = x;
	        next = null;
	        min = x;
	    }
	}
    
	Node top;
    
    public void push(int x)
    {
        if(top == null) {
            top = new Node(x);
        }
        else
        {
            Node temp = new Node(x);
            temp.next = top;
            temp.min = Math.min(top.min, x);
            top = temp;
        }
    }
     
    public void pop()
    {
        if(top == null)
        {
            System.out.println("Stack empty!");
            return;
        }
         
        top = top.next;
    }
     
    public int top()
    {
        if(top == null)
        {
            System.out.println("Stack empty!");
            return Integer.MAX_VALUE;
        }
         
        return top.value;
    }
     
    public int min()
    {
        if(top == null)
        {
            System.out.println("Stack empty!");
            return Integer.MAX_VALUE;
        }
         
        return top.min;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinStack m = new MinStack();
		m.push(-2);
		m.push(0);
		m.push(-3);
		int min = m.min();
		System.out.println("minimum element : "+min);
		int top = m.top();
		System.out.println("top element : "+top);
		m.pop();
		System.out.println("top element now : "+m.top());
		System.out.println("min element now : "+m.min());

	}

}
