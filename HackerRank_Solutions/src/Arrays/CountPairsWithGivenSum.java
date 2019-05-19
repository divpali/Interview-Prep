package Arrays;

import java.util.HashMap;
import java.util.Map;

public class CountPairsWithGivenSum {

    public static void main(String[] args) {
        // Scanner input = new Scanner(System.in);
        // System.out.println("length of array :");
        // int n = input.nextInt();
        // int[] arr = new int[n];
        // System.out.println("Add elements to array :");
        // for(int i =0;i<n;i++){
        //   arr[i] = input.nextInt();
        // }
        int arr[] = { 5, 1, 7, -1, 5 };
        int sum = 6;
        int c = countPairs(arr,sum);
        System.out.println(c);
    }


    public static int countPairs(int[] arr, int sum){
        //add elements and their frequency in map
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<arr.length;i++){
            if(map.get(arr[i])==null){
                map.put(arr[i],0);
            }
            map.put(arr[i],map.get(arr[i])+1);
        }
        System.out.println(map);

        int count = 0;
        for(int i=0;i<arr.length;i++){
            if(map.get(sum-arr[i]) != null){
                System.out.println("arr[i]: "+arr[i] +" diff : "+(sum-arr[i])+" value : "+map.get(sum-arr[i]));
                count += map.get(sum-arr[i]);
                System.out.println("count : "+count);
            }

            if(sum-arr[i] == arr[i]){
                count--;
            }
        }
        return count/2;
    }
}
