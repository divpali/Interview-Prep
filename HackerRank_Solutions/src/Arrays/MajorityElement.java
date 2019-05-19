package Arrays;

public class MajorityElement {

	private static int getMajorityElement(int[] arr) {
	    int candidate = 0;
	    int count=0;
	    for(int i=0;i<arr.length;i++) {
	      if(count==0){
	        candidate=arr[i]; //2
	        count=1;
	      }
	      else {
	        if(candidate==arr[i]) {
	          count++;
	        } else {
	          count--;
	        } 
	      }
	    }
	    
	    if(count==0) return 0;
	    for(int i=0;i<arr.length;i++) {
	      if(candidate==arr[i]) {
	        count++;
	      }
	    }
	    return (count > arr.length/2) ? candidate : null;   
	  }
	  
	  public static void main(String[] args) {
	    int[] arr = {2,2,1,1,1,1,4,2};
	    System.out.println(getMajorityElement(arr));
	  }
}
