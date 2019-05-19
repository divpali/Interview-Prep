package Arrays;

public class FirstNonRepeatingCharacter {
	
	static int[] charArray = new int[26];
    
    public static int[] getCharCount(char[] arr) {
        for(int i=0;i<arr.length;i++) {
            int code = (int) 'a';
            int offset = (int) arr[i] - code;
            charArray[offset]++;
        }
        return charArray;
    }
    
    public static int firstNonRepeatingChar(char[] arr) {
        int[] charCount = getCharCount(arr);
        for(int i=0;i<charCount.length;i++) {
            if(charCount[i]>1) {
                int code = (int) 'a' + i;
                char c = (char) code;
                System.out.println("found first repaeting character : "+c);
                return 0;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
		//code
		int N = 4;
		char[] c = {'a','c','b','b'};
		int c1 = firstNonRepeatingChar(c);
		System.out.println(c1);
	}
}
