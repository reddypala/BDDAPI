package pojo;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SerializeTest {
	
	@Test
	public void addApi() {
		
		AddPlace ap = new AddPlace();
		ap.setAccuracy(50);
		ap.setAddress("29, side layout, cohen 09");
		ap.setLanguage("French-IN");
		ap.setPhone_number("(+91) 983 893 3937");
		ap.setWebsite("http://google.com");
		ap.setName("Frontline house");
		List<String> myList = new ArrayList<String>();
		myList.add("shoe park");
		myList.add("shop");
		ap.setTypes(myList);
		Location loc = new Location();
		loc.setLat(-38.383494);
		loc.setLng(33.427362);
		
		
		ap.setLocation(loc);
		
		
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		Response response = given().queryParam("key", "qaclick123").body(ap)
		.when().post("/maps/api/place/add/json")
		.then().assertThat().statusCode(200).extract().response();
		
		String resp = response.asString();
		System.out.println(resp);
	}
}
