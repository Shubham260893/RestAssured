package stepdefinitions;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;

import APIPathConfigs.APIPaths;
import Utils.RequestSpecificationBuilder;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AddVehicleSteps {
	
	public static RequestSpecification request;
	public static Response response;
	
	@Given("I do the new user registration through {string} microservice")
	public void i_do_the_new_user_registration_through_microservice(String microservicename) throws IOException {
	   
		request= RequestSpecificationBuilder.buildRequest(microservicename).body(RequestSpecificationBuilder.userRegistration());
		APIPaths resource= APIPaths.valueOf("AddUser");
		
		response= RequestSpecificationBuilder.sendPostRequest(resource.getResource());
			
	}

	@Then("Validate the response code as {int}")
	public void validate_the_response_code_as(Integer int1) {
	
		assertEquals(response.getStatusCode(), int1);
	    
	}

	@Then("Validate {string} in the response body is {string}")
	public void validate_in_the_response_body_is(String key, String value) {
		
		
		assertEquals(response.getBody().jsonPath().get(key),value);
	   
	}

	@Then("I generate the token by passing login claims")
	public void i_generate_the_token_by_passing_login_claims() throws StreamReadException, DatabindException, IOException {
		
		request= RequestSpecificationBuilder.buildRequest("identity").body(RequestSpecificationBuilder.generateToken());

		APIPaths resource= APIPaths.valueOf("GetToken");
		
		response= RequestSpecificationBuilder.sendPostRequest(resource.getResource());
		
		System.out.println(response.asPrettyString());
		
		String token= response.getBody().jsonPath().get("primaryAccessToken.value").toString();
		
		System.out.println(token);
	   
	}

	@When("I call {string} with POST request")
	public void i_call_with_post_request(String string) {
	   
		
		
	}

}
