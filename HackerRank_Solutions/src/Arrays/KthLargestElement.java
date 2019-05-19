package Arrays;

public class KthLargestElement {

	public int findKthLargest(int[] nums, int k) {
		if (nums == null || nums.length == 0) return Integer.MAX_VALUE;
	    return findKthLargest(nums, 0, nums.length - 1, nums.length - k + 1);
	}    
	
	public int findKthSmallest(int[] nums, int k) {
		if (nums == null || nums.length == 0) return Integer.MAX_VALUE;
	    return findKthLargest(nums, 0, nums.length - 1, k);
	}

	public int findKthLargest(int[] nums, int start, int end, int k) {// quick select: kth smallest
		if (start > end) return Integer.MAX_VALUE;
		
		int pivot = nums[end];// Take A[end] as the pivot, 
		int left = start;
		for (int i = start; i < end; i++) {
			if (nums[i] <= pivot) // Put numbers < pivot to pivot's left
				swap(nums, left++, i);			
		}
		swap(nums, left, end);// Finally, swap A[end] with A[left]
		
		System.out.println("index is "+left);
		if (left + 1 == k)// Found kth smallest number
			return nums[left];
		else if (left + 1 < k)// Check right part
			return findKthLargest(nums, left + 1, end, k);
		else // Check left part
			return findKthLargest(nums, start, left - 1, k);
	} 

	void swap(int[] A, int i, int j) {
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;				
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {7,2,3,1,6,5,8,4};
		int k=2;
		KthLargestElement s = new KthLargestElement();
		
		int res2 = s.findKthLargest(arr, k);
		System.out.println(k+" largest : "+res2);
		
		int res3 = s.findKthSmallest(arr, k);
		System.out.println(k+" smallest : "+res3);

	}
	
	/*
	 * public int findKthLargest(int[] nums, int k) {
    if (nums == null || nums.length == 0) return Integer.MAX_VALUE;
      return partitionIndex(nums, 0, nums.length - 1, nums.length - k + 1);
  } 
  
  public int partitionIndex(int[] arr, int start, int end, int k) {
    int pivot = arr[end];
    int pIndex = start;
    int i;
    for(i=0;i<end;i++) {
      if(arr[i] <= pivot) {
        swap(arr,i,pIndex);
        pIndex++;
      }
    }
    swap(arr,pIndex,end);
    
    System.out.println("partitionIndex is "+pIndex);
    if (pIndex + 1 == k)// Found kth smallest number
      return arr[pIndex];
    else if (pIndex + 1 < k)// Check right part
      return partitionIndex(arr, pIndex + 1, end, k);
    else // Check left part
      return partitionIndex(arr, start, pIndex - 1, k);
    
     
  }
  
  public void swap(int[] arr, int i, int j) {
    int temp;
    temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
  
  
  public static void main(String[] args) {
    Solution n = new Solution();
    int[] arr = {7,2,1,6,8,5,3,4};
    int res = n.findKthLargest(arr,2);
    // System.out.println(arr[res]);
  }
	 */

}
