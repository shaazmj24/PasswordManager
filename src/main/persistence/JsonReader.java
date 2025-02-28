package persistence;

import org.json.JSONArray;
import org.json.JSONObject;

import model.PasswordManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// A reader that can read passwords from a file 
public class JsonReader {  
    private static final String DELIMITER = ",";    

    // EFFECT: returns a list of passwords from file; throws 
    // IOException if an exception is caught when opening or reading file 
    public static PasswordManager readPasswords(File file) throws IOException {  
        List<String> fileContent = readFile(file); 
        return parseContent(fileContent); 
    }

    //EFFECT: returns content of file as a list of strings, each string 
    // containing the content of one row of the file 
    private static List<String> readFile(File file) throws IOException {  
        
    }


}
