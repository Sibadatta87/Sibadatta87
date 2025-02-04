package ECOM;

import org.apache.http.cookie.CookieSpecRegistry;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import pojo.EcomLogin;
import pojo.EcomOrderDetails;
import pojo.EcomOrders;

import pojo.ecomloginResponse;

import  static io.restassured.RestAssured.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class login {

	public static void main(String[] args) {
		
		
	RequestSpecification res =new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").setContentType(ContentType.JSON).build();

	
	EcomLogin  pj = new EcomLogin();

	pj.setUserEmail("sibadatta16@gmail.com");
	pj.setUserPassword("0712@Siba");
	

RequestSpecification response =  given().log().all().spec(res).body(pj);


ecomloginResponse loginresponse = response .when().post("/api/ecom/auth/login").then().log().all().extract().response().as(ecomloginResponse.class);

System.out.println(loginresponse.getToken());
    System.out.println(loginresponse.getMessage());
	System.out.println(loginresponse.getUserId());
	
	
	// add product 
	
	RequestSpecification  productRs =  new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addHeader("Authorization", loginresponse.getToken())
	 .build();
	
	RequestSpecification productadd =  given().log().all().spec(productRs).param("productName", "qwerty").
	param("productAddedBy", loginresponse.getUserId()).
	param("productCategory", "fashion").
	param("productSubCategory", "shirts").
	param("productPrice","11500").
	param("productDescription","Addias Originals").
	param("productFor","women").
	multiPart("productImage",new File ("C://Users//Deepa//Downloads//download.png"));
	
String addedDetails =productadd.when().post("/api/ecom/product/add-product").then().log().all().assertThat().extract().response().asString();
	
	JsonPath jp = new JsonPath(addedDetails);
	String productID =jp.get("productId");
	
	//create order 
	
	EcomOrderDetails  details = new EcomOrderDetails();
	details.setCountry("India");
	details.setProductOrderedId(productID);
	List<EcomOrderDetails>  orders = new ArrayList<EcomOrderDetails>();
	orders.add(details);
	EcomOrders  order =  new EcomOrders();
	order.setOrders(orders);
	RequestSpecification createOrder = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").
			addHeader("authorization", loginresponse.getToken()).setContentType(ContentType.JSON).build();
RequestSpecification createorderReq = 	given().log().all().spec(createOrder).body(order);
String responseorder =createorderReq.when().post("/api/ecom/order/create-order").then().log().all().assertThat().extract().response().asString();
	
	System.out.println(responseorder);
	
//DeleteOrder  using path parameter
	
	RequestSpecification DeleteOrder = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").
			addHeader("authorization", loginresponse.getToken()).setContentType(ContentType.JSON).build();
RequestSpecification  deleteProd = 	given().spec(DeleteOrder).log().all().pathParam("productId",productID );
String deleteProductResponse =	deleteProd.when().delete("api/ecom/product/delete-product/{productId}").then().log().all().extract().response().asString();
	
JsonPath js = new JsonPath(deleteProductResponse);
//String value =js.get("message");
System.out.println(js.getString("message"));
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
