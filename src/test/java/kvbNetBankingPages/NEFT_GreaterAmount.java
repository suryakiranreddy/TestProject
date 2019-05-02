package kvbNetBankingPages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.LogStatus;

import Common.Screenshot;
import TestBase.TestBase;

public class NEFT_GreaterAmount extends TestBase {

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

	public NEFT_GreaterAmount(WebDriver driver) {
		NEFT_GreaterAmount.driver = driver;
	}

	public void NEFTTransactionWithGreaterThanCurrentBalance(String sourceAccountName, String BeneficiaryId,
			String TransferAmount, String Narrative) throws Exception {
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
		selectVisibleText(sourceAccount, sourceAccountName);
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
		sendkeys(beneficiaryId, BeneficiaryId);
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
		click(submit_btn);
		test.log(LogStatus.INFO, " submit button clicked ");
		log.info(" submit button clicked");
		Thread.sleep(2000);
		Screenshot.infoScreenshot(driver, "No Available Balance");

	}

}
