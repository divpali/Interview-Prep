package StacksAndQueues;

import java.util.Stack;

public class BalancedParenthesis {

	public void balanceExpression(String input) {
		int len = input.length();
		char[] ch = input.toCharArray();
		Stack<Character> stk = new Stack<Character>();
		for (char c : ch) {
			if (c == '{' || c == '[' || c == '(') {
				stk.push(c);
			}
			if (c == '}' && stk.peek() == '{' || c == ']' && stk.peek() == '[' || c == ')' && stk.peek() == '(') {
				stk.pop();
			}
		}
		if (stk.isEmpty()) {
			System.out.print("balanced");
		} else {
			System.out.print("not balanced");
		}

	}

	public static void main(String[] args) {
		BalancedParenthesis s = new BalancedParenthesis();
		s.balanceExpression("{[]");
	}

}
