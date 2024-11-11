import org.testng.Assert;

import Files.Payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JsonPath js = new JsonPath(Payload.courseDetails());
		//no of course available 

			System.out.println(js.getInt("courses.size()"));
			//print all course title 
String value =		js.get("courses[0].title");
System.out.println(value );
System.out.println(js.getString("courses[0].title"));
//get will return the object so to ensure type safety we need to pass get string explictly 


// print all course titles and their respective prices 

for (int i =0;i<js.getInt("courses.size()");i++) {
	
	System.out.println(js.getString("courses["+i+"].title"));
	
	
	System.out.println(js.getInt("courses["+i+"].price"));
	
	
}
//print the no of copies sold by RPA by using dynamic logic as might be RPA would not be there in 3 location so use for loop over here

for(int i=0;i<js.getInt("courses.size()");i++) {
	
	if (js.getString("courses["+i+"].title").equalsIgnoreCase("RPA")) {
		System.out.println(js.getInt("courses["+i+"].copies"));
		//break;
	}
	
	//break;
}

System.out.println(js.getInt("courses[2].copies"));

int sum =0;
//Verify  if the sum of course prices matches with purchase price amount 
for(int i =0;i<js.getInt("courses.size()");i++) {
	
	sum= sum +js.getInt("courses["+i+"].price")*js.getInt("courses["+i+"].copies");
	
}
System.out.println(sum);

Assert.assertEquals(sum, js.getInt("dashboard.purchaseAmount"));

																							
	
	}

}
