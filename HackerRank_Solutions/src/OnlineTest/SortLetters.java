package OnlineTest;

import java.util.Arrays;

/*
 * Sort the letters in one word by the order they occur in another in linear time
 */
public class SortLetters {
	
	 public static void main(String[] args) {
		 SortLetters s = new SortLetters();
		 String word = "divyaa";

		 s.SortLettersOfAWord(word);
		 
	 }

	private void SortLettersOfAWord(String word) {
		// TODO Auto-generated method stub
		int[] letters = new int[26];
		Arrays.fill(letters, 0);
		char[] ch = word.toCharArray();
		for(int i=0;i<ch.length;i++) {
			int code = (int) 'a';
			int offset = (int) ch[i] - code;
			letters[offset]++;    // 1,0,0,1,0,0,0,0,1......
		}
		
		for (int i = 0; i < letters.length; i++) {
			if(letters[i] > 0) {
				int code1 = (int) 'a';
				int res = code1 + i;
				System.out.println((char) res);
			}
		}
	}

}
