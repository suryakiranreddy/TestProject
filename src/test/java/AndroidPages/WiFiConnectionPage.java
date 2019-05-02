package AndroidPages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import Common.Screenshot;
import TestBase.AndroidTestBase;
import lunch2Desk_pages.SellerLogin;

public class WiFiConnectionPage extends AndroidTestBase{
	
	private static By Preference_link = By.xpath("//android.widget.TextView[@text='Preference']");
	private static By dependencies = By.xpath("//android.widget.TextView[@text='3. Preference dependencies']");
	private static By CheckBox = By.className("android.widget.CheckBox");
	private static By wifi = By.xpath("//android.widget.TextView[@text='WiFi settings']");
	private static By text = By.className("android.widget.EditText");
	private static By ok = By.xpath("//*[@text='OK']");
	
	private static By views_link = By.xpath("//android.widget.TextView[@text='Views']");
	private static By dragNDDrop = By.xpath("//android.widget.TextView[@text='Drag and Drop']");
	/*private static By element1 = By.className("(android.view.View)[1]");
	private static By element2 = By.className("(android.view.View)[2]");*/
	private static By animation = By.xpath("//android.widget.TextView[@text='Animation']");
	private static By webview = By.xpath("//android.widget.TextView[@text='WebView']");
	
	
	
	public static void wiFiConnection(String ScreenOrientation, String PreferenceExpectedTxt, String WiFiname ) throws IOException, InterruptedException {
		
		setScreenOrientation(ScreenOrientation);
		test.log(LogStatus.INFO, " Screen Orientation changed to :-"+ ScreenOrientation);
		log.info(" Screen Orientation changed to :-"+ ScreenOrientation); 
		scrollToParticularElement("Preference");
		//moveTo(Preference_link);
		test.log(LogStatus.INFO, "scroll up to Preference link ");
		log.info("scroll up to Preference link ");
		String actualText=getElementText(Preference_link);
		System.out.println(actualText);	
		test.log(LogStatus.INFO, "Actual text:-"+actualText);
		log.info("Actual text:-"+actualText);
		String ExpectedText=PreferenceExpectedTxt;
		System.out.println(ExpectedText);	
		test.log(LogStatus.INFO, "Expected text:-"+ExpectedText);
		log.info("Expected text:-"+ExpectedText);
		click(Preference_link);
		test.log(LogStatus.INFO, "click on Preference link");
		log.info("click on Preference link");
		tap(dependencies);
		test.log(LogStatus.INFO, "tap on dependencies link");
		log.info("tap on dependencies link");
		click(CheckBox);
		test.log(LogStatus.INFO, "click on CheckBox");
		log.info("click on CheckBox");
		longPress(wifi, 3);
		test.log(LogStatus.INFO, "Long press on wifi settings upto 3 seconds");
		log.info("Long press on wifi settings upto 3 seconds");
		hideKeyBoard();
		sendkeys(text, WiFiname );//hello
		test.log(LogStatus.INFO, WiFiname+ " wifi name entered");
		log.info(WiFiname+ " wifi name entered");
		click(ok);
		test.log(LogStatus.INFO, "click on ok");
		log.info("click on ok");
		clickOnBackButton();
		
		test.log(LogStatus.INFO, "click on back button");
		log.info("click on back button");
		/*click(CheckBox);
		clickOnBackButton();
		clickOnBackButton();*/
		clickOnHomeButton();
		test.log(LogStatus.INFO, "click on home button");
		log.info("click on home button");
		//Thread.sleep(2000);
		
		
	}
	
	public static void DargndDrop() throws Exception{
		scrollToParticularElement("Views");
		click(views_link);
		verticalSwipedown(0.2, 0.8, 1);
		System.out.println("hghghb");
		//swipe(animation, webview, 1);
		//scrollFromBottomToUp();
		System.out.println("hghghb");
		//verticalSwipe();
		//click(dragNDDrop);
		//swipe(animation, webview, 1);
	}
	private static By login_txt = By.xpath("//div[@class='login-option']/a");// Login
	// /
	// Register
private static By userName = By.name("user_login");
private static By pasword = By.name("user_pass");
private static By submit_btn = By.name("user-submit");
private static By userName_txt = By.xpath("//*[@id='header']/div/div/div/div[2]/div/div/ul/li/a");
private static By welcome_txt = By.xpath("//*[@id='close-me']/h2");



public static void sellerLogin(String uanme, String password) throws IOException, InterruptedException {

// ****URL verification****
String expected_url = "https://www.lunch2desk.co.in/n/";
String actual_url = androidDriver.getCurrentUrl();
Assert.assertTrue(expected_url.contains(actual_url));
test.log(LogStatus.INFO, "<b>'" + expected_url + "'</b> url matched ");
log.info("'" + expected_url + "' url matched");
//Screenshot.infoScreenshot(driver, "Lunch2Desk homepage");

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

System.out.println(password);
//clear(pasword);
sendkeys(pasword, password);
test.log(LogStatus.INFO, "password '**********' entered ");
log.info("password '**********' entered");

Thread.sleep(2000);
click(submit_btn);
test.log(LogStatus.INFO, "submit button clicked");
log.info("submit button clicked");

// ****user name verification ****
String expected_userName_txt = "DIMPLE MEHTA";
String actual_userName_txt = getElementText(userName_txt);
System.out.println(actual_userName_txt);
Assert.assertTrue(expected_userName_txt.contains(actual_userName_txt));
test.log(LogStatus.INFO, "'" + expected_userName_txt + "' user name matched ");
log.info("'" + expected_userName_txt + "' user name matched");
//Screenshot.infoScreenshot(driver, "Lunch2Desk dashboard");
test.log(LogStatus.INFO, "login into the application ");
log.info("login into the application ");

// ****welcome text verification****
String expected_welcome_txt = "Welcome To Your Restaurant.";
String actual_welcome_txt = getElementText(welcome_txt);
System.out.println(actual_welcome_txt);
Assert.assertTrue(expected_welcome_txt.contains(actual_welcome_txt));
test.log(LogStatus.INFO, "'" + expected_welcome_txt + "' text matched ");
log.info("'" + expected_welcome_txt + "' text matched");

}
	
	
}
