package AndroidTestcases;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import AndroidPages.WiFiConnectionPage;
import AndroidPages.WifiConnection;
import Common.TestDataProvider;
import TestBase.AndroidTestBase;

public class WifiConnectionTest extends AndroidTestBase {

	@DataProvider
	public Object[][] testData() throws Exception {
		Object data[][] = TestDataProvider.excelReader(Repository.getProperty("AndroidTestingExcelPath"), "wifi");
		return data;
	}

	
	@BeforeClass
	public void TestEngine() throws IOException {
		try {
			androidInit();	
			log.info(getClass().getName() + "Test is started");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Test(dataProvider = "testData")
	public void wifiConnectionPageTest(String ScreenOrientation, String PreferenceExpectedTxt, String WiFiname) throws IOException, InterruptedException {
		
		desiredCapabilities();
		WifiConnection.wiFiConnection(ScreenOrientation, PreferenceExpectedTxt, WiFiname);
		closedriver();
		
	}
	

	@AfterClass(alwaysRun = true)
	public void endreport() {

		closeReport();

	}


}
