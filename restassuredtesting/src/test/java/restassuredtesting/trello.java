package restassuredtesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.*;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.*;
import static io.restassured.RestAssured.*;
import io.restassured.path.json.JsonPath;
import static org.hamcrest.Matchers.*;

public class trello {
	
	public static String baseuri="https://api.trello.com";
	public String id;
	
	@Test(enabled=true)
	public void createBoard()
	{
	   
		
		baseURI=baseuri;
		given().queryParam("name","vishnu")
		.queryParam("key","e170143e5cd82d1243c1497e1b1f6bac")
.queryParam("token","76016fa2a3665c7343f5c95b511e5eeb63cf4deba368051e060a55af75c856f0")
.when()
.contentType(ContentType.JSON).accept(ContentType.JSON)
.post("/1/boards/").then().statusCode(200).log().all();
		Response res=given().queryParam("name","vishnu")
				.queryParam("key","e170143e5cd82d1243c1497e1b1f6bac")
		.queryParam("token","76016fa2a3665c7343f5c95b511e5eeb63cf4deba368051e060a55af75c856f0")
		.when()
		.contentType(ContentType.JSON).accept(ContentType.JSON)
		.post("/1/boards/").then().extract().response();
		String s=res.asString();
		JsonPath jt=new JsonPath(s);
		id=jt.get("id");
		System.out.println(id);
		
		
	}
	
	
	@Test(enabled=false)
	public void updateboard()
	{
	   
		
		baseURI=baseuri;
		
		
		given().queryParam("key","d82314f6caf0c20a8fc504bd95dbb372")
		.queryParam("token","6ee9cda44a7520df4cd5236ac30ea3cb679165de225ef3bbc9c272ff84b3d531")
		.when()
		.contentType(ContentType.JSON).accept(ContentType.JSON)
		.put("/1/boards/"+id).then().log().all();
		
	}
	
	
	@Test(enabled=false)
	public void deleteBoard()
	{
	   
		
		baseURI=baseuri;
		//JSONObject js=new JSONObject();
		//js.put("name", "Testing");
		
		given().queryParam("key","d82314f6caf0c20a8fc504bd95dbb372")
		.queryParam("token","6ee9cda44a7520df4cd5236ac30ea3cb679165de225ef3bbc9c272ff84b3d531")
		.when()
		.contentType(ContentType.JSON).accept(ContentType.JSON)
		.delete("/1/boards/"+id).then().log().all();
		
	}
	@Test(enabled=false)
	public void getallboards()
	{
	   
		
		baseURI=baseuri;
		
		
		given().queryParam("key","d82314f6caf0c20a8fc504bd95dbb372")
		.queryParam("token","6ee9cda44a7520df4cd5236ac30ea3cb679165de225ef3bbc9c272ff84b3d531")
		.when()
		.contentType(ContentType.JSON).accept(ContentType.JSON)
		.get("/1/members/me/boards").then().log().all();
		
	}
	
	
	@Test(enabled=true)
	public void getaboard()
	{
	   
		
		baseURI=baseuri;
		
		
		given().queryParam("key","d82314f6caf0c20a8fc504bd95dbb372")
		.queryParam("token","6ee9cda44a7520df4cd5236ac30ea3cb679165de225ef3bbc9c272ff84b3d531")
		.when()
		.contentType(ContentType.JSON).accept(ContentType.JSON)
		.get("/1/boards/"+id).then().log().all();
		
	}

}
