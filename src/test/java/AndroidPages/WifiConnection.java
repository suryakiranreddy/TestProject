package AndroidPages;

import java.io.IOException;

import org.openqa.selenium.By;

import com.relevantcodes.extentreports.LogStatus;

import TestBase.AndroidTestBase;

public class WifiConnection extends AndroidTestBase{
	
	private static By Preference_link = By.xpath("//android.widget.TextView[@text='Preference']");
	private static By dependencies = By.xpath("//android.widget.TextView[@text='3. Preference dependencies']");
	private static By CheckBox = By.className("android.widget.CheckBox");
	private static By wifi = By.xpath("//android.widget.TextView[@text='WiFi settings']");
	private static By text = By.className("android.widget.EditText");
	private static By ok = By.xpath("//*[@text='OK']");	
	private static By views_link = By.xpath("//android.widget.TextView[@text='Views']");
	private static By dragNDDrop = By.xpath("//android.widget.TextView[@text='Drag and Drop']");
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
		clickOnHomeButton();
		test.log(LogStatus.INFO, "click on home button");
		log.info("click on home button");
		
		
		
	}
	

}
