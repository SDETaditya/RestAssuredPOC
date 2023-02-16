package stepdefinitions;
import classesforserializing.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;

import java.io.IOException;

import Utility.Utility;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import testdata.TestData;
import io.cucumber.java.en.Then;
import static io.restassured.RestAssured.*;
public class StepDefinitions extends Utility{
	RequestSpecification reqspec;	
	Response response;
	String responseString;

	@Given("Add User Payload with {string} {string}")
	public void add_user_payload_with(String name, String job) throws IOException {
	TestData td = new TestData();
		
		reqspec=given()
				.spec(requestSpec())
				
				.body(td.AddUserpayload(name, job));
	    
	}



	
	@When("User calls {string} with POST http request")
	public void user_calls_with_post_http_request(String string) {
	  response  = reqspec.when().post("/api/users").then().extract().response();
	}
	@Then("The API call is successful with status code {int}")
	public void the_api_call_is_successful_with_status_code(Integer statusCode) {
		
	    assertEquals(Integer.valueOf(response.getStatusCode()), statusCode);
	}
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String key, String val) {
		responseString = response.asString();
	
		JsonPath jpath = new JsonPath(responseString);
		
		assertEquals(jpath.get(key).toString(),val);
	}



}
