package commos.Funcionalidade;

import org.hamcrest.Matchers;

import commons.Config;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;

public class Login implements Config {

	
	public void login() {
		RestAssured.baseURI = APP_BASE_URL;
		RestAssured.port = APP_PORT;
		
		RequestSpecBuilder resBilder = new RequestSpecBuilder();
		resBilder.setContentType(APP_CONTENT_TYPE);
		RestAssured.requestSpecification = resBilder.build();
		
		ResponseSpecBuilder resPonse = new ResponseSpecBuilder();
		resPonse.expectResponseTime(Matchers.lessThan(MAX_TIMEOUT));
		RestAssured.responseSpecification = resPonse.build();
		
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
	}
}
