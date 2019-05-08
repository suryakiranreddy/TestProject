package webServicesPages;

import TestBase.TestBase;
import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import com.relevantcodes.extentreports.LogStatus;

public class GetAPIWithHeaders extends TestBase {

	public static void getAPITestWithHeaders(String apiURL, String StatusCode, String PerPageValue, 
			String TotalValue, String LastName, String Id,
			String Avatar, String FirstName) throws ClientProtocolException, IOException {

		
		
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

		closebaleHttpResponse = get(url, headerMap);

		// a. Status Code:
		int statusCode = getStatusCode();
		System.out.println("Status Code--->" + statusCode);
		test.log(LogStatus.INFO, "Actual Status Code--->" + statusCode);
		log.info("Actual Status Code--->" + statusCode);
		test.log(LogStatus.INFO, "Expected Status Code--->" + statusCode);
		log.info("Expected Status Code--->" + statusCode);
		Assert.assertEquals(statusCode, Integer.parseInt(StatusCode), "Status code is not 200");
		test.log(LogStatus.INFO, statusCode + "Status code matched");
		log.info(statusCode + "Status code matched");

		// b. Json String:
		getResponseFromJson();

		// single value assertion:
		// per_page:
		test.log(LogStatus.INFO, "***********************************************************************************");
		String perPageValue = getValueByJPath(responseJson, "/per_page");
		test.log(LogStatus.INFO, "single value assertion:");
		System.out.println("Actual value of per page is-->" + perPageValue);
		test.log(LogStatus.INFO, "Actual value of per page is-->" + perPageValue);
		log.info("Actual value of per page is-->" + perPageValue);
		test.log(LogStatus.INFO, "Expected value of per page is-->" + perPageValue);
		log.info("Expected value of per page is-->" + perPageValue);
		Assert.assertEquals(perPageValue, PerPageValue);
		test.log(LogStatus.INFO, perPageValue + " perPageValue matched");
		log.info(perPageValue + " perPageValue matched");

		// total:
		String totalValue = getValueByJPath(responseJson, "/total");
		System.out.println("Acutal value of total is-->" + totalValue);
		test.log(LogStatus.INFO, "Actual value of total is-->" + totalValue);
		log.info("Actual value of total is-->" + totalValue);
		test.log(LogStatus.INFO, "Expected value of total is-->" + TotalValue);
		log.info("Expected value of total is-->" + TotalValue);
		Assert.assertEquals(totalValue, TotalValue);
		test.log(LogStatus.INFO, TotalValue + " TotalValue matched");
		log.info(TotalValue + " TotalValue matched");

		// get the value from JSON ARRAY:
		String lastName = getValueByJPath(responseJson, "/data[0]/last_name");
		String id = getValueByJPath(responseJson, "/data[0]/id");
		String avatar = getValueByJPath(responseJson, "/data[0]/avatar");
		String firstName = getValueByJPath(responseJson, "/data[0]/first_name");

		test.log(LogStatus.INFO, "***********************************************************************************");
		test.log(LogStatus.INFO, "get the value from JSON ARRAY:");
		log.info("get the value from JSON ARRAY:");
		System.out.println(lastName);
		test.log(LogStatus.INFO, "Actual lastName is-->" + lastName);
		log.info("Actual lastName is-->" + lastName);
		test.log(LogStatus.INFO, "Expected lastName is-->" + LastName);
		log.info("Expected lastName is-->" + LastName);
		Assert.assertTrue(lastName.contains(LastName));
		test.log(LogStatus.INFO, LastName + " LastName matched");
		log.info(LastName + " LastName matched");

		System.out.println(id);
		test.log(LogStatus.INFO, "Actual id is-->" + id);
		log.info("Actual id is-->" + id);
		test.log(LogStatus.INFO, "Expected id is-->" + Id);
		log.info("Expected id is-->" + Id);
		Assert.assertEquals(id, Id);
		test.log(LogStatus.INFO, LastName + " id matched");
		log.info(LastName + " id matched");

		System.out.println(avatar);
		test.log(LogStatus.INFO, "Actual avatar name is-->" + avatar);
		log.info("Actual avatar name is-->" + avatar);
		test.log(LogStatus.INFO, "Expected avatar name is-->" + Avatar);
		log.info("Expected avatar name is-->" + Avatar);
		Assert.assertTrue(avatar.contains(Avatar));
		test.log(LogStatus.INFO, Avatar + " avatar name matched");
		log.info(Avatar + " avatar name matched");

		System.out.println(firstName);
		test.log(LogStatus.INFO, "Actual firstName is-->" + firstName);
		log.info("Actual firstName is-->" + firstName);
		test.log(LogStatus.INFO, "Expected firstName is-->" + FirstName);
		log.info("Expected firstName is-->" + FirstName);
		Assert.assertTrue(firstName.contains(FirstName));
		test.log(LogStatus.INFO, firstName + " firstName matched");
		log.info(firstName + " firstName matched");

		getAllHeaders();

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
