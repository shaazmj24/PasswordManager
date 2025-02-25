package persistence; 

import org.json.JSONObject;

public interface Saveable {  
    //EFFECT: returns this as JSON object
    JSONObject toJson();
}
