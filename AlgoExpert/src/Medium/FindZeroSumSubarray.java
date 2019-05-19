package Medium;

import java.util.HashMap;
import java.util.Map;

public class FindZeroSumSubarray {
	
	// arr = 1,2,-5,1,2,-1
	// sum = 0,1,3,-2,-1,1,0
	//	i  = 0,1,2,3,4,5,6
	public static void zeroSum(int[] arr) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int sum = 0;
		int startIndex=0, endIndex=0;
		if(map.isEmpty()) {
			map.put(sum, 0);
		}
		for(int i=1;i<arr.length;i++) {
			sum += arr[i-1]; //1,3,-2
			if(!map.containsKey(sum)) {
				map.put(sum, i);
			} else {
				startIndex = map.get(sum);
				endIndex = i;
			}
		}
		
		System.out.println("startIndex : "+startIndex +", endIndex : "+endIndex);
		for(int j=startIndex;j<endIndex;j++) {
			System.out.println(arr[j]);
		}
		
		/*
		 * for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
		 * System.out.println(entry.getKey() +", "+entry.getValue()); }
		 */
	  }

	public static void main(String[] args) {
		int[] arr = {1,2,-5,1,2,-1};
		zeroSum(arr);

	}

}
