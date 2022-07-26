package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.response.Validatable;
import io.restassured.response.ValidatableResponse;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;
import java.util.Map;

public class GETTest01 {
	
	@Test
	public void getUser_Test1() {
		Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		String res = response.asString();
		System.out.println(res);
		
		int resCode = response.getStatusCode();
		Assert.assertEquals(resCode, 200);
		
	
	}
	
	@Test
	public void getAllUsers() {
		Response allresponse = RestAssured.get("https://reqres.in/api/users?page=2");
	JsonPath jsonPathObj = allresponse.jsonPath();

	//get a list of all employees id:
	List<String> employeeIds = jsonPathObj.get("data.id");
	System.out.println(employeeIds);

	//get the first employee name:
	String empfirstName = jsonPathObj.get("data[0].first_name");
	System.out.println(empfirstName);
	
	int totalcount = jsonPathObj.get("total");
	System.out.println("total elements count :"+totalcount);
	
	}

	@Test
	public void getUser_Test2() {
		
		given()
			.get("https://reqres.in/api/users?page=2")
			.then()
			.statusCode(200)
			.log()
			.all()
			.body("data.id[0]", equalTo(7));
	
	}
	
	@Test
	public void getUser_TestBlacklistHeaders() {
		
		    given()
		    .config(config.logConfig(LogConfig.logConfig().blacklistHeader("Accept","set-cookie")))
		    .log()
		    .headers()
		    .when()
			.get("https://reqres.in/api/users?page=2")
			.then()
			.statusCode(200)
			.log()
			.headers();
	}
	
	
	@Test
	public void getUser_Test4() {
		
		given()
		     .header("Content-Type","application/json")
			.get("https://reqres.in/api/users?page=2")
			.then().assertThat()
			.statusCode(200)
			.body("data.first_name", hasItem("Michael"));
	
	}
	@Test
	public void getUser_Test5() {
		
		given()
			.get("https://reqres.in/api/users?page=2")
			.then()
			.statusCode(200)
			.body("data.first_name", hasItems("Michael","George","Byron"));
	
	}
	
	@Test
	public void getUser_invalidTest1() {
		
		given()
			.get("https://reqres.in/api/users?page=2")
			.then()
			.statusCode(200)
			.body("data.id[0]", equalTo(4));
	
	}
	@Test
	public void getUser_invalidTest2() {
		
		given()
			.get("https://reqres.in/api/users?page=2")
			.then()
			.statusCode(200)
			.body("data.first_name", hasItems("Michael","George","Rache"));
	
	}
}
