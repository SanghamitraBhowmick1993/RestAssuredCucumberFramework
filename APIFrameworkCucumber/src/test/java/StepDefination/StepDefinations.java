package StepDefination;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.api.pojo.AddPlace;
import com.api.pojo.Location;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import junit.extensions.TestSetup;
import resources.APIResourcesEnum;
import resources.TestDataBuild;
import resources.Utils;

import static org.junit.Assert.*;

public class StepDefinations extends Utils{
	
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	TestDataBuild data = new TestDataBuild();
	static String place_id;

	@Given("add Place Payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String language, String address) throws IOException {
		
		res=given().spec(requestSpecification())
				.body(data.addPlacePayLoad(name,language,address));

	}

	@When("user calls {string} with {string} HTTP Request")
	public void user_calls_with_http_request(String resource, String httpType) {
		// constructor will be called with value of resource which we pass
		
		APIResourcesEnum resourceAPI = APIResourcesEnum.valueOf(resource);
		resourceAPI.getResource();
		
		resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		if(httpType.equalsIgnoreCase("POST"))
			
		response = res.when().post(resourceAPI.getResource());
		
		else if(httpType.equalsIgnoreCase("GET"))
			response = res.when().get(resourceAPI.getResource());
		
	}

	@Then("the API call is success with status code {int}")
	public void the_api_call_is_success_with_status_code(Integer int1) {
		
		assertEquals(response.getStatusCode(), 200);

	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String expectedValue) {	
		
		assertEquals(getJsonPath(response,keyValue),expectedValue);
	}
	
	@Then("verify place_id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String expectedNme, String resource) throws IOException {
		
		place_id= getJsonPath(response, "place_id");
		res = given().spec(requestSpecification()).queryParam("place_id", place_id);
		user_calls_with_http_request(resource,"GET");
		String name= getJsonPath(response, "name");
		assertEquals(expectedNme, name);

	}
	@Given("DeletePlace Payload")
	public void delete_place_payload() throws IOException {

		res = given().spec(requestSpecification()).body(data.deletePlacePayload(place_id));
	}
}
