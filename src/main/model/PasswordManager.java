package model;

import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;

import persistence.Saveable;

import java.util.ArrayList;

// Manages a collection of passwords associated with 
// different accounts 
public class PasswordManager implements Saveable {  
    private HashMap<String, Password> passwords;
 
    // EFFECT: Constructs a PasswordManager and initializes an empty 
    // hashmap to store passwords
    public PasswordManager() {  
        passwords = new HashMap<>();
    }

    // MODIFIES: this
    // EFFECT: Adds a new password and account 
    public void addPasswordAccount(Password password, String account) {   
        passwords.put(account, password);
    }

    // EFFECT: Returns the password object by the account name
    // if the account is not found, then "account not found" 
    // in main class
    public Password searchPassword(String account) { 
        if (passwords.containsKey(account)) { 
            return passwords.get(account);
        } else { 
            return null;
        }
    }
 
    // MODIFIES: this  
    // EFFECT: Removes the password by the account name otherwise 
    // "account not found"
    public String deletePassword(String account) {  
        if (passwords.containsKey(account)) { 
            passwords.remove(account);
            return "Password deleted successfully";
        } else { 
            return "account not found";
        }
    }

    // EFFECT: Returns a list of passwords 
    public ArrayList<Password> listPasswords() { 
        ArrayList<Password> listP = new ArrayList<>();
        for (Password pass : passwords.values()) {
            listP.add(pass);
        }
        return listP; 
    }

    // Effect: Returns a list of accounts 
    public ArrayList<String> listAccounts() { 
        ArrayList<String> listA = new ArrayList<>();
        for (String acc : passwords.keySet()) { 
            listA.add(acc);
        }
        return listA;
    }  

    //EFFECT: return this PasswordManager as a JSON object
    @Override 
    public JSONObject toJson() { 
    }

}
