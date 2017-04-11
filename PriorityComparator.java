import java.util.Comparator;

public class PriorityComparator implements Comparator<Task>{
    public int compare(Task x, Task y){
        return x.getPriority()-y.getPriority();
    }
}


/*

public class Task{
	
	private String name;
	private int priority;
	
	public Task(String name, int priority){
		this.name=name;
		this.priority=priority;
	}
	
	public String getName(){
		return name;
	}
	
	public int getPriority(){
		return priority;
	}
	
	public String toString(){
		return name+"{"+priority+"}";
	}
}

import java.util.*;


public class Employee {
	
	private String name;
	private Stack<Task> completed=new Stack<Task>();
	Comparator<Task> comparator=new PriorityComparator();
	private PriorityQueue<Task> tasks=new PriorityQueue<Task>(comparator);
	

	public Employee(String name){
		this.name=name;
	}
	
	public String getName(){
		return name;
	}
	
	public void addTask(Task t){
		tasks.add(t);
	}
	
	public Task getNextTask(){
		return tasks.peek();
	}
	
	public void completeTask(){
		completed.push(tasks.poll());
	}
	
	public Task lastCompleted(){
		return completed.peek();
	}
	
	public void returnTask(){
		tasks.add(completed.pop());
	}
	
	public String info(){
		return "\nEmployee Name: "+name+"\nTasks to Complete: "+tasks.toString()+"\nCompleted Tasks: "+completed.toString();
	}
	
}
*/