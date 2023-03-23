package restAssuredTests;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class GetRequestDemo {
	@Test
	public void getUserDetails() {
		
		given()
		.when().get("https://reqres.in/api/users/2")
		.then().log().all().statusCode(200).statusLine("HTTP/1.1 200 OK")
		.assertThat()
		.body(containsString("first_name"), containsString("Janet"))
		.body("data.last_name", equalTo("Weaver"))
		.header("Content-Type", "application/json; charset=utf-8");
	}
	
	
}
