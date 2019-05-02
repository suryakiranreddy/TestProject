package lunch2desk_TestCases;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Common.TestDataProvider;
import TestBase.TestBase;
import lunch2Desk_pages.Logout;
import lunch2Desk_pages.SellerLogin;

public class TC02_SellerLoginTest extends TestBase {

	SellerLogin sellerLogin;
	Logout logout;

	@DataProvider
	public Object[][] testData() throws Exception {
		Object data[][] = TestDataProvider.excelReader(Repository.getProperty("CreditMantriExcelPath"),"sellerlogin");
		return data;
	}

	@BeforeClass
	public void TestEngine() {
		try {
			sellerLogin = new SellerLogin(driver);
			logout = new Logout(driver);
			init();
			log.info(getClass().getName() + "Test is started");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "testData")
	public void sellerLoginTest(String uname, String password, String Runmode) throws Exception {

		try {
			test.assignCategory("RegressionTest");
			if (Runmode.equalsIgnoreCase("N")) {
				throw new SkipException("Runmode flag set as No");
			}
			SellerLogin.sellerLogin(uname, password);
			Logout.logout();
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}

}
	@AfterClass(alwaysRun = true)
	public void endreport() {
		closeBrowser();
	}
}
