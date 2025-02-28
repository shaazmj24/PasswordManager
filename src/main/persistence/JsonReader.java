package persistence;

import org.json.JSONArray;
import org.json.JSONObject;

import model.PasswordManager;

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
        
    } 



}
