package Arrays;

public class MaxProductOfTriplets {
	
	private static int maximumProduct(int[] arr) {
	    int min1=Integer.MAX_VALUE;
	    int min2=Integer.MAX_VALUE;
	    
	    int max1=Integer.MIN_VALUE;
	    int max2=Integer.MIN_VALUE;
	    int max3=Integer.MIN_VALUE;
	    
	    for(int i=0;i<arr.length;i++) {
	      int val = arr[i];
	      
	      if(val<=min1) {
	        min2 = min1;
	        min1 = val;
	      }
	      
	      else if(val<=min2) {
	        min2=val;
	      }
	      
	      if(val>=max1) {
	        max3=max2;
	        max2=max1;
	        max1=val;
	      }
	      
	      else if(val>=max2) {
	        max3=max2;
	        max2=val;
	      }
	      
	      else if(val>=max3) {
	        max3=val;
	      }
	    }
	    return Math.max((max1 * max2 * max3), (min1 * min2 * max1 ));
	  }
	
	private static int maximumProductOfQuadruplets(int[] arr) {
	    int min1=Integer.MAX_VALUE;
	    int min2=Integer.MAX_VALUE;
	    int min3=Integer.MAX_VALUE;
	    int min4=Integer.MAX_VALUE;
	    
	    int max1=Integer.MIN_VALUE;
	    int max2=Integer.MIN_VALUE;
	    int max3=Integer.MIN_VALUE;
	    int max4=Integer.MIN_VALUE;
	    
	    for(int i=0;i<arr.length;i++) {
	      int val = arr[i];
	      
	      if(val<=min1) {
	    	  min4 = min3;
	    	  min3 = min2;
	    	  min2 = min1;
	    	  min1 = val;
	      }
	      else if(val<=min2) {
	    	  min4 = min3;
	    	  min3 = min2;
	    	  min2 = val;
	      }
	      else if(val<=min3) {
	    	  min4 = min3;
	    	  min3 = val;
	      }
	      else if(val<=min4) {
	    	  min4 = val;
	      }
	      
	      if(val>=max1) {
	    	  max4=max3;
	    	  max3=max2;
	    	  max2=max1;
	    	  max1=val;
	      }
	      else if(val>=max2) {
	    	  max4=max3;
	    	  max3=max2;
	    	  max2=val; 
	      }
	      else if(val>=max3) {
	    	  max4=max3;
	    	  max3=val;
	      }
	      else if(val>=max4) {
	        max4=val;
	      }
	      //max1 * max2 * max3 * max4
	      //min1 * min2 * max1 * max2
	      //min1 * min2 * min3 * min4
	    }
	    int res = Math.max((min1 * min2 * max1 * max2), (min1 * min2 * min3 * min4));
	    return Math.max((max1 * max2 * max3 * max4), res);
	  }
	
	public static void main(String[] args) {
	    int[] arr = {1,-20,-10,-15,-2,7,3,10,1,5};
	    System.out.println(maximumProduct(arr));
	    System.out.println(maximumProductOfQuadruplets(arr));
	  }

}
