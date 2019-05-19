package String;

public class ReverseWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		reverseWords();
	}
	
	private static void reverseWords() {
		String str = "Divya is at home";
		String[] s = str.split(" ");
		for (int i = s.length-1; i >=0; i--) {
			System.out.print(s[i]+" ");
		}
	}

}
