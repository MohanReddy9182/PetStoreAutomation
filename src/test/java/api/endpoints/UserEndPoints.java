package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//UserEndPoints.java
//Created this for to perform Create , Read , Update, Delete requests to the user API's

public class UserEndPoints {

	// implementing the create user end point menthod
	public static Response createUser(User payload) {
		
		Response res = given().contentType("application/json").header("accept", "application/json").body(payload)
		.when()
				.post(Routes.post_url);
		
		return res;
		
	}

	// implementing the readuser end points method
	public static Response readUser(String userName) {

		Response res = given().pathParam("username", userName).when().get(Routes.get_url);

		return res;

	}

//implementing the update use endpoints method
	public static Response updateUser(String userName, User payload) {

		Response res = given().contentType(ContentType.JSON).accept(ContentType.JSON).pathParam("username", userName)
				.body(payload).when().put(Routes.update_url);

		return res;

	}

//implementing the delete userendpoints menthod 
	public static Response deleteUser(String userName) {

		Response res = given().pathParam("username", userName).when().delete(Routes.delete_url);

		return res;

	}

}
