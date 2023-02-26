import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomWord {
    public static void main(String[] args) {

            String champion = "";
            int arguments = 0;
            while (!StdIn.isEmpty()) {
                String str = StdIn.readString();
                arguments++;
                double prob = 1.0/arguments;
                if (StdRandom.bernoulli(prob)) {
                    champion = str;
                }
            }
            System.out.println(champion);
    }
}
