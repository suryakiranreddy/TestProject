package PaymateTestcases;

import java.io.IOException;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Common.Screenshot;

import Common.SentMail;
import Common.TestDataProvider;
import TestBase.TestBase;
import paymatePages.PaymateLogin;
import paymatePages.PaymateLogout;

public class TC_002_PaymateLogout extends TestBase{
	//Verify whether the user is able to Logout in to the Paymate application
	PaymateLogin paymateLogin;
	PaymateLogout paymateLogout;
	SentMail sentMail;
	
	@DataProvider
	public Object[][] testData() throws Exception {
		Object data[][] = TestDataProvider.excelReader(Repository.getProperty("PaymateTestDataFilePath"),"Paymate_Login");
		return data;
	}
	
	@BeforeClass
	@Parameters("browser")
	public void TestEngine(String browser) {
		try {
			paymateLogin=new PaymateLogin(driver);
			paymateLogout=new PaymateLogout(driver);
			sentMail= new SentMail();
			//init();
			crossBrowserinit(browser);
			log.info(getClass().getName() + "Test is started");
			//test.log(LogStatus.INFO, getClass().getName() + "Test is started in "+browser );
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*public void TestEngine() {
		try {
			paymateLogin=new PaymateLogin(driver);
			paymateLogout=new PaymateLogout(driver);
			sentMail= new SentMail();
			init();			
			log.info(getClass().getName() + "Test is started");
			//test.log(LogStatus.INFO, getClass().getName() + "Test is started in "+browser );
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/
	
	@Test(dataProvider="testData")
	public void PaymateLogoutTest(String uname,String pasword,String runmode) {
		
		try {
			test.assignCategory("RegressionTest");
			if (runmode.equalsIgnoreCase("N")) {
				throw new SkipException("Runmode flag set as No");
			}
			Screenshot.infoScreenshot(driver, "Paymate login page");
			PaymateLogin.paymateLogin(uname, pasword);
			Screenshot.infoScreenshot(driver, "Paymate page after login ");
			PaymateLogout.paymateLogout();
			Screenshot.infoScreenshot(driver, "Paymate page after logout ");
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	
	@AfterClass(alwaysRun = true)
	public void endreport() throws Exception {
		closeBrowser();
		
	}
}
