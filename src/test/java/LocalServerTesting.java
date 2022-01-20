import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class LocalServerTesting {

    //@Test
    public void test_get(){

        baseURI = "http://localhost:3000/";
        given().
                param("name", "Automation").
                get("/subjects").
        then().
                statusCode(200).
                log().all();

    }

    @Test
    public void test_post() {
        JSONObject request = new JSONObject();
        request.put("firstName", "Tom");
        request.put("lastName", "Cooper");
        baseURI = "http://localhost:3000/";

        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                header("Content-Type", "application/json").
                body(request.toJSONString()).
                post("/users2").
        then().
                statusCode(201).
                log().all();
    }
}
