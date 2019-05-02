package kvbNetBankingPages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import Common.Screenshot;
import TestBase.TestBase;

public class NEFT_FundsTransfer extends TestBase {

	private static By payments_link = By.linkText("Payments");
	private static By NEFT_Funds_Transfer = By.linkText("NEFT Funds Transfer");
	private static By sourceAccount = By.xpath(".//*[@id='fldsourceaccount']");
	private static By beneficiaryName = By.xpath(".//*[@id='fldbenenameanchor']");
	private static By beneficiaryId = By.xpath(".//*[@id='fldidbene']");
	private static By search = By.xpath(".//*[@id='contentarea']/div[1]/div[1]/ul/li/input");
	private static By submit = By.xpath(".//*[@id='contentarea']/div[2]/div/ul/li[2]/input");
	private static By transferAmount = By.xpath(".//*[@id='fldtxnamount']");
	private static By narrative = By.xpath(".//*[@id='fldnarrative']");
	private static By submit_btn = By.xpath(".//*[@id='fldinitiate']");
	private static By confirm = By.xpath(".//*[@id='btnConfirm']");
	private static By beneficiary_Name = By.xpath(".//*[@id='datacol411']");
	private static By transfer_amount = By.xpath(".//*[@id='table2']/tbody/tr[1]/td[2]");
	private static By transactionPin = By.xpath(".//*[@id='fldtxnpin1']");
	private static By submitt = By.xpath(".//*[@id='contentarea']/div/div/ul/li[3]/input");
	private static By transferMessage = By.xpath("html/body/div[7]/div/ul/li[1]");
	private static By accountnumber = By.xpath(".//*[@id='datacol421']");
	private static By amount = By.xpath(".//*[@id='datacol211']");
	private static By ok = By.xpath(".//*[@id='fldok']");//

	public NEFT_FundsTransfer(WebDriver driver) {
		NEFT_FundsTransfer.driver = driver;
	}

	public void NEFTTransaction(String sourceAccountName, String BeneficiaryId, String TransferAmount, String Narrative, String TransactionPin) throws Exception {
		
		try{
			handlingWindow();
		
		Screenshot.infoScreenshot(driver, "kvb after login");
		test.log(LogStatus.INFO, " **** NEFT Transaction function starts ****");
		log.info("**** NEFT Transaction  function starts **** ");
		driver.switchTo().frame("frame_top");
		click(payments_link);
		test.log(LogStatus.INFO, " payments link clicked ");
		log.info(" payments link clicked");
		driver.switchTo().defaultContent();

		driver.switchTo().frame("frame_menu");

		click(NEFT_Funds_Transfer);
		test.log(LogStatus.INFO, " NEFT Funds Transfer  link clicked ");
		log.info(" NEFT Funds Transfer  link clicked");
		driver.switchTo().defaultContent();

		driver.switchTo().frame("frame_txn");
		Thread.sleep(2000);
		Screenshot.infoScreenshot(driver, "NEFT Funds Transfer page");
		selectVisibleText(sourceAccount, sourceAccountName);// gurram
		test.log(LogStatus.INFO, sourceAccountName + " source Account Name selected ");
		log.info(sourceAccountName + " source Account Name selected ");
		click(beneficiaryName);
		test.log(LogStatus.INFO, " Beneficiary Name clicked ");
		log.info(" Beneficiary Name clicked");
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

		System.out.println(driver.getCurrentUrl());
		driver.switchTo().frame("txn");
		sendkeys(beneficiaryId, BeneficiaryId);// SURYA
		test.log(LogStatus.INFO, BeneficiaryId + " BeneficiaryId entered ");
		log.info(BeneficiaryId + " BeneficiaryId entered ");
		click(search);
		test.log(LogStatus.INFO, " search button clicked ");
		log.info(" search button clicked");
		click(submit);
		test.log(LogStatus.INFO, " submit button clicked ");
		log.info(" submit button clicked");
		driver.switchTo().window(Addbenwindow);
		driver.switchTo().frame("frame_txn");
		sendkeys(transferAmount, TransferAmount);
		test.log(LogStatus.INFO, TransferAmount + " Transfer Amount entered ");
		log.info(TransferAmount + " TransferAmount entered ");
		sendkeys(narrative, Narrative);
		test.log(LogStatus.INFO, Narrative + " narrative entered ");
		log.info(Narrative + " narrative entered ");
		Screenshot.infoScreenshot(driver, "kvb NEFT tranfer");
		click(submit_btn);
		test.log(LogStatus.INFO, " submit button clicked ");
		log.info(" submit button clicked");
		Thread.sleep(3000);
		String expect_beneficiary_Name = "suryateja";
		String actual_beneficiary_Name = getElementText(beneficiary_Name);
		System.out.println(actual_beneficiary_Name+"actual_beneficiary_Name");
		//Assert.assertTrue(actual_beneficiary_Name.contains(expect_beneficiary_Name));
		test.log(LogStatus.INFO, expect_beneficiary_Name + " beneficiary Name matched");
		log.info(expect_beneficiary_Name + " beneficiary Name matched");
		String expect_transfer_amount = "100";
		String actual_transfer_amount = getElementText(transfer_amount);
		System.out.println(actual_transfer_amount+"actual_transfer_amount");
		//Assert.assertTrue(actual_transfer_amount.contains(expect_transfer_amount));
		test.log(LogStatus.INFO, expect_transfer_amount + " transfer amount matched");
		log.info(expect_transfer_amount + " transfer amount matched");
		Screenshot.infoScreenshot(driver, "kvb confirm page");
		click(confirm);
		test.log(LogStatus.INFO, " confirm button clicked ");
		log.info(" confirm button clicked");
		Screenshot.infoScreenshot(driver, "NEFT Funds Transfer confirm  page");
		sendkeys(transactionPin, TransactionPin);
		test.log(LogStatus.INFO, TransactionPin + " Transaction Pin entered ");
		log.info(TransactionPin + " Transaction Pin entered ");
		
		Thread.sleep(60000);
		click(submitt);
		test.log(LogStatus.INFO, " submit button clicked ");
		log.info(" submit button clicked ");
		
		

		String expect_transferMessage = "Your request has been completed successfully.";
		String actual_transferMessage = getElementText(transferMessage);
		Assert.assertTrue(actual_transferMessage.contains(expect_transferMessage));
		test.log(LogStatus.INFO, expect_transferMessage + " transfer message matched");
		log.info(expect_transferMessage + " transfer message matched");
		
		Thread.sleep(3000);

		String expect_accountnum = "192310100016354";
		String actual_accountnum = getElementText(accountnumber);
		System.out.println(actual_accountnum);
		Assert.assertTrue(actual_accountnum.contains(expect_accountnum));
		test.log(LogStatus.INFO, expect_accountnum + " account num matched");
		log.info(expect_accountnum + " account num matched");

		String expect_amount = "100.00";
		Thread.sleep(2000);
		String actual_amount = getElementText(amount);
		Assert.assertTrue(actual_amount.equalsIgnoreCase(expect_amount));
		test.log(LogStatus.INFO, expect_amount + " amount matched");
		log.info(expect_amount + " amount matched");
		Screenshot.infoScreenshot(driver, "NEFT transation complted");
		click(ok);
		test.log(LogStatus.INFO, " ok button clicked ");
		log.info(" ok button clicked ");
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
