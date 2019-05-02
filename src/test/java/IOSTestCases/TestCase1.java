package IOSTestCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import IOSPages.Lunch2DeskMobileWeb;
import IOSPages.Page1;
import TestBase.IOSTestBase;

public class TestCase1 extends IOSTestBase{
	
	
	@BeforeClass
	public void TestEngine() {
		try {
			IosInit();
			startServer();
			log.info(getClass().getName() + "Test is started");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/*@Test
	@Parameters({"deviceName","wda", "port"})
	public void testCase1(String deviceName , int wda, int port) throws Exception {
		desiredCapabilities(deviceName, wda, port);
		Page1.page1();	
		closedriver();
		
}
	*/
	
	@Test
	public void testCase1() throws Exception {
		desiredCapabilities();
		Page1.page1();	
		closedriver();
		
}
	
	@AfterClass(alwaysRun = true)
	public void endreport() {
		
		closeReport();
		stopServer();

	}

	
	
	
	
	
}
