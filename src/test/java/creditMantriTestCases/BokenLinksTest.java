package creditMantriTestCases;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Common.Screenshot;
import TestBase.TestBase;
import creditMantriPages.BorkenLinks;


public class BokenLinksTest extends TestBase{

	BorkenLinks borkenLinks;
	
	
	
	@BeforeClass
	public void TestEngine() throws Exception {
		try {
			
			
			init();
			
			log.info(getClass().getName() + "Test is started");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test()
	public void brokenLinksTest() throws Exception {
		
		Screenshot.infoScreenshot(driver, "Home Page");
		//BorkenLinks.login();
		System.out.println("hgdasuidyhjasn");
		Thread.sleep(10000);
		BorkenLinks.bokenLinks();	
		
		
	}
	
	
	@AfterClass(alwaysRun = true)
	public void endreport() throws IOException {
		//closeBrowser();
		
	}
	
}
