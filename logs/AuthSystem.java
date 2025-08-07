package logs;
import java.util.Scanner;
import java.io.*;

class Register {
    public static void register(Scanner A, File file) {
        String username = "";
        String password = "";

        do {
            System.out.println("Enter the user name: ");
            username = A.nextLine().trim();

            if (!username.equals("") && !username.equals(" ")) {
                System.out.println("Enter the password: ");
                password = A.nextLine().trim();

                try  (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));BufferedReader reader = new BufferedReader(new FileReader(file))){

                    boolean exists = false;
                    String line;
                    while ((line = reader.readLine()) != null) {
                        String[] parts = line.split(",");
                        if (parts.length > 0 && parts[0].equals(username)) {
                            exists = true;
                            break;
                        }
                    }

                    if (!exists) {
                        writer.write(username + "," + password);
                        writer.newLine();
                        System.out.println("Registered successfully!");
                    } else {
                        System.out.println("Username already exists. Try a different username.");
                    }



                } catch (IOException e) {
                    System.out.println("Error writing to file.");
                }

            } else {
                System.out.println("Try again");
            }
        } while (username.equals(""));
    }
}

class Login {
             
    public static void login(Scanner A ,File file)  {
             String username = "";
             String password = "";
                   do{System.out.println("Enter the user name: ");
                 username = A.nextLine().trim();
                
                 if (!username.equals("") && !username.equals(" ")) {
                    System.out.println("enter the password: ");
                    password = A.nextLine().trim();

                    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                        boolean found = false;
                        String line;
                        while ((line = reader.readLine()) != null) {
                            String[] parts = line.split(",");
                            if (parts.length > 1 && parts[0].equals(username) && parts[1].equals(password)) {
                                found = true;
                                break;
                            }
                        }
                        if (found) {
                            System.out.println("Login successful!");
                            System.out.println("welcome " + username + "!");
                        } else {
                            System.out.println("Invalid username or password.");
                        }
                    } catch (IOException e) {
                        System.out.println("Error reading the file");
                    }
                 }else{System.out.println("Try again");

                    }
                }while(username.equals(""));}

    
}

public class AuthSystem {
    

    public static void main(String [] args)
    {
          String opt = "";
        Scanner A = new Scanner(System.in);

        File file = new File("C:\\Users\\anilm\\OneDrive\\.vscode\\LoginAndRegisterSystem\\user.txt");

        System.out.println("wlcome");System.out.println("press enter to continue");

        String ent = A.nextLine().trim();
        if(ent.equals(""))
        {
         


        while(true){
            System.out.println("-----------------------------------");
            System.out.print("Choose an option: ");
            System.out.println("1. Login \n                  2. Register \n                  3. Exit");
            System.out.println("-----------------------------------");

             opt = A.nextLine().trim().toLowerCase();
             if(opt.equals("1" )|| opt.equals("2")|| opt.equals("3"))
             {
                if(opt.equals("3"))
                {System.out.println("Exiting---->");break;}

                if(opt.equals("2"))
                 {
                       Register.register(A, file );}


                else if(opt.equals("1"))
                {
                    Login.login(A, file);
                }


             }else{System.out.println("option not available...");
              System.out.println("Try again with option 1,2 or 3");}}
             }else{return;}
    }
}