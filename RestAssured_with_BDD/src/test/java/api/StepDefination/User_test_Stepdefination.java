package api.StepDefination;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.UserEndpoints.UserEndPoints;
import api.Utilities.FakerData;
import api.payload.User;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class User_test_Stepdefination {

	User userPayload;
	int ids;
	Faker faker = new Faker();

	FakerData fd = new FakerData();
	Logger logger;

	@Test(priority = 1)
	public void Api_using_post_Request() {
		userPayload = new User();
		userPayload = fd.fakerDataGenerator();
		Response response = UserEndPoints.crerateUser(userPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 201);
		// To pass the id from post to other tests we use jsonpath
		JsonPath jsonpasthEvaluator = response.jsonPath();
		ids = jsonpasthEvaluator.get("id");

	}

	@Test(priority = 2)
	public void Api_using_get_Request() {
		Response response = UserEndPoints.getUser(ids);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);

	}

	@Test(priority = 3)
	public void Api_using_update_Requrest() {
		User userPayload = new User();
		userPayload.setName(faker.name().name());
		List<String> randomlist = new ArrayList<String>();
		randomlist.add("male");
		randomlist.add("female");
		int index = getRandomElement(randomlist);
		String gender = randomlist.get(index);
		userPayload.setGender(gender);
		userPayload.setEmail(faker.internet().emailAddress());
		List<String> randomlist1 = new ArrayList<String>();
		randomlist1.add("Active");
		randomlist1.add("Inactive");
		int index1 = getRandomElement(randomlist1);
		String status = randomlist.get(index1);
		userPayload.setStatus(status);

		Response response = UserEndPoints.updateUser(ids, userPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);

	}

	@Test(priority = 4)
	public void Api_with_Delete_Request() {
		Response response = UserEndPoints.deleteUser(ids);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}


	@Test(priority = 1)
	@Given("User Hit API with Post Request method then new resource created including id")
	public void user_Hit_API_with_Post_Request_method_then_new_resource_created_including_id() {
		
		logger=Logger.getLogger("RestAssered_WithBDD_Framework");
		PropertyConfigurator.configure("log4j.properties");
		logger.setLevel(Level.DEBUG);
		
		userPayload = new User();
		userPayload = fd.fakerDataGenerator();
		Response response = UserEndPoints.crerateUser(userPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 201);
		// To pass the id from post to other tests we use jsonpath
		JsonPath jsonpasthEvaluator = response.jsonPath();
		ids = jsonpasthEvaluator.get("id");
		logger.info("New resource is created successfully by Post Method");

	}

	@Test(priority = 2)
	@When("Use Hit with Get Request method to retrive retrive resource through previously generated id")
	public void use_Hit_with_Get_Request_method_to_retrive_retrive_resource_through_previously_generated_id() {
		Response response = UserEndPoints.getUser(ids);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("Existing Resource is Retrived successfully by Get Method");

	}
	
	@Test(priority = 3)
	@When("Use Hit Api with Put method to modify resource through same generated id")
	public void use_Hit_Api_with_Put_method_to_modify_resource_through_same_generated_id() {
		User userPayload = new User();
		userPayload.setName(faker.name().name());
		List<String> randomlist = new ArrayList<String>();
		randomlist.add("male");
		randomlist.add("female");
		int index = getRandomElement(randomlist);
		String gender = randomlist.get(index);
    	userPayload.setGender(gender);
		userPayload.setEmail(faker.internet().emailAddress());
		List<String> randomlist1 = new ArrayList<String>();
		randomlist1.add("Active");
		randomlist1.add("Inactive");
		int index1 = getRandomElement(randomlist1);
		String status = randomlist.get(index1);
		userPayload.setStatus(status);

		Response response = UserEndPoints.updateUser(ids, userPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("Modifying data successfully by Put Method");

	}

	@Test(priority = 4)
	@Then("User Hit Api with Delete method to delete that record")
	public void user_Hit_Api_with_Delete_method_to_delete_that_record() {
		Response response = UserEndPoints.deleteUser(ids);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("Deleting Resource is successfully by Delete Method");

	}

	private int getRandomElement(List<String> list) {
		// TODO Auto-generated method stub
		Random rand = new Random();
		return rand.nextInt(list.size());
	}
}
