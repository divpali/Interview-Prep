package StacksAndQueues;

import java.util.Stack;

public class ValidateParenthesis {

    public static void main(String[] args) {
        String exp = "{[}";
        boolean val = validate(exp);
        System.out.println(val);
    }

    private static boolean validate(String exp) {
        //create stack
        Stack<Character> stack = new Stack<>();
        boolean result;
        Character current,previous;

        for(int i=0; i< exp.length(); i++){
            current = exp.charAt(i);
            if (current=='{' || current=='[' || current=='('){
                stack.push(current);
            }else if(current=='}' || current==']' || current==')'){
                if (stack.isEmpty()){
                    return false;
                }else {
                    previous = stack.peek();
                    if (current=='}' && previous=='{' || current==']' && previous=='[' || current=='(' && previous==')'){
                        stack.pop();
                    }else {
                        return false;
                    }
                }

            }
        }
        if (stack.isEmpty()){
            return true;
        }else {
            return false;
        }
    }

}
