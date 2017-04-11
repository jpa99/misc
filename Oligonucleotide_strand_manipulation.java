import java.util.ArrayList;
import java.util.HashMap;

public class Oligonucleotide_strand_manipulation {

	public static void main(String[] args) {
		String s="actgactg";
		System.out.println(rev_comp(s));
	}
	
	public static String rev_comp(String strand){
		HashMap<String, String> nucleotides=new HashMap<String, String>();
		nucleotides.put("A", "T");
		nucleotides.put("T", "A");
		nucleotides.put("C", "G");
		nucleotides.put("G", "C");
		StringBuilder rev_strand=new StringBuilder();
		for(char c:strand.toCharArray()){
			rev_strand.append(nucleotides.get(Character.toString(c).toUpperCase()));
		}
		
		return rev_strand.reverse().toString();
	}

}
