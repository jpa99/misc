
public class Highly_divisible_triangle_number {

	public static void main(String[] args) {
		int index=1;
		int max_divisors=0;
		int i=1;
		while(max_divisors<=500){
			System.out.println("trinum is "+i+": "+ num_divisors(i));
			max_divisors=Math.max(max_divisors, num_divisors(i));
			System.out.println("index is "+index);
			index++;
			i+=index;
		}
		System.out.println("The "+(index-1)+"th triangle number, "+(i-index)+", has "+max_divisors+" divisors");
		
	}
	
	public static int num_divisors(int input){
	    int sum=2;
	    if(input==1)
	    	sum=1;
	    for(int i = 2; i <= (int)Math.sqrt(input); i++)
	    {
	        if(input % i == 0)
	        {
	           sum ++;
	           int d = input/i;
	           if(d!=i){
	              sum++;
	           }
	        }
	    }
	    return sum;

	}

	
}
