package Tests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class logFailedTC {
	
	@Test
    public void testIfValidationFails() {
        given().
        baseUri("https://reqres.in").
        log().ifValidationFails().
        when().
        get("/api/users?page=2").
        then().
        log().ifValidationFails().
        assertThat().
        statusCode(200);
    }
	
	

	@Test
    public void testIfValidationFails_02() {
        given().
        baseUri("https://reqres.in").
        log().ifValidationFails().
        when().
        get("/api/users?page=2").
        then().
        log().ifValidationFails().
        assertThat().
        statusCode(201);
    }

}
