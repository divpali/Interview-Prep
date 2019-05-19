package Arrays;

/* 
 * Given an integer array, move all elements that are equal to 0 to the left while maintaining the order of other elements in the array.
 */
public class ZerosToLeft {
	
	public void moveZeroes(int[] nums) {
        int j = nums.length-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                swap(nums, i, j);
                j--;
                if(i+1 < nums.length-1) {
                	swap(nums, i, i+1);
                }
            }
            
        }
    }
    
    public void swap(int[] arr, int i , int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public void printArray(int[] num) {
        for(int i = 0; i< num.length; i++) {
            System.out.println(num[i]);
        }
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 2, 0, 4, 3, 0, 5, 0};
		ZerosToLeft z = new ZerosToLeft();
		z.moveZeroes(arr);
		z.printArray(arr);
		
	}

}
