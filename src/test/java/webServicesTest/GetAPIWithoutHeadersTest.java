package webServicesTest;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Common.TestDataProvider;
import TestBase.TestBase;
import webServicesPages.GetAPIWithoutHeaders;

public class GetAPIWithoutHeadersTest extends TestBase {


	@DataProvider
	public Object[][] testData() throws Exception {
		Object data[][] = TestDataProvider.excelReader(Repository.getProperty("excelSheetPath"), "getApi");
		return data;
	}

	@BeforeClass
	public void setUp() throws IOException {

		webServicesInit();

	}

	@Test(dataProvider = "testData")
	public void getAPIWithoutHeadersTest(String apiURL, String StatusCode, String PerPageValue, String TotalValue, String LastName, String Id,
			String Avatar, String FirstName) throws ClientProtocolException, IOException, NumberFormatException, JSONException {
		
		GetAPIWithoutHeaders.getAPItestWithoutHeaders(apiURL, StatusCode, PerPageValue, TotalValue, LastName, Id, Avatar, FirstName);
		
	}

	@AfterClass(alwaysRun = true)
	public void endreport() {
		//closeReport();
	}

}
