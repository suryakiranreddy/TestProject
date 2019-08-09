package Common;

import org.testng.annotations.DataProvider;

import TestBase.TestBase;

public class DataProviderClass extends TestBase{
	
	@DataProvider(name="login")
	public static Object[][] login() throws Exception {
		Object data[][] = TestDataProvider.excelReader(Repository.getProperty("excelSheetPath"), "login");
		return data;
	}
/*	@DataProvider(name="getAPIData")
	public static Object[][] registrartion() throws Exception {
		Object data[][] = TestDataProvider.excelReader(Repository.getProperty("excelSheetPath"), "res");
		return data;
	}
	@DataProvider(name="getAPIData")
	public static Object[][] sbi_cc() throws Exception {
		Object data[][] = TestDataProvider.excelReader(Repository.getProperty("excelSheetPath"), "sbi");
		return data;
	}
	@DataProvider(name="getAPIData")
	public static Object[][] Yesbank_cc() throws Exception {
		Object data[][] = TestDataProvider.excelReader(Repository.getProperty("excelSheetPath"), "yes");
		return data;
	}*/

}
