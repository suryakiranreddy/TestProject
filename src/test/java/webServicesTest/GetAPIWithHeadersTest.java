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
import Common.TestListner;
import TestBase.TestBase;
import webServicesPages.GetAPIWithHeaders;

@Listeners({Common.TestListner.class})
public class GetAPIWithHeadersTest extends TestBase {

	@BeforeClass
	public void setUp() throws IOException {

		webServicesInit();

	}

	@Test(dataProvider = "getAPIData", dataProviderClass = DataProviderClass.class,description="Invalid Login Scenario with empty username and password.")
	public void getAPIWithoutHeadersTest(String customerType, String mobilnumber) throws ClientProtocolException, IOException {

		GetAPIWithHeaders.getAPITestWithHeaders(customerType, mobilnumber);

	}

	@AfterClass(alwaysRun = true)
	public void endreport() {
		//closeReport();
	}
}
