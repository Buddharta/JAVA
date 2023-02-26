public class ActivationFunction {

    // return the Heaviside function
    public static double heaviside(double x) {
                if(x < 0){return 0.0;}
                else if(x == 0){return 0.5;}
                else  return 1.0;
    }

    // return the sigmoid function
    public static double sigmoid(double x) {
        return 1.0 / (1.0 + Math.exp(-x));
    }

    // return hyperbolic tan
    public static double tanh(double x) {
        return (Math.exp(x)-Math.exp(-x))/(Math.exp(x)+Math.exp(-x));
    }

    // return softsign function
    public static double softsign(double x) {
        return x / (1 + Math.abs(x));
    }

    // returns the square non lineality
    public static double sqnl(double x) {
            if(x<=-2.0){return -1.0;}
            else if(-2.0 < x && x < 0.0 ) {return x + x*x/4.0;}
            else if(0.0 <= x && x < 2.0 ) {return x - x*x/4.0;}
            else {return 1;}
    }


    // test client with command-line argument x and prints each function call for x in order 
     public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        System.out.println("heaviside(" + x + ") = " + heaviside(x));
        System.out.println("  sigmoid(" + x + ") = " + sigmoid(x));
        System.out.println("     tanh(" + x + ") = " + tanh(x));
        System.out.println(" softsign(" + x + ") = " + softsign(x));
        System.out.println("     sqnl(" + x + ") = " + sqnl(x));
    }
}
