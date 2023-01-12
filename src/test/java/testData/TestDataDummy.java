package testData;
import jdk.security.jarsigner.JarSigner;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Objects;

public class TestDataDummy {


    public int statusCode = 200;
    public String contentDummyType = "application/json";

    public JSONObject innerDataJsonBodyOlustur (){

        JSONObject innerDataBodyJSON = new JSONObject();

        innerDataBodyJSON.put("id", 3);
        innerDataBodyJSON.put("employee_name","Ashton Cox");
        innerDataBodyJSON.put("employee_salary",86000);
        innerDataBodyJSON.put("employee_age", 66);
        innerDataBodyJSON.put("profile_image", "");

        return innerDataBodyJSON;
    }


    public JSONObject expectedDataBodyOlustur (){

        JSONObject expecDataJSON = new JSONObject();

        expecDataJSON.put("status", "success");
        expecDataJSON.put("data", innerDataJsonBodyOlustur());
        expecDataJSON.put("message","Successfully! Record has been fetched.");

        return expecDataJSON;
    }

    public HashMap expectedDataOlusturMap(){
        /*
        {
"status":"success",
"data":{
        "id":3,
        "employee_name":"Ashton Cox",
        "employee_salary":86000,
        "employee_age":66,
        "profile_image":""
        },
"message":"Successfully! Record has been fetched."
}
         */

        HashMap<String, Object> innerMap =new HashMap<>();
        HashMap<String, Object> expMap =new HashMap<>();

        innerMap.put("id", 3.0);
        innerMap.put("employee_name","Ashton Cox");
        innerMap.put("employee_salary",86000.0);
        innerMap.put("employee_age",66.0);
        innerMap.put("profile_image","");

        expMap.put("status","success");
        expMap.put("message","Successfully! Record has been fetched.");
        expMap.put("data", innerMap);

        return expMap;

    }

}