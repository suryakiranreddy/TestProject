package webServicesTest;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Common.TestDataProvider;
import TestBase.TestBase;
import webServicesPages.PostAPI;


public class PostAPITset extends TestBase {
	
	@DataProvider
	public Object[][] testData() throws Exception {
		Object data[][] = TestDataProvider.excelReader(Repository.getProperty("excelSheetPath"), "postApi");
		return data;
	}
	
	@BeforeClass
	public void setUp() throws IOException {

		webServicesInit();

	}

	@Test(dataProvider = "testData")
	public void postAPITset(String apiURL, String StatusCode) throws ClientProtocolException, IOException {
		
		PostAPI.postAPITest(apiURL, StatusCode);
		
	}

	@AfterClass(alwaysRun = true)
	public void endreport() { 
		closeReport();
	}

}
