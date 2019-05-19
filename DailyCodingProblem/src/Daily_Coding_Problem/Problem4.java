package Daily_Coding_Problem;

/*
Given an array of integers, find the first missing positive integer in linear time and constant space. 
In other words, find the lowest positive integer that does not exist in the array. The array can contain duplicates and negative numbers as well.

For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.
 */
public class Problem4 {
	
    
 // Driver code 
    public static void main (String[] args)  
    { 
//        int arr[] = { 2, 3, 7, 6, 8, -1, -10, 15 }; 
        int[] arr = {-1, 4,3,8};
        int arr_size = arr.length; 
          
        int missing = findMissingNo(arr, arr_size); 
          
        System.out.println( "The smallest positive"
                + " missing number is " + missing); 
    }

	private static int findMissingNo(int[] arr, int arr_size) {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < arr.length; i++) {
			//base case : its greater than zero , less than array length
			if (arr[i] < 0 || arr[i] > arr.length) {
				continue;
			}
			
			int val = arr[i];
			
			while(arr[val-1] != val) {
				int nextval = arr[val-1];
				arr[val-1] = val;
				val = nextval;
				
				if (val < 0 || val > arr.length) {
					break;
				}
			}
			
			for (int j = 0; j < arr.length; j++) {
				if (arr[j]!=j+1) {
					return j+1;
				}
			}
			
		}
		return arr.length+1;
	} 
	


}
