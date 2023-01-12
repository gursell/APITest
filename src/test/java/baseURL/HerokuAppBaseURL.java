package baseURL;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import testData.TestDataHerokuApp;

import java.util.HashMap;

public class HerokuAppBaseURL {
    protected RequestSpecification specHerokuApp;
    @Before
    public void setUp(){
        specHerokuApp = new RequestSpecBuilder().
                setBaseUri("https://restful-booker.herokuapp.com").
                build();
    }






}