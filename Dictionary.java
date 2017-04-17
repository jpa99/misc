import java.util.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.*;

public class Dictionary<T> {
	
	public static void main (String[] args) throws Exception{
		Scanner in=new Scanner(System.in); 
		String word, doc, def;
		while (true) {
			try{
				System.out.println("---------------------------------------------------------------------");
				System.out.println("Enter a word: ");
				word=in.next();
				doc = Jsoup.connect("http://www.dictionary.com/browse/"+word+"?s=t").get().select("div").select(".def-content").toString();
			}catch(Exception e){
				System.out.println("\n\nINCORRECT INPUT: "+e.toString()+"\n\n");
				continue;
			}
			
			Scanner scan=new Scanner(doc); scan.nextLine();
			def=scan.nextLine().trim();
			def=def.substring(0,  def.length()-1).toLowerCase(); scan.nextLine();
			System.out.println("\n"+word.toUpperCase()+": "+def);
			System.in.read();
		}
		
		
		/*String ex=scan.nextLine().trim().sdfghplit("[>,<]")[2];
		ex=ex.substring(0, ex.length()-1).toLowerCase();
		System.out.println(word.toUpperCase()+": "+def);//+"\ne.g.: "+//ex);*/
	}
}
