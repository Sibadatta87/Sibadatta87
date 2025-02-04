import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Files.Payload;
import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


public class DynamicJson {
	
	@Test(dataProvider = "BookData")
	
	public void addBook(String isbn, String asile) {
		
	RestAssured.baseURI ="https://rahulshettyacademy.com";
	
Response response =given().log().all().header("Content-Type","application/json")
.body(Payload.addBook(isbn,asile)).when().post("/Library/Addbook.php").then().assertThat().log().all().statusCode(200).extract().response();

JsonPath js = new JsonPath(response.asString());
		
		String id = js.get("ID");
		System.out.println(id);
	
	}
	
	@DataProvider(name ="BookData")
	
	public String[][] getData(){
		return new String [][] {{"aba","6678"},{"23","456"}};
		
		
	}
	


}
