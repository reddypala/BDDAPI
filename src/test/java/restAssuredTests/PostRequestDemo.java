package restAssuredTests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

import java.util.HashMap;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class PostRequestDemo {
	
	public static HashMap<String, String> map = new HashMap<String, String>();
	
	@BeforeTest
	public void postData() {
		map.put("username", "admin");
		map.put("password","password123");
		
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		RestAssured.basePath = "/auth";
	}
	
	@Test
	public void postRequest() {
		given().contentType("application/json").
		body(map)
			.when().post()
		.then()
			.log().all()
			.statusCode(200).and().statusLine("HTTP/1.1 200 OK")
			.assertThat().body(containsString("token"));

	}

}
