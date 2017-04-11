import java.util.*;

public class Tasks {

	public static String task;
	public static HashMap<String, Boolean> subtasks=new HashMap<String, Boolean>();
	public static ArrayList<String> keys=new ArrayList<String>();
	
	
	public Tasks(String t, ArrayList<String> k){
		task=t;
		keys=k;
		for(String x:keys){
			subtasks.put(x, false);
		}
	}
	
	public String getTask(){
		return task;
	}
	
	public void complete(String subtask){
		if(present(subtask)){
			subtasks.replace(subtask, true);
		}
	}
	
	public boolean present(String subtask){
		for(int i=0;i<keys.size();i++){
			if(keys.get(i)==subtask){
				return true;
			}
		}
		return false;
	}
	
	public boolean completeable(){
		for(String s:keys){
			if(!subtasks.get(s)){
				return false;
			}
		}
		return true;
	}
	
	public ArrayList<String> getKeys(){
		return keys;
	}
	
	public HashMap<String, Boolean> getSubtasks(){
		return subtasks;
	}
}
