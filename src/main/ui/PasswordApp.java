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





}
