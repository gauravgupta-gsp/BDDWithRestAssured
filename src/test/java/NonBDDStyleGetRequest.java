import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class NonBDDStyleGetRequest {
	static String BASE_URI="reqres.in";
	@Test
	public void getAllUsers() {
		// Create Request Specification
		RequestSpecification request = RestAssured.given();
		// Add a URI
		request.baseUri("https://reqres.in/api/users?page=2");
//		Calling Get method of URI
		Response response =request.get();
		// print response
		String resString = response.asString();
		System.out.println("Response "+ resString);
		// Validate 
		ValidatableResponse valRes=    response.then();
		valRes.statusCode(200);	
		
	}
	
	@Test
	public void addNewUser() {
		
		JSONObject json = new JSONObject();
		json.put("name", "Gaurav");
		json.put("job", "SM");
		
		RequestSpecification request = RestAssured.given();
		request.baseUri("https://reqres.in/api/users");
		
		request.body(json.toJSONString());
		
		Response response = request.post();
		
		String resString = response.asString();
		System.out.println("Response "+ resString);
		
		ValidatableResponse valRes=    response.then();
		valRes.statusCode(201);	
		
		
	}
	
	
	

}
