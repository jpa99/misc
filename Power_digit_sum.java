import java.math.BigInteger;
public class Power_digit_sum {
	public static void main(String[] args){
		int sum=0;
		BigInteger x=new BigInteger("2").pow(1000);
		char[] num=String.valueOf(x).toCharArray();
		for(char a:num){sum+=Integer.valueOf(String.valueOf(a));}
		System.out.println(sum);
	}
}
