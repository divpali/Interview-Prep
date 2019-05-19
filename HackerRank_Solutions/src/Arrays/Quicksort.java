package Arrays;

public class Quicksort {
	
	public static void sort(int[] arr,int start, int end) {
		if(start < end) {
			int pIndex = partition(arr, start, end);
			sort(arr, start, pIndex-1);
			sort(arr, pIndex + 1, end);
		}
	}

	private static int partition(int[] arr, int start, int end) {
		//7,2,1,6,8,5,3,4
		//2,7,1,6,8,5,3,4
		//2,1,7,6,8,5,3,4
		//2,1,3,6,8,5,7,4
		int pivot = arr[end];
		int pIndex = 0;
		for(int i=0; i< arr.length ;i++) {
			if(arr[i] <= pivot) {
				swap(arr[i], arr[pIndex]);
				pIndex++;
			}
		}
		swap(arr[pIndex] , pivot);
		
		return pIndex;
	}

	private static void swap(int i, int pivot) {
		int temp = i;
		i = pivot;
		pivot = temp; 		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {7,2,1,6,8,5,3,4};
		sort(arr, 0, arr.length-1);
		
		for(int i=0; i<arr.length;i++) {
			System.out.println(arr[i]);
		}

	}

}
