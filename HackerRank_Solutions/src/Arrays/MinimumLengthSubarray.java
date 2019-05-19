package Arrays;

//find minimum length subarray of sum k

public class MinimumLengthSubarray {

    public static void main(String[] args){
        int[] arr = {2,3,1,1,-1,3,4};
        int k = 8;
        findSubarray(arr,k);

    }

    private static void findSubarray(int[] array,int k) {
        int start = -1;
        int end = -1;
        int min = Integer.MAX_VALUE;

        for (int i=0;i<array.length;i++){
            int current = 0;
            for (int j=i;j<array.length && (j-i+1) < min ;j++){
                current += array[j];
                if (current == k){
                    start = i;
                    end = j;
                    min = end - start + 1;
                    break;
                }
            }
        }

        if (start == -1 && end == -1){
            return;

        }

        while (start <= end){
            System.out.println(array[start]);
            start++;
        }
    }
}
