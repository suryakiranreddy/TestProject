package kvbNetBankingTestCases;

import java.io.IOException;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Common.Screenshot;
import Common.TestDataProvider;
import TestBase.TestBase;
import kvbNetBankingPages.AddBeneficiary;
import kvbNetBankingPages_sikuli.KVB_Login;

public class AddBeneficiaryTest extends TestBase {

	AddBeneficiary addBeneficiary;
	KVB_Login kVB_Login;

	@DataProvider
	public Object[][] testData() throws Exception {
		Object data[][] = TestDataProvider.excelReader(Repository.getProperty("KVBNETBANKINGExcelPath"),
				Repository.getProperty("addBeneficiary"));
		return data;
	}

	@BeforeClass
	public void TestEngine() {
		try {
			addBeneficiary = new AddBeneficiary(driver);
			kVB_Login = new KVB_Login(driver);

			init();
			log.info(getClass().getName() + "Test is started");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "testData")
	public void addBeneficiaryTest(String username, String passowrd, String TransactionType, String BeneficiaryNickname,
			String BeneficiaryName, String BeneficiaryAccountNo, String BeneficiaryAccountType, String ifsccode,
			String TransactionPin, String Runmode) throws Exception {

		try {
			test.assignCategory("RegressionTest");
			if (Runmode.equalsIgnoreCase("N")) {
				throw new SkipException("Runmode flag set as No");
			}
			Screenshot.infoScreenshot(driver, "kvb before login");
			kVB_Login.login(username, passowrd);

			//addBeneficiary.addBeneficiary(TransactionType, BeneficiaryNickname, BeneficiaryName, BeneficiaryAccountNo, BeneficiaryAccountType, ifsccode, TransactionPin);

		} catch (Exception e) {
			e.getMessage();
		}
	}

	@AfterClass(alwaysRun = true)
	public void endreport() {
		closeBrowser();
	}

}
