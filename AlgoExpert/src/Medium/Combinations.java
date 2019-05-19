package Medium;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
	//{1,2,3}
	public static List<List<Integer>> subset(int[] arr) {
		//result set
		List<List<Integer>> result = new ArrayList<List<Integer>>(); //[[],[1], [1,2]....]
		List<Integer> subset = new ArrayList<Integer>();
		subsetUtil(arr, result, subset,0);
		return result;
	}

	private static void subsetUtil(int[] arr, List<List<Integer>> result, List<Integer> subset, int start) {
		result.add(new ArrayList(subset));
		for(int i=start;i<arr.length;i++) {
			subset.add(arr[i]);
			subsetUtil(arr, result, subset, i +1);
			subset.remove(subset.size()-1);
		}
	}

	public static void main(String[] args) {
		int[] arr = {1,2,3};
		System.out.println(subset(arr));

	}

}
