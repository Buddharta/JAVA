public class GreatCircle{
        public static void main(String[] args){
                double x1 = Math.toRadians(Double.parseDouble(args[0]));
                double x2 = Math.toRadians(Double.parseDouble(args[2]));
                double y1 = Math.toRadians(Double.parseDouble(args[1]));
                double y2 = Math.toRadians(Double.parseDouble(args[3]));
                double diam = 12742.0;
                double angle = Math.sin((x2-x1)/2.0) * Math.sin((x2-x1)/2.0) + Math.cos(x1) * Math.cos(x2) * Math.sin((y2-y1)/2.0) * Math.sin((y2-y1)/2.0);
                double dist = diam * (Math.asin(Math.sqrt(angle)));
                System.out.println(dist + " Kilometers");
        }
}
