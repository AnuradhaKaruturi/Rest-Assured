package Tests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class EmployeeTest {
	
	@Test
	public void getEmp() {
		
		given()
		.header("Content-Type" ,"Application/json")
		.baseUri("https://restapi.demoqa.com/utilities/weather/city")
		.when()
		.get("/Hyderabad")
		.then()
		.assertThat().statusCode(200);
		
		
		
		
	}

}
