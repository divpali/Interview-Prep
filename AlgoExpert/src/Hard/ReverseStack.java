package Hard;

import java.util.Stack;

public class ReverseStack {
	
	private static void insertAtBottom(Stack<Integer> stk, int x) {
		if(stk.isEmpty()) {
			stk.push(x);
			return;
		} else {
			int temp = stk.pop();
			insertAtBottom(stk, x);
			stk.push(temp);
		}
	}
	
	public static Stack<Integer> reverse(Stack<Integer> stack) {
		if(stack.isEmpty()) {
			return stack;
		}
		int temp = stack.pop(); //
		reverse(stack);
		insertAtBottom(stack, temp);
		return stack;
	}

	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		s.push(4);
		s.push(3);
		s.push(2);
		s.push(1);
		
		System.out.println(reverse(s));
	}

}
