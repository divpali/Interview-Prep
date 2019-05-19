package StacksAndQueues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MyStacksAndQueues {

	// Implement stack using queues
	Queue<Integer> q1 = new LinkedList<Integer>();
	Queue<Integer> q2 = new LinkedList<Integer>();

	public void push(int data) {
		if (q1.peek() == null) {
			q1.add(data);
		} else {
			/*
			 * for (int i = q1.size(); i > 0; i--) { q2.add(q1.remove()); } q1.add(data);
			 * for (int j = q2.size(); j > 0; j--) { q1.add(q2.remove()); }
			 */
			while (!q1.isEmpty()) {
				q2.add(q1.remove());
			}
			q1.add(data);
			while (!q2.isEmpty()) {
				q1.add(q2.remove());
			}
		}
	}

	public int peek() {
		return q1.peek();
	}

	public int pop() {
		if (q1.peek() == null) {
			return -1;
		} else {
			return q1.remove();
		}
	}

	// ------------------------------------------------------------//

	// Implement queue using stacks
	Stack<Integer> stackNewestOnTop = new Stack<Integer>();
	Stack<Integer> stackOldestOnTop = new Stack<Integer>();

	public void enqueue(int data) {
		stackNewestOnTop.push(data);
	}

	public int peekForQueue() {
		// keep all the incoming elelments in the newest stack
		// until the oldest is empty
		shiftStack();
		return stackOldestOnTop.peek();
	}

	private void shiftStack() {
		if (stackOldestOnTop.isEmpty()) {
			while (!stackNewestOnTop.isEmpty()) {
				stackOldestOnTop.push(stackNewestOnTop.pop());
			}
		}
	}

	public int dequeue() {
		shiftStack();
		return stackOldestOnTop.pop();

	}

	// next greater element for each element of the array within the array
	//1 3 2 4
	public static void nextGreaterElement(int[] arr) {
		int next, element;
		Stack<Integer> stk = new Stack<Integer>();
		
		stk.push(arr[0]);
		
		for (int j = 1; j < arr.length; j++) {
			next = arr[j];
			if(stk.isEmpty() == false) {
				element = stk.pop();
				
				while(element < next) {
					System.out.println(element +"------>"+ next);
					if(stk.isEmpty()==true) {
						break;
					}
					element = stk.pop();
				}
				
				if (element>next) {
					stk.push(element);
				}
			}
			stk.push(next);
			
		}
		
		while(!stk.isEmpty()) {
			element = stk.pop();
			next = -1;
			System.out.println(element +"------>"+ next);
		}
		
	}

	public static void main(String[] args) {
		MyStacksAndQueues m = new MyStacksAndQueues();
		System.out.println("Implement stack using queue");
		m.push(1);
		m.push(2);
		m.push(3);
		m.push(4);
		System.out.println(m.pop());
		m.push(5);
		System.out.println(m.pop());
		System.out.println(m.pop());

		System.out.println("");
		System.out.println("Implement Queue using stack");
		m.enqueue(1);
		m.enqueue(2);
		m.enqueue(3);
		System.out.println(m.peekForQueue());
		m.dequeue();
		m.enqueue(4);
		System.out.println(m.dequeue());
		
		
		System.out.println("");
		System.out.println("Next greatest element");
		int[] arr = {1,3,2,4};
		nextGreaterElement(arr);
	}
}
