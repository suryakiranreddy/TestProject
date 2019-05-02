package lunch2Desk_pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.LogStatus;

import Common.Screenshot;
import TestBase.TestBase;

public class Logout extends TestBase {

	private static By logout_link = By.xpath("//*[@id='header']/div/div/div/div[2]/div/div/ul/li/a");
	private static By logout = By.linkText("Signout");

	public Logout(WebDriver driver) {
		Logout.driver = driver;
	}

	public static void logout() throws IOException, InterruptedException {

		//**** logout verification ****
		click(logout_link);
		click(logout);
		test.log(LogStatus.INFO, "logout link clicked ");
		log.info("logout link clicked ");
		test.log(LogStatus.INFO, "logout the application ");
		log.info("logout the application ");
		Thread.sleep(20000);
		Screenshot.infoScreenshot(driver, "Lunch2Desk dashboard");
	}

}