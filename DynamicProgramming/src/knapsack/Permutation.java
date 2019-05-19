package knapsack;

public class Permutation {

	// {1,2,3}

	// {1,2,3}
	// {1,3,2}
	// {2,1,3}
	// {2,1,3}
	
	public static void main(String[] args) {
		/*
		 * permute("ABC"); test(); System.out.println(); permute1("ABC"); int[] arr = {
		 * 1, 2, 3 }; permuteArray(arr);
		 */
//		getSubstring();
		permutation("ABC");
	}
	
	public static void getSubstring() {
		String s = "ABC";
		System.out.println(s.substring(0,0)+s.substring(1, s.length()));
		System.out.println(s.substring(0,1)+s.substring(2, s.length()));
		System.out.println(s.substring(0,2)+s.substring(3, s.length()));
		
	}
	
	public static void permutation(String str) {
		permutation("",str);
	}
	

	private static void permutation(String prefix, String suffix) { 
		if(suffix.length()==0) {
			System.out.println(prefix);
		}
		for(int i=0;i<suffix.length();i++) {
			//i=0 - A,BC
			//i=1 - AB,C
			//i=2 - 
			permutation(prefix + suffix.charAt(i), suffix.substring(0, i)+suffix.substring(i+1, suffix.length()));
		}	
	}


	public static void permute(String str) {
		if (str.length() == 0 || str == null) {
			return;
		}
		permute(str, 0, str.length() - 1);
	}

	public static void permute(String str, int start, int end) {
		if (start == end) {
			System.out.println(str);
		}

		for (int i = start; i <= end; i++) {
			str = swap(str, start, i);
			permute(str, start + 1, end);
			str = swap(str, start, i);
		}
	}

	public static String swap(String str, int i, int j) {
		char[] ch = str.toCharArray();
		char temp = ch[i];
		ch[i] = ch[j];
		ch[j] = temp;
		return String.valueOf(ch);
	}

	public static void test() {
		String s = "divya";
		System.out.println(s.substring(0, 0) + s.substring(1, s.length()));
	}

	public static void permute1(String str) {
		permute1("", str);
	}

	public static void permute1(String prefix, String suffix) {
		if (suffix.length() == 0) {
			System.out.println(prefix);
		}
		for (int i = 0; i < suffix.length(); i++) {
			permute1(prefix + suffix.charAt(i), suffix.substring(0, i) + suffix.substring(i + 1, suffix.length()));
		}

	}

	public static void permuteArray(int[] arr) {
		permuteArray(arr, 0, arr.length - 1);
	}

	public static void permuteArray(int[] arr, int l, int m) {
		if (l == m) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[j] + ",");
			}
			System.out.println();
		}
		for (int i = l; i <= m; i++) {
			arr = swap(arr, l, i);
			permuteArray(arr, l + 1, m);
			arr = swap(arr, l, i);
		}
	}

	public static int[] swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		return a;
	}

	//Print all palindrome permutations of a string
	public static boolean isPalindrome(int[] arr, int start, int end) {
		if (start >= end) {
			return true;
		}

		if (arr[start] == arr[end]) {
			return isPalindrome(arr, start + 1, end - 1);
		}

		return false;
	}

}
