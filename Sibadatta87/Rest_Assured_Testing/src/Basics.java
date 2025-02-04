import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import  static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.testng.Assert;

import Files.Payload;

public class Basics {
public static 	String value;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//System.out.println(" dada");
	//valdiate if add place api si 	
		//given - all the input 
		//when - submit the api  resource ,http method 
		//then - validate the response 
		
		//add palce and update place with new address -> get place to validate if new address is present in the response 
		RestAssured.baseURI ="https://rahulshettyacademy.com";
	String response =	given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json").
		body(Payload.addPlace()).when().post("maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).body("scope",equalTo("APP")).header("Server", "Apache/2.4.52 (Ubuntu)").
		extract().response().asString();
		
	
	System.out.println(response);
	
	JsonPath js = new JsonPath(response);
	
	
 value =	js.getString("place_id");
System.out.println(value);

String placeName = "test one bangalore";


// update place 

given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json").
body(Payload.updatePlace(value,placeName)).when().put("maps/api/place/update/json").then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));

//get update place 

String address =given().log().all().queryParam("key", "qaclick123").queryParam("place_id",value).when().get("maps/api/place/get/json").then().assertThat().log().all().statusCode(200).extract().response().asString();

System.out.println(address);

  JsonPath pathb = new JsonPath(address); String actualaddress
  =pathb.get("address");
 

Assert.assertEquals(actualaddress, placeName);


//Read from the external Json file 

File fi = new File("C:\\Users\\LENOVO\\Desktop");

String str =Files.readString(Path.of("C:\\Users\\LENOVO\\Desktop\\addPlace.json"));
System.out.println(str+"my test for ");



	}

}
