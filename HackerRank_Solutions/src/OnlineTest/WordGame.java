package OnlineTest;

/*
    Michelle has created a word game for her students. The word game begins with Michelle writing a string and a number, K, on the board.
The students must find a substring of size K such that there is exactly one character that is repeated one;
in other words, there should be k - 1 distinct characters in the substring.

Write an algorithm to help the students find the correct answer. If no such substring can be found, return an empty list;
if multiple such substrings exist, return all them, without repetitions. The order in which the substrings are does not matter.

Input:
The input to the function/method consists of two arguments - inputString, representing the string written by the teacher;
num an integer representing the number, K, written by the teacher on the board.

Output:
Return a list of all substrings of inputString with K characters, that have k-1 distinct character i.e.
exactly one character is repeated, or an empty list if no such substring exist in inputString.
The order in which the substrings are returned does not matter.

Constraints:
The input integer can only be greater than or equal to 0 and less than or equal to 26 (0 <= num <= 26)
The input string consists of only lowercase alphabetic characters.

Example
Input:
inputString = awaglk
num = 4

Output:
[awag]

Explanation:
The substrings are {awag, wagl, aglk}
The answer is 'awag' as it has 3 distinct characters in a string of size 4, and only one character is repeated twice.

 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordGame {

    public static void main(String[] args){
        String str = "democracy";
        int k = 5;
        findOccurences(str, k);
        System.out.println("str = " + str.substring(0,1));

    }

    private static List<String> findOccurences(String s, int k) {
        int n = s.length()-k+1;
        List<String> list = new ArrayList<>();
        for (int i=0;i<n;i++){
            String str = s.substring(i, i + k);
            s.substring(i);
            Map<Character, Integer> dupMap = new HashMap<>();
            char[] chrs = str.toCharArray();
            for(Character ch:chrs){
                if(dupMap.containsKey(ch)){
                    dupMap.put(ch, dupMap.get(ch)+1);
                } else {
                    dupMap.put(ch, 1);
                }
            }

            Set<Character> keys = dupMap.keySet();
            for(Character ch:keys){
                if(dupMap.get(ch) > 1){
                    System.out.println(str+" has "+ch+" --->"+dupMap.get(ch));
                    list.add(str);
                    System.out.println(list);
                }
            }

        }
        return list;
    }
}

