public class GeneralizedHarmonic{        
        public static void main(String args[]){
                int n = Integer.parseInt(args[0]);        
                int r = Integer.parseInt(args[1]);
                double harmonic = 0.0;
                for(int i = 1; i <= n; i++){
                        harmonic += Math.pow(i,-r);
                }
                System.out.println(harmonic);
        }
}
