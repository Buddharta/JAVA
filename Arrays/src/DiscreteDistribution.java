public class DiscreteDistribution
{ 

	public static void main(String [] args)
	{
        int m = Integer.parseInt(args[0]);
        int len = args.length - 1;
        int[] partition = new int[len];
        int[] probabilities = new int[m];
        int[] index = new int[m];
        int[] sums = new int[len + 1];
        int sum = 0;
                for (int i = 0; i < len; i ++){
                       sums[i] = sum;
	               partition[i] = Integer.parseInt(args[i + 1]);
                       sum += partition[i];
                }
                sums[len] = sum;
                for(int i = 0; i < m ;i++){
                        probabilities[i] = (int)(Math.random()*(sums[len]-1));
                        for (int j = 1; j <= len; j++){
                                        if(sums[j-1]<= probabilities[i] && probabilities[i] < sums[j]){
                                                index[i] = j;
                                }
                        }
                }
                for(int i = 0; i < m ;i++){System.out.print(index[i] + " ");}
                System.out.println();
        }
}
