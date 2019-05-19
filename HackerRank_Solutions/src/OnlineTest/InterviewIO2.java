package OnlineTest;

public class InterviewIO2 {

	//start      end
	//	0		  0
	//	0
	void m2(char[] c2) {
	    int start,end;
	    start=0;end=0; //0
	    for(int i=0;i<c2.length;i++) {
	    	if(c2[i] == ' ') {
	    		end = i; //7
		    	  while(start<end) {
		  	        swap(c2,start, end-1); 
		  	        start++;
		  	        end--;  
		    	  }
		      }
	    	start = i+1;
	      
	    }
	    
	    System.out.println("result");
	    for(int j=0;j<c2.length;j++){
	      System.out.print(c2[j]);
	    }
	    
	    System.out.println("");
	    for(int k=c2.length-1;k>=0;k--) {
	    	System.out.print(c2[k]);
	    }
	      
	  }
	  
	  public void swap(char[] c, int start, int end) {
	    char temp = c[start];
	    c[start] = c[end];
	    c[end] = temp;
	  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InterviewIO2 i = new InterviewIO2();
		char[] c2 = {'a','b',' ','c',' ','d'};
		char[] c1 =  {'p', 'e', 'r', 'f', 'e', 'c', 't', ' ', 'm', 'a', 'k', 'e', 's', ' ', 'p', 'r', 'a', 'c', 't', 'i', 'c', 'e'};
		i.m2(c1);

	}

}
