package Palindromes;

public class  LongestPalindromicSubsequence {

    public static void main(String[] args){
        String X = "ABBDCACB";
        int n = X.length();
        int len = longestPalindromicSub(X, 0, n-1);
        System.out.println("len = " + len);
    }

    private static int longestPalindromicSub(String x, int start, int end) {

        if (start > end) return 0;
        if (start == end) return 1;
        if (x.charAt(start) == x.charAt(end)) {
            return longestPalindromicSub(x, start+1, end-1) + 2;
        }
        return Math.max(longestPalindromicSub(x, start, end-1), longestPalindromicSub(x, start + 1, end));
    }
}
