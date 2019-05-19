package Arrays;

/*
    Find maximum (or minimum) sum of a subarray of size k
 */
public class MaxSumOfSubArray {

    public static void main(String[] args) {
        int arr[] = {1, 4, 2, 10, 2, 3, 1, 0, 20};
        int k = 4;
        int n = arr.length;
        System.out.println(maxSum(arr, n, k));
    }

    private static int maxSum(int[] arr, int n, int k) {

        int res=0;
        for (int i = 0; i<k ; i++) {
            res += arr[i];
        }
        int curr_max=res;
        for (int j = k; j<n;j++) {
            curr_max += arr[j] - arr[j-k];
            Math.max(res, curr_max);
        }
        return curr_max;
    }
}
