public class ThueMorse{        
        public static void main(String args[]){
                int n = Integer.parseInt(args[0]);
                int n2 = n*n;
                int pow = 1;
                boolean[] tmseq = new boolean[n2];  
                for(int j = 0; j < n; j++){
                        for(int i = 0; i < n; i++){
                                if( j == 0 ){
                                        if(i + j*n == 2 * pow){pow = 2 * pow;}
                                        if(i + j*n - pow < 0)
                                                tmseq[i + j*n] = false;
                                        else
                                                tmseq[i + j*n] = !tmseq[i + j*n - pow];
                                        if(i == n - 1){pow = 1;}
                                }
                                else{
                                        if(j == 2 * pow){pow = 2 * pow;}
                                        tmseq[i + j*n] = !tmseq[i + n * (j - pow)];
                                }
                                if(!tmseq[i + j*n])
                                        System.out.print("+  ");
                                else
                                        System.out.print("-  ");
                        }
                        System.out.println();
                }
        }
}
