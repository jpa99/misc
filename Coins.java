public class Coins {
	
	public static void main(String[] args) {
		long start=System.nanoTime();
		int q, d, n, p, x=1000, num=0;

		for(q=0; q<=x/25; q++){
			for(d=0;d<= (x-25*q)/10; d++){
				for(n=0;n<= (x-25*q-10*d)/5; n++){
					for(p=0;p<= x-25*q-10*d-5*n;p++){
						if(25*q+10*d+5*n+p==x){
							num++;
							//System.out.println(q+" Quarters, "+d+" Dimes, "+n+" Nickels, "+p+" Pennies");
						}
					}
				}
			}
		}
		
		System.out.println(num+" combinations");
		System.out.println((System.nanoTime()-start));
		
	}

}
