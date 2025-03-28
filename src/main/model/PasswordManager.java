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
        // Add event 
        EventLog.getInstance().logEvent(new Event("Password added for: " + account));
    }

    // EFFECT: Returns the password object by the account name
    // if the account is not found, then "account not found" 
    // in main class
    public Password searchPassword(String account) { 
        if (passwords.containsKey(account)) { 
            // Add event  
            EventLog.getInstance().logEvent(new Event("Password searched for: " + account));
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
            // Add event  
            EventLog.getInstance().logEvent(new Event("Password deleted for: " + account));
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
        JSONObject json = new JSONObject();  
        JSONArray jarray = new JSONArray();

        for (Password pass : passwords.values()) {  
            jarray.put(pass.toJson()); 
        }
        json.put("Passwords", jarray);
        return json;
    }

    //EFFECT: set hashmap to passwords
    public void setMap(HashMap<String, Password> loaded) {   
        this.passwords = loaded; 
    }

    //EFFECT: get hashmap 
    public HashMap<String, Password> getHashMap() { 
        return passwords; 
    }

}
