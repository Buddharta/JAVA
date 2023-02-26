public class Divisors {

    // return the gcd of a and b
    public static int gcd(int a,int b) {
                if (a < 0){a = -a;}
                if (b < 0){b = -b;}
                return b == 0 ? a : gcd(b, a % b);
    }

    // return the least common multiple
    public static int lcm(int a,int b) {
            int m = (a*b < 0)? -a*b : a*b;
            if(a == 0||b == 0){return 0;}
            else{return m/gcd(a,b);}
    }

    // Check if numbers are relatively prime
    public static boolean areRelativelyPrime(int a,int b) {
            return (gcd(a,b) == 1);
    }

    // return Eulers totient function
    public static int totient(int n) {
            if(n < 0){n = -n;}
            int euler = 0;
            for (int i = 1; i <= n ;i++){
                if (areRelativelyPrime(i,n)) {euler++;}
            }
            return euler;
    }

    // test client with command-line argument x and prints each function call for x in order 
     public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        System.out.println("gcd("+ a +","+ b +") = "+ gcd(a,b));
        System.out.println("lcm("+ a +","+ b +") = "+ lcm(a,b));
        System.out.println("areRelativelyPrime("+ a +","+ b +") = "+ areRelativelyPrime(a,b));
        System.out.println("totient("+ a +") = "+ totient(a));
        System.out.println("totient("+ b +") = "+ totient(b));
    }
}
