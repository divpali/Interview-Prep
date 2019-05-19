package knapsack;

public class SubsetOfGivenSize {

	public static void main(String[] args){
        int[] arr = {2,1,3,4};
        int k = 2;
        boolean[] used = new boolean[arr.length];
        printAllSizeKSubset(arr,used,0,0, k);

    }

    private static void printAllSizeKSubset(int[] arr, boolean[] used, int startIndex, int currentSize, int k) {
        int n = arr.length;
        if (currentSize == k) {
            for (int i = 0; i<n; i++) {
                if (used[i]) {
                    System.out.println(arr[i] + " ");
                }
            }
            System.out.println();
            return;
        }

        //when focused index exceeds aray length
        if (startIndex == arr.length) return;

        //now its the key recursion step
        used[startIndex] = true;
        printAllSizeKSubset(arr,used,startIndex+1, currentSize+1,k);
        used[startIndex] = false;
        printAllSizeKSubset(arr,used,startIndex+1, currentSize,k);

    }

}
