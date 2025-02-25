package persistence;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.util.List;
import model.PasswordManager;

// Represents a writer that writes JSON representation of 
// passwormanager to file
public class JsonWriter {
    private PrintWriter writer; 

    // EFFECT: constructs a writer that will write data to file
    public JsonWriter(File file) throws FileNotFoundException {      
        writer = new PrintWriter(file);
    }   

    // MODIFIES: this 
    // EFFECTS: write the JSON representation of PasswordManager to 
    // the file 
    public void write(PasswordManager passwords) {    
        JSONObject jPass = passwords.toJson(); 
        writer.print(jPass.toString(4));
    }   

    // MODIFIES: this 
    // EFFECTS: closes writer 
    public void close() {  
        
    }


}
