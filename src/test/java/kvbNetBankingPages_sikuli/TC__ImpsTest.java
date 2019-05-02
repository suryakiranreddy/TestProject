package kvbNetBankingPages_sikuli;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Common.Screenshot;
import Common.TestDataProvider;
import TestBase.TestBase;

public class TC__ImpsTest extends TestBase {
	public static ImpsTransferPage impsPage;
	
	@DataProvider
	public Object[][] testData() throws Exception {
		Object data[][] = TestDataProvider.excelReader(Repository.getProperty("KVBNETBANKINGExcelPath"),
				Repository.getProperty("impsdataSHEET"));
		return data;
	}
	@BeforeClass
	public void beforeTest() {
		try {
			impsPage= new ImpsTransferPage(driver);
			init();
			log.info(getClass().getName() + "Test is started");
		} catch (IOException e) {
			e.printStackTrace();
			log.info("Unable to locate file");
		}
	}

	@Test(dataProvider="testData")
	public void impsTransfer(String username,String password,String amount,String narativeText,String runmode) throws InterruptedException, AWTException{
		
		try {
			test.assignCategory("RegressionTest");
			if (runmode.equalsIgnoreCase("N")) {
				throw new SkipException("Runmode flag set as No");
			}
			Screenshot.infoScreenshot(driver, "ImpsTransferPage");
			impsPage.login(username,password);
			Thread.sleep(3000);
			impsPage.impsTransfer(amount, narativeText);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	  @AfterClass
	    public void endreport()
	    {
	    	//closeBrowser();
	       
	    }


}
