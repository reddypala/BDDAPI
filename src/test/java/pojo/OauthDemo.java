package pojo;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class OauthDemo {

	@Test
	public void oauthTest() {
		

		String url1 = "https://rahulshettyacademy.com/getCourse.php?code=4%2F0AX4XfWjTIX79iUTXb7jHnq5S1iR_sFLXSvxJtJ8HIUzWMaaGVPU8jZlIVDtq8z8D8F3cFA&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&prompt=none";
		String partialCode = url1.split("code=")[1];
		String code = partialCode.split("&scope")[0];
		System.out.println(code);

		String accessTokenResponse = given().urlEncodingEnabled(false).queryParam("code", code)
				.queryParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
				.queryParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
				.queryParam("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
				.queryParam("grant_type", "authorization_code").when().log().all()
				.post("https://www.googleapis.com/oauth2/v4/token").asString();

		JsonPath js = new JsonPath(accessTokenResponse);
		String accessToken = js.getString("access_token");
		
		
		CoursePojo gc =given().queryParam("access_token", accessToken).expect().defaultParser(Parser.JSON)
				.when()
				.get("https://rahulshettyacademy.com/getCourse.php").as(CoursePojo.class);
		//CoursePojo gc = response.as(CoursePojo.class);
		System.out.println(gc.getLinkedIn());
		System.out.println(gc.getInstructor());
	}

}
