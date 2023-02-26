/******************************************************************************
 *  Compilation:  javac TrinomialDP.java
 *  Execution:    java TrinomialDp n k
 ******************************************************************************/

public class TrinomialDP {
        public static long trinomial(int n, int k){
                if (k < -n || k > n) {return 0;}
                //int m = n*(n+1)/2; 
                long[][] triarr = new long[n+1][n+1];
                triarr[0][0] = 1;
                        triarr[n][n] = 1;
                for(int i = 1; i <= n; i++){
                        for(int j = 0; j < n; j++){
                                //trinomial(n-1,k-1) + trinomial(n-1,k) + trinomial(n-1,k+1);
                                triarr[i][j] = (j - 1 < 0)?
                                        triarr[i-1][j] + 2 * triarr[i-1][j+1] : 
                                        triarr[i-1][j-1] + triarr[i-1][j] + triarr[i-1][j+1];
                        }
                }
                return triarr[n][Math.abs(k)];
        }
    // test client trinomial
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        long y = trinomial(n,k);
        System.out.println(y);
    }
}
