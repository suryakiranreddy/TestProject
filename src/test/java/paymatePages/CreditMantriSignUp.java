package paymatePages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.relevantcodes.extentreports.LogStatus;

import TestBase.TestBase;

public class CreditMantriSignUp extends TestBase {
	
	private static By singnup = By.xpath("//*[@id='mm-0']/header/div/div/div/div[3]/ul/li[3]/a");
	
	private static By mobileNum = By.id("s-mobile-number");
	
	private static By OTP = By.xpath("//*[@id='mobile-form']/div[3]/div/input");
	
	
	//*[@id="mobile-verification"]/div/div[2]/form/div/div[1]/div/input
	//*[@id="mobile-verification"]/div/div[2]/form/div/div[2]/input
	
	private static By PAN = By.id("cs-pan");
	private static By day = By.id("select2-cs-day-container");
	private static By month = By.id("select2-cs-month-container");
	private static By year = By.id("select2-cs-year-container");
	private static By email = By.id("cs-email");
	private static By pinCode = By.id("cs-pincode");
	private static By creditScore = By.id("//*[@id='credit-score-form']/div/div[7]/div/input");
	//*[@id="preApprovedOffers"]/div[1]/div[1]/div[2]/h5   Congratulations! You are pre-approved for 5 personal loans
	
	public CreditMantriSignUp(WebDriver driver) {
		CreditMantriSignUp.driver = driver;
	}

	public static void signUp(String mobileNumber, String PANNumber,String emailId,String PinCode) throws InterruptedException, IOException {
		
		click(singnup);
		 test.log(LogStatus.INFO, "signUp button clicked" );
		 log.info("signUp button clicked " ); 
		sendkeys(mobileNum, mobileNumber);
		 test.log(LogStatus.INFO, mobileNumber+" mobile number entered" );
		 log.info( mobileNumber+" mobile number entered"  ); 
		click(OTP);
		 test.log(LogStatus.INFO, "OTP button clicked" );
		 log.info("OTP button clicked " ); 
		Thread.sleep(20000);
		sendkeys(PAN, PANNumber);
		 test.log(LogStatus.INFO, PANNumber+" PAN Number entered" );
		 log.info( PANNumber+"PAN Number entered"  ); 
		click(day);
		Actions a = new Actions(driver);
		a.sendKeys(Keys.DOWN).build().perform();
		a.sendKeys(Keys.ENTER).build().perform();
		click(day);
		actionClick(10);
		test.log(LogStatus.INFO, "day selected");
		 log.info( "day selected"  ); 
		click(month);
		Actions a1 = new Actions(driver);
		a1.sendKeys(Keys.DOWN).build().perform();
		a1.sendKeys(Keys.ENTER).build().perform();
		click(month);
		actionClick(5);
		test.log(LogStatus.INFO, "month selected");
		 log.info( "month selected"  ); 
		click(year);
		Actions a2 = new Actions(driver);
		a2.sendKeys(Keys.DOWN).build().perform();
		a2.sendKeys(Keys.ENTER).build().perform();
		click(year);
		actionClick(5);//1996
		test.log(LogStatus.INFO, "year selected");
		 log.info( "year selected"  ); 
		sendkeys(email, emailId);
		test.log(LogStatus.INFO, emailId+" email Id entered" );
		 log.info( emailId+" email Id entered"  ); 
		sendkeys(pinCode, PinCode);
		test.log(LogStatus.INFO, PinCode+" PinCode entered" );
		 log.info( PinCode+" PinCode entered"  ); 
		 Thread.sleep(5000);
		click(creditScore);
		 test.log(LogStatus.INFO, "creditScore button clicked" );
		 log.info("creditScore button clicked " ); 
		 Thread.sleep(20000);
		
	}
}
