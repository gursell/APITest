package test;

import groovy.lang.DelegatesTo;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C01_Get_ApiSorgulama {
    /*
        https://restful-booker.herokuapp.com/booking/256884 url’ine bir GET request gonderdigimizde donen Response’un,
        status code’unun 200,
        ve content type’inin application/json; charset=utf-8,
        ve Server isimli Header’in degerinin Cowboy,
        ve status Line’in HTTP/1.1 200 OK
        ve response suresinin 5 sn’den kisa oldugunu manuel olarak test ediniz.
     */
    @Test
    public void get01(){
        // 1- Request için URL ve Body hazırla (bu soruda body testi yok)
        String url = "https://restful-booker.herokuapp.com/booking/256884";

        // 2- Expected Datayi hazırla (bu soruda bu yok)

        // 3- Reponse'u kaydet
        Response response = given().when().get(url);
        response.prettyPrint();

        System.out.println("Status Code : " + response.getStatusCode());
        System.out.println("Content Type : " + response.getContentType());
        System.out.println("Status Server Header Degeri : " + response.getHeader("Server"));
        System.out.println("Status Line : " + response.getStatusLine());
        System.out.println("Response suresi : " + response.getTime());

        // 4- Assertion

    }
}
