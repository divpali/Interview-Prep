package Arrays;

public class mergeSortedArray {

    public static void main(String[] args){
        int[] arr1 = {3,9,16,-1,-1,-1};
        int[] arr2 = {2,4,5};
        int m = arr2.length;
        int n = arr1.length - m;
        int k = arr1.length;

        while (n > 0 & m > 0){
            if (arr1[n-1] > arr2[m-1]){
                arr1[k-1] = arr1[n-1];
                n--;k--;
            }else {
                arr1[k-1] = arr2[m-1];
                m--;k--;
            }
        }

        //copy the remaining elements
        while (m>0){
            arr1[k-1] = arr2[m-1];
            m--;
        }

        System.out.println("length of two merge sorted array");
        for (int i = 0;i < arr1.length; i++){
            System.out.println(arr1[i]);
        }

    }
}
