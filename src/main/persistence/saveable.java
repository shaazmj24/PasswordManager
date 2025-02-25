package persistence; 

import org.json.JSONObject;

public interface saveable {  
    //EFFECT: returns this as JSON object
    JSONObject toJson();
}
