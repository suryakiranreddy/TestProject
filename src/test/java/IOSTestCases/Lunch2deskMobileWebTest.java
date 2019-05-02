package IOSTestCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import AndroidPages.MobileWeb;
import Common.TestDataProvider;
import IOSPages.IOSDemo;
import IOSPages.Lunch2DeskMobileWeb;
import TestBase.IOSTestBase;

public class Lunch2deskMobileWebTest extends IOSTestBase{

	
	@Test
	@DataProvider
	public Object[][] testData() throws Exception {
		Object data[][] = TestDataProvider.excelReader(Repository.getProperty("CreditMantriExcelPath"),"sellerlogin");
		return data;
	}
	
	@BeforeClass
	public void TestEngine() {
		try {
			IosInit();
			startServer();
			log.info(getClass().getName() + "Test is started");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test(dataProvider = "testData")
	public void sellerLoginTest(String uname, String password, String Runmode) throws Exception {
		browDesiredCapabilities();
		Lunch2DeskMobileWeb.sellerLogin(uname, password);
		closedriver();
		
}
	@AfterClass(alwaysRun = true)
	public void endreport() {
		
		closeReport();
		stopServer();
	}


}
