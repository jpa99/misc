import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Lattice_paths {

	public static void main(String args[]){
		int r=20;
		int sum=0;
	    String[] arr=new String[2*r];
	    for(int a=0;a<r;a++){
	    	arr[a]="1";
	    }
	    for(int b=0;b<r;b++){
	    	arr[r+b]="0";
	    }
	   ArrayList<String> used=new ArrayList<String>();
	   for(int i=0;i<1000000;i++){
		  shuffleArray(arr);
		  if(!used.contains(Arrays.toString(arr))){
				used.add(Arrays.toString(arr));
				sum++;
			}
		  else{
			  i--;
		  }
	   }
	   
	   System.out.println(sum);
	}
	
	  public static void shuffleArray(String[] ar){
	    Random rnd = ThreadLocalRandom.current();
	    for (int i = ar.length - 1; i > 0; i--){
	      int index = rnd.nextInt(i + 1);
	      String a = ar[index];
	      ar[index] = ar[i];
	      ar[i] = a;
	    }
	  }

}

