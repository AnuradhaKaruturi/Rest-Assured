package Tests;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DELETETest {
	
	@Test
	public void deleteUser_Test1() {
    
    given()
    	.header("Content-Type","application/json")
    	.contentType(ContentType.JSON)
    	.accept(ContentType.JSON)
    .when()
    	.delete("https://reqres.in/api/users/2")
    .then()
    	.statusCode(204)
    	.log()
    	.all();
	
}

}
