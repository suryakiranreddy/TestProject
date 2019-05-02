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
import kvbNetBankingPages.NEFT_FundsTransfer;
import kvbNetBankingPages_sikuli.KVB_Login;

public class NEFT_FundsTransferTest extends TestBase {

	KVB_Login kVB_Login;
	NEFT_FundsTransfer nEEFT;

	@DataProvider
	public Object[][] testData() throws Exception {
		Object data[][] = TestDataProvider.excelReader(Repository.getProperty("KVBNETBANKINGExcelPath"),
				Repository.getProperty("NEFT"));
		return data;
	}

	@BeforeClass
	public void TestEngine() {
		try {

			kVB_Login = new KVB_Login(driver);
			nEEFT = new NEFT_FundsTransfer(driver);
			init();
			log.info(getClass().getName() + "Test is started");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "testData")
	public void NEFT_Transaction(String username, String passowrd, String sourceAccountName, String BeneficiaryId,
			String TransferAmount, String Narrative, String TransactionPin, String Runmode) throws Exception {

		try {
			test.assignCategory("RegressionTest");
			if (Runmode.equalsIgnoreCase("N")) {
				throw new SkipException("Runmode flag set as No");
			}
			Screenshot.infoScreenshot(driver, "kvb before login");
			kVB_Login.login(username, passowrd);
			nEEFT.NEFTTransaction(sourceAccountName, BeneficiaryId, TransferAmount, Narrative, TransactionPin);

		} catch (Exception e) {
			e.getMessage();
		}
	}

	/*@AfterClass(alwaysRun = true)
	public void endreport() {
		closeBrowser();
	}*/

}
