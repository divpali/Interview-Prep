package Easy;

import java.util.Arrays;

/*
 * Find closest value in an array for a given number
 */
public class ClosestValue {
	
	//-1, -3, 4, 5, 2    {0}
	int findClosestValue(int[] arr, int num) {
		//sort arr
		Arrays.parallelSort(arr);
		return nearestNum(arr,0,arr.length-1,num);	
	}
	
	private int nearestNum(int[] arr, int start, int end, int num) {
		int mid = (start + end)/2;
		if(arr[mid] == num) {
			return arr[mid];
		}
		if(start == end-1) {
			if(Math.abs(arr[start]-num) > Math.abs(arr[end]-num)) {
				return arr[end];
			} else {
				return arr[start];
			}
		}
		if(arr[mid] < num) {
			return nearestNum(arr, mid, end, num);
		} else {
			return nearestNum(arr, start, mid, num);
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClosestValue c = new ClosestValue();
		int[] arr = {-1, -3, 4, 5, 2};
		int res = c.findClosestValue(arr, 1);
//		int res = c.findClosest(arr, 1);
		System.out.println("closest value to 0 in arr is "+res);
	}

}
