
/**************************************************************************
 *  Compilation:  javac AudioCollage.java
 *  Execution:    java AudioCollage < input.txt
 *  Dependencies: StdAudio.java StdIn.java
 *
***************************************************************************/
public class AudioCollage {

    // Returns a new array that rescales a[] by a multiplicative factor of alpha.
        public static double[] amplify(double[] a, double alpha){
                int len = a.length;
                double[] amp = new double[len];
                for(int i = 0; i < len;i++){
                        amp[i] = alpha * a[i];
                }
                return amp;
        }

    // Returns a new array that is the reverse of a[].
    public static double[] reverse(double[] a){
                int len = a.length;
                double[] rev = new double[len];
                for(int i = 1; i <= len; i++){
                        rev[i] = a[len-i];
                }
                return rev;
        }

    // Returns a new array that is the concatenation of a[] and b[].
    public static double[] merge(double[] a, double[] b){
                int lena = a.length;
                int lenb = b.length;
                double[] merg = new double[lena+lenb];
                for(int i = 0; i < lena;i++){
                        merg[i] = a[i];
                }
                for(int j = lena;j < lena+lenb;j++){
                        merg[j] = b[j-lena];
                }
                return merg;
        }

    // Returns a new array that is the sum of a[] and b[],
    // padding the shorter arrays with trailing 0s if necessary.
    public static double[] mix(double[] a, double[] b){
                int totlen = Math.max(a.length, b.length);
                double[] na = new double[totlen];
                double[] nb = new double[totlen];
                double[] sum = new double[totlen];
                for(int i = 0; i < totlen;i++){
                        na[i] = (a.length <= i)? 0 : a[i];
                        nb[i] = (b.length <= i)? 0 : b[i];
                        sum[i] = na[i] + nb[i];
                }
                return sum;
    }

    // Returns a new array that changes the speed by the given factor.
    public static double[] changeSpeed(double[] a, double alpha){
                if(alpha < 0){alpha = -alpha;}
                int len = a.length;
                int flen = (int)(len/alpha);
                double[] amp = new double[flen];
                for(int i = 0; i < flen;i++){
                        amp[i] = a[(int)(alpha * i)];
                }
                return amp;
        }

    // Creates an audio collage and plays it on standard audio.
    // See below for the requirements.
    public static void main(String[] args){
            double[] samp = StdAudio.read("beatbox.wav");
            double[] a = StdAudio.read("buzzer.wav");
            double[] b = StdAudio.read("chimes.wav");
            double[] c = StdAudio.read("cow.wav");
            double[] d = StdAudio.read("dialup.wav");
            double[] e = StdAudio.read("exposure.wav");
            // play it using standard audio
                StdAudio.play(samp);
                StdAudio.play(a);
                StdAudio.play(b);
                StdAudio.play(c);
                StdAudio.play(d);
                StdAudio.play(e);
                double[] ampa   =  amplify(samp, 0.3);
                double[] ampb   =  amplify(b, 2.3);
                double[] reva   =  reverse(a);
                double[] merga  =  merge(a,samp);
                double[] mixa   =  mix(b,c);
                double[] speeda =  changeSpeed(d,2.0); 
                double[] speede =  changeSpeed(e,0.4); 
                StdAudio.play(ampa);
                StdAudio.play(ampb);
                StdAudio.play(reva);
                StdAudio.play(merga);
                StdAudio.play(mixa);
                StdAudio.play(speeda);
                StdAudio.play(speede);
//            double[]  reva =ampa   = new double[n+1];
//            double[]  merga reva   = new double[n+1];
//            double[]  mixa =merga  = new double[n+1];
//            double[]  speedamixa   = new double[n+1];
//            double[] speeda =  new double[n+1];
//                 ampa = amplify(a, 0.3);
//                 reva = reverse(a);
//                 merga = merge(a,reva);
//                 mixa = mix(a,merga);
//                 speeda = changeSpeed(a,2); 
    }
}
