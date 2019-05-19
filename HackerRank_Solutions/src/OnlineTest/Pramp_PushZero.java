package OnlineTest;

public class Pramp_PushZero {
	
	//1,2,0,3,0,4,0,0
	int[] moveZeros(int[] arr) {
		int n = arr.length;
		int count = 0;
		for(int i =0;i<n;i++) {
			if(arr[i]!=0) {
				arr[count] = arr[i];
				count++;
			}
		}
		
		while(count<n-1) {
			arr[count] = 0;
			count++;
		}
		return arr;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pramp_PushZero p = new Pramp_PushZero();
		int[] arr = {1,2,0,3,0,4,0,0};
		int[] arr1 = p.moveZeros(arr);
		for(int i =0;i<arr1.length;i++) {
			System.out.println(arr1[i]);
		}

	}

}
