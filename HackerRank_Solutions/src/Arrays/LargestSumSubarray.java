package Arrays;

/*
    Largest Sum Contiguous Subarray
    Write an efficient program to find the sum of contiguous subarray within
    a one-dimensional array of numbers which has the largest sum.
 */
public class LargestSumSubarray {

    public static void main(String[] args) {
        // Scanner input = new Scanner(System.in);
        // System.out.println("length of array :");
        // int n = input.nextInt();
        // int[] arr = new int[n];
        // System.out.println("Add elements to array :");
        // for(int i =0;i<n;i++){
        //   arr[i] = input.nextInt();
        // }

        int[] arr = { -2, -3, 4, -1, -2, 1, 5, -3 };
        int c = largestSum(arr);
        System.out.println(c);

    }

    static int largestSum(int[] arr) {
        int curr_max = arr[0];
        int max_so_far = arr[0];

        for (int i = 1; i < arr.length; i++) {
            System.out.println(
                    "arr[" + i + "] : " + arr[i] + " curr_max : " + curr_max + " max_so_far : " + max_so_far);
            curr_max = Math.max(arr[i], curr_max + arr[i]);
            max_so_far = Math.max(max_so_far, curr_max);
        }

        return max_so_far;
    }
}
