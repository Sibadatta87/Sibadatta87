package Files;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.io.File;

public class JiraBugDefect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
RestAssured.baseURI ="https://rahulshettyacademy-team.atlassian.net";

String re =given().header("Content-Type","application/json").
header("Authorization","Basic bWVudG9yQHJhaHVsc2hldHR5YWNhZGVteS5jb206QVRBVFQzeEZmR0YwdFNlOHYzNUtILWQtU3U4NUFMckIyTjdDNXIwY0pJU0djdFIwRFBybUhfZjVlUmg4dE5UUVV6UVp1dTFkMXJHdkRjUzNHRnV4TVE4WklSNU9tdFlPbUszLUxBbVU4OEFTM3JrOGkwODFSYV9kQTlPQ3J5QjRERXlFWldJYXpwWGw3VDFTWnBLY0ZOSDBucjVBMUtLQ3FuWVBldzFLR2JSMWowa2JFdGVNVFZFPUZCMzhFM0JB")
.body("{\r\n"
		+ "    \"fields\": {\r\n"
		+ "       \"project\":\r\n"
		+ "       {\r\n"
		+ "          \"key\": \"SCRUM\"\r\n"
		+ "       },\r\n"
		+ "       \"summary\": \"REST ye merry gentlemen1\",\r\n"
		+ "      \r\n"
		+ "       \"issuetype\": {\r\n"
		+ "          \"name\": \"Bug\"\r\n"
		+ "       }\r\n"
		+ "   }\r\n"
		+ "}\r\n"
		+ "").when()
.post("rest/api/3/issue").then().assertThat().log().ifStatusCodeIsEqualTo(200).log().all().extract().response().asString();

System.out.println(re);

JsonPath jp = new JsonPath(re);
String id =jp.getString("id");
System.out.println(id);

given().pathParams("key",id).header("X-Atlassian-Token","no-check").header("Authorization","Basic bWVudG9yQHJhaHVsc2hldHR5YWNhZGVteS5jb206QVRBVFQzeEZmR0YwdFNlOHYzNUtILWQtU3U4NUFMckIyTjdDNXIwY0pJU0djdFIwRFBybUhfZjVlUmg4dE5UUVV6UVp1dTFkMXJHdkRjUzNHRnV4TVE4WklSNU9tdFlPbUszLUxBbVU4OEFTM3JrOGkwODFSYV9kQTlPQ3J5QjRERXlFWldJYXpwWGw3VDFTWnBLY0ZOSDBucjVBMUtLQ3FuWVBldzFLR2JSMWowa2JFdGVNVFZFPUZCMzhFM0JB")
.multiPart("file",new File ("C:/Users/LENOVO/Downloads/download-1600351_640.PNG")).post("rest/api/3/issue/{key}/attachments")
.then().log().all().assertThat().statusCode(200);
	
	}

}
