import java.util.ArrayList;
import java.util.Scanner;

class addtask{
    private static String tasknumber;private static String task;
    public static void addtask(Scanner A, ArrayList<String>tasks)
    {
                 boolean done = false;
                while(done == false)
                {
                    System.out.println("enter the number or the name of the task you wants to add");
                    tasknumber = A.nextLine();
                    if(!tasknumber.equals("") && !tasknumber.equals(" "))
                    {
                        System.out.println("add the task you wants to add to the list");
                        task = A.nextLine();
                        if(!task.equals("") && !task.equals(" "))
                        {
                            tasks.add("'Task-number'"+tasknumber + " :- "+"'task'" + task);
                            System.out.println("Task successfully added to the list......");
                            done= true;
                        }else{
                            System.out.println(" Task cant be empty or blank\n please try again");
                            }
                    }else{System.out.println(" Task number cant be empty or blank\n please try again");}
                }

    }
}

class removingtask {
    private static String taskneedstoberemoved;
    public static void removingtask(Scanner A , ArrayList<String>tasks)
    {
        if (tasks.isEmpty()) 
                    {
                        System.out.println("No tasks found....");
                        System.out.println("Choose option (1) to add tasks");
                    }
                    else 
                    {
                        boolean found = false;
                    while (found == false) 
                    {

                        System.out.println("Enter the number or name of the task you want to remove ");
                        taskneedstoberemoved = A.nextLine();
                        if(!taskneedstoberemoved.equals("") && !taskneedstoberemoved.equals(" "))
                        {
                            
                            for(int i = 0; i < tasks.size(); i++)
                            {
                                if(tasks.get(i).startsWith("'Task-number'"+taskneedstoberemoved + " :- "))
                                {
                                    tasks.remove(i);
                                    System.out.println("Task removed successfully.....");
                                    found = true;
                                    break;
                                }else if(found == false){
                                System.out.println("Task with number or name " + taskneedstoberemoved+ " not found\nTry again");}
                            }
                            
                        }else{System.out.println("Task number cant be empty or blank\n please try again");}
                    }

                    }
    }
}

public class ToDoList {

    
    
    
    public static void main(String[] args)
    {
        String opt = "";
        Scanner A = new Scanner(System.in);
        ArrayList<String>tasks = new ArrayList<>();
       while (true) {
        
       
        System.out.println("---------------------welcome---------------------");
        System.out.println("Choose an option: ");
        System.out.println("1. Add task");
        System.out.println("2. View tasks");
        System.out.println("3. Remove task");
        System.out.println("4. Exit");
        System.out.println("-------------------------------------------------");

        opt = A.nextLine().trim().toLowerCase();
             if(opt.equals("1" )|| opt.equals("2")|| opt.equals("3")|| opt.equals("4"))
             {
                if(opt.equals("4"))
                {System.out.println("Exit--------->");break;}

                if(opt.equals("1"))
                {
                   addtask.addtask(A, tasks);   
                }
                    
                else if(opt.equals("2"))
                {
                    for(int i=0; i<tasks.size(); i++)
                    {System.out.println("Tasks---->");
                        System.out.println((i+1)+ ". "+ tasks.get(i));}
                }
               
                else if(opt.equals("3"))
                {
                    removingtask.removingtask(A, tasks);
                }

            }
    }
    
    }
}

