import java.awt.Color;

public class KernelFilter {
    private static Picture convolution(Picture picture, int[] Kernel, double multiplyingFactor){
	int width = picture.width();
	int height = picture.height();
	int len = Kernel.length;
	Picture convolutionPicture = new Picture(width,height);
	for (int i = 0; i < width; i++){
	    for (int j = 0; j < height; j++){
		int newRed = 0;
		int newGreen = 0;
		int newBlue = 0;
		for (int k = 0; k < len; k++){
		    int leftRight = (k % 3) -1;
		    int upDown = (k - (k % 3))/3 - 1;
		    int neighbourRed;
		    int neighbourGreen;
		    int neighbourBlue;
		    Color neighbourColor = picture.get(Math.floorMod(i + leftRight,width),Math.floorMod(j + upDown,height));
		    neighbourRed = neighbourColor.getRed() * Kernel[k];	
		    neighbourGreen = neighbourColor.getGreen() * Kernel[k];
		    neighbourBlue = neighbourColor.getBlue() * Kernel[k];
		    newRed += neighbourRed;
		    newGreen += neighbourGreen; 
		    newBlue += neighbourBlue;
		}
		newRed = (int)Math.round(multiplyingFactor * newRed);   	
		newGreen = (int)Math.round(multiplyingFactor * newGreen);
		newBlue = (int)Math.round(multiplyingFactor * newBlue);
		
		newRed = (newRed < 0) ? 0 : newRed;
		newGreen = (newGreen < 0) ? 0 : newGreen;
		newBlue = (newBlue < 0) ? 0 : newBlue;
		
		newRed = (newRed > 255) ? 255 : newRed;
		newGreen = (newGreen > 255) ? 255 : newGreen;
		newBlue = (newBlue > 255) ? 255 : newBlue;
		
		Color newColor = new Color(newRed,newGreen,newBlue);
		convolutionPicture.set(i,j,newColor);
	    }
	}
	return convolutionPicture;       
    }

    // Returns a new picture that applies the identity filter to the given picture.
    public static Picture identity(Picture picture){
	return picture;       //There is nothing to do here
    }
 
    // Returns a new picture that applies a Gaussian blur filter to the given picture.
    public static Picture gaussian(Picture picture){
	int[] kernel = {1,2,1,2,4,2,1,2,1};
	double multiplyingFactor = 1.0/16.0; 
	return convolution(picture,kernel,multiplyingFactor);       
    }


    // Returns a new picture that applies a sharpen filter to the given picture.
    public static Picture sharpen(Picture picture){
	int[] kernel = {0,-1,0,-1,5,-1,0,-1,0};
	return convolution(picture,kernel,1);              
    }


    // Returns a new picture that applies an Laplacian filter to the given picture.
    public static Picture laplacian(Picture picture){
	int[] kernel = {-1,-1,-1,-1,8,-1,-1,-1,-1};
	return convolution(picture,kernel,1);        
    }

    // Returns a new picture that applies an emboss filter to the given picture.
    public static Picture emboss(Picture picture){
	int[] kernel = {-2,-1,-0,-1,1,1,0,1,2};
	return convolution(picture,kernel,1);       
    }

    // Returns a new picture that applies a motion blur filter to the given picture.
    public static Picture motionBlur(Picture picture){
	int width = picture.width();
	int height = picture.height();
	double multiplyingFactor = 1.0/9.0;// No need for kernel since the matrix is the 9x9 identity. 
	Picture motionPicture = new Picture(width,height);
	for (int i = 0; i < width; i++){
	    for (int j = 0; j < height; j++){
		int newRed = 0;
		int newGreen = 0;
		int newBlue = 0;
		for (int k = -4; k < 5; k++){
		    int neighbourRed;
		    int neighbourGreen;
		    int neighbourBlue;
		    Color neighbourColor = picture.get(Math.floorMod(i + k,width),Math.floorMod(j + k,height));
		    neighbourRed = neighbourColor.getRed();	
		    neighbourGreen = neighbourColor.getGreen();
		    neighbourBlue = neighbourColor.getBlue();
		    newRed += neighbourRed;
		    newGreen += neighbourGreen; 
		    newBlue += neighbourBlue;
		}
		newRed = (int)Math.round(multiplyingFactor * newRed);   	
		newGreen = (int)Math.round(multiplyingFactor * newGreen);
		newBlue = (int)Math.round(multiplyingFactor * newBlue);
		
		newRed = (newRed < 0) ? 0 : newRed;
		newGreen = (newGreen < 0) ? 0 : newGreen;
		newBlue = (newBlue < 0) ? 0 : newBlue;
		
		newRed = (newRed > 255) ? 255 : newRed;
		newGreen = (newGreen > 255) ? 255 : newGreen;
		newBlue = (newBlue > 255) ? 255 : newBlue;
		    
		
		Color newColor = new Color(newRed,newGreen,newBlue);
		motionPicture.set(i,j,newColor);
	    }
	}
	return motionPicture;       
    }

    // Test client (ungraded).
    public static void main(String[] args) {
	Picture img = new Picture(args[0]);
	Picture identityImg = identity(img);
	Picture sharpenImg = sharpen(img);
	Picture laplacianImg = laplacian(img);
	Picture embossImg = emboss(img);
	Picture motionImg = motionBlur(img);
	identityImg.show(); 	
	sharpenImg.show();
	laplacianImg.show();	
	embossImg.show();  	
	motionImg.show();  	
    }
}

