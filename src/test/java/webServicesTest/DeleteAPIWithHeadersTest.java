package webServicesTest;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Common.TestDataProvider;
import TestBase.TestBase;
import webServicesPages.DeleteAPIWithHeaders;
import webServicesPages.DeleteAPIWithOutHeaders;

public class DeleteAPIWithHeadersTest extends TestBase {
	
	@DataProvider
	public Object[][] testData() throws Exception {
		Object data[][] = TestDataProvider.excelReader(Repository.getProperty("excelSheetPath"), "deleteApi");
		return data;
	}
	
	@BeforeClass
	public void setUp() throws IOException {

		webServicesInit();

	}

	@Test(dataProvider = "testData")
	public void deleteAPIWithHeadersTest(String apiURL, String StatusCode) throws ClientProtocolException, IOException {
		
		DeleteAPIWithHeaders.deleteAPIWithHeaders(apiURL, StatusCode);
		
	}

	@AfterClass(alwaysRun = true)
	public void endreport() {
		closeReport();
	}

	
}
