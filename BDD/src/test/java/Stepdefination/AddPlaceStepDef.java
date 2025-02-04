package Stepdefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddPlaceStepDef {
	
	@Given("Add Place Payload")
	public void add_place_payload() {
	    // Write code here that turns the phrase above into concrete actions
	
	}

	@When("user calls {string}  with Post Http request")
	public void user_calls_with_post_http_request(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the API call got success with status code")
	public void the_api_call_got_success_with_status_code() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("{string}  in the response body is {string}")
	public void in_the_response_body_is(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}




}
