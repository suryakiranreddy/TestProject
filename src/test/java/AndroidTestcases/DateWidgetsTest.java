package AndroidTestcases;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import AndroidPages.DateWidgets;
import Common.TestDataProvider;
import TestBase.AndroidTestBase;

public class DateWidgetsTest extends AndroidTestBase {

	@DataProvider
	public Object[][] testData() throws Exception {
		Object data[][] = TestDataProvider.excelReader(Repository.getProperty("AndroidTestingExcelPath"), "dateWidgets");
		return data;
	}

	
	@BeforeClass
	public void TestEngine() throws IOException {
		try {
			androidInit();	
			log.info(getClass().getName() + "Test is started");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Test(dataProvider = "testData")
	public void dateWidgetsTest(String ScreenOrientation) throws IOException, InterruptedException {
		
		desiredCapabilities();
		DateWidgets.dateWidgets(ScreenOrientation);
		closedriver();
		
	}
	

	@AfterClass(alwaysRun = true)
	public void endreport() {

		closeReport();

	}
}
