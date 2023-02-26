public class RandomWalker{        
        public static void main(String args[]){
                int r = Integer.parseInt(args[0]);
                int steps = 0;
                int x = 0;
                int y = 0;
                double randnumber;
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
                        System.out.println("(" + x + ", " + y + ")");
                }
                System.out.println("Steps = " + steps);
        }
}
