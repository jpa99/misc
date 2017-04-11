import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PhoneNumber {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		String number="";
		System.out.println("Enter your name: ");
		String name=scan.nextLine();
		System.out.println("Enter your phone number: (ex. 5129548181)");
		for(char i:scan.nextLine().toCharArray())
			number+=Character.isDigit(i)? String.valueOf(i):"";
		System.out.println(number);
		int a=(int) ((number.length()/2)+0.5);
		System.out.println("The number is: "+Arrays.toString(number.toCharArray())+"\nThe number is "+number.length()+" characters"+"\nThe first character is "+number.substring(0, 1)+"\nThe last character is "+number.substring(number.length()-1)+"\nThe middle character is "+number.substring(a, a+1));

	}

}
