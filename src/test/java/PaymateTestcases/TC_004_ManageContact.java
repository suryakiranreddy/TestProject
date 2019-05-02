package PaymateTestcases;

import java.io.IOException;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Common.Screenshot;
import Common.TestDataProvider;
import Common.VideoRecorder;
import TestBase.TestBase;
import paymatePages.ManageContacts;
import paymatePages.PaymateLogin;
import paymatePages.PaymateLogout;

public class TC_004_ManageContact extends TestBase{
	
	PaymateLogin paymateLogin;
	PaymateLogout paymateLogout;
	ManageContacts manageContacts;
	
	
	@DataProvider
	public Object[][] testData() throws Exception {
		Object data[][] = TestDataProvider.excelReader(Repository.getProperty("PaymateTestDataFilePath"),"ManageContact");
		return data;
	}
	
	@BeforeClass	
	public void TestEngine() throws Exception {
		try {
			paymateLogin=new PaymateLogin(driver);
			paymateLogout=new PaymateLogout(driver);
			manageContacts=new ManageContacts(driver);			
			init();
			//crossBrowserinit(browser);
			//videoRecord.startRecording();
			log.info(getClass().getName() + "Test is started");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test(dataProvider="testData")
	public void ManageContactTest(String uname,String pasword,String Phnum, String runmode) {
		
		try {
			test.assignCategory("RegressionTest");
			if (runmode.equalsIgnoreCase("N")) {
				throw new SkipException("Runmode flag set as No");
			}
			Screenshot.infoScreenshot(driver, "Paymate login page");
			PaymateLogin.paymateLogin(uname, pasword);
			Screenshot.infoScreenshot(driver, "Paymate page after login ");
			ManageContacts.manageContacts(Phnum);
			Screenshot.infoScreenshot(driver, "manage contact page ");
			PaymateLogout.paymateLogout();
			Screenshot.infoScreenshot(driver, "Paymate page after logout ");
			//videoRecord.stopRecording();
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
	
	
	@AfterClass(alwaysRun = true)
	public void endreport() throws Exception {
		closeBrowser();
		
	}
}

