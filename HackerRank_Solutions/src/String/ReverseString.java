package String;

public class ReverseString {
	
	public static void main(String[] args) {
		reverseStrings();
    }

	private static void reverseStrings() {
		String input = "DIVYA"; 
        char[] ch = input.toCharArray();
        int left, right=0;
        right = ch.length-1;
        for(left=0;left<right;left++,right--) {
        	char temp = ch[left];
        	ch[left] = ch[right];
        	ch[right] = temp;
        }
        
        for (char c : ch) {
			System.out.print(c);
		}
	}
}
