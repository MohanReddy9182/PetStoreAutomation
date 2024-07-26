package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//UserEndPoints.java
//Created this for to perform Create , Read , Update, Delete requests to the user API's

public class UserEndPoints2 {
	// method created for getting URL's from the properties file
	static ResourceBundle getURL() {
		ResourceBundle routes = ResourceBundle.getBundle("routes"); // load the properties file // name of the
																	// properties file

		return routes;
	}

	// implementing the create user end point menthod
	public static Response createUser(User payload) {
		
		String post_url = getURL().getString("post_url");

		Response res = given().contentType("application/json").header("accept", "application/json").body(payload)
		.when()
				.post(post_url);
		
		return res;
		
	}

	// implementing the readuser end points method
	public static Response readUser(String userName) {
		String get_url = getURL().getString("get_url");

		Response res = given().pathParam("username", userName).when().get(get_url);

		return res;

	}

//implementing the update use endpoints method
	public static Response updateUser(String userName, User payload) {
		String update_url = getURL().getString("update_url");

		Response res = given().contentType(ContentType.JSON).accept(ContentType.JSON).pathParam("username", userName)
				.body(payload).when().put(update_url);

		return res;

	}

//implementing the delete userendpoints menthod 
	public static Response deleteUser(String userName) {
		String delete_url = getURL().getString("delete_url");

		Response res = given().pathParam("username", userName).when().delete(delete_url);

		return res;

	}

}
