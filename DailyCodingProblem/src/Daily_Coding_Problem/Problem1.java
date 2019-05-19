package Daily_Coding_Problem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
 */
public class Problem1 {
	
	static int[] a = new int[2];
	
	public static boolean addUp(int[] arr, int k) {
		
		if (arr.length == 0 || arr == null) {
			return false;
		}
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < arr.length; i++) {
			int curr = arr[i];
			if (map.containsKey(k-curr)) {
				System.out.println((k-curr) + "," +arr[i]);
				a[0] = i;
				for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
					if(entry.getKey()== k-curr) {
						int val = entry.getValue();
						a[1] = val;
					}
				}
				return true;
			}
			map.put(curr, i);
		}
		
		return false;	
	}
	
	public static void printArray(int[] num) {
        for(int i = 0; i< num.length; i++) {
            System.out.println(num[i]);
        }
        
    }
	
	
	public static int playlist(String[] songs, int k, String q) {
	    // Write your code here
	        //A -> B -> C -> D -> E -> F
	        //0    1    2    3    4    5
	        //size of list = size = 6
	        //size - k -1 = 4
	        int size = songs.length;
	        int qIndex = getQIndex(songs, q, size);

	        int o_count=(size-1) - k + qIndex +1;
	        int res = Math.min(k-qIndex,o_count);
	        return res;
	    }

	private static int getQIndex(String[] songs, String q, int size) {
		for(int i=0;i<size;i++) {
		    if(songs[i]==q) {
		        return i;
		    }
		}
		return -1;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * int[] arr = {10, 15, 3, 7}; int k = 17; boolean res = addUp(arr, k);
		 * System.out.println(res); printArray(a);
		 */
		
		String[] s = {"A", "B", "C", "D", "E", "F"};   //  k - qIndex   (size-1) - k + qIndex + 1
		int res = playlist(s, 5, "A");
		System.out.println(res);

	}

}
