package WindowSliding;

import java.util.Deque;
import java.util.LinkedList;

public class FindFirstNegativeInWindow {

    // Driver program to test above functions
    public static void main(String[] args)
    {
        int arr[] = {12, -7, -1, 8, -15, 30, 16, 28};
        int k=3;
        findFirstNegative(arr, arr.length,k);
    }

    private static void findFirstNegative(int[] arr, int length, int k) {
        Deque<Integer> di = new LinkedList<>();
        int n = arr.length;
        for (int i=0;i<k;i++) {
            if (arr[i] < 0) {
                di.addLast(i);
            }
            /*if (arr[i] < arr[i+1]) {
                di.addLast(i);
            } else {
                di.addLast(i+1);
            }*/
        }

        for (int i=k;i<n;i++) {
            if (!di.isEmpty()) {
                System.out.println(arr[di.peekLast()]);
            }

            while (!di.isEmpty() && di.peek() <= i - k) {
                di.removeLast();
            }

            if (arr[i] < 0) {
                di.addLast(i);
            }
        }

        if (!di.isEmpty()) {
            System.out.println("arr[di.peekLast()] = " + arr[di.peekLast()]);
        }
    }
}
