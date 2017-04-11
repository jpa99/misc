import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class NewYear {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner scan=new Scanner(new File("test.in"));
		ArrayList<Integer> poss=new ArrayList<Integer>();
		int n=scan.nextInt();
		int[][] arr=new int[n][2];
		
		for(int i=0;i<n;i++){
			arr[i][0]=scan.nextInt();
			arr[i][1]=scan.nextInt();
		}
		
		for(int x=0;x<3000;x++){

		}
		
		
		
		

	}

}
