/******************************************************************************
 *  Compilation:  javac-introcs Average.java
 *  Execution:    java-introcs Average 
 *  Dependencies: StdIn.java StdOut.java
 *
 *  Reads in a sequence of integers, and computes the Shannon Entropy.
 ******************************************************************************/

public class ShannonEntropy { 
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        double shannon = 0.0;    // sum of input values
        int[] arr = new int[m + 1];
        // read data and compute Shannon value

        int[] values = StdIn.readAllInts();
        int len = values.length;
        for (int i = 0; i < len ; i++ ) {
                if (values[i] < 1 || m < values[i]){
                        StdOut.println(values[i] + " not a valid input");
                        shannon = 0.0;
                        break;
                }
                        arr[values[i]]++;
        }
        for (int i = 1; i <= m ;i++){

                double val;
                if (arr[i] == 0)
                        val = 0.0;
                else{
                        double p = (double)(arr[i])/(double)(len); 
                        val = (p * Math.log(p))/Math.log(2);
                }
                
                shannon += -val;
        }
        // print results
        StdOut.printf("%.4f\n",shannon);
    }
}
