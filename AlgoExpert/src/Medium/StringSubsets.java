package Medium;

public class StringSubsets {

    static void printSubsets(char set[])
    {
        int n = set.length;

        // Run a loop for printing all 2^n
        // subsets one by obe
        for (int i = 0; i < (1<<n); i++)
        {
            System.out.print("{ ");

            // Print current subset
            for (int j = 0; j < n; j++)
                if ((i & (1 << j)) > 0)
                    System.out.print(set[j] + " ");

            System.out.println("}");
        }
    }

    public static void main(String[] args)
    {
        char set[] = {'a', 'b', 'c'};
//        printSubsets(set);
        int set1[] = {1,2,};
        subsets(set1);
    }

    public static void subsets(int[] arr){
        int n = arr.length;
        int[] new_arr = new int[n];
        /*for (int i=0;i<n;i++){
            helper(arr,new_arr,i,n-1);
        }*/

        helper(arr,new_arr,0);
    }

    private static void helper(int[] arr, int[] new_arr, int i) {
        if (i == arr.length){
            System.out.println("we here");
        }else {
            new_arr[i] = Integer.parseInt(null);
            helper(arr,new_arr,i+1);
            new_arr[i] = new_arr[i];
            helper(arr,new_arr,i+1);

        }
    }

    private static void helper(int[] arr, int[] new_arr, int i, int n) {
        if (i == n){
            System.out.println(new_arr);
        }else {
            new_arr[i] = -1;
            helper(arr,new_arr,i+1,n);
            new_arr[i] = arr[i];
            helper(arr,new_arr,i+1,n);
        }
    }
}
