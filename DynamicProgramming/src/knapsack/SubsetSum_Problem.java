package knapsack;

import java.util.ArrayList;

public class SubsetSum_Problem {

	public static void main(String[] args) {
		int[] input = {2,3,7,8,10};
	    int total = 11;
	    
		/*
		 * System.out.println(subsetSum(input,total));
		 * System.out.println(printAllSubsets(input, input.length, total));
		 */
	    
	    subset_sum(input, total);
		
	}
	
	static boolean[][] dp;
	static boolean printAllSubsets(int arr[], int n, int sum) { 
        if (n == 0 || sum < 0) 
           return false; 
       
        // Sum 0 can always be achieved with 0 elements 
        dp = new boolean[n][sum + 1]; 
        for (int i=0; i<n; ++i) { 
            dp[i][0] = true;   
        } 
       
        // Sum arr[0] can be achieved with single element 
        if (arr[0] <= sum) 
           dp[0][arr[0]] = true; 
       
        // Fill rest of the entries in dp[][] 
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < sum + 1; ++j)  {
            	if(j >= arr[i]) {
            		dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i]];
            	} else {
            		dp[i][j] = dp[i-1][j];
            	}
            }
        }
        if (dp[n-1][sum] == false) { 
            System.out.println("There are no subsets with" +  
                                                  " sum "+ sum); 
            return false; 
        } 
       
        // Now recursively traverse dp[][] to find all 
        // paths from dp[n-1][sum] 
		/*
		 * ArrayList<Integer> p = new ArrayList<>(); 
		 *  printSubsetsRec(arr, n-1, sum, p);
		 */
        return dp[n-1][sum];
    }
	
	static boolean[][] T;
	public static void subset_sum(int[] input, int total) {
		T = new boolean[input.length][total+1];
		for (int i = 0; i < input.length; i++) {
			T[i][0] = true; 
		}
		if(input[0] <= total) {
			T[0][input[0]] = true;
		}
		for (int i = 1; i < input.length; i++) {
			for (int j = 0; j < total+1; j++) {
				if (j >= input[i]) {
					T[i][j] = T[i-1][j] || T[i-1][j-input[i]];
				} else {
					T[i][j] = T[i-1][j];
				}
			}
		}
		ArrayList<Integer> p = new ArrayList<Integer>();
        printAllSubsetRec(input, input.length, total, p);
	}

	private static void printAllSubsetRec(int[] input, int i, int sum, ArrayList<Integer> p) {
		if(i==0 && sum!=0 && T[i][sum]) {
			p.add(input[i]);
			display(p);
			p.clear();
			return;
		}
		
		if (i==0 && sum==0) {
			display(p);
			p.clear();
			return;
		}
		
		if (T[i][sum]) {
			ArrayList<Integer> b = new ArrayList<Integer>();
			b.addAll(p);
			printAllSubsetRec(input, i-1, sum, b);
		}
		
		if (sum >= input[i] && dp[i-1][sum-input[i]]) { 
            p.add(input[i]); 
            printAllSubsetRec(input, i-1, sum-input[i], p); 
        }
	}

	private static void display(ArrayList<Integer> p) {
		System.out.println(p);
	}

	public static boolean subsetSum(int[] input, int total) {
	    boolean T[][] = new boolean[input.length + 1][total + 1];
	        for (int i = 0; i <= input.length; i++) {
	            T[i][0] = true;
	        }

	        for (int i = 1; i <= input.length; i++) {
	            for (int j = 1; j <= total; j++) {
	                if (j >=input[i - 1]) {
	                    T[i][j] = T[i - 1][j] || T[i - 1][j - input[i - 1]];
	                } else {
	                    T[i][j] = T[i-1][j];
	                }
	            }
	        }
	        return T[input.length][total];
	        
	  }

}
