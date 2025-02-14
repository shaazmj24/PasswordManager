package ui;

import model.Password;
import model.PasswordManager;
import java.util.Scanner;
import java.util.ArrayList;

public class PasswordApp { 
    private Password password;
    private PasswordManager passwords;    

    // Initializes PasswordManager and Runs the application
    public PasswordApp() {   
        this.passwords = new PasswordManager();
        run();
    } 

    // Displays a menu of options and 
    // prompts the user to choose an action.
    private void run() {    
        Scanner input = new Scanner(System.in);


       System.out.println("1. Store Password");
       System.out.println("2. Encrypt Password");
       System.out.println("3. Search Password");
       System.out.println("4. Delete Password");
       System.out.println("5. View Passwords");
       System.out.println("6. View Accounts");
       System.out.println("choose options");


       int optionChoosen = input.nextInt(); 
       runOption(optionChoosen);
    }

    // Executes the corresponding method based 
    // on the user's chosen option.
    private void runOption(int option) {   
        if (option == 1) {
            one();
        }
        else if (option == 2) {
            two();
        }
        else if (option == 3) {
            three();
        }
        else if (option == 4) {
            four();
        }
        else if (option == 5) {
            five();
        } else {
            six();
        } 
    }

    // Prompts the user to type "ok" to 
    // return to the main menu.
    private void oK() {  
        Scanner input = new Scanner(System.in);  
       System.out.println("Type ok to go back");
       String uS = input.nextLine();
       if (uS.equals("ok")) {
           run();
       }
    } 

    // Displays a prompt to enter an 
    // account or cancel
    private void enterAccountCancel() {   
        System.out.println("Enter Account: "); 
        System.out.println("    Cancel    ");
    }

    // Stores a new password for a given account
    private void one() {    
        Scanner input = new Scanner(System.in); 
        enterAccountCancel(); 
        String userAccount = input.nextLine().trim(); 
        if (userAccount.equals("cancel")) { 
            run(); 
        } else { 
            Scanner input1 = new Scanner(System.in); 
            System.out.println("Enter Password: "); 
            System.out.println("   Cancel   "); 
            String userPassword = input1.nextLine().trim(); 
            if (userPassword.equals("cancel")) { 
                run(); 
            } else { 
                this.password = new Password(userPassword, userAccount); 
                passwords.addPasswordAccount(password, userAccount); 
                System.out.println("Successfully Stored"); 
                oK(); 
            } 
        } 
    }  

    // Encrypts the password for a specified account
    private void two() {  

    }







 



 




}
