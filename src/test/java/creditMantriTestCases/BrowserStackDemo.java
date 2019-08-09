package creditMantriTestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Common.Screenshot;
import TestBase.TestBase;
import creditMantriPages.BorkenLinks;

public class BrowserStackDemo extends TestBase{

	 public  final String USERNAME = "suryakiran14";
	  public  final String AUTOMATE_KEY = "TWtczMYygyckEgLGz6ND";
	  public  final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	  BorkenLinks borkenLinks;
	
	
	
	
	@BeforeClass
	public void TestEngine() throws Exception {
		try {
			DesiredCapabilities caps = new DesiredCapabilities();
		    caps.setCapability("browser", "Chrome");
		    caps.setCapability("browser_version", "74.0");
		    caps.setCapability("os", "Windows");
		    caps.setCapability("os_version", "10");
		    caps.setCapability("resolution", "1024x768");

		    driver = new RemoteWebDriver(new java.net.URL(URL), caps);
		    driver.get("http://www.creditmantri.com");
			
			//init();
			
			log.info(getClass().getName() + "Test is started");
		} catch (Exception e) {
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
		closeBrowser();
		
	}


}
