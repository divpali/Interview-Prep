package Arrays;

import java.util.Arrays;

public class WordBreak {

	public static void main(String[] args) {
		WordBreak w = new WordBreak();
		// create a set
		String[] dictionary = { "hello", "to", "the", "world" };
		String word = "ehllootehotwolrd";
		w.wordBreakFunc(word, dictionary, "");

	}

	private void wordBreakFunc(String word, String[] dictionary, String answer) {
		int n = word.length();
		for (int i = 0; i < n; i++) {
			String first = word.substring(0, i);
			boolean found = wordExistsInDictionary(first, dictionary);
			if (!found) {
				answer = word.charAt(i) + answer;
				wordBreakFunc(first, dictionary, answer);
			} else {
				String second = word.substring(i);
				wordBreakFunc(second, dictionary, "");
			}
		}
	}

	private boolean wordExistsInDictionary(String first, String[] dictionary) {
		char[] str1 = first.toCharArray();
		Arrays.sort(str1);
		for (String str : dictionary) {
			char[] str2 = str.toCharArray();
			Arrays.sort(str2);
			for (int i = 0; i < str2.length; i++) {
				if (str1[i] == str2[i]) {
					return true;
				}
			}
		}
		return false;
	}

}
