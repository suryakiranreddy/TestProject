package lunch2Desk_pages;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.relevantcodes.extentreports.LogStatus;
import Common.Screenshot;
import TestBase.TestBase;

public class CustomerLogin extends TestBase {

	private static By login_txt = By.xpath("//div[@class='login-option']/a");
	private static By userName = By.name("user_login");
	private static By pasword = By.name("user_pass");
	private static By submit_btn = By.name("user-submit");
	private static By userName_txt = By.xpath("//*[@id='header']/div/div/div/div[2]/div/div/ul/li/a");
	private static By welcome_txt = By.xpath("//*[@id='close-me']/h2");

	public CustomerLogin(WebDriver driver) {
		CustomerLogin.driver = driver;
	}

	public static void customerLogin(String uanme, String password) throws IOException {

		// ****URL verification****
		String expected_url = "https://www.lunch2desk.co.in/n/";
		String actual_url = driver.getCurrentUrl();
		Assert.assertTrue(expected_url.contains(actual_url));
		test.log(LogStatus.INFO, "'" + expected_url + "' url matched ");
		log.info("<b>'" + expected_url + "'</b> url matched");
		Screenshot.infoScreenshot(driver, "Lunch2Desk homepage");

		// ****Login / Register link verification****
		String expected_login_txt = "LOGIN / REGISTER";
		String actual_login_txt = getElementText(login_txt);
		System.out.println(actual_login_txt);
		Assert.assertTrue(expected_login_txt.contains(actual_login_txt));
		test.log(LogStatus.INFO, "'" + expected_login_txt + "' text matched ");
		log.info("'" + expected_login_txt + "' text matched");

		// ****Login verification****
		click(login_txt);
		sendkeys(userName, uanme);
		test.log(LogStatus.INFO, "User name '" + uanme + "' entered ");
		log.info("User name '" + uanme + "' entered ");

		sendkeys(pasword, password);
		test.log(LogStatus.INFO, "password '**********' entered ");
		log.info("password '**********' entered");

		click(submit_btn);
		test.log(LogStatus.INFO, "submit button clicked");
		log.info("submit button clicked");

		// ****user name verification ****
		String expected_userName_txt = "ROOPA";
		String actual_userName_txt = getElementText(userName_txt);
		System.out.println(actual_userName_txt);
		Assert.assertTrue(expected_userName_txt.contains(actual_userName_txt));
		test.log(LogStatus.INFO, "'" + expected_userName_txt + "' user name matched ");
		log.info("'" + expected_userName_txt + "' user name matched");
		Screenshot.infoScreenshot(driver, "Lunch2Desk dashboard");
		test.log(LogStatus.INFO, "login into the application ");
		log.info("login into the application ");

		/*// ****welcome text verification****
		String expected_welcome_txt = "Welcome To Your Account";
		String actual_welcome_txt = getElementText(welcome_txt);
		System.out.println(actual_welcome_txt);
		Assert.assertTrue(expected_welcome_txt.contains(actual_welcome_txt));
		test.log(LogStatus.INFO, "'" + expected_welcome_txt + "' text matched ");
		log.info("'" + expected_welcome_txt + "' text matched");*/

	}
}
