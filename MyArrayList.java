import java.util.Arrays;

public class MyArrayList{

	
	private static Object[] list;
	private static int size;
	
	public MyArrayList(){
		size=10;
		list = new Object[size];
	}
	
	public static void add(Object n){
		expandList();
		list[list.length-1]=n;
	}
	
	public static int size(){
		return list.length;
	}
	
	public String toString(){
		return Arrays.toString(list);
	}
	
	public static void expandList(){
		Object[] temp=new Object[list.length+1];
		for(int i=0;i<temp.length;i++)
			if(i<list.length)
				temp[i]=list[i];
		list=temp;
	}
	
	public void add(int pos, Object n) throws Exception{
		if(pos<0 || pos>list.length-1){
			throw new Exception("Index out of Bounds");
		}
		expandList();
		for(int i=0;i<list.length;i++){
			if(i>pos)
				list[i]=list[i-1];
		}
		list[pos]=n;
	}
	
	public void remove(int pos) throws Exception{
		if(pos<0 || pos>list.length-1){
			throw new Exception("Index out of Bounds");
		}
		Object[] temp=new Object[list.length-1];
		for(int i=0;i<temp.length;i++){
			if(i<pos)
				temp[i]=list[i];
			else if(i>=pos)
				temp[i]=list[i+1];
		}
		list=temp;
	}
	
	public void remove(int start, int end) throws Exception{ // range to be removed includes start and excludes end
		if(start>end || start<0 || end>list.length-1){
			throw new Exception("Index out of Bounds");
		}
		int range=end-start;
		Object[] temp=new Object[list.length-range];
		for(int i=0;i<temp.length;i++){
			if(i<start)
				temp[i]=list[i];
			else{
				temp[i]=list[i+range];
			}
		}
		list=temp;
	}
	
	public static int indexOf(Object n){
		for(int i=0;i<list.length;i++){
			if(list[i].equals(n)){
				return i;
			}
		}
		return -1;
	}
	
	public static boolean contains(Object n){
		return (indexOf(n)>-1) ? true:false;
	}
		
	
	public Object get(int pos) throws Exception{
		if(pos<0 || pos>=list.length){
			throw new Exception("Index out of Bounds");
		}
		return list[pos];
	}
	
	public void set(int pos, Object n) throws Exception{
		if(pos<0 || pos>list.length-1){
			throw new Exception("Index out of Bounds");
		}
		list[pos]=n;
	}
	
	


}