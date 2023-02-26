/******************************************************************************
 *  Compilation:  javac WorlMap.java
 *  Execution:    java WorldMap < input.txt
 *  Dependencies: StdDraw.java StdIn.java
 ******************************************************************************/

public class WorldMap {

    public static void main(String[] args) {

        // read in bounding box and rescale
        int width = StdIn.readInt();
        int height = StdIn.readInt(); 
        
        StdDraw.setCanvasSize(width,height);
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(0, height);
        
        while  (!StdIn.isEmpty()){        
                StdIn.readString();
                int vertex = StdIn.readInt();
                double[] x = new  double[vertex];
                double[] y = new  double[vertex];
                for (int i = 0; i < vertex; i++) {
                        x[i] = StdIn.readDouble();
                        y[i] = StdIn.readDouble();
                }
                StdDraw.polygon(x,y);
        }
    }
}
