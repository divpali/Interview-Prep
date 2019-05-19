package Arrays;

public class SearchInRotatedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3, 4, 5, 6, 1, 2};
		int num = 3;
		int pivot = findPivot(arr);
		System.out.println("pivot : "+ pivot +", with pivot value : "+arr[pivot]);
		
		//if the number 
		int index = findNumIndex(arr, num, pivot);
		System.out.println("index of "+ num + " is "+index);
		
	}

	private static int findNumIndex(int[] arr, int num, int pivot) {
		if (pivot>0 && num>= arr[0] && num <= arr[pivot-1]) {
			//if number lies between start and pivot-1
			return binarySearch(arr, 0, pivot-1, num);
		} else {
			//if number lies between pivot and end
			return binarySearch(arr, pivot, arr.length-1, num);
		}
	}
	
	public static int binarySearch(int[] arr, int start, int end, int num) {
		if(start <= end) {
			int mid = (start+end)/2;
			if (arr[mid] == num) {
				return mid;
			} else if(arr[mid] > num) {
				return binarySearch(arr, start, mid-1, num);
			} else {
				return binarySearch(arr, mid+1, end, num);
			}
		}
		return -1;
	}

	private static int findPivot(int[] arr) {
		if(arr.length == 0) {
			return -1;
		}

		int start = 0;
		int end = arr.length - 1;
		
		while (start <= end) {
			int mid = (start + end)/2;
			if(arr[mid]>arr[mid+1]) {
				return mid+1;
			} else if(arr[start] <= arr[mid]) {
				start = mid+1;
			} else {
				end = mid-1;
			}
		}
		return 0;
	}

}
