package Arrays;

public class LargestContiguousSumArray {
	
	public static void largestSumSubArray(int[] arr) {
		int curr_max = 0;
		int max_so_far = 0;
		int beg = 0;
		int start = 0, end = 0;
		
		for (int i = 0; i < arr.length; i++) {
			curr_max = curr_max + arr[i];
			if (curr_max < 0) {
				curr_max = 0;
				beg = i+1;
			}
			if(max_so_far < curr_max) {
				max_so_far = curr_max;
				start = beg;
				end = i;
			}
		}
		
		System.out.println(max_so_far);
		for (int i = start; i < end; i++) {
			System.out.println(arr[i]);
		}
	}
	
	public static void largestSumSubArray1(int[] arr) {
		int curr_max = 0;
		int max_so_far = 0;
		int start=0, end=0, s=0;
		for (int i = 0; i < arr.length; i++) {
			curr_max = Math.max(arr[i], curr_max+arr[i]);
			
			if(max_so_far > curr_max) {
				start = i;
				System.out.println(start);
			}
			max_so_far = Math.max(curr_max, max_so_far);
			
			
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
//		largestSumSubArray(arr);
		largestSumSubArray1(arr);
	}

}
