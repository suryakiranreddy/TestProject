package IOSTestCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import IOSPages.Page1;
import IOSPages.Page2;
import TestBase.IOSTestBase;

public class TestCase2  extends IOSTestBase{
	
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
	
	@Test
	public void testCase2() throws Exception {
		desiredCapabilities();
		Page2.page2();
		closedriver();
}
	@AfterClass(alwaysRun = true)
	public void endreport() {
		
		closeReport();
		stopServer();
	}

}
