package com.qa.rest.test;


import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import com.qa.files.Payload;
import com.qa.files.ReusableMethods;

import static io.restassured.RestAssured.*;
//https://deloittedevelopment.udemy.com/course/rest-api-automation-testing-rest-assured/learn/lecture/16212122#reviews

//Grant type: Authorization code, password creds, client creds
public class Basics {
	
	public static void main(String[] args){
	//add place
	RestAssured.baseURI = "https://rahulshettyacademy.com";
	String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
	.body(Payload.addPlace())
	.when().post("maps/api/place/add/json")
	.then()
	.assertThat().statusCode(200)
	.body("scope", equalTo("APP"))
	.header("Server", "Apache/2.4.18 (Ubuntu)")
	.extract().response().asString();
	System.out.println(response);
	JsonPath js = new JsonPath(response);
	String placeId = js.getString("place_id");
	System.out.println(placeId);
	
	//update Place
	String newAddress = "90 winter walk, USA";
	given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
	.body("{\r\n" + 
			"\"place_id\":\""+placeId+"\",\r\n" + 
			"\"address\":\""+newAddress+"\",\r\n" + 
			"\"key\":\"qaclick123\"\r\n" + 
			"}")
	.when().put("maps/api/place/update/json")
	.then()
	.assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));
	
	//get place
	String getPlaceResponse = given().log().all().queryParam("key", "qaclick123")
	.queryParam("place_id", placeId)
	.when().get("maps/api/place/get/json")
	.then().assertThat().log().all().statusCode(200).extract().response().asString();
	JsonPath json = ReusableMethods.rawToJson(getPlaceResponse);
	String actualAddress = json.getString("address");
	System.out.println(actualAddress);
	Assert.assertEquals(actualAddress, newAddress);

	

}
}
