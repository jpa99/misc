import java.util.*;
import java.io.*;
import java.time.*;
import java.math.*;
import java.awt.*;

public class MatrixRotation {
	static String input="input.txt", out="output.txt";

	public static void main(String[] args) throws Exception{
		long start=System.nanoTime();
		PrintWriter writer=new PrintWriter(new BufferedWriter(new FileWriter(out)));
		Scanner scan=new Scanner(new File(input));
		ArrayList<String[]> list=new ArrayList<String[]>();
		while(scan.hasNextLine())
			list.add(scan.nextLine().split(" "));
		int[][] mat=new int[list.size()][list.get(0).length];
		for(int i=0;i<list.size();i++)
			for(int j=0;j<list.get(0).length;j++)
				mat[i][j] = Integer.parseInt(list.get(i)[j]);
		
		
		mat=rotate1(mat);
		
		for(int i=0;i<mat.length;i++)
			System.out.println(Arrays.toString(mat[i]));

		System.out.println("\n"+(System.nanoTime()-start)*1e-6+"  ms");
		
	}
	
	//COUNTERCLOCKWISE ROTATION:
	//Method 1: Reflects across diagonal (y=x) and reflects vertically across horizontal (y=len/2)
	public static int[][] rotate1(int[][] mat){
		for(int i=0;i<mat.length;i++)
			for(int j=i;j<mat.length;j++)
				mat[i][j] = mat[i][j] ^ mat[j][i] ^ (mat[j][i] = mat[i][j]);
		
		for(int i=0;i<mat.length/2;i++)
			for(int j=0;j<mat.length;j++)
				mat[i][j] = mat[i][j] ^ mat[mat.length-i-1][j] ^ (mat[mat.length-i-1][j] = mat[i][j]);
	
		return mat;
	}
	
	//Method 2: Rotates groups of 4 elements with symmetry wrt center until each shell rotated
	public static int[][] rotate2(int[][] mat)
	{
		int N=mat.length-1;
	    for(int x=0; x<(N+1)/2; x++){
	        for (int y=x; y<N-x; y++){
	            int temp = mat[x][y];
	            mat[x][y] = mat[y][N-x];
	            mat[y][mat.length-1-x] = mat[N-x][N-y];
	            mat[N-x][N-y] = mat[N-y][x];
	            mat[N-y][x] = temp;
	        }
	    }
	    return mat;
	}
}
