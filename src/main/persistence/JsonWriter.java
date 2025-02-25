package persistence;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.util.List;

// Represents a writer that writes JSON representation of 
// passwormanager to file
public class JsonWriter {
    private PrintWriter writer; 

    // EFFECT: constructs a writer that will write data to file
    public JsonWriter(File file) throws FileNotFoundException {      
        writer = new PrintWriter(file);
    }

    



    
}
