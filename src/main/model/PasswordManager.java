package model;

import java.util.HashMap;
import java.util.ArrayList;

// Manages a collection of passwords associated with 
// different accounts 
public class PasswordManager {  
 
    // EFFECT: Constructs a PasswordManager and initializes an empty 
    // hashmap to store passwords
    public PasswordManager() {  
    }

    // MODIFIES: this
    // EFFECT: Adds a new password and account 
    public void addPasswordAccount(Password password, String account) { 

    }

    // EFFECT: Returns the password object by the account name
    // if the account is not found, return "account not found" 
    public Password searchPassword(String account) {  
        return null; 
    }
 
    // MODIFIES: this  
    // EFFECT: Removes the password by the account name  
    public void deletePassword(String account) {  

    }

    // EFFECT: Returns a list of passwords 
    public ArrayList<String> listPasswords() { 
        return null; 
    }

    // Effect: Returns a list of accounts 
    public ArrayList<String> listAccounts() { 
        return null;
    }





}
