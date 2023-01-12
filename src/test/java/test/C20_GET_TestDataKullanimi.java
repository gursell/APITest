package test;



import baseURL.DummyBaseURL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import testData.TestDataDummy;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C20_GET_TestDataKullanimi extends DummyBaseURL {

    /*
        http://dummy.restapiexample.com/api/v1/employee/3 url'ine bir GET request
        gonderdigimizde donen response'un status code'unun 200,
        content Type'inin "application/json" ve body'sinin asagidaki gibi oldugunu test edin.

        Response Body
        {
        "status":"success",
        "data": {
                "id": 3,
                "employee_name":"Ashton Cox",
                "employee_salary":86000,
                "employee_age":66,
                "profile_image":""
                },
        "message":"Successfully! Record has been fetched."
        }

     */

    @Test
    public void get02() {

        // 1 - Request URL ve Body hazirla (GET methodu icin Body'e ihtiyacimiz yok)
        specDummy.pathParams("pp1", "employee", "pp2", 3);


        // 2 - Expected Datayi Hazirla
        TestDataDummy testDataDummy = new TestDataDummy();

        JSONObject expecData = testDataDummy.expectedDataBodyOlustur();


        // 3 - Response kaydet
        Response response = given().spec(specDummy)
                .when().get("/{pp1}/{pp2}");

        response.prettyPrint();


        // 4 - Assertion
        JsonPath jsonPath = response.jsonPath();

        assertEquals(testDataDummy.statusCode, response.getStatusCode());
        assertEquals(testDataDummy.contentDummyType, response.contentType());

        assertEquals(expecData.get("status"),jsonPath.get("status"));
        assertEquals(expecData.get("message"),jsonPath.get("message"));
        assertEquals(expecData.getJSONObject("data").get("employee_name"),  jsonPath.get("data.employee_name"));
        assertEquals(expecData.getJSONObject("data").get("employee_salary"), jsonPath.get("data.employee_salary"));
        assertEquals(expecData.getJSONObject("data").get("employee_age"), jsonPath.get("data.employee_age"));
        assertEquals(expecData.getJSONObject("data").get("profile_image"), jsonPath.get("data.profile_image"));


    }


}