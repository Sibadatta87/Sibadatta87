package Serialization;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

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
p.setLocation(l);

  RequestSpecification res =new
  RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").
  addQueryParam("key", "qaclick123") .setContentType(ContentType.JSON).build();
  
  ResponseSpecification response = new
  ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.
  JSON).build(); 
  
  RequestSpecification res1 = given().spec(res).body(p);
  
  System.out.println(res1.toString());
  Response respo
  =res1.when().post("/maps/api/place/add/json")
  .then().spec(response).extract().response(); System.out.println("text");
  String responseString = respo.asString(); 
  System.out.println(responseString);
 
	//given().queryParam("key", "qaclick123").contentType("application/json").log().all().body(p).when().post("maps/api/place/add/json").then().log().all().assertThat().statusCode(200);




	}

}
