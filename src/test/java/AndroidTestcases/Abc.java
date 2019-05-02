package AndroidTestcases;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import AndroidPages.WiFiConnectionPage;
import Common.TestDataProvider;
import TestBase.AndroidTestBase;

public class Abc extends AndroidTestBase {

	@DataProvider
	public Object[][] testData() throws Exception {
		Object data[][] = TestDataProvider.excelReader(Repository.getProperty("AndroidTestingExcelPath"), "WiFiSettings_landscape");
		return data;
	}

	
	@BeforeClass
	public void TestEngine() throws IOException {
		try {
			androidInit();
			//desiredCapabilities();
			//webDesiredCapabilities();
			log.info(getClass().getName() + "Test is started");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Test(dataProvider = "testData")
	public void test(String ScreenOrientation, String PreferenceExpectedTxt, String WiFiname) throws IOException, InterruptedException {
		//startServer();
		//desiredCapabilities();
		//WiFiConnectionPage.wiFiConnection(ScreenOrientation, PreferenceExpectedTxt, WiFiname);
		//closedriver();
	}
	
	@Test
	public void wifiConnectionPageTest() throws Exception {
		//webDesiredCapabilities();
		//startServer();
		desiredCapabilities();
		WiFiConnectionPage.DargndDrop();
		//WiFiConnectionPage.sellerLogin("xxxx", "yyyy");
		//closedriver();
		
	}

	@AfterClass(alwaysRun = true)
	public void endreport() {

		closeReport();

	}
}
