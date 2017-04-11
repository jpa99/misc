import java.util.*;

public class ToDoList {
	
	private static ArrayList<Tasks> todo;
	
	public static void main(String[] args) {
		todo=new ArrayList<Tasks>();
		Scanner scan=new Scanner(System.in);
		int choice=0, sub;
		String task;
		ArrayList<String> subtasks;
		while(choice!=5){
			Tasks a=null;
			menu();
			choice=scan.nextInt();
			scan.nextLine();
			switch(choice){
			case 1:
				System.out.println("Enter the task: ");
				task=scan.nextLine();
				System.out.println("How many subtasks are required: ");
				sub=Integer.parseInt(scan.nextLine());
				subtasks=new ArrayList<String>();
				for(int i=0;i<sub;i++){
					System.out.println("Enter the subtask: ");
					subtasks.add(scan.nextLine());
				}
				a=new Tasks(task, subtasks);
				todo.add(a);
				break;
			case 2:
				System.out.println("Enter the task to complete: ");
				task=scan.nextLine();
				complete(task);
				break;
			case 3:
				System.out.println("Enter the task to check: ");
				task=scan.nextLine();
				for(Tasks t:todo){
					if(t.getTask()==task){
						a=t;
					}
				}
				checkPrerequisites(a);
				break;
			case 4:
				displayList();
				break;
			case 5:
				System.exit(0);
			default:
				System.out.println("\nPlease enter a valid entry");
				break;
			}
		}
	}
	
	public static void menu(){
		System.out.println("\n1. Add Task"+"\n2. Complete Task"+"\n3. Check Prerequisites"+"\n4. Display List"+"\n5. Exit");
	}
	
	public static void add(String task, ArrayList<String> subtasks){
		
	}
	
	public static void complete(String task){
		for(Tasks t:todo){
			t.complete(task);
			System.out.println("\nThe subtask "+task+" has been completed");
		}
		for(int i=0;i<todo.size();i++){
			if(todo.get(i).getTask()==task){
				if(todo.get(i).completeable()){
					todo.remove(i);
					System.out.println("\nThe task "+task+" has been completed");
				}else{
					System.out.println("Sorry, you can't complete that task yet");
				}
			}
		}
		
	}
	
	public static void displayList(){
		for(Tasks t:todo){
			System.out.println("•"+t.getTask());
		}
	}
	
	public static void checkPrerequisites(Tasks task){
		String a=null;
		for(String s:task.getKeys()){
			if(task.getSubtasks().get(s)){
				a="COMPLETE";
			}else{
				a="INCOMPLETE";
			}
			System.out.println("The task \""+s+"\" is "+a);
		}
	}
	
	
	public static ArrayList<String> removeDuplicates(ArrayList<String> list) {
		ArrayList<String> result = new ArrayList<>();
		HashSet<String> set = new HashSet<>();
		for (String item : list) {
		    if (!set.contains(item)){
				result.add(item);
				set.add(item);
		    }
		}
		return result;
    }
}	
