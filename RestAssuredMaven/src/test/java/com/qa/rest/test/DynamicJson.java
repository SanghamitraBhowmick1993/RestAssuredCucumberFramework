package com.qa.rest.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.files.Payload;
import com.qa.files.ReusableMethods;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class DynamicJson {
	
	@Test(dataProvider="bookData")
	public void addBook(String isbn, String aisle){
		RestAssured.baseURI ="http://216.10.245.166";
		String response = given().header("Content-Type","application/json")
		.body(Payload.addBook(isbn,aisle))
		.when()
		.post("/Library/Addbook.php")
		.then().assertThat().statusCode(200)
		.extract().response().asString();
		JsonPath js = ReusableMethods.rawToJson(response);
		String id = js.get("ID");
		System.out.println(id);
		
		
	}
	//delete Book
	public void deleteBook(String isbn, String aisle){
		RestAssured.baseURI ="http://216.10.245.166";
	}
	@DataProvider(name = "bookData")
	public Object[][] getData(){		
		return new Object[][] {{"bcddf","234"},{"bcddg","235"},{"bcddh","236"}};
	}
}
