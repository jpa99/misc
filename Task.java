/**
 * Task
 * 
 * The Task class contains two attributes which comprise the task-its name and priority
 *
 * @author  Joel Abraham
 * @version 1.0
 * @since   2015-11-29
 */
public class Task{
	
	/**
	 * The name of the task
	 */ 
	private String name;
	
	/**
	 * The priority of the task
	 */ 
	private int priority;
	
	public Task(String name, int priority){
		this.name=name;
		this.priority=priority;
	}
	
	 /**
	  * The getName method returns the name of the task
	  * 
	  * @return The name of the task
	  */
	public String getName(){
		return name;
	}
	
	 /**
	  * The getPriority method returns the priority of the task
	  * 
	  * @return The priority of the task
	  */
	public int getPriority(){
		return priority;
	}
	
	 /**
	  * The toString method returns the task in a string format
	  * 
	  * @return The task name and priority in the form: name{priority}
	  */
	public String toString(){
		return name+"{"+priority+"}";
	}
}
