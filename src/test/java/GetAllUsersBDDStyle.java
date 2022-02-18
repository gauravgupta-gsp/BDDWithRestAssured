import static org.hamcrest.CoreMatchers.equalTo;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetAllUsersBDDStyle {
	
	public void getAllUsers() {
		// Given
		given()
			.baseUri("https://reqres.in")
		.when()
			.get("/api/users?page=2")
		.then()
			.statusCode(200)
			.body("total", equalTo(12))
			.log().all();
	}
	
	@Test
	public void getSingleUser() {
		// Given
		given()
			.baseUri("https://reqres.in")
		.when()
			.get("/api/users/2")
		.then()
			.statusCode(200)
//			.body("total", equalTo(12))
			.log().body();
	}
	
	public void addNewUser() {
		JSONObject json = new JSONObject();
		json.put("name", "Gupta");
		json.put("job", "SME");
		
		given()
			.baseUri("https://reqres.in")
			.body(json.toJSONString())
		.when()
			.post("/api/users")
		.then()
			.statusCode(201)
			.log().all();
	}


	
	public void editAUserWithPut() {
		JSONObject json = new JSONObject();
		json.put("name", "Gaurav");
		json.put("job", "Coach");
		
		given()
			.baseUri("https://reqres.in")
			.body(json.toJSONString())
		.when()
			.put("/api/users/2")
		.then()
			.statusCode(200)
			.log().body();
	}
}
