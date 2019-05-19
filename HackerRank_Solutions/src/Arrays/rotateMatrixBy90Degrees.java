package Arrays;

public class rotateMatrixBy90Degrees {

    public static void main(String[] args){
        int mat[][] =
                {
                        {1, 2, 3, 4, 16},
                        {5, 6, 7, 8, 3},
                        {9, 10, 11, 12, 6},
                        {13, 14, 15, 16, 3},
                        {4, 5, 7, 8, 11}
                };
        int n = 5;
        rotateMatrix(mat,n);
    }

    private static int[][] rotateMatrix(int[][] matrix, int n) {
        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - layer - 1;
            System.out.println("layer : "+layer+", first : "+first+", last : "+last);
            for (int i = first; i < last; i++) {
                int offset = i - first;
                System.out.println("first : "+first+" i : "+i);
                int top = matrix[first][i];
                matrix[first][i] = matrix[last - offset][first];
                matrix[last - offset][first] = matrix[last][last - offset];
                matrix[last - offset][last] = matrix[i][last];
                matrix[i][last] = top;
            }
        }
        System.out.println("Matrix After Rotating 90 degree:-");
//        printMatrix(matrix, n);
        return matrix;

    }

    /*private static void rotateMatrix(int[][] mat, int n) {
        //traverse through each layer
        for (int layer = 0; layer == n/2; layer++){
            System.out.println(layer);
            int first = layer;
            int last = n - layer -1;
            System.out.println("layer : "+layer+", first : "+first+", last : "+last);
            for (int i=first;i<last;i++){
                int offset = i - first;
                System.out.println("offset : "+offset);
                //save top
                int top = mat[first][i];
                //left -> top
                mat[first][i] = mat[last - offset][first];
                //bottom -> left
                mat[last - offset][first] = mat[last][last - offset];
                //right -> bottom
                mat[last - offset][last] = mat[i][last];
                mat[i][last] = top;
            }
        }
    }*/
}
