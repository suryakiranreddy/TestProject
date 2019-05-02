package AndroidTestcases;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import AndroidPages.FlipCart;
import Common.TestDataProvider;
import TestBase.AndroidTestBase;

public class FlipCartTest extends AndroidTestBase {
	
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
	@Test
	public void wifiConnectionPageTest() throws Exception {
		
		desiredCapabilities();
		FlipCart.flipcart();
		closedriver();
		
	}
	@AfterClass(alwaysRun = true)
	public void endreport() {

		closeReport();

	}
}
