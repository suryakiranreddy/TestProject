package paymatePages;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.LogStatus;

import Common.Screenshot;
import TestBase.TestBase;

public class CreditMantriLogin extends TestBase {

	private static By login = By.linkText("Login");

	private static By loginWithGoogle = By.xpath("//*[@id='login-form']/div[2]/div[1]/div/div[2]/a/div/div[2]/span");

	private static By email = By.id("identifierId");

	private static By emailNext = By.xpath("//*[@id='identifierNext']/content/span");

	private static By password = By.xpath("//*[@id='password']/div[1]/div/div[1]/input");

	private static By passwordNext = By.xpath("//*[@id='passwordNext']/content/span");

	private static By icon = By.xpath("/html/body/div[1]/div[2]/div/div[1]/div[2]/ul/li[2]/a");
	
	private static By logout = By.xpath("/html/body/div[1]/div[2]/div/div[1]/div[2]/ul/li[2]/ul/li[4]/a");

	public CreditMantriLogin(WebDriver driver) {
		CreditMantriLogin.driver = driver;
	}

	public static void login(String emailId, String passwordd) throws InterruptedException, IOException {
		

		click(login);
		 test.log(LogStatus.INFO, "Login button clicked" );
		 log.info("Login button clicked " ); 
		Thread.sleep(5000);
		click(loginWithGoogle);
		 test.log(LogStatus.INFO, "Login with google button clicked" );
		 log.info("Login with google button clicked " ); 
		 
		String parentWindowHandler = driver.getWindowHandle();
		Set<String> handler = driver.getWindowHandles();
		Iterator<String> iter = handler.iterator();
		String parentWindow = iter.next();
		log.info("loanprocess parentWindow  is--->" + parentWindow);
		String childWindow = iter.next();
		log.info("loanprocess child window is--->" + childWindow);
		driver.switchTo().window(childWindow);
		
		sendkeys(email, emailId);
		 test.log(LogStatus.INFO, emailId +"email id entered" );
		 log.info(emailId +"email id entered"  ); 
		click(emailNext);
		test.log(LogStatus.INFO, "next button clicked " );
		 log.info("next button clicked "); 		
		sendkeys(password, passwordd);
		 String depassword=getDecodedString(passwordd);
		 System.out.println("depassword  "+depassword);
		 sendkeys(password, getDecodedString(passwordd));
		// sendkeys(password, passwordd);
		 test.log(LogStatus.INFO, "********** passowrd entered" );
		 log.info("********** passowrd entered"  ); 
		click(passwordNext);
		 test.log(LogStatus.INFO, "next button clicked " );
		 log.info("next button clicked "); 
		
		driver.switchTo().window(parentWindowHandler);
		Thread.sleep(3000);
		Screenshot.infoScreenshot(driver, "After Login");
		
		click(icon);
		click(logout);
		Thread.sleep(50000);

	}

}
