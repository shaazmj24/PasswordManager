package ui;

import model.Password;
import model.PasswordManager;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import persistence.*;

public class PasswordApp { 
    private Password password;
    private PasswordManager passwords;
    private static final String JSON_STORE = "./data/passwordstore.json"; 
    private JsonWriter jw; 

    // EFFECT: Initializes PasswordManager and Runs the application
    public PasswordApp() {   
        this.passwords = new PasswordManager();
        run();
    } 

    // EFFECT: Displays a menu of options and 
    // prompts the user to choose an action.
    private void run() {    
        Scanner input = new Scanner(System.in);  
        
        System.out.println("1. Store Password"); 
        System.out.println("2. Encrypt Password"); 
        System.out.println("3. Search Password"); 
        System.out.println("4. Delete Password"); 
        System.out.println("5. View Passwords"); 
        System.out.println("6. View Accounts"); 
        System.out.println("7. Save stored data to file"); 
        System.out.println("8. load data from file");
        System.out.println("9. quit");
        System.out.println("choose options"); 
        
        int optionChoosen = input.nextInt();  
        runOption(optionChoosen); 
    }

    // EFFECT: Executes the corresponding method based 
    // on the user's chosen option.
    private void runOption(int option) {  
        try {  
            if (option == 1) {
                one();
            } else if (option == 2) {
                two();
            } else if (option == 3) {
                three();
            } else if (option == 4) {
                four();
            } else if (option == 5) {
                five();
            } else if (option == 6) { 
                six();
            } else if (option == 7) { 
                seven(); 
            } else if (option == 8) { 
                eight(); 
            } else if (option == 9) { 
                System.exit(0); 
            } else { 
                throw new Exception();
            } 
        } catch (Exception e) {  
            System.out.println("Enter appropriate number"); 
        } 
        ok();
    }

    // EFFECT: Prompts the user to type "ok" to 
    // return to the main menu.
    private void ok() {  
        Scanner input = new Scanner(System.in);   
        System.out.println("Type ok to go back"); 
        String us = input.nextLine(); 
        if (us.equals("ok")) { 
            run(); 
        } 
    } 

    // EFFECT: Displays a prompt to enter an 
    // account or cancel
    private void enterAccountCancel() {   
        System.out.println("Enter Account: "); 
        System.out.println("    Cancel    ");
    }

    // MODIFIES: this
    // EFFECT: Stores a new password for a given account
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
                ok(); 
            } 
        } 
    }  

    // MODIFIES: this
    // EFFECT: Encrypts the password for a specified account
    private void two() {    
        Scanner input = new Scanner(System.in); 
        enterAccountCancel(); 
        String userS = input.nextLine().trim(); 
        if (userS.equals("cancel")) { 
            run(); 
        } else { 
            Password passToE = passwords.searchPassword(userS); 
            if (passToE == null) {  
                System.out.println("account not found");  
                ok(); 
            } else {  
                passToE.encrypt(); 
                System.out.println("Succusfully encrypted"); 
                ok(); 
            } 
        } 
    }

    // EFFECT: Searches for and displays a password for a given account, 
    // with an option to decrypt if encrypted
    private void three() {  
        Scanner input = new Scanner(System.in); 
        enterAccountCancel(); 
        String us = input.nextLine().trim(); 
        if (us.equals("cancel")) { 
            run(); 
        } else { 
            Password pass = passwords.searchPassword(us); 
            if (pass == null) { 
                System.out.println("account not found"); 
                ok(); 
            } else {  
                displayDecrypt(pass); 
            } 
        }  
    }

    // EFFECT: display decrypt option if pass is encrypted 
    private void displayDecrypt(Password pass) {  
        if (!pass.getIsEncrypted()) { 
            System.out.println(pass.getPassword()); 
            ok(); 
        } else { 
            Scanner input1 = new Scanner(System.in);  
            System.out.println("Do you want to decrypt your encrypted password? Yes or No"); 
            String userAnswer = input1.nextLine().trim().toLowerCase(); 
            if (userAnswer.equals("yes")) {  
                pass.decrypt(); 
                System.out.println(pass.getPassword()); 
                pass.encrypt(); 
                ok(); 
            } else { 
                System.out.println(pass.getPassword()); 
                ok(); 
            }   
        } 
    }


    // MODIFIES: this
    // EFFECT: Delete the password for a specified account
    private void four() {  
        Scanner input = new Scanner(System.in);  
        enterAccountCancel(); 
        String userAcc = input.nextLine().trim(); 
        if (userAcc.equals("cancel")) { 
            run(); 
        } else { 
            System.out.println(passwords.deletePassword(userAcc));  
            ok(); 
        } 
    }
 
    // EFFECT: prints a list of all stored passwords 
    private void five() {  
        ArrayList<String> viewPass = new ArrayList<>(); 
        if (passwords.listPasswords().isEmpty()) { 
            System.out.println("Empty");  
            ok(); 
        } else { 
            for (Password pass : passwords.listPasswords()) {  
                viewPass.add(pass.getPassword()); 
            }  
            System.out.println(viewPass);  
            ok(); 
        }  
    }

    // EFFECT: prints a list of all stored accounts 
    private void six() {  
        ArrayList<String> listA = passwords.listAccounts(); 
        if (listA.isEmpty()) {  
            System.out.println("Empty");  
            ok(); 
        } else {  
            System.out.println(listA); 
            ok(); 
        } 
    } 

    // MODIFIES: this
    // EFFECT: saves the data to file 
    private void seven() {     
        try {   
            jw = new JsonWriter(new File(JSON_STORE)); 
            jw.write(passwords);
            jw.close(); 
            System.out.println("Saved Passwords to" + JSON_STORE);
        } catch (FileNotFoundException e) { 
            System.out.println("not found");
        }
        ok(); 
    } 

    // EFFECT: loads data from file
    private void eight() {  
        try { 
            passwords = JsonReader.readPasswords(new File(JSON_STORE));  
            System.out.println("Loaded data from" + JSON_STORE);
        } catch (IOException e) { 
            System.out.println("Unable to read from file:" + JSON_STORE);
        }
        ok(); 
    }  


}
