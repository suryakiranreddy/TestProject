package creditMantriTestCases;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Common.Screenshot;
import TestBase.AndroidTestBase;
import creditMantriPages.Android_BrokenLinksPage;
import creditMantriPages.BorkenLinks;

public class Android_BrokenLinksTestCase extends AndroidTestBase {

	Android_BrokenLinksPage android_BrokenLinksPage;

	@BeforeClass
	public void TestEngine() throws Exception {
		try {

			webDesiredCapabilities();

			log.info(getClass().getName() + "Test is started");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test()
	public void bokenLinksTest() throws Exception {

		android_BrokenLinksPage.bokenLinks();

	}

	@AfterClass(alwaysRun = true)
	public void endreport() throws IOException {
		closedriver();
		closeReport();

	}

}
