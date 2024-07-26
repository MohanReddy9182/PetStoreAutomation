package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints2;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests2 {
	Faker faker;
	User payload;
	public Logger logger;
	@BeforeClass
	public void SetupData() {
		faker = new Faker();
		payload = new User();
		payload.setId(faker.idNumber().hashCode());
		payload.setUsername(faker.name().username());
		payload.setFirstname(faker.name().firstName());
		payload.setLastname(faker.name().lastName());
		payload.setEmail(faker.internet().safeEmailAddress());
		payload.setPassword(faker.internet().password(5, 10));
		payload.setPhone(faker.phoneNumber().cellPhone());

		// logs
		logger = LogManager.getLogger(this.getClass());

	}

	// writing the post request test case
	@Test(priority = 1)
	public void testPostUser() {
		logger.info("================ creating the user===========");
		Response res = UserEndPoints2.createUser(payload);

		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
		logger.info("================ User is created===========");
	}

	// writing the test case for getUserByname
	@Test(priority = 2)
	public void testGetUserByName() {
		logger.info("================ getting the user ===========");
		Response res = UserEndPoints2.readUser(this.payload.getUsername());
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
		logger.info("================ user is successfully retrieved===========");
	}

	// writing test case for update user

	@Test(priority = 3)
	public void testUpdateuserByName() {
		logger.info("================ updating the user===========");
		// update data using payload
		payload.setFirstname(faker.name().firstName());
		payload.setLastname(faker.name().lastName());
		payload.setEmail(faker.internet().safeEmailAddress());

		Response res = UserEndPoints2.updateUser(this.payload.getUsername(), payload);
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);

		// checking the data after update
		Response resAfterUpdate = UserEndPoints2.readUser(this.payload.getUsername());
		resAfterUpdate.then().log().body();
		Assert.assertEquals(resAfterUpdate.getStatusCode(), 200);
		logger.info("================ user is updated===========");
	}

	// writing the test case for delete user by name
	@Test(priority = 4)
	public void testDeleteUserByName() {
		logger.info("================ deleting the user===========");
		Response res = UserEndPoints2.deleteUser(this.payload.getUsername());
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
		logger.info("================user is deleted===========");
	}
}
