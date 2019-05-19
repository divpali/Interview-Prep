package StacksAndQueues;

import java.util.Stack;

public class FindNextGreaterElement {
	
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
		System.out.println("");
		System.out.println("Next greatest element");
		int[] arr = {1,3,2,4};
		nextGreaterElement(arr);

	}

}
