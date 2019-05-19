package Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Finding all combinations from array of Numbers say {1,2,3,4} We want to make
 * combination of r numbers, So if r=3 then combinations will be {1,2,3},
 * {1,3,2}, {2,3,1}..etc
 *
 */

public class RecursiveSubsetGeneration {

    private final static List<List<Integer>> combList = new ArrayList<>();

    public static void findAllCombinations(int[] arr, int r) {

        // Queue for storing all paths
        Queue<List<Integer>> paths = new LinkedList<>();

        // Initialize queue with array elements
        for (int i : arr) {
            List<Integer> list = new LinkedList<>();
            list.add(i);
            paths.add(list);
            list = null;
        }

        while (!paths.isEmpty()) {

            // dequeue a path
            List<Integer> path = paths.remove();

            // Loop through all array elements
            for (int i : arr) {
                if (!path.contains(i)) {
                    if (path.size() == r) {
                        combList.add(path);
                        continue;
                    }
                    List<Integer> newPath = new LinkedList<>(path);
                    newPath.add(i);
                    paths.add(newPath);
                    newPath = null;
                }
            }
        }
    }

    public static void main(String[] args){
        // Input array and r
        int[] arr = { 1, 2, 3, 4 };
        int r = 3;

        // Find all combinations of r elements
        findAllCombinations(arr, r);

        // print all combinations
        System.out.println("All possible combinations are :-");
        for (List<Integer> arrEle : combList) {
            System.out.println(arrEle);
        }
    }


}
