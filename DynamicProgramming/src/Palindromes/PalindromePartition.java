package Palindromes;

public class PalindromePartition {
	
	public static boolean ispalin(String input, int begin, int end) {
        while (begin < end) {
            if (input.charAt(begin) != input.charAt(end))
                return false;
            begin++;
            end--;
        }
        return true;
    }
 
    public static void printpart(String input, String output, int begin, int end) {
        if (begin == end) {
            System.out.println(output);
            return;
        }
        int n = input.length();
        String delimiter = "-";
        for (int i = begin; i < end; i++) {
            if (ispalin(input, begin, i)) {
                if (i+1 == n) {
                    delimiter = "";
                }
                printpart(input, output + input.substring(begin, i+1) + delimiter, i + 1, end);
            }
        }
    }
 
    public static void main(String[] args) {
        String input = "banana";
        String output = "";
        int begin = 0;
        int end = input.length();
        printpart(input, output, begin, end);
    }
}
