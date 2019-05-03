package paymatePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.relevantcodes.extentreports.LogStatus;
import TestBase.TestBase;

public class PaymateLogin extends TestBase {
	

	 
	private static By logo=By.xpath("//*[@id='UpnlHome']/div[1]");
	private static By userName=By.id("txtParanNaam");
	private static By password=By.id("txtParanShabd");
	private static By submit_btn=By.id("cphContents_btnLogin");	
	private static By homepage_txt=By.xpath("//*[@id='UpnlHome']/div/div[1]/h1");
	

	public PaymateLogin(WebDriver driver){
		TestBase.driver=driver;
	}
	
	public static void paymateLogin(String uname,String pasword){
		
		try{
			
		test.log(LogStatus.INFO, "**** Paymate Login function starts ****");
		log.info("**** Paymate Login function starts ****");			
		String actual_logotxt=getElementText(logo);		
		test.log(LogStatus.INFO, "actual_logotxt is "+actual_logotxt);		
		log.info("actual_logotxt is "+actual_logotxt);
		String expert_txt="Login with your PayMate Account";
		test.log(LogStatus.INFO, "expert_txt is "+expert_txt);
		log.info("expert_txt is "+expert_txt);
		Assert.assertTrue(actual_logotxt.contains(expert_txt));
		test.log(LogStatus.INFO, "Login with your PayMate Account text matched");
		log.info("Login with your PayMate Account text matched");
		//sendkeys(userName, "nikhilpaymate01@gmail.com");
		sendkeys(userName,uname );//
		test.log(LogStatus.INFO, uname+" - username entered");
		log.info(uname+" username entered");
		//sendkeys(password, "Paymate@1");//
		sendkeys(password,pasword );
		test.log(LogStatus.INFO, pasword+" - password entered");
		log.info(pasword+" password entered");
		click(submit_btn);
		test.log(LogStatus.INFO, "submit button clicked");
		log.info("submit button clicked");
		String actual_hometxt=getElementText(homepage_txt);
		test.log(LogStatus.INFO, "actual_hometxt is "+actual_hometxt);
		log.info("actual_hometxt is "+actual_hometxt);
		String expect_hometxt="WELCOME TO PAYMATE";
		test.log(LogStatus.INFO, "expect_hometxt is "+expect_hometxt);
		log.info("expect_hometxt is "+expect_hometxt);
		//String expert_txt="Login with your PayMate Account";
		Assert.assertTrue(actual_hometxt.contains(expect_hometxt));
		test.log(LogStatus.INFO, "WELCOME TO PAYMATE text matched");
		log.info("WELCOME TO PAYMATE text matched");
		test.log(LogStatus.INFO, "**** Paymate Login function ends ****");
		log.info( "**** Paymate Login function ends ****");
		
		}catch(Exception e){
			System.out.println(e);
		}
	}//paymateLogin(String uname,String pasword)
	
	
}//PaymateLogin
