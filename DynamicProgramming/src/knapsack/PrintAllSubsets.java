package knapsack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class PrintAllSubsets {
	
	public static void main(String[] args){
        int[] arr = {2,1};
//        System.out.println("print all subset of size k");
//        int k = 2;
//        boolean[] used = new boolean[arr.length];
//        printAllSizeKSubset(arr,used,0,0, k);
//        
//        List<List<Integer>> res = subsets(arr);
//        for(List<Integer> r : res) {
//        	System.out.println(r);
//        }
//        
//        System.out.println("find subset more than m");
//		findSubsetMoreThanK(res, 6);
		
		PrintAllSubsets s = new PrintAllSubsets();
		System.out.println("find all subsets of a set");
		int[] a = {1,2,3};
	    System.out.println(s.subsets1(a));
    }
	
	
	
	//using recursion
	public List<List<Integer>> subsets1(int[] arr) {
	    List<List<Integer>> res = new ArrayList<>();
	    if(arr == null || arr.length==0){
	      return res;
	    }
	    //sort array
//	    Arrays.sort(arr);
	    List<Integer> subset = new ArrayList<>();
	    toFindAllSubsets(arr, res, subset, 0);
	    
	    return res;
	  }
	  
	  public void toFindAllSubsets(int[] arr, List<List<Integer>> res,
	                                              List<Integer> subset, int start) {
	    res.add(new ArrayList<Integer>(subset));  //first is empty set
	    for(int i=start;i<arr.length;i++) {
	      subset.add(arr[i]); // 1
	      toFindAllSubsets(arr, res, subset, i+1);
	      
	      subset.remove(subset.size()-1);
	    }
	  }


	private static List<List<Integer>> subsets(int[] arr) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		helper(arr,res);
		return res;
	}

	private static void helper(int[] arr, List<List<Integer>> res) {
		//create an empty res
		if(res.size()==0) {
			res.add(new ArrayList<Integer>());
		}
		
		//traverse and add array elements
		for (int i = 0; i < arr.length; i++) {
			int n = res.size(); // 1, 2
			for (int j = 0; j < n; j++) {
				ArrayList<Integer> l = new ArrayList<Integer>(res.get(j)); //[[]], [[],[2]] 
				l.add(arr[i]); // [2]
				res.add(l);    // [[],[2]]
			}
		}
		
	}


	private static void findSubsetMoreThanK(List<List<Integer>> res, int m) {
		int sum = 0;
		for (List<Integer> li : res) {
			System.out.println(li);
			for(int ele : li) {
				sum+=ele;
			}
			if(sum > m) {
				System.err.println(li);
			}
		}
	}

	private static void printAllSizeKSubset(int[] arr, boolean[] used, int startIndex, int currentSize, int k) {
        int n = arr.length;
        if (currentSize == k) {
            for (int i = 0; i<n; i++) {
                if (used[i]) {
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
            return;
        }

        //when focused index exceeds aray length
        if (startIndex == arr.length) return;

        //now its the key recursion step
        used[startIndex] = true;
        printAllSizeKSubset(arr,used,startIndex+1, currentSize+1,k);
        used[startIndex] = false;
        printAllSizeKSubset(arr,used,startIndex+1, currentSize,k);

    }
    
    

}
