package Arrays;

public class LowAndHighIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,3,4,4,4,4,5,6,7,7,7,8};
		int k = 4;
		LowAndHighIndex l = new LowAndHighIndex();
		int[] a = l.searchRange(arr, k);
		l.printArray(a);
	}
	
	public int[] searchRange(int[] nums, int target) {
        //find presence
        int index = binarySearch(nums, target, 0, nums.length);
        
        int[] arr = new int[2];
        
        //find if its the first element
        while(index >=0 && nums[index] == nums[index-1]){
            index--;
        }
        
        int low = index;
        arr[0] = low;
        
        // 0,1,2,3,4 
        // 8,8,8,8,8
        while(low<=nums.length-1 && nums[low]== nums[low+1]) {
            low++;
        }
        int high = low;

        arr[1] = high;
        return arr;
        
    }
        
    
    public int binarySearch(int[] arr , int k,int low, int high) {
        if(low<=high) {
            int mid = (low+high)/2;
            if(arr[mid]==k) {
                return mid;
            } else if(arr[mid] > k) {
                return binarySearch(arr, k, low, mid-1);
            } else {
                return binarySearch(arr, k, mid+1, high);
            }
        }
        return -1;
    }
    
    public void printArray(int[] num) {
        for(int i = 0; i< num.length; i++) {
            System.out.println(num[i]);
        }
        
    }

}
