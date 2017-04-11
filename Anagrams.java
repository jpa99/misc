import java.io.*;
import java.util.*;
public class Anagrams {

	public static void main(String[] args) throws FileNotFoundException{
		
		Scanner scan=new Scanner(new File("anagram.dat"));
		int n=scan.nextInt();
		for(int i=0;i<n;i++){
			String s1=scan.next();
			String s2=scan.next();
			
			boolean an=true;
			int[] a1=alpha(s1);
			int[] a2=alpha(s2);
			for(int j=0;j<65535;j++){
				if(a1[j]!=a2[j]){
					an=false;
					break;
				}
			}
			
			if(an){
				System.out.println("YES");
			}
			else{
				System.out.println("NO");
			}
			
		}
		

	}
	
	public static int[] alpha(String s){
		int[] alpha=new int[65535];
		for(int i=0;i<s.length();i++){
			alpha[s.charAt(i)]++;
		}
		return alpha;
	}

}
