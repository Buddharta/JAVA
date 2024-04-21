public class Huntingtons {

    // Returns the maximum number of consecutive repeats of CAG in the DNA string.
    public static int maxRepeats(String dna){
	int length = dna.length();
	if (length < 3)
	    return 0;
	int repeats = 0;
	int maxRepeats = 0;
	
	for (int index = 0; index <= length - 3; index++){
	    String subStr = dna.substring(index,index+3);
	    if (subStr.equals("CAG")){
		repeats++;
		index+=2;
	    }
	    else
		repeats = 0;
	    if (maxRepeats < repeats)
		maxRepeats = repeats;
	}
	return maxRepeats;
    }

    // Returns a copy of s, with all whitespace (spaces, tabs, and newlines) removed.
    public static String removeWhitespace(String s){
	String whitespacelessStr = s.replaceAll(" ","").replaceAll("\t","").replaceAll("\n","");
	return whitespacelessStr;
    }

    // Returns one of these diagnoses corresponding to the maximum number of repeats:
    // "not human", "normal", "high risk", or "Huntington's".
    public static String diagnose(int maxRepeats){
	if (10 <= maxRepeats && maxRepeats < 36)
	    return "normal";
	else if (36 <= maxRepeats && maxRepeats < 40)
	    return "high risk";
	else if (40 <= maxRepeats && maxRepeats < 181)
	    return "Huntington's";
	else
	    return "not human";
    }
    // Sample client (see below).
    public static void main(String[] args){
	String filename = args[0];
        In In = new In(filename);
        String DNA = In.readAll();
	String cleanDNA = removeWhitespace(DNA); 
	int maxRepeats = maxRepeats(cleanDNA);
	StdOut.println("max repeats = " + maxRepeats);	
	StdOut.println(diagnose(maxRepeats));
    }
}
