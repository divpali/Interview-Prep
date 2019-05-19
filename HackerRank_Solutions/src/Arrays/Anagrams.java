package Arrays;

import java.util.Scanner;

/*
    h e l l o
    b i l l i o n

 */
public class Anagrams {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str1 = input.next();
        String str2 = input.next();

        int num = numberNeeded(str1,str2);
        System.out.println(num);


    }

    public static int numberNeeded(String str1, String str2){
        int[] charCount1 = getCharCount(str1);
        int[] charCount2 = getCharCount(str2);
        return getdiff(charCount1,charCount2);
    }

    public static int[] getCharCount(String str){
        int num = 26;
        int[] charCount = new int[num];
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            int offset = (int) 'a';
            int res = ch - offset;
            // System.out.println("ch : "+ch+" res : "+res);
            charCount[res]++;
            System.out.println(charCount[res]);

        }
        return charCount;

    }

    public static int getdiff(int[] arr1,int[] arr2){
        int diff = 0;
        if(arr1.length != arr2.length){
            return -1;
        }
        for(int i = 0; i < arr1.length; i++){
            // System.out.println(arr1[i]+" , "+arr2[i]);
            int res = Math.abs(arr1[i]-arr2[i]);
            System.out.println(i + " , " +res);
            diff += res;
        }
        return diff;
    }
}
