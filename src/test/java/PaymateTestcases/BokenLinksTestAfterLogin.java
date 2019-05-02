package PaymateTestcases;

import java.io.IOException;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Common.Screenshot;
import Common.TestDataProvider;
import TestBase.TestBase;
import creditMantriPages.BorkenLinks;
import paymatePages.CreditMantriLogin;

public class BokenLinksTestAfterLogin  extends TestBase {

	CreditMantriLogin creditMantriLogin;
	BorkenLinks borkenLinks;

	@DataProvider
	public Object[][] testData() throws Exception {
		Object data[][] = TestDataProvider.excelReader(Repository.getProperty("CreditMantriExcelPath"),
				Repository.getProperty("CreditMantri_Login"));
		return data;
	}

	@BeforeClass
	public void TestEngine() {
		try {
			creditMantriLogin = new CreditMantriLogin(driver);
		

			init();
			log.info(getClass().getName() + "Test is started");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "testData")
	public void bokenLinksTestAfterLogin(String emailId,String passwordd,String Runmode) throws Exception {

		try {
			test.assignCategory("RegressionTest");
			if (Runmode.equalsIgnoreCase("N")) {
				throw new SkipException("Runmode flag set as No");
			}
			Screenshot.infoScreenshot(driver, "Home Page");
			CreditMantriLogin.login(emailId, passwordd);
			//borkenLinks.bokenLinks();

		} catch (Exception e) {
			e.getMessage();
		}
	}

	@AfterClass(alwaysRun = true)
	public void endreport() {
		closeBrowser();
	}


}
