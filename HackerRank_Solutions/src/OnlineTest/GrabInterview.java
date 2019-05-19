package OnlineTest;

public class GrabInterview {
	
	public static int[] solution1(int[] A, int[] B) {
        // write your code in Java SE 8
      int[] sum = {0, 0, 0, 0, 0, 0, 0, 0,0,0,0,0,0};
      int carry = 0;
      int random = 0;
      int x = 7;
      for(x = 7; x >= 0; x--){
        random = A[x] + B[x] + carry;
        if(random == 1){
          sum[x] = 1;
          carry = 0;
        }
        else if(random == 2){
          sum[x] = 0;
          carry = 1;
        }
        else if(random == 3){
          sum[x] = 1;
          carry = 1;
        }
        else if(random == 0){
          sum[x] = 0;
          carry = 0;
        }
        else{
          
        }
      }
          if(carry == 1){
            sum[x] = 1;
      }
      return sum;
        
    }
	
	public static void main(String[] args) {
		int[] A = {0,1,1,0,0,1,0,1,1,1,0,1,0,1,1};
		int[] B = {0,0,1,0,0,1,1,1,1,1,0,1};
		int[] a = solution1(A, B);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

}
