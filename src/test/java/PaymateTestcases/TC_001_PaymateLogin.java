package PaymateTestcases;

import java.io.IOException;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Common.Screenshot;
import Common.SentMail;
import Common.TestDataProvider;
import Common.VideoRecorder;
import TestBase.TestBase;
import paymatePages.PaymateLogin;

public class TC_001_PaymateLogin extends TestBase{
	//Verify whether the user is able to login in to the Paymate application
	PaymateLogin paymateLogin;
	
	
	@DataProvider
	public Object[][] testData() throws Exception {
		Object data[][] = TestDataProvider.excelReader(Repository.getProperty("PaymateTestDataFilePath"),"Paymate_Login");
		return data;
	}
	
	@BeforeClass
	public void TestEngine() throws Exception {
		try {
			paymateLogin=new PaymateLogin(driver);
			
			init();
			//crossBrowserinit(browser);
			//videoRecord.startRecording();
			log.info(getClass().getName() + "Test is started");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test(dataProvider="testData")
	public void PaymateLoginTest(String uname,String pasword,String runmode) {
		
		try {
			test.assignCategory("RegressionTest");
			if (runmode.equalsIgnoreCase("N")) {
				throw new SkipException("Runmode flag set as No");
			}
			Screenshot.infoScreenshot(driver, "Paymate login page");
			PaymateLogin.paymateLogin(uname, pasword);
			Screenshot.infoScreenshot(driver, "Paymate page after login ");
	
		} catch (Exception e) {
			e.getMessage();
			
		}
	}
	
	
	/*@AfterClass(alwaysRun = true)
	public void endreport() {
		closeBrowser();
		
	}*/
	

}
