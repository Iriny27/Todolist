import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
  

private ArrayList<Task> tasks;
  
  public ToDoList() {
    tasks = new ArrayList<Task>();
  }
  TaskManager taskManager = new TaskManager();
  public void addTask(String name, String description, String startDate, String dueDate, String status ) {
    Task task = new Task(name, description, startDate, dueDate, status);
    tasks.add(task);
    taskManager.addTask(name, description, startDate, dueDate, status);
  }
  
  public void removeTask(int TaskId) {
    tasks.remove(TaskId);
    taskManager.removeTask(TaskId);
  }
  
  public void editTask(int taskId, String name, String description, String startDate, String dueDate, String status) {
    Task task = tasks.get(taskId);
    task.setName(name);
    task.setDescription(description);
    task.setStartDate(startDate);
    task.setDueDate(dueDate);
    task.setStatus(status);
    taskManager.updateTask(taskId, name, description, startDate, dueDate, status);
   
  }
  
  public void printTasks() {
    if (tasks.isEmpty()) {
      System.out.println("No tasks.");
    } else {
    	for (int i=0; i< tasks.size();i++) {
    		System.out.println((i+1) + ". " + tasks.get(i));
    	}
      taskManager.getTasks();
     
    }
  }
  
  public static void main(String[] args) throws ParseException {
	    Scanner input = new Scanner(System.in);
	    ToDoList list = new ToDoList();
	    
	    while (true) {
	      System.out.println("Enter a command: (add/remove/edit/print/quit)");
	      String command = input.nextLine();
	      
	      if (command.equals("add")) {
	        System.out.println("Enter task name:");
	        String name = input.nextLine();
	        System.out.println("Enter task description:");
	        String description = input.nextLine();
	        System.out.println("Enter start date:");
	        String startDate = input.nextLine();
	      
	        System.out.println("Enter due date:");
	        String dueDate = input.nextLine();
	        
	        System.out.println("Enter task status: ");
	        String status = input.nextLine();
	        list.addTask( name, description, startDate, dueDate,status);
	      } else if (command.equals("remove")) {
	        System.out.println("Enter a task number to remove:");
	        int index = input.nextInt();
	        input.nextLine(); // consume the newline
	        list.removeTask(index-1);
	      } else if (command.equals("edit")) {
	        System.out.println("Enter a task number to edit:");
	        int index = input.nextInt();
	        input.nextLine(); // consume the newline
	        System.out.println("Enter new task name:");
	        String name = input.nextLine();
	        System.out.println("Enter new task description:");
	        String description = input.nextLine();
	        System.out.println("Enter new start date:");
	        String startDate = input.nextLine();
	        System.out.println("Enter new due date:");
	        String dueDate = input.nextLine();
	        System.out.println("Enter task status: ");
	        String status = input.nextLine();
	        list.editTask(index-1, name, description, startDate, dueDate,status);
	      } else if (command.equals("print")) {
	        list.printTasks();
	      } else if (command.equals("quit")) {
	        break;
	      } else {
	        System.out.println("Invalid command.");
	      }
	    }
	  }
}