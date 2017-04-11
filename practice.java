import java.util.ArrayList;

public class practice{
	
	public static void main(String[] args){
		int[]a={1,2, 3};
	}
	public static int mostCommon(ArrayList<Integer> a)
	{
		  int count = 1, tempCount;
		  int popular = a.get(0);
		  int temp = 0;
		  for (int i = 0; i < (a.size() - 1); i++)
		  {
		    temp = a.get(i);
		    tempCount = 0;
		    for (int j = 1; j < a.size(); j++)
		    {
		      if (temp == a.get(i)){
		        tempCount++;
		      }
		    }
		    if (tempCount > count)
		    {
		      popular = temp;
		      count = tempCount;
		    }
		  }
		  return popular;
	}
}