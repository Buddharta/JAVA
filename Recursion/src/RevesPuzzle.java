/******************************************************************************
 *  Compilation:  javac RevesPuzzle.java
 *  Execution:    java RevesPuzzle n 
 *  Reve’s puzzle is identical to the towers of Hanoi problem, except that there are 4 poles (instead of 3). 
 *  The task is to move n discs of different sizes from the starting pole to the destination pole, 
 *  while obeying the following rules:
 *      Move only one disc at a time.
 *      Never place a larger disc on a smaller one. 
 *  The following remarkable algorithm, discovered by Frame and Stewart in 1941, transfers n discs from the starting 
 *  pole to the destination pole using the fewest moves (although this fact was not proven until 2014).
 *  Let k denote the integer nearest to n+1−\sqrt{2n+1}.
 *  Transfer (recursively) the k smallest discs to a single pole other than the start or destination poles.
 *  Transfer the remaining n−k disks to the destination pole (without using the pole that now contains the smallest k discs).
 *  To do so, use the algorithm for the 3-pole towers of Hanoi problem.
 *  Transfer (recursively) the k smallest discs to the destination pole. 
 *  This is a program that takes an integer command-line argument n and prints a solution to Reve’s puzzle. 
 *  We assume that the the discs are labeled in increasing order of size from 1 to n and that the poles are 
 *  labeled A, B, C, and D, with A representing the starting pole and D representing the destination pole.  
 ******************************************************************************/

public class RevesPuzzle {
        public static void move(int disk, char start, char end){
                System.out.println("Move disk " + disk + " from " + start + " to " + end); // move the nth disk
        }
        
        public static void reves(int disks, char pole1, char pole2, char pole3, char pole4){
                if( disks == 1){move(disks, pole1, pole4); return;}
                int k = (int)Math.round(disks + 1 - Math.sqrt(2 * disks + 1));
                int m = disks - k;
                reves(k, pole1, pole4, pole3, pole2);
                Hanoi(m, k, pole1, pole4, pole3);
                reves(k, pole2, pole1, pole3, pole4);
        }
        public static void Hanoi(int disks, int k, char fromPole, char toPole, char auxPole){
                if (disks == 0) return;
                Hanoi(disks - 1, k, fromPole, auxPole, toPole); // recursive call 1
                move(disks + k, fromPole,toPole); // move the nth disk
                Hanoi(disks - 1, k, auxPole, toPole, fromPole); 
        }
        // test client 
        public static void main(String[] args) {
                int n = Integer.parseInt(args[0]);
                reves(n,'A','B','C','D');
    }
}
