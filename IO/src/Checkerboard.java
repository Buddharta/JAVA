/******************************************************************************
 *  Compilation:  javac Checkerboard.java
 *  Execution:    java Checkerboard
 *  Dependencies: StdDraw.java
 ******************************************************************************/

public class Checkerboard { 
    public static void main(String[] args) {
	int n = Integer.parseInt(args[0]);
	// set the scale of the coordinate system
	StdDraw.setScale(0, n);
	double rx;
	double ry;
	double r = 0.5;
	for (int j = 0; j < n ; j++){
	    for (int i = 0; i < n; i++){
		rx =0.5;
		ry = 0.5;
		rx += i;
		ry += j; 
		if ((i + j)% 2 == 0){
		    StdDraw.setPenColor(StdDraw.BLUE); 
		    StdDraw.filledSquare(rx,ry,r);
		}
		else {
		    StdDraw.setPenColor(StdDraw.LIGHT_GRAY); 
		    StdDraw.filledSquare(rx,ry,r);
		}
	    }
	}
    } 
} 
