import java.awt.Color;

public class histogram {
    
    public static int[] mkhistogram(Picture grayscaleimg) {
	int width = grayscaleimg.width();
	int height = grayscaleimg.height();
	int[] histarray = new int[256];
	for (int i = 0; i < width; i++){
	    for (int j = 0; j < height; j++){
		Color gray = grayscaleimg.get(i,j);
		int scale = gray.getRed(); //Since all are in grayscale, they should be equal
		histarray[scale]++; //all of them are a 256 int
	    }
	}
	return histarray;       
    }
    public static void main(String[] args) {
	Picture grayimg = new Picture(args[0]);
	int width = grayimg.width();
	int height = grayimg.height();
	double maxheit = 8000.0/(width*height);
	int[] histogram = mkhistogram(grayimg);
	StdDraw.setCanvasSize(2*256 + 20, 220);
	StdDraw.setXscale(0,532);
	StdDraw.setYscale(0,220);
	StdDraw.clear(StdDraw.BOOK_LIGHT_BLUE);
	double x=11;
	double y=110;
	for (int gray = 0; gray < 256; gray++){
	    double rectangleheight = maxheit * (histogram[gray]);
	    Color colorgray = new Color(gray,gray,gray);
	    StdDraw.setPenColor(colorgray);
	    StdDraw.filledRectangle(x,y,1.0,rectangleheight);
	    x=x+2;
	}
    }
}


