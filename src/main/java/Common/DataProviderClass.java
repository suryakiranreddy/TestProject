package Common;

import org.testng.annotations.DataProvider;

import TestBase.TestBase;

public class DataProviderClass extends TestBase{
	
	@DataProvider(name="getAPIData")
	public static Object[][] testData() throws Exception {
		Object data[][] = TestDataProvider.excelReader(Repository.getProperty("excelSheetPath"), "getApi");
		return data;
	}

}
