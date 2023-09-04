/******************************************************************************
 *  Compilation:  javac Ramanujan.java
 *  Execution:    java Ramanujan
 ******************************************************************************/

public class Ramanujan {

    // Is n a Ramanujan number?
    public static boolean isRamanujan(long n){
        long root = Math.round(Math.cbrt(n));
        int sums = 0;
        for (long i = 1; i < root; i++) {
            long cube = i * i * i;
            double iscube = Math.cbrt(n - cube);
            if(iscube == Math.round(iscube)){
                sums++;
            }
        }
        return (sums > 1);
    }

    // Takes a long integer command-line arguments n and prints true if
    // n is a Ramanujan number, and false otherwise.
        public static void main(String[] args){
        long num = Long.parseLong(args[0]);
        StdOut.print(isRamanujan(num));
    }
}
