public class HelloGoodbye {
    public static void main(String[] args){
        String name1 = args[0];
        String name2 = args[1];
        String helloSentence = String.join(" ","Hello",name1,"and", name2);
        String goodbyeSentence = String.join(" ","Goodbye",name2,"and", name1);
        System.out.println(helloSentence);
        System.out.println(goodbyeSentence);
    }
}
