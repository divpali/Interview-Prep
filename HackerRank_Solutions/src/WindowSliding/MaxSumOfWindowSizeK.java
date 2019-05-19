package WindowSliding;

/*
 * Given an array of integers of size ‘n’. Our aim is to calculate the maximum sum of ‘k’ consecutive elements in the array.
 */
public class MaxSumOfWindowSizeK {
	
	public static int maxSumOfWindow(int[] arr, int k) {
		int n = arr.length;
		if (n < k) { 
            System.out.println("Invalid"); 
            return -1; 
        } 
  
        // Compute sum of first window of size k 
        int max_sum = 0; 
        for (int i = 0; i < k; i++) 
            max_sum += arr[i]; 
  
        // Compute sums of remaining windows by 
        // removing first element of previous 
        // window and adding last element of 
        // current window. 
        int window_sum = max_sum; 
        for (int i = k; i < n; i++) { 
            window_sum += arr[i] - arr[i - k]; 
            max_sum = Math.max(max_sum, window_sum); 
        } 
  
        return max_sum;
	}

	public static void main(String[] args) {
		int[] arr = {1, 4, 2, 10, 23, 3, 1, 0, 20};
		System.out.println(maxSumOfWindow(arr, 4));
		
	}

}
