public class Random5Int{
        public static void main(String[] args){
                double rand1 = Math.random();               
                double rand2 = Math.random();               
                double rand3 = Math.random();               
                double rand4 = Math.random();               
                double rand5 = Math.random();
                System.out.println("values =" + rand1 + "," + rand2 + ","+ rand3 + ","+ rand4 + ","+ rand5);
                double average = 0.2 * (rand1+rand2+rand3+rand4+rand5);
                System.out.println("average = " + average);
        
                double min1 = Math.min(rand1,rand2);
                double min2 = Math.min(min1,rand3);
                double min3 = Math.min(min2,rand4);
                double min4 = Math.min(min3,rand5);
                System.out.println("min = " + min4);

                double max1 = Math.max(rand1,rand2);
                double max2 = Math.max(max1,rand3);
                double max3 = Math.max(max2,rand4);
                double max4 = Math.max(max3,rand5);
                System.out.println("max = " + max4);

        }
}
