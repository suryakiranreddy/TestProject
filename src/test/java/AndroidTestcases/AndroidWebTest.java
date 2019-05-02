package AndroidTestcases;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import AndroidPages.DateWidgets;
import AndroidPages.MobileWeb;
import Common.TestDataProvider;
import TestBase.AndroidTestBase;
import lunch2Desk_pages.Logout;
import lunch2Desk_pages.SellerLogin;

public class AndroidWebTest extends  AndroidTestBase{
	
	@DataProvider
	public Object[][] testData() throws Exception {
		Object data[][] = TestDataProvider.excelReader(Repository.getProperty("CreditMantriExcelPath"),"sellerlogin");
		return data;
	}
	
	@BeforeClass
	public void TestEngine() {
		try {
			//androidInit();	
			webDesiredCapabilities();
			log.info(getClass().getName() + "Test is started");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test(dataProvider = "testData")
	public void sellerLoginTest(String uname, String password, String Runmode) throws Exception {

		MobileWeb.sellerLogin(uname, password);
		
}
	@AfterClass(alwaysRun = true)
	public void endreport() {
		closedriver();
		closeReport();

	}
}
