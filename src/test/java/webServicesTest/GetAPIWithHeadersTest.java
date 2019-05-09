package webServicesTest;

import java.io.IOException;


import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Common.DataProviderClass;
import Common.TestDataProvider;
import TestBase.TestBase;
import webServicesPages.GetAPIWithHeaders;

@Listeners({Common.TestListner.class})
public class GetAPIWithHeadersTest extends TestBase {

	@BeforeClass
	public void setUp() throws IOException {

		webServicesInit();

	}

	@Test(dataProvider = "getAPIData", dataProviderClass = DataProviderClass.class,description="Invalid Login Scenario with empty username and password.")
	public void getAPIWithoutHeadersTest(String apiURL, String StatusCode, String PerPageValue, String TotalValue,
			String LastName, String Id, String Avatar, String FirstName) throws ClientProtocolException, IOException {

		GetAPIWithHeaders.getAPITestWithHeaders(apiURL, StatusCode, PerPageValue, TotalValue, LastName, Id, Avatar,
				FirstName);

	}

	@AfterClass(alwaysRun = true)
	public void endreport() {
		closeReport();
	}
}
