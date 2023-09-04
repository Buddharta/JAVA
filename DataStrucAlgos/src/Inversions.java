/******************************************************************************
 *  Compilation:  javac Inversions.java
 *  Execution:    java Inversions n k
 ******************************************************************************/
public class Inversions {

    // Return the number of inversions in the permutation a[].
    public static long count(int[] a) {
        int N = a.length;
        long cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                if (a[i] > a[j])
                    cnt++;
            }
        }
        return cnt;
    }

    // Return a permutation of length n with exactly k inversions.
    public static int[] generate(int n, long k) {
        int[] permutation = new int[n];
        long gsum = n - 1;
        int res = 0;
        int position = 0;
        for (int i = 0; i < n; i++) {
            if (k >= gsum) {
                permutation[i] = n - 1 - i;
                position++;
                gsum += (n - 2 - i);
            }
            else {
                long prevgsum = gsum - (n - 1 - position);
                res = (int) (k - prevgsum);
                if (i == (n - 1 - res)) {
                    permutation[i] = n - 1 - position;

                }
                else if (i > n - 1 - res) {
                    permutation[i] = i - 1 - position;
                }
                else {
                    permutation[i] = i - position;
                }
            }
        }
        return permutation;
    }

    // Takes an integer n and a long k as command-line arguments,
    // and prints a permutation of length n with exactly k inversions.
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        long k = Long.parseLong(args[1]);
        int[] permutation = generate(n, k);
        long permucnt = count(permutation);
        for (int i = 0; i < n; i++) {
            StdOut.print(permutation[i] + " ");
        }
    }
}
