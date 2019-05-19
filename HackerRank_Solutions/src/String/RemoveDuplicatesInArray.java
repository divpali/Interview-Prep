package String;

public class RemoveDuplicatesInArray {
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 2, 3, 4, 4, 4, 5, 5};
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[Math.abs(arr[i])] >= 0) 
                arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])]; 
            else
                System.out.print(Math.abs(arr[i]) + " "); 
		}
    }

}
