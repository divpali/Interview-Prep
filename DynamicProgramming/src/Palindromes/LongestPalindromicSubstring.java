package Palindromes;

public class LongestPalindromicSubstring {

	public String palindromeForRest(String str) {
		int max_length = 1;
		int palinBeginsAt = 0;
		int n = str.length();
		boolean[][] palin = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			palin[i][i] = true;
		}

		for (int i = 0; i < n - 1; i++) {
			if (str.charAt(i) == str.charAt(i + 1)) {
				palin[i][i + 1] = true;
				max_length = 2;
				palinBeginsAt = i;
			}
		}

		for (int curr_len = 3; curr_len <= n; curr_len++) {
			for (int i = 0; i < n - curr_len + 1; i++) {
				int j = i + curr_len - 1;
				if (str.charAt(i) == str.charAt(j) && palin[i + 1][j - 1]) {
					palin[i][j] = true;
					max_length = curr_len;
					palinBeginsAt = i;
				}
			}

		}
		return str.substring(palinBeginsAt, max_length + palinBeginsAt);
	}

	public static void main(String[] args) {
		LongestPalindromicSubstring p = new LongestPalindromicSubstring();
		String str = "BANANA";
		System.out.println(p.palindromeForRest(str));
	}
}
