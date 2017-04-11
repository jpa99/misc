import java.util.Scanner;
import java.io.*;
import java.time.*;
import java.math.*;
import java.awt.*;

public class Toolbox {

	public static void main(String[] args) throws Exception{
		int n=6089788;
		long start, start2;
		
		start=System.nanoTime();
		System.out.println(isPrime(n));
		start=System.nanoTime()-start;
		System.out.println(start+"\n");
		
		start2=System.nanoTime();
		System.out.println(isPrime(n));
		start2=System.nanoTime()-start2;
		System.out.println(start2+"\n");
		
		System.out.println(start-start2);
	}
	
	//Tests if input is divisible by 2 (10x faster than standard)
	public static boolean div2(int n){
		return (n & 1) == 0 && n!=0;
	}
	
	//Tests if input is prime
	public static boolean isPrime(int n){
		for(int i=2;i<Math.sqrt(n)+1;i++)
			if(n%i==0)
				return false;
		return true;
	}

}
