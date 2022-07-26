package Tests;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import org.json.simple.JSONObject;
import org.testng.Assert;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.LinkedHashMap;
import java.util.Map;

public class POSTTest {
	
	
	@Test
	public void postUser_Test1() {
		/*
		Map<String, Object> map = new LinkedHashMap<>();
		 
		map.put("id", "16");
		map.put("email", "Peter@gmail.com");
		map.put("first_name", "Peter");
		map.put("last_name", "John");
		System.out.println(map);
		
		JSONObject obj = new JSONObject(map);
		System.out.println(obj.toJSONString());
		
		//or
		  JSONObject obj = new JSONObject();
		    obj.put("id", "16");
		    obj.put("email", "pet@gmail.com");
		*/
	
		JSONObject req = new JSONObject();
	    req.put("name", "morpheus");
	    req.put("job", "leader");
	    
	    given()
	    	.header("Content-Type","application/json")
	    	.contentType(ContentType.JSON)
	    	.accept(ContentType.JSON)
	    	.body(req.toJSONString())
	    .when()
	    	.post("https://reqres.in/api/users")
	    .then()
	    	.statusCode(201);
		
}
	
	/*
	@Test
	public void httpPostMethod() throws JSONException, InterruptedException {
	    //Rest API's URL
	    String restAPIUrl = "http://{URL of API}";
	    //API Body
	    String apiBody = "{\"key1\":\"value1\",\"key2\":\"value2\",\"key3\":\"value3\"}";
	    // Building request by using requestSpecBuilder
	    RequestSpecBuilder builder = new RequestSpecBuilder();
	    //Set API's Body
	    builder.setBody(apiBody);
	    //Setting content type as application/json
	    builder.setContentType("application/json; charset=UTF-8");
	    RequestSpecification requestSpec = builder.build();
	    //Making post request with authentication or leave blank if you don't have credentials like: basic("","")
	    Response response = given()
	        .auth()
	        .preemptive()
	        .basic({ username }, { password })
	        .spec(requestSpec)
	        .when()
	        .post(restAPIUrl);
	    
	    JSONObject JSONResponseBody = new JSONObject(response.body().asString());
	    //Get the desired value of a parameter
	    String result = JSONResponseBody.getString({ key });
	    //Check the Result
	    Assert.assertEquals(result, "{expectedValue}");
	}
	*/
}
