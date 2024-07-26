package api.endpoints;

/* Swagger URI -->  https://petstore.swagger.io
 * 
 *  crete user(POST) : https://petstore.swagger.io/v2/user
 *  Get User (get) : https://petstore.swagger.io/v2/user/{username}
 *  Update user(put): https://petstore.swagger.io/v2/user/{username}
 *  Delete user(DElete): https://petstore.swagger.io/v2/user/{username}
 *  
 */

public class Routes {

	public static String base_url = "https://petstore.swagger.io/v2";

	// User Module

	public static String post_url = base_url + "/user";
	public static String get_url = base_url + "/user/{username}";
	public static String update_url = base_url + "/user/{username}";
	public static String delete_url = base_url + "/user/{username}";

	// Store module
	// here we will create the store module url's

	// pet module
	// here we will create the pet module url's

}
