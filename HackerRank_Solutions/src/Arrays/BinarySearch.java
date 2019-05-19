package Arrays;

public class BinarySearch {
	
	public static void binSearch(int[] arr, int num) {
		int len = arr.length-1;
		int index = binSearchUtil(arr, 0, len, num);
		System.out.println("index : " + index + " val : " + arr[index]);
	}

	private static int binSearchUtil(int[] arr, int start, int end, int num) {
		if (start < end) {
			int mid = (start + end)/2;
			if (arr[mid] == num) {
				return mid;
			} else if(arr[mid] > num) {
				return binSearchUtil(arr, start, mid-1, num);
			} else {
				return binSearchUtil(arr, mid+1, end, num);
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {10, 30, 36, 80, 111};
		int num = 80;
		binSearch(arr, num);
	}

}
