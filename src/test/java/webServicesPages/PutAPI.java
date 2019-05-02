package webServicesPages;

import java.io.IOException;

import org.testng.Assert;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.relevantcodes.extentreports.LogStatus;

import TestBase.TestBase;
import webServicesData.Users;

public class PutAPI extends TestBase{
	
	
	
	public  static void putAPI(String apiURL, String StatusCode ) throws JsonGenerationException, JsonMappingException, IOException{
		
		serviceUrl = Repository.getProperty("URL");
		url = serviceUrl + apiURL;
		test.log(LogStatus.INFO, "Actual Testing get URI- " + url);
		log.info("Actual Testing get URI- " + url);
		test.log(LogStatus.INFO, "expected Testing get URI- https://reqres.in/api/users ");
		log.info("expected Testing get URI- https://reqres.in/api/users");
		Assert.assertTrue(url.contains("https://reqres.in/api/users"));
		test.log(LogStatus.INFO, "https://reqres.in/api/users URL matched");
		log.info("https://reqres.in/api/users URL matched");
		
		
		headerMap.put("Content-Type", "application/json");
		
		//jackson API:
		ObjectMapper mapper = new ObjectMapper();
		Users users = new Users("surya", "Automation engineer", "000"); //expected users obejct
		
		//object to json file:
		//mapper.writeValue(new File("./src/test/java/webServicesData/users.json"), users);
		
		//java object to json in String:
		String usersJsonString = mapper.writeValueAsString(users);
		System.out.println(usersJsonString);
		test.log(LogStatus.INFO, "usersJsonString " + usersJsonString);
		log.info("usersJsonString " + usersJsonString);
		
		closebaleHttpResponse = put(url, usersJsonString, headerMap); //call the API
		//closebaleHttpResponse = put(url, usersJsonString);
		// a. Status Code:
		int statusCode = getStatusCode();
		System.out.println("Status Code--->" + statusCode);
		test.log(LogStatus.INFO, "Actual Status Code--->" + statusCode);
		log.info("Actual Status Code--->" + statusCode);
		test.log(LogStatus.INFO, "Expected Status Code--->" + statusCode);
		log.info("Expected Status Code--->" + statusCode);
		Assert.assertEquals(statusCode, Integer.parseInt(StatusCode), "Status code is not 201");
		test.log(LogStatus.INFO, statusCode + "Status code matched");
		log.info(statusCode + "Status code matched");
		
		//2. JsonString:
		getResponseFromJson();
			
		//json to java object:
		Users usersResObj = mapper.readValue(responseString, Users.class); //actual users object
		System.out.println(usersResObj);
		System.out.println(users.getName());
		System.out.println(usersResObj.getName());
		test.log(LogStatus.INFO,  "Actual name is " +usersResObj.getName() );
		log.info("Actual name is " +usersResObj.getName());	
		test.log(LogStatus.INFO,  "Expected name is " +users.getName() );
		log.info("Expected name is " +users.getName());	
		Assert.assertTrue(users.getName().equals(usersResObj.getName()));
		test.log(LogStatus.INFO,  users.getName() + " name matched" );
		log.info(users.getName() + " name matched" );	
		
		System.out.println(users.getJob());
		System.out.println(usersResObj.getJob());
		test.log(LogStatus.INFO,  "Actual job is " +users.getJob() );
		log.info("Actual job is " +users.getJob());	
		test.log(LogStatus.INFO,  "Expected job is " +usersResObj.getJob() );
		log.info("Expected job is " +usersResObj.getJob());
		Assert.assertTrue(users.getJob().equals(usersResObj.getJob()));
		test.log(LogStatus.INFO,  users.getName() + " job matched" );
		log.info(users.getName() + " job matched" );
		
		System.out.println(usersResObj.getId());
		test.log(LogStatus.INFO,  "Expected Id is " +usersResObj.getId() );
		log.info("Expected Id is " +usersResObj.getId());;
		test.log(LogStatus.INFO,  "Actual Id is " +users.getId() );
		log.info("Actual Id is " +users.getId());;
		Assert.assertTrue(users.getId().equals(usersResObj.getId()));
		test.log(LogStatus.INFO,  users.getId() + " id matched" );
		log.info(users.getId() + " id matched" );
		
		System.out.println(usersResObj.getUpdatedAt());
		test.log(LogStatus.INFO,  "Updated At " +usersResObj.getUpdatedAt() );
		log.info("Updated At " +usersResObj.getUpdatedAt());
		
		
	}

}
