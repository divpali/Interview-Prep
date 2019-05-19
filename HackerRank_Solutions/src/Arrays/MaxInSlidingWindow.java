package Arrays;

import java.util.Deque;
import java.util.LinkedList;

/*
 * Given an array and an integer k, find the maximum for each and every contiguous subarray of size k.
 */
public class MaxInSlidingWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 2, 3, 1, 4, 5, 2, 3, 6};
		int k = 3;
		printMaxInWindow(arr,k);
		
 	}

	private static void printMaxInWindow(int[] arr, int k) {
		
		//Initialize the dequeue
		Deque<Integer> Qi = new LinkedList<Integer>();
		int i;
		//find max in the first window
		for (i = 0; i < k; i++) {
			while(!Qi.isEmpty() && arr[i]<=arr[Qi.peekLast()]) {
				Qi.removeLast();
			}
			Qi.addLast(i);
		}
		
		for( ;i < arr.length; ++i) {
			System.out.println(arr[Qi.peek()]);
			
			while(!Qi.isEmpty() && Qi.peek()<=i-k) {
				Qi.removeFirst();
			}
			
			while(!Qi.isEmpty() && arr[i]<=arr[Qi.peekLast()]) {
				Qi.removeLast();
			}
			Qi.addLast(i);
		}
	}

}
