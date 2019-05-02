package paymatePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.relevantcodes.extentreports.LogStatus;
import TestBase.TestBase;

public class PaymateLogout extends TestBase{
	
	
	
	 
	private static By logo=By.xpath("//*[@id='UpnlHome']/div[1]");
	private static By logout_icon=By.xpath("//*[@id='navbar-collapse']/ul/li/a[2]/i");
	private static By Logout=By.xpath("//*[@id='navbar-collapse']/ul/li/ul/li[1]/ul/li/a/div[2]");

	
	public PaymateLogout(WebDriver driver){
		TestBase.driver=driver;
	}
	
	
	public static void paymateLogout() throws InterruptedException{
		
		try{
			
		test.log(LogStatus.INFO, " **** Paymate Logut function starts ****");
		log.info("**** Paymate Logut function starts **** ");	
		click(logout_icon);
		test.log(LogStatus.INFO, "Clicked on Logout icon");
		log.info("Clicked on Logout icon");	
		click(Logout);
		test.log(LogStatus.INFO, " clicked on Logout link");
		log.info("clicked on Logout link ");	
		Thread.sleep(4000);
		String actual_logotxt=getElementText(logo);
		test.log(LogStatus.INFO, "actual_logotxt is "+ actual_logotxt);
		log.info("actual_logotxt is "+ actual_logotxt);	
		String expert_txt="Login with your PayMate Account";
		test.log(LogStatus.INFO, " expected_logotxt is "+ expert_txt);
		log.info(" expected_logotxt is "+ expert_txt );	
		Assert.assertTrue(actual_logotxt.contains(expert_txt));
		test.log(LogStatus.INFO, "Login with your PayMate Account text matched");
		log.info("Login with your PayMate Account text matched ");	
		test.log(LogStatus.INFO, "**** Paymate Logut function ends ****");
		log.info("**** Paymate Logut function ends **** ");	
		
		}catch(Exception e){
			System.out.println(e);
			e.getMessage();
		}
		
	}//paymateLogout()

}//PaymateLogout
