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
import paymatePages.CreditMantriSignUp;

public class CreditMantriSignUpTest extends TestBase{

	CreditMantriSignUp creditMantriSignUp;
	
	@DataProvider
	public Object[][] testData() throws Exception {
		Object data[][] = TestDataProvider.excelReader(Repository.getProperty("CreditMantriExcelPath"),
				Repository.getProperty("CreditMantri_signup"));
		return data;
	}
	
	@BeforeClass
	public void TestEngine() throws Exception {
		try {
			creditMantriSignUp=new CreditMantriSignUp(driver);
			
			init();
			
			log.info(getClass().getName() + "Test is started");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test(dataProvider = "testData")
	public void creditMantriSignUpTest(String mobileNumber, String PANNumber,String emailId,String PinCode,String Runmode) throws Exception {
		

		try {
			test.assignCategory("RegressionTest");
			if (Runmode.equalsIgnoreCase("N")) {
				throw new SkipException("Runmode flag set as No");
			}
			Screenshot.infoScreenshot(driver, "Home Page");
			CreditMantriSignUp.signUp(mobileNumber, PANNumber, emailId, PinCode);

		} catch (Exception e) {
			e.getMessage();
		}

	
	}
	
	
	/*@AfterClass(alwaysRun = true)
	public void endreport() {
		closeBrowser();
		
	}*/
}
