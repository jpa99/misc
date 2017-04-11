import java.util.*;

public class TaskTracker {
	
	public static void main(String[] args) throws Exception{
		Scanner scan=new Scanner(System.in);
		String name;
		int priority, choice;
		ArrayList<Employee> employees=new ArrayList<Employee>();
		Employee e = null;
		do{
			menu();
			choice=scan.nextInt();
			scan.nextLine();
			switch(choice){
			case 1:
				System.out.println("\nEnter Employee Name:");
				name=scan.nextLine();
				employees.add(new Employee(name));
				break;
			case 2:
				System.out.println("\nEnter Employee Name:");
				name=scan.nextLine();
				for(Employee i:employees){
					if(i.getName().equals(name)){
						e=i;
						choice=0;
					}
				}
				if(e==null){
					choice=8;
					System.out.println("Sorry that employee doesn't work here");
				}
				while(choice<8){
					emenu();
					choice=scan.nextInt();
					scan.nextLine();
					switch(choice){
					case 1:
						System.out.println("\nEnter Task Name:");
						name=scan.nextLine();
						System.out.println("\nEnter Task Priority:");
						priority=scan.nextInt();
						scan.nextLine();
						e.addTask(new Task(name, priority));
						break;
					case 2:
						if(e.getNextTask()!=null){
							System.out.println("The next task to be completed is: "+e.getNextTask().toString());
						}
						else{
							System.out.println("All tasks completed");
						}
						break;
					case 3:
						if(e.getNextTask()!=null){
							e.completeTask();
							System.out.println("The task "+e.lastCompleted().toString()+" has been completed");
						}
						else{
							System.out.println("All tasks completed");
						}
						break;
					case 4:
						if(e.lastCompleted()!=null){
							System.out.println("The last task completed was: "+e.lastCompleted().toString());
						}
						else{
							System.out.println("No tasks completed");
						}
						break;
					case 5:
						if(e.lastCompleted()!=null){
							System.out.println("The task "+e.lastCompleted().toString()+" has been returned to the list");
							e.returnTask();
						}
						else{
							System.out.println("No tasks completed");
						}
						break;
					case 6:
						System.out.println(e.info());
						break;
					case 7:
						choice=8;
						break;
					case 8:
						System.exit(0);
					default:
						System.out.println("\nPlease enter a valid entry");
						break;
					}
				}
				break;
			case 3:
				System.out.println("\n\nLIST OF EMPLOYEES: ");
				for(Employee x:employees){
					System.out.println(x.info());
				}
				System.out.println();
				break;
			case 4:
				System.exit(0);
			default:
				System.out.println("\nPlease enter a valid entry");
				break;
			}
		} while(true);
	}
	
	public static void emenu(){
		System.out.println("\n1. Add a task\n"+"2. Display the next task to be completed\n"+"3. Mark task as completed\n"+"4. Display last task completed\n"+"5. Return last task completed to the task to do list\n"+"6. Display employee information\n"+"7. Change Employee\n"+"8. Exit Program");
	}
	
	public static void menu(){
		System.out.println("\n1. Add Employee\n"+"2. Choose Employee\n"+"3. Employee List\n"+"4. Exit Program");
	}

}
