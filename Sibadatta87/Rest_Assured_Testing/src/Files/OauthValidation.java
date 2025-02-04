package Files;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;

public class OauthValidation {

	public static void main(String[] args) {
		
		RestAssured.baseURI ="https://rahulshettyacademy.com";
		
		String []  expected = {"Protractor","Cypress","Selenium Webdriver Java"};

	String reponse =	given().formParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com").
		formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W").
		formParams("grant_type","client_credentials").
		formParam("scope", "trust").when().log().all().post("/oauthapi/oauth2/resourceOwner/token").asString();
	
	System.out.println(reponse);
	
 JsonPath json =  new JsonPath(reponse);
		System.out.println("---------");
		String accessToken = 	json.getString("access_token");
//	String response2	= given().param("access_token", accessToken).log().all().when().log().all().get("https://rahulshettyacademy.com/oauthapi/getCourseDetails").then().log().all().extract().asString();
	
		
	//  This default parser we need to check 	given ().queryParam("", "").expect().defaultParser(Parser.JSON).when().get("").as(GetCourse.class);
	GetCourse gc =	given().queryParam("access_token", accessToken).when().log().all().get("https://rahulshettyacademy.com/oauthapi/getCourseDetails").as(GetCourse.class);
	
	System.out.println(gc.getLinkedIn());
List<API> text =	gc.getCourses().getApi();

for (int i =0;i<text.size();i++) {
	
	System.out.println(text.get(i).getCourseTitle());
}

// Get me the all courses available in selenium automation 
		//System.out.println(response2);
List<WebAutomation> webcourses =gc.getCourses().getWebAutomation();
List<String> actual = new ArrayList<>();

for (int i =0;i<webcourses.size();i++) {
	
	//String []  actual ;
	
	
	actual.add(webcourses.get(i).getCourseTitle());
	
	
	
	

	System.out.println(webcourses.get(i).getCourseTitle());
	
	
}

List<String > value =Arrays.asList(expected);

Assert.assertEquals(value, actual);

//comparison of titles of webAutomation

	}

}
