/******************************************************************************
 *  Compilation:  javac Trinomial.java
 *  Execution:    java Trinomial n k
 *  Program that takes two integer command-line arguments n and k and computes the 
 *  corresponding trinomial coefficient. 
 *  The trinomial coefficient T(n,k) is the coefficient of xn+k in the expansion of (1+x+x^2)^n.
 ******************************************************************************/

public class TrinomialBrute {
        public static long trinomial(int n, int k){
                if(k == 0 && n==0){return 1;}
                else if (k < -n || k > n) {return 0;
                }else
                        return trinomial(n-1,k-1) + trinomial(n-1,k) + trinomial(n-1,k+1);
        }
    // test client trinomial
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        long y = trinomial(n,k);
        System.out.println(y);
    }
}
