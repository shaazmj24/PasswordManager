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

    }

}
