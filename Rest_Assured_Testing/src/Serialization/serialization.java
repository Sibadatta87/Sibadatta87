package Serialization;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import  static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

public class serialization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
	





Bodypojo p = new Bodypojo();
p.setAccuracy(50);
p.setAddress("29, side layout, cohen 09");
p.setName("Frontline test 1");
p.setPhone_number(123242);
p.setWebsite("http://google.com");
p.setLanguage("French-IN");

List<String>al = new ArrayList<>();
al.add("shoe park");
al.add("shop");
p.setType(al);

location l = new location();
l.setLat(-38.383494);
l.setLng( 33.427362);

	given().queryParam("key", "qaclick123").contentType("application/json").log().all().body(p).when().post("maps/api/place/add/json").then().log().all().assertThat().statusCode(200);




	}

}
