import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import io.restassured.*;


public class BasicApiTest {

    @Test
    void test01Get(){

        Response response  = RestAssured.get("https://reqres.in/api/users?page=2");


        System.out.println(response.asString());
        System.out.println(response.getBody().asString());
        System.out.println(response.getHeader("content-type"));
        System.out.println(response.getTime());

        int statusCode = response.getStatusCode();
        assertEquals(statusCode, 200);

    }

    @Test
    void test02(){
        given().get("https://reqres.in/api/users?page=").then().statusCode(200);
    }
}
