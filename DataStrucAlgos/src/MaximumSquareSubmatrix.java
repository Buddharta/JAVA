/******************************************************************************
*  Compilation:  javac MaximumSquareSubmatrix.java
*  Execution:    java MaximumSquareSubmatrix
 ******************************************************************************/
public class MaximumSquareSubmatrix {

    // Returns the size of the largest contiguous square submatrix
    // of a[][] containing only 1s.
    public static int size(int[][] a){
        if (a == null || a.length == 0 || a.length == 0) {
            return 0;
        }

     // Initialize the maximum side length of the square submatrix
        int size = 0;
        int n = a[0].length;
        int[][] greater = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (a[i - 1][j - 1] == 1) {
                    greater[i][j] = Math.min(greater[i - 1][j - 1], Math.min(greater[i - 1][j], greater[i][j - 1])) + 1;
                    size = Math.max(size, greater[i][j]);
                }
            }
        }
    return size;
    }

    // Reads an n-by-n matrix of 0s and 1s from standard input
    // and prints the size of the largest contiguous square submatrix
    // containing only 1s.
    public static void main(String[] args){
        int n = StdIn.readInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = StdIn.readInt();
            }
        }
        System.out.println(size(matrix));
    }
}
