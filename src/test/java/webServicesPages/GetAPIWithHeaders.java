package webServicesPages;


import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.Status;
import com.mysql.cj.xdevapi.Result;

import Common.ExtentTestManager;
import TestBase.TestBase;



public class GetAPIWithHeaders extends TestBase {

	public static void getAPITestWithHeaders(String apiURL, String StatusCode, String PerPageValue, 
			String TotalValue, String LastName, String Id,
			String Avatar, String FirstName) throws ClientProtocolException, IOException, NumberFormatException, JSONException {

		
		
		headerMap.put("Content-Type", "application/json");
		// headerMap.put("username", "test@amazon.com");
		// headerMap.put("password", "test213");
		// headerMap.put("Auth Token", "12345");

		// ***** URL verification *****
		serviceUrl = Repository.getProperty("URL");
		url = serviceUrl + apiURL;
		ExtentTestManager.getTest().log(Status.INFO, "Hellooo started base test3");
		ExtentTestManager.getTest().log(Status.INFO, "Actual Testing get URI- " + url);
		log.info("Actual Testing get URI- " + url);
		ExtentTestManager.getTest().log(Status.INFO, "expected Testing get URI- https://reqres.in/api/users ");
		log.info("expected Testing get URI- https://reqres.in/api/users");
		Assert.assertTrue(url.contains("https://reqres.in/api/users"));
		ExtentTestManager.getTest().log(Status.INFO, "https://reqres.in/api/users URL matched" + ITestResult.SUCCESS);
		log.info("https://reqres.in/api/users URL matched");

		closebaleHttpResponse = get(url, headerMap);

		// a. Status Code:
		int statusCode = getStatusCode();
		System.out.println("Status Code--->" + statusCode);
		ExtentTestManager.getTest().log(Status.INFO, "Actual Status Code--->" + statusCode);
		log.info("Actual Status Code--->" + statusCode);
		ExtentTestManager.getTest().log(Status.INFO, "Expected Status Code--->" + statusCode);
		log.info("Expected Status Code--->" + statusCode);
		Assert.assertEquals(statusCode, Integer.parseInt(StatusCode), "Status code is not 200");
		ExtentTestManager.getTest().log(Status.INFO, statusCode + "Status code matched");
		log.info(statusCode + "Status code matched");

		// b. Json String:
		getResponseFromJson();

		// single value assertion:
		// per_page:
		ExtentTestManager.getTest().log(Status.INFO, "***********************************************************************************");
		String perPageValue = getValueByJPath(responseJson, "/per_page");
		ExtentTestManager.getTest().log(Status.INFO, "single value assertion:");
		System.out.println("Actual value of per page is-->" + perPageValue);
		ExtentTestManager.getTest().log(Status.INFO, "Actual value of per page is-->" + perPageValue);
		log.info("Actual value of per page is-->" + perPageValue);
		ExtentTestManager.getTest().log(Status.INFO, "Expected value of per page is-->" + perPageValue);
		log.info("Expected value of per page is-->" + perPageValue);
		Assert.assertEquals(perPageValue, PerPageValue);
		ExtentTestManager.getTest().log(Status.INFO, perPageValue + " perPageValue matched");
		log.info(perPageValue + " perPageValue matched");

		// total:
		String totalValue = getValueByJPath(responseJson, "/total");
		System.out.println("Acutal value of total is-->" + totalValue);
		ExtentTestManager.getTest().log(Status.INFO, "Actual value of total is-->" + totalValue);
		log.info("Actual value of total is-->" + totalValue);
		ExtentTestManager.getTest().log(Status.INFO, "Expected value of total is-->" + TotalValue);
		log.info("Expected value of total is-->" + TotalValue);
		Assert.assertEquals(totalValue, TotalValue);
		ExtentTestManager.getTest().log(Status.INFO, TotalValue + " TotalValue matched");
		log.info(TotalValue + " TotalValue matched");

		// get the value from JSON ARRAY:
		String lastName = getValueByJPath(responseJson, "/data[0]/last_name");
		String id = getValueByJPath(responseJson, "/data[0]/id");
		String avatar = getValueByJPath(responseJson, "/data[0]/avatar");
		String firstName = getValueByJPath(responseJson, "/data[0]/first_name");

		/*test.log(Status.INFO, "***********************************************************************************");
		test.log(Status.INFO, "get the value from JSON ARRAY:");
		log.info("get the value from JSON ARRAY:");
		System.out.println(lastName);
		test.log(Status.INFO, "Actual lastName is-->" + lastName);
		log.info("Actual lastName is-->" + lastName);
		test.log(Status.INFO, "Expected lastName is-->" + LastName);
		log.info("Expected lastName is-->" + LastName);
		Assert.assertTrue(lastName.contains(LastName));
		test.log(Status.INFO, LastName + " LastName matched");
		log.info(LastName + " LastName matched");

		System.out.println(id);
		test.log(Status.INFO, "Actual id is-->" + id);
		log.info("Actual id is-->" + id);
		test.log(Status.INFO, "Expected id is-->" + Id);
		log.info("Expected id is-->" + Id);
		Assert.assertEquals(id, Id);
		test.log(Status.INFO, LastName + " id matched");
		log.info(LastName + " id matched");

		System.out.println(avatar);
		test.log(Status.INFO, "Actual avatar name is-->" + avatar);
		log.info("Actual avatar name is-->" + avatar);
		test.log(Status.INFO, "Expected avatar name is-->" + Avatar);
		log.info("Expected avatar name is-->" + Avatar);
		Assert.assertTrue(avatar.contains(Avatar));
		test.log(Status.INFO, Avatar + " avatar name matched");
		log.info(Avatar + " avatar name matched");

		System.out.println(firstName);
		test.log(Status.INFO, "Actual firstName is-->" + firstName);
		log.info("Actual firstName is-->" + firstName);
		test.log(Status.INFO, "Expected firstName is-->" + FirstName);
		log.info("Expected firstName is-->" + FirstName);
		Assert.assertTrue(firstName.contains(FirstName));
		test.log(Status.INFO, firstName + " firstName matched");
		log.info(firstName + " firstName matched");

*/		getAllHeaders();

		/*
		 * {
 	"per_page": 3,
 	"total": 12,
 	"data": [{
 		"last_name": "Bluth",
 		"id": 1,
 		"avatar": "https://s3.amazonaws.com/uifaces/faces/twitter/calebogden/128.jpg",
 		"first_name": "George",
 		"email": "george.bluth@reqres.in"
 	}, {
 		"last_name": "Weaver",
 		"id": 2,
 		"avatar": "https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg",
 		"first_name": "Janet",
 		"email": "janet.weaver@reqres.in"
 	}, {
 		"last_name": "Wong",
 		"id": 3,
 		"avatar": "https://s3.amazonaws.com/uifaces/faces/twitter/olegpogodaev/128.jpg",
 		"first_name": "Emma",
 		"email": "emma.wong@reqres.in"
 	}],
 	"page": 1,
 	"total_pages": 4
 }
 */
	}
}
