package restAssuredTests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class OauthDemo {

	@Test
	public void oauthTest() {
		

		String url = "https://rahulshettyacademy.com/getCourse.php?code=4%2F0AX4XfWjq8-SirqT4cgfbUM8nv_KMrlMCCKB1J9yxP4uo3RaTDNNmGlVEbGJAz6WWcTlz7g&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&prompt=none";
		String partialCode = url.split("code=")[1];
		String code = partialCode.split("&scope")[0];
		System.out.println(code);

		String accessTokenResponse = given().urlEncodingEnabled(false).queryParam("code", code)
				.queryParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
				.queryParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
				.queryParam("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
				.queryParam("grant_type", "authorization_code").when()
				.post("https://www.googleapis.com/oauth2/v4/token").then().log().all().extract().response().asString();

		JsonPath js = new JsonPath(accessTokenResponse);
		String accessToken = js.getString("access_token");
		Response response = given().queryParam("access_token", accessToken).when()
				.post("https://rahulshettyacademy.com/getCourse.php").then().log().all().statusCode(200).extract()
				.response();
		String StrResponse = response.asString();
		System.out.println(StrResponse);
	}

}
