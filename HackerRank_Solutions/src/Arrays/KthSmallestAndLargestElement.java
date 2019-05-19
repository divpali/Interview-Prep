 package Arrays;

public class KthSmallestAndLargestElement {
       
	//find the smallest element
    public int kthSmallest(int[] arr, int start, int end, int k) { 
    	if (k > 0 && k <= end - start + 1) { 
    		int pos = partition(arr, start, end); 

    		if (pos-start == k-1) {
    			return arr[pos]; 
    		}

    		if (pos-start > k-1)   {      // If position is more, recur for left subarray 
    			return kthSmallest(arr, start, pos-1, k); 
    		}
    		return kthSmallest(arr, pos+1, end, k-pos+start-1); // Else recur for right subarray
    	} 

    	return Integer.MAX_VALUE; 
    }
	
    public int partition(int[] nums, int start,  int end) { 
    	int pivot = nums[end];
    	int pIndex = start; 
    	for (int j = start; j <= end - 1; j++) { 
    		if (nums[j] <= pivot) { 
    			swap(nums, j, pIndex);
    			pIndex++; 
    		} 
    	}
    	swap(nums, pIndex, end); 
    	return pIndex; 
    }
 
    public void swap(int[] nums, int n1, int n2) { 
    	int tmp = nums[n1];
    	nums[n1] = nums[n2];
    	nums[n2] = tmp;
    } 
     
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {7,2,3,1,6,5,8,4};
		int k=6;
		KthSmallestAndLargestElement s = new KthSmallestAndLargestElement();
		
		int res2 = s.kthSmallest(arr, 0, arr.length-1, k);
		System.out.println(k+" smallest : "+res2);
	}
	
}
