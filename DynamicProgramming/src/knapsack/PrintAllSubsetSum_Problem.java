package knapsack;

import java.util.ArrayList;

public class PrintAllSubsetSum_Problem {
	
	// dp[i][j] is going to store true if sum j is 
    // possible with array elements from 0 to i. 
    static boolean[][] dp; 
    static int count=0;
       
    static void display(ArrayList<Integer> v) { 
    	count++;
       System.out.println(v); 
    } 
        
    static void printSubsetsRec(int arr[], int i, int sum, ArrayList<Integer> p) { 
        // If we reached end and sum is non-zero. We print 
        // p[] only if arr[0] is equal to sun OR dp[0][sum] 
        // is true. 
    	
        if (i == 0 && sum != 0 && dp[0][sum]) { 
            p.add(arr[i]);
            display(p);
            p.clear(); 
            return; 
        } 
       
        // If sum becomes 0 
        if (i == 0 && sum == 0) { 
            display(p); 
            p.clear(); 
            return; 
        } 
       
        // If given sum can be achieved after ignoring 
        // current element. 
        if (dp[i-1][sum]) { 
            // Create a new vector to store path 
            ArrayList<Integer> b = new ArrayList<>(); 
            b.addAll(p); 
            printSubsetsRec(arr, i-1, sum, b); 
        } 
       
        // If given sum can be achieved after considering 
        // current element. 
        if (sum >= arr[i] && dp[i-1][sum-arr[i]]) { 
            p.add(arr[i]); 
            printSubsetsRec(arr, i-1, sum-arr[i], p); 
        } 
    } 
       
    // Prints all subsets of arr[0..n-1] with sum 0. 
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
		 * ArrayList<Integer> p = new ArrayList<>(); printSubsetsRec(arr, n-1, sum, p);
		 */
        return dp[n-1][sum];
    } 

	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 4, 5}; 
        int n = arr.length; 
        int sum = 10; 
        System.out.println(printAllSubsets(arr, n, sum));
        System.out.println(count);
        
		/*
		 * int[] input = {2,3,7,8,10}; int total = 11; printAllSubsets(input,
		 * input.length, total);
		 */

	}

}
