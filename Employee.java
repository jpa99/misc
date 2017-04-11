import java.util.*;
/**
 * Employee
 * 
 * The Employee class contains a queue of Task objects which are to be completed, ordered by priority, and a stack of Task objects which have been completed
 *
 * @author  Joel Abraham
 * @version 1.0
 * @since   2015-11-29
 */
public class Employee {
	
	/**
	 * The name of the employee
	 */ 
	private String name;
	/**
	 * A stack of completed items of object Task
	 */ 
	private Stack<Task> completed=new Stack<Task>();
	
	Comparator<Task> comparator=new PriorityComparator();
	/**
	 * A priority queue of object Task which uses an overridden version of the Comparator interface to evaluate the respective priority of two Tasks
	 */ 
	private PriorityQueue<Task> tasks=new PriorityQueue<Task>(comparator);
	

	public Employee(String name){
		this.name=name;
	}
	
	 /**
	  * The getName method returns the name of the employee
	  * 
	  * @return The name of the employee
	  */
	public String getName(){
		return name;
	}
	
	/**
	 * The addTask method adds a Task object to the queue of tasks
	 * 
	 * @param the Task object to be added
	 */
	public void addTask(Task t){
		tasks.add(t);
	}
	
	/**
	 * The getNextTask method returns the Task object at the head of the queue of tasks
	 * 
	 * @return the Task object at the head of hte queue of tasks
	 */
	public Task getNextTask(){
		return tasks.peek();
	}
	
	/**
	 * The completeTask method adds the Task at the head of the queue of tasks to the stack of completed tasks
	 */
	public void completeTask(){
		completed.push(tasks.poll());
	}
	
	/**
	 * The lastCompleted method returns the Task object which was last completed
	 * 
	 * @return the Task object completed last
	 */
	public Task lastCompleted(){
		return completed.peek();
	}
	
	/**
	 * The returnTask method moves the Task at the top of the stack of completed Tasks to the queue of tasks
	 */
	public void returnTask(){
		tasks.add(completed.pop());
	}
	
	/**
	 * The info method returns the employee's information
	 * 
	 * @return a String detailing the employee's name, the queue of tasks to complete, and the stack of tasks they completed
	 */
	public String info(){
		return "\nEmployee Name: "+name+"\nTasks to Complete: "+tasks.toString()+"\nCompleted Tasks: "+completed.toString();
	}
	
}


