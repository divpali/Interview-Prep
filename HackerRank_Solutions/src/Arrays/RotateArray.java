package Arrays;

public class RotateArray {
	
	//1,2,3,4,5,6,7
    //k=3, len=7, diff= 4
    //4321567
    //4321765
    //5671234
    
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        int diff = len - k;
        
        if(nums.length == 0 || nums==null || k<0) {
            return;
        }
         
        if(k > nums.length) {
        	k = k % nums.length;
        }
        
		/*
		 * if(nums.length==2) { int i = 0; int j=nums.length-1; int temp = nums[i];
		 * nums[i] = nums[j]; nums[j] = temp; }
		 */
        
        swap(nums, 0, diff-1);
        swap(nums, diff, len-1);
        swap(nums, 0, len-1);
        printArray(nums);
        
    }
    
    public void swap(int[] num, int start, int end) {
        while(start<=end) {
            int temp = num[start];
            num[start] = num[end];
            num[end] = temp;
            start++;
            end--;
        }
        
    }
    
    public void printArray(int[] num) {
        for(int i = 0; i< num.length; i++) {
            System.out.println(num[i]);
        }
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,4,5,6,7,8,9};
		int k = 3;
		RotateArray r = new RotateArray();
		r.rotate(nums, k);
	}

}
