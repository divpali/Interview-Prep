package Easy;

import java.util.Arrays;

public class FindFourNumbers {
	
	void find4Numbers(int A[], int n, int X)  
    { 
        int l, r; 
   
        Arrays.sort(A); 
  
        /* Now fix the first 2 elements one by one and find 
           the other two elements */
        for (int i = 0; i < n - 3; i++)  
        { 
            for (int j = i + 1; j < n - 2; j++)  
            { 
                // Initialize two variables as indexes of the first and last  
                // elements in the remaining elements 
                l = j + 1; 
                r = n - 1; 
  
                // To find the remaining two elements, move the index  
                // variables (l & r) toward each other. 
                while (l < r)  
                { 
                    if (A[i] + A[j] + A[l] + A[r] == X)  
                    { 
                        System.out.println(A[i]+","+A[j]+","+A[l]+","+A[r]);
                      System.out.println("Quadruplets is " + A[i]+","+A[j]+","+A[l]+","+A[r]);
                        l++; 
                        r--; 
                    }  
                    else if (A[i] + A[j] + A[l] + A[r] < X) 
                        l++; 
                    else // A[i] + A[j] + A[l] + A[r] > X 
                        r--; 
                } 
            }  
        }
    } 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindFourNumbers s = new FindFourNumbers();
		int B[] = {1, 4, 45, 6, 10, 12}; 
        int n = B.length; 
        int X = 21; 
        s.find4Numbers(B, n, X); 
	}

}
