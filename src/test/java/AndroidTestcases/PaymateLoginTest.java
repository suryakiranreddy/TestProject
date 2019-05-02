package AndroidTestcases;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import AndroidPages.FlipCart;
import AndroidPages.WiFiConnectionPage;
import AndroidPages.paymateLogin;
import Common.TestDataProvider;
import TestBase.AndroidTestBase;

public class PaymateLoginTest extends AndroidTestBase {
	
	@DataProvider
	public Object[][] testData() throws Exception {
		Object data[][] = TestDataProvider.excelReader(Repository.getProperty("AndroidTestingExcelPath"), "wifi");
		return data;
	}

	@BeforeClass
	public void TestEngine() throws IOException {
		try {
			androidInit();	
			//startServerr();
			//desiredCapabilities();
			
			log.info(getClass().getName() + "Test is started");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Test(dataProvider = "testData")
	public void wifiConnectionPageTest(String ScreenOrientation, String PreferenceExpectedTxt, String WiFiname) throws IOException, InterruptedException {
		
		desiredCapabilities();
		WiFiConnectionPage.wiFiConnection(ScreenOrientation, PreferenceExpectedTxt, WiFiname);
		stopServer1();
		//closedriver();
		
	}
	
	/*@Test
	public void wifiConnectionPageTest() throws Exception {
		
		desiredCapabilities();
		FlipCart.flipcart();
		//paymateLogin.paymteLogin();
		//closedriver();
		
	}
*/
	@AfterClass(alwaysRun = true)
	public void endreport() {

		closeReport();

	}

}
