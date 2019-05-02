package webServicesPages;

import java.io.IOException;

import org.testng.Assert;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.relevantcodes.extentreports.LogStatus;

import TestBase.TestBase;

public class DeleteAPIWithHeaders extends TestBase {
	
public  static void deleteAPIWithHeaders(String apiURL , String StatusCode) throws JsonGenerationException, JsonMappingException, IOException{
	
	headerMap.put("Content-Type", "application/json");
	// headerMap.put("username", "test@amazon.com");
	// headerMap.put("password", "test213");
	// headerMap.put("Auth Token", "12345");

		
	// ***** URL verification *****
	serviceUrl = Repository.getProperty("URL");
	url = serviceUrl + apiURL;
	test.log(LogStatus.INFO, "Actual Testing get URI- " + url);
	log.info("Actual Testing get URI- " + url);
	test.log(LogStatus.INFO, "expected Testing get URI- https://reqres.in/api/users ");
	log.info("expected Testing get URI- https://reqres.in/api/users");
	Assert.assertTrue(url.contains("https://reqres.in/api/users"));
	test.log(LogStatus.INFO, "https://reqres.in/api/users URL matched");
	log.info("https://reqres.in/api/users URL matched");
	closebaleHttpResponse = delete(url);
	

	// a. Status Code:
	int statusCode = getStatusCode();
	System.out.println("Status Code--->" + statusCode);
	test.log(LogStatus.INFO, "Actual Status Code--->" + statusCode);
	log.info("Actual Status Code--->" + statusCode);
	test.log(LogStatus.INFO, "Expected Status Code--->" + statusCode);
	log.info("Expected Status Code--->" + statusCode);
	Assert.assertEquals(statusCode, Integer.parseInt(StatusCode), "Status code is not 204");
	test.log(LogStatus.INFO, statusCode + "Status code matched");
	log.info(statusCode + "Status code matched");
	
	 getResponseFromJson();
	 
}
}
