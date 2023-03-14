package org.igt.demo.stepDefinitions;

import org.igt.demo.apitests.DeleteTest;
import org.igt.demo.apitests.GetTest;
import org.igt.demo.apitests.PostTest;
import org.igt.demo.apitests.UpdateTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class carnivalStepDefinitions {
	
	@Given("API endpoint")
	public void api_endpoint() {
		GetTest gt = new GetTest();
		gt.getUserDetails();
	}
	
	@When("User id is provided")
	public void useridDetails() {
		GetTest gt = new GetTest();
		gt.getUserDetails();
	}
	
	@Then("Response should give complete user details")
	public void responseValidate() {
		GetTest gt = new GetTest();
		gt.getUserDetails();
	}
	
	@Given("API endpoint")
	public void api_endpoint2() {
		GetTest gt = new GetTest();
		gt.checkContentForGetUser();
	}
	
	@When("User id is provided")
	public void userid2() {
		GetTest gt = new GetTest();
		gt.checkContentForGetUser();
	}
	
	@Then("Content type should be application json")
	public void responseContentType() {
		GetTest gt = new GetTest();
		gt.checkContentForGetUser();
	}
	
	@Given("API endpoint")
	public void api_endpoint3() {
		GetTest gt = new GetTest();
		gt.checkUserTitle();;
	}
	
	@When("User id is provided")
	public void userid3() {
		GetTest gt = new GetTest();
		gt.checkUserTitle();
	}
	
	@Then("Content should have first name field")
	public void responseContentFields() {
		GetTest gt = new GetTest();
		gt.checkUserTitle();
	}
	
	@Given("Request is given with data")
	public void createNewUser() {
		PostTest pt = new PostTest();
		pt.createNewUser();
	}
	
	@When("Data is retrived from json file")
	public void createUserGetData() {
		PostTest pt = new PostTest();
		pt.createNewUser();
	}
	
	@And("API endpoint is up and running")
	public void postEndpointCheck() {
		PostTest gt = new PostTest();
		gt.createNewUser();
	}
	
	@Then("User should be able to create new user")
	public void userCreation() {
		PostTest gt = new PostTest();
		gt.createNewUser();
	}
	
	@Given("Request is given with data")
	public void newUserRegistration() {
		PostTest pt = new PostTest();
		pt.newUserRegistartion();
	}
	
	@When("Data is retrived from json file")
	public void registerUserGetData() {
		PostTest pt = new PostTest();
		pt.newUserRegistartion();
	}
	
	@And("API endpoint is up and running")
	public void postEndpointCheck2() {
		PostTest gt = new PostTest();
		gt.newUserRegistartion();
	}
	
	@Then("New user is registered successfully")
	public void userregistartion() {
		PostTest gt = new PostTest();
		gt.newUserRegistartion();
	}
	
	@Given("Request is given with data")
	public void newUserRegistrationInvalidReq() {
		PostTest pt = new PostTest();
		pt.checkValidationCodeForMissingPassword();;
	}
	
	@When("Data is retrived from json file")
	public void registerUserGetData3() {
		PostTest pt = new PostTest();
		pt.checkValidationCodeForMissingPassword();
	}
	
	@And("API endpoint is up and running")
	public void postEndpointCheck3() {
		PostTest gt = new PostTest();
		gt.checkValidationCodeForMissingPassword();
	}
	
	@Then("Response should have validation message for missing field")
	public void userregistartionInvalidMessage() {
		PostTest gt = new PostTest();
		gt.checkValidationCodeForMissingPassword();
	}
	
	@Given("Request is given with data")
	public void updateUser() {
		UpdateTest ut = new UpdateTest();
		ut.updateRequest();
	}
	
	@When("First name is replaced")
	public void valueChange() {
		UpdateTest ut = new UpdateTest();
		ut.updateRequest();
	}
	
	@And("API endpoint is up and running")
	public void apiEndpoint4() {
		UpdateTest ut = new UpdateTest();
		ut.updateRequest();
	}
	
	@Then("User should be updated with new details")
	public void userUpdation() {
		PostTest gt = new PostTest();
		gt.checkValidationCodeForMissingPassword();
	}
	
	@Given("Request is given with data")
	public void updateFirstName() {
		UpdateTest ut = new UpdateTest();
		ut.updateRequestToValidateUserDetails();
	}
	
	@When("First name is replaced")
	public void valueChange2() {
		UpdateTest ut = new UpdateTest();
		ut.updateRequestToValidateUserDetails();
	}
	
	@And("API endpoint is up and running")
	public void apiEndpoint5() {
		UpdateTest ut = new UpdateTest();
		ut.updateRequestToValidateUserDetails();
	}
	
	@Then("Verify if email is present in response")
	public void userUpdation2() {
		UpdateTest ut = new UpdateTest();
		ut.updateRequestToValidateUserDetails();
	}
	
	@Given("Request is given with data")
	public void updateLastName() {
		UpdateTest ut = new UpdateTest();
		ut.checkLastNameAfterUpdation();
	}
	
	@When("Last name is replaced from request")
	public void valueChange3() {
		UpdateTest ut = new UpdateTest();
		ut.checkLastNameAfterUpdation();
	}
	
	@And("API endpoint is up and running")
	public void apiEndpoint6() {
		UpdateTest ut = new UpdateTest();
		ut.checkLastNameAfterUpdation();
	}
	
	@Then("Check if last name is replaced in response")
	public void userUpdation3() {
		UpdateTest ut = new UpdateTest();
		ut.checkLastNameAfterUpdation();
	}
	
	@Given("Request is given with data")
	public void validateresponseBody() {
		UpdateTest ut = new UpdateTest();
		ut.verifyResponseBody();
	}
	
	@When("Response body is posted")
	public void valueChange5() {
		UpdateTest ut = new UpdateTest();
		ut.verifyResponseBody();
	}
	
	@And("API endpoint is up and running")
	public void apiEndpoint7() {
		UpdateTest ut = new UpdateTest();
		ut.verifyResponseBody();
	}
	
	@Then("Verify that response body is available for testing")
	public void userUpdation4() {
		UpdateTest ut = new UpdateTest();
		ut.verifyResponseBody();
	}
	
	@Given("Request is given with data")
	public void deleteUserDetails() {
		DeleteTest dt = new DeleteTest();
		dt.deleteUserDetails();
	}
	
	@When("API endpoint is up and running")
	public void deleteReqBody() {
		DeleteTest dt = new DeleteTest();
		dt.deleteUserDetails();
	}
	
	@Then("User should be deleted from database")
	public void userDeletion() {
		DeleteTest dt = new DeleteTest();
		dt.deleteUserDetails();
	}
	
	@Given("Request is given with data")
	public void deleteUserDetails2() {
		DeleteTest dt = new DeleteTest();
		dt.deleteAndCheckStatus();
	}
	
	@When("API endpoint is up and running")
	public void deleteReqBody2() {
		DeleteTest dt = new DeleteTest();
		dt.deleteAndCheckStatus();
	}
	
	@Then("Status code should be 204 after deletion")
	public void userStatusCheck() {
		DeleteTest dt = new DeleteTest();
		dt.deleteAndCheckStatus();
	}
	
	
	

}
