package Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class KMostFrequentElement {

    //create a array of list
    LinkedList<Integer> l[];

    KMostFrequentElement(int i){
        l = new LinkedList[i];
    }
    
    public static void main(String[] args){
        String[] s = {"i", "love", "leetcode", "i", "love", "coding"};
        int k1 = 2;
        topKFrequent(s, k1);

    }

    private static void topKFrequent(String[] s, int k1) {
        Map<String, Integer> map = new HashMap<>();
        for (String s1 : s) {
            if (map.containsKey(s1)) {
                int count = map.get(s1);
                map.put(s1, count+1);
            } else  {
                map.put(s1, 1);
            }

        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort( list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare( Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2 )
            {
                return (o2.getValue()).compareTo( o1.getValue() );
            }
        } );

        for(Map.Entry<String, Integer> entry:list){
            System.out.println(entry.getKey()+" ==== "+entry.getValue());
        }

        List<Map.Entry<String, Integer>> val = list.subList(0, 2);
        System.out.println("val = " + val);
    }
}
