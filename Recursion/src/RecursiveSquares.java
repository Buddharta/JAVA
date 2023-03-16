/******************************************************************************
 *  Compilation:  javac RecursiveSquares.java
 *  Execution:    java ReursiveSquares n
 *  Dependencies: StdDraw.java StdIn.java
 ******************************************************************************/

public class RecursiveSquares {

        // Draws a square centered on (x, y) of the given side length
        // with a light gray background and a black border.
        public static void drawSquare(double x, double y, double length){
                StdDraw.filledSquare(x,y,length);
        }

        // Draws a recursive square pattern of order n, centered on (x, y)
        // of the given side length.
        public static void draw(int n, double x, double y, double length){
                if (n==0){return;}
                double half = Math.pow(0.5,n-1);
                double halflen = half * length;
                draw(n-1,x+half,y+half,halflen);
                draw(n-1,x-half,y+half,halflen);
                draw(n-1,x-half,y-half,halflen);
                draw(n-1,x+half,y-half,halflen);
                drawSquare(x,y,length);
        }
    // Takes an integer command-line argument n and draws a recursive
    // square pattern of order n, centered on (0.5, 0.5) with side length 0.5.
    public static void main(String[] args) {

        // read integer from command line representing the number of steps
        int n = StdIn.readInt();
        // set the scale of the coordinate system
        StdDraw.setXscale(-1.0, 1.0);
        StdDraw.setYscale(-1.0, 1.0);
        StdDraw.enableDoubleBuffering();
        draw(n,0.0,0.0,0.5);

        }
    
}
