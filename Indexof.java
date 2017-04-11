public class Indexof {

	public static void main(String[] args) {
		char[] needle="westwood".toCharArray();
		char[] haystack="westlake wishes it were westwood".toCharArray();
		
		System.out.println(indexOf(needle, haystack));

	}
	
	public static int indexOf(char[] needle, char[] haystack){
		for(char i: haystack){
			if(String.valueOf(needle)==String.valueOf(haystack).substring(i, i+needle.length)){
				return i;
			}
		}
		return -1;
	}

}
