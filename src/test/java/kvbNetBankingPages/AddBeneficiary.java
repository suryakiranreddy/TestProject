package kvbNetBankingPages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import Common.Screenshot;

import TestBase.TestBase;

public class AddBeneficiary extends TestBase {

	private static By payments_link = By.linkText("Payments");
	private static By beneficiaryMaintenance_link = By.linkText("Beneficiary Maintenance");
	private static By beneficiaryMaintenance_txt = By.id("pageheading");
	private static By transactionType = By.xpath(".//*[@id='box']/div[2]/table/tbody/tr[1]/td[2]/select");
	private static By createBeneficiary_btn = By
			.xpath(".//*[@id='box']/div[2]/table/tbody/tr[2]/td[2]/div/ul/li/input");
	private static By beneficiary_Nickname = By.name("fldbeneid");
	private static By beneficiary_name = By.name("fldname");
	private static By beneficiary_paymentType = By.xpath(".//*[@id='box']/div[2]/table/tbody/tr[3]/td[2]/input[2]");
	private static By beneficiary_AccountNo = By.name("fldbeneaccountno");
	private static By beneficiary_AccountType = By.name("fldaccounttypeselect");
	private static By beneficiary_IFSCCode = By.xpath(".//*[@id='tr3']/td[2]/input[2]");
	private static By fldifsccode = By.name("fldifsccode");
	private static By search = By.name("search1");
	private static By select = By.xpath(".//*[@id='box']/div[2]/table/tbody/tr[2]/td[4]/input");
	private static By add = By.xpath(".//*[@id='maintable']/tbody/tr[3]/td/div/div[2]/ul/li[3]/input");
	private static By conform = By.xpath(".//*[@id='maintable']/tbody/tr[3]/td/div/div[2]/ul/li[2]/input");
	private static By transactionPin = By.xpath(".//*[@id='fldtxnpin1']");
	private static By submit = By.xpath(".//*[@id='contentarea']/div/div/ul/li[3]/input");
	private static By message = By.xpath("html/body/div[7]/div/ul/li[1]");
	private static By BeneficiaryId = By.xpath(".//*[@id='box']/div[2]/table/tbody/tr[1]/td[2]");
	private static By TransactionTypee = By.xpath(".//*[@id='box']/table/tbody/tr/td[2]");
	private static By ok = By.xpath(".//*[@id='maintable']/tbody/tr[3]/td/div/div[2]/ul/li/input");

	public AddBeneficiary(WebDriver driver) {
		AddBeneficiary.driver = driver;
	}

	public void addBeneficiary(String TransactionType, String BeneficiaryNickname, String BeneficiaryName,
			String BeneficiaryAccountNo, String BeneficiaryAccountType, String ifsccode, String TransactionPin)
			throws Exception {

		handlingWindow();
		Screenshot.infoScreenshot(driver, "kvb after login");
		test.log(LogStatus.INFO, " **** Paymate addBeneficiary function starts ****");
		log.info("**** Paymate addBeneficiary function starts **** ");
		driver.switchTo().frame("frame_top");
		click(payments_link);
		test.log(LogStatus.INFO, " payments link clicked ");
		log.info(" payments link clicked");
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame_menu");
		click(beneficiaryMaintenance_link);
		test.log(LogStatus.INFO, " Beneficiary Maintenance  link clicked ");
		log.info(" Beneficiary Maintenance  link clicked");
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame_txn");
		String expect_hometxt = "Beneficiary Maintenance";
		String actual_hometxt = getElementText(beneficiaryMaintenance_txt);
		Assert.assertTrue(actual_hometxt.contains(expect_hometxt));
		test.log(LogStatus.INFO, expect_hometxt + " text matched ");
		log.info(expect_hometxt + " text matched");
		Screenshot.infoScreenshot(driver, "Beneficiary Maintenance page");
		selectVisibleText(transactionType, TransactionType);
		test.log(LogStatus.INFO, TransactionType + " TransactionType selected ");
		log.info(TransactionType + " TransactionType selected ");
		click(createBeneficiary_btn);
		test.log(LogStatus.INFO, " Create Beneficiary button clicked ");
		log.info(" Create Beneficiary button clicked ");
		sendkeys(beneficiary_Nickname, BeneficiaryNickname);
		test.log(LogStatus.INFO, BeneficiaryNickname + " Beneficiary Nickname entered ");
		log.info(BeneficiaryNickname + " Beneficiary Nickname entered ");
		sendkeys(beneficiary_name, BeneficiaryName);
		test.log(LogStatus.INFO, BeneficiaryName + " Beneficiary Name entered ");
		log.info(BeneficiaryName + " Beneficiary Name entered ");
		click(beneficiary_paymentType);
		test.log(LogStatus.INFO, " beneficiary paymentType selected i.e IFSC ");
		log.info(" beneficiary paymentType selected i.e IFSC");
		sendkeys(beneficiary_AccountNo, BeneficiaryAccountNo);
		test.log(LogStatus.INFO, BeneficiaryAccountNo + " Beneficiary AccountNo entered ");
		log.info(BeneficiaryAccountNo + " Beneficiary AccountNo entered ");
		selectVisibleText(beneficiary_AccountType, BeneficiaryAccountType);
		test.log(LogStatus.INFO, BeneficiaryAccountType + " Beneficiary AccountType selected ");
		log.info(BeneficiaryAccountType + " Beneficiary AccountType selected ");
		click(beneficiary_IFSCCode);
		test.log(LogStatus.INFO, " Beneficiary IFSCCode icon clicked ");
		log.info("Beneficiary IFSCCode icon clicked ");
		driver.switchTo().defaultContent();
		String Addbenwindow = driver.getWindowHandle();
		Set<String> s2 = driver.getWindowHandles();
		Iterator<String> I2 = s2.iterator();
		while (I2.hasNext()) {
			String child_window1 = I2.next();
			if (!Addbenwindow.equals(child_window1)) {
				driver.switchTo().window(child_window1);
				System.out.println(driver.switchTo().window(child_window1).getTitle());
			}
		}
		driver.switchTo().frame("txn");
		sendkeys(fldifsccode, ifsccode);
		test.log(LogStatus.INFO, ifsccode + " ifsc code entered ");
		log.info(ifsccode + " ifsc code entered ");
		click(search);
		test.log(LogStatus.INFO, " search button clicked ");
		log.info(" search button clicked ");
		click(select);
		test.log(LogStatus.INFO, " select button clicked ");
		log.info(" select button clicked ");
		driver.switchTo().window(Addbenwindow);
		driver.switchTo().frame("frame_txn");
		click(add);
		test.log(LogStatus.INFO, " add button clicked ");
		log.info(" add button clicked ");
		Screenshot.infoScreenshot(driver, "Beneficiary Maintenance conform page");
		click(conform);
		test.log(LogStatus.INFO, " conform button clicked ");
		log.info(" conform button clicked ");
		sendkeys(transactionPin, TransactionPin);
		test.log(LogStatus.INFO, TransactionPin + " Transaction Pin entered ");
		log.info(TransactionPin + " Transaction Pin entered ");
		Thread.sleep(60000);
	//	click(submit);
		test.log(LogStatus.INFO, " submit button clicked ");
		log.info(" submit button clicked ");
		String expect_hometxtt = "Beneficiary has been added successfully and will be activated after 3 hours of time.(Instant Activation of GST IFSC RBIS0GSTPMT (NEFT/RTGS))";
		String actual_hometxtt = getElementText(message);
		Assert.assertTrue(actual_hometxtt.contains(expect_hometxtt));
		test.log(LogStatus.INFO,
				"Beneficiary has been added successfully and will be activated after 3 hours of time.(Instant Activation of GST IFSC RBIS0GSTPMT (NEFT/RTGS)) text matched ");
		log.info(
				" Beneficiary has been added successfully and will be activated after 3 hours of time.(Instant Activation of GST IFSC RBIS0GSTPMT (NEFT/RTGS)) text matched ");
		String expect_BeneficiaryId = "PRAVEEN ENHOPS ";
		String actual_BeneficiaryId = getElementText(BeneficiaryId);
		Assert.assertTrue(actual_BeneficiaryId.contains(expect_BeneficiaryId));
		test.log(LogStatus.INFO, expect_BeneficiaryId + " BeneficiaryId matched ");
		log.info(expect_BeneficiaryId + " BeneficiaryId matched");
		String expect_TransactionType = "IMPS Payments";
		String actual_TransactionType = getElementText(TransactionTypee);
		Assert.assertTrue(actual_TransactionType.contains(expect_TransactionType));
		test.log(LogStatus.INFO, expect_TransactionType + " Transaction Type matched ");
		log.info(expect_TransactionType + " Transaction Type matched");
		Screenshot.infoScreenshot(driver, "Beneficiary added ");
		click(ok);
		test.log(LogStatus.INFO, " ok button clicked ");
		log.info(" ok button clicked ");

	}
}
