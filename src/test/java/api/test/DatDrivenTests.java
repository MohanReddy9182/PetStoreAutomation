package api.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class DatDrivenTests {

	@Test(priority = 1, dataProvider = "Data", dataProviderClass = DataProvider.class) // for acccessing the file we
																						// need to provider the
																						// dataProviderClass
	public void testPostUser(String userID, String userName, String fname, String lname, String useremail,
			String password, String phone) {

		User payload = new User();
		payload.setId(Integer.parseInt(userID));
		payload.setUsername(userName);
		payload.setFirstname(fname);
		payload.setLastname(lname);
		payload.setEmail(useremail);
		payload.setPassword(password);
		payload.setPhone(phone);

		Response res = UserEndPoints.createUser(payload);

		Assert.assertEquals(res.getStatusCode(), 200);
	}

	@Test(priority = 2, dataProvider = "UserNames", dataProviderClass = DataProvider.class)
	public void testDeleteUserByName(String UserName) {

		Response res = UserEndPoints.deleteUser(UserName);
		Assert.assertEquals(res.getStatusCode(), 200);
	}
}
