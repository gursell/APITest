package test;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C7_Get_BodyTekrarlardanKurtulma {
    /*
                https://restful-booker.herokuapp.com/booking/133 url’ine
                bir GET request gonderdigimizde donen Response’un,
                status code’unun 200,
                ve content type’inin application-json,
                ve response body’sindeki
                    "firstname“in,"Josh",
                    ve "lastname“in, "Allen",
                    ve "totalprice“in,111,
                    ve "depositpaid“in,true,
                    ve "additionalneeds": "super bowls"
}
         */

    @Test
    public void get01(){
        // 1- Request için URL ve Body hazırla (bu soruda body testi yok)
        String url = "https://restful-booker.herokuapp.com/booking/1590";


        // 2- Expected Datayi hazırla

        // 3- Reponse'u kaydet

        Response response = given().when().get(url);
        response.prettyPrint();

        // 4- Assertion
        //Bu kısım asıl yöntem. aşağıda kısaltma var
        /*response.
                then().
                assertThat().
                statusCode(200).
                contentType("application/json").
                body("firstname", Matchers.equalTo("Augustin")).
                body("lastname", Matchers.equalTo("Sevilla")).
                body("totalprice", Matchers.equalTo(111)).
                body("depositpaid", Matchers.equalTo(true)).
                body("additionalneeds", Matchers.equalTo("Breakfast"));

        */
    //Matchers dan equal methodunu kullandik, en kisa method bu.
        response.
                then().
                assertThat().
                statusCode(200).
                contentType("application/json").
                body("firstname", equalTo("Josh"),
                "lastname", equalTo("Allen"),
                "totalprice", equalTo(111),
                "depositpaid", equalTo(true),
                "additionalneeds", containsString("super bowls"));



    }

}
