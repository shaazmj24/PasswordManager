package persistence;

import org.json.JSONArray;
import org.json.JSONObject;

import model.PasswordManager;
import model.Password;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// A reader that can read passwords from a file 
public class JsonReader {  
    private static final String DELIMITER = ",";    

    // EFFECT: returns a PasswordManager from file; throws 
    // IOException if an exception is caught when opening or reading file 
    public static PasswordManager readPasswords(File file) throws IOException {   
        // Read the content as a single string 
        String fileContent = readFile(file); 
         
        // Organise fileContent by converting it to JsonObject
        JSONObject fileObject = new JSONObject(fileContent); 

        // Convert JSONObject into a passwordmanager object 
        return parsePasswordManager(fileObject); 
    }

    // EFFECT: read the file content as a single string  
    private static String readFile(File file) throws IOException {      
        return new String(Files.readAllBytes(file.toPath()));
    }  

    //EFFECT: parse a PasswordManager from a JSONOBject 
    private static PasswordManager parsePasswordManager(JSONObject filePass) {   
        // create PassowrdManager to store password 
        PasswordManager passwords = new PasswordManager(); 
        // get the "passwords" array from JSONOBJECT 
        JSONArray passwordsArray = filePass.getJSONArray("Passwords"); 

        // loop each JSONOBJECT in the array 
        for (Object obj : passwordsArray) { 
            JSONObject passwordJson = (JSONObject) obj;
            String account = passwordJson.getString("Account");
            String password = passwordJson.getString("Password"); 
            Boolean IsEncrypted = passwordJson.getBoolean("IsEncrypted"); 

            // create password object and then add it to password manager 
            Password pass = new Password(password, account);  
            if (IsEncrypted) { 
                pass.encrypt();
            }
            passwords.addPasswordAccount(pass, account); 
        } 
        return passwords;
    }


}
