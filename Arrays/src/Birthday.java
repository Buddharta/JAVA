//Birthday problem. Suppose that people enter a room one at a time. How people must enter until two share a birthday? 
//Counterintuitively, after 23 people enter the room, there is approximately a 50–50 chance that two share a birthday. 
//This phenomenon is known as the birthday problem or birthday paradox.
//
//Write a program Birthday.java that takes two integer command-line arguments n and trials and performs the following 
//experiment, trials times:
//
//    Choose a birthday for the next person, uniformly at random between 0 and n−1.
//
//    Have that person enter the room.
//
//    If that person shares a birthday with someone else in the room, stop; otherwise repeat. 
//
//In each experiment, count the number of people that enter the room. Print a table that summarizes the results 
//(the count i, the number of times that exactly i people enter the room, and the fraction of times that i or fewer 
//people enter the room) for each possible value of i from 1 until the fraction reaches (or exceeds) 50%. 

public class Birthday{        
        public static void main(String args[]){
                int n  = Integer.parseInt(args[0]);
                int trials = Integer.parseInt(args[1]);
                int[] exptilperson = new int[n];
                double[] percentage = new double[n];
                double firstdupbefore = 0.0;
                int randbday;
                for(int k = 0 ; k < trials; k++){
                        int persons = 0;
                        boolean[] days = new boolean[n];
                        while(persons < n){
                                persons++;
                                randbday = (int)(Math.random() * (n - 1));
                                if(!days[randbday])
                                        days[randbday] = true;
                                else
                                        break;
                        }
                        exptilperson[persons]++;
                }
                int count = 1;
                do{
                        percentage[count] = (double)(exptilperson[count])/(double)(trials);
                        firstdupbefore += percentage[count];
                        System.out.println(count + "  " + exptilperson[count] + "  " + firstdupbefore);
                        count++;
                }while(firstdupbefore < 0.5);       
        }
}
