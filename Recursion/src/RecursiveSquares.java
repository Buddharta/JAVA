/******************************************************************************
 *  Compilation:  javac RecursiveSquares.java
 *  Execution:    java ReursiveSquares n
 *  Dependencies: StdDraw.java StdIn.java
 ******************************************************************************/

public class RecursiveSquares {

        // Draws a square centered on (x, y) of the given side length
        // with a light gray background and a black border.
        public static void drawSquare(double x, double y, double length){
                StdDraw.setXscale(-1.0, 2.0);
                StdDraw.setYscale(-1.0, 2.0);
                StdDraw.enableDoubleBuffering();
                StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                StdDraw.filledSquare(x,y,length);
                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.square(x,y,length);
                StdDraw.show();
        }

        // Draws a recursive square pattern of order n, centered on (x, y)
        // of the given side length.
        public static void draw(int n, double x, double y, double length){
                if (n == 0){return;}
                double halflen = 0.5 * length;
                draw(n-1,x-length,y+length,halflen);
                draw(n-1,x+length,y+length,halflen);
                drawSquare(x,y,length);
                draw(n-1,x-length,y-length,halflen);
                draw(n-1,x+length,y-length,halflen);
        }
    // Takes an integer command-line argument n and draws a recursive
    // square pattern of order n, centered on (0.5, 0.5) with side length 0.5.
    public static void main(String[] args) {

        // read integer from command line representing the number of steps
        int n = Integer.parseInt(args[0]);
        // set the scale of the coordinate system
        draw(n,0.5,0.5,0.5);
        }
    
}
