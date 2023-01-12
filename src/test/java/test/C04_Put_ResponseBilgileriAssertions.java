package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C04_Put_ResponseBilgileriAssertions {

/*
        https://jsonplaceholder.typicode.com/posts/70 url’ine asagidaki
        Json formatindaki body ile bir PUT request gonderdigimizde
                {
                "title":"Cemile",
                "body":"Barak",
                "userId":3,
                "id":1
                }
        donen Response’un,
            status code’unun 200,
            ve content type’inin application/json; charset=utf-8,
            ve Server isimli Header’in degerinin cloudflare,
            ve status Line’in HTTP/1.1 200 OK
                 */


    @Test
    public void put01(){
        // 1- Request için URL ve Body hazırla (bu soruda body testi yok)
        String url = "https://jsonplaceholder.typicode.com/posts/70";

        //BODY:
        JSONObject reqBody = new JSONObject();

        reqBody.put("title","Cemile");
        reqBody.put("body","Bardak");
        reqBody.put("userId", 3);
        reqBody.put("id", 1);

        System.out.println(reqBody);

        // 2- Expected Datayi hazırla


        // 3- Reponse'u kaydet
        Response response = given().
                                    contentType(ContentType.JSON).
                            when().
                                    body(reqBody.toString()).
                                    put(url);
        response.prettyPrint();

        // 4- Assertion
        response.
                then().
                assertThat().
                statusCode(200).
                contentType("application/json; charset=utf-8").
                header("Server", "cloudflare").
                statusLine("HTTP/1.1 200 OK");

    }
}
