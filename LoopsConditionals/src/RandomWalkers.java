public class RandomWalkers{        
        public static void main(String args[]){
                int r = Integer.parseInt(args[0]);
                int trials = Integer.parseInt(args[1]); 
                double randnumber;
                double average = 0.0;
                for(int k = 0 ; k < trials; k++){
                        int steps = 0;
                        int x = 0;
                        int y = 0;
                        while(Math.abs(x) + Math.abs(y) < r){
                                randnumber=Math.random();
                                if (randnumber < 0.25)
                                        x++;
                                else if(randnumber < 0.5)
                                        y++;
                                else if(randnumber < 0.75)
                                        x--;
                                else
                                        y--;
                                steps+=1;
                        }
                        average+=((double)steps)/((double)trials);
                }
                System.out.println("average number of steps = " + average);
        }
}
