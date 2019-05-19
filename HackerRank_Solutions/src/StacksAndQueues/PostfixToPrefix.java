package StacksAndQueues;

import java.util.Stack;

public class PostfixToPrefix {
	
	public boolean isOperator(char ch) {
	    switch(ch) {
	        case '+' : return true; 
	        case '-' : return true; 
	        case '*' : return true; 
	        case '/' : return true; 
	    }
	    return false;
	  }
	  
	  public String postToPre(String post_exp) { 
	    Stack<String> stk = new Stack<String>();
	    int n = post_exp.length();
	    for(int i=0;i<n;i++) {
	      if(isOperator(post_exp.charAt(i))) {
	        String op1 = stk.peek(); stk.pop();
	        String op2 = stk.peek(); stk.pop();
	        String temp = post_exp.charAt(i)+op2+op1;
	        stk.push(temp);
	      } else {
	        stk.push(post_exp.charAt(i)+"");
	      }
	    }
	    return stk.peek();
	  } 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PostfixToPrefix s = new PostfixToPrefix();
		System.out.println(s.postToPre("AB*"));
	}

}
