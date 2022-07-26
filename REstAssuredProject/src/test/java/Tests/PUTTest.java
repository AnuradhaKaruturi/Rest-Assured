package Tests;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PUTTest {
	
	@Test
	public void putUser_Test1() {
	JSONObject req = new JSONObject();
    req.put("name", "morpheus");
    req.put("job", "leader");
    
    given()
    	.header("Content-Type","application/json")
    	.contentType(ContentType.JSON)
    	.accept(ContentType.JSON)
    	.body(req.toJSONString())
    .when()
    	.put("https://reqres.in/api/users/2")
    .then()
    	.statusCode(200)
    	.log()
    	.all();
	
}

}
