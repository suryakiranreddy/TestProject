package IOSPages;

import org.openqa.selenium.By;

import com.relevantcodes.extentreports.LogStatus;

import TestBase.IOSTestBase;


public class Page1 extends IOSTestBase{
	
	//private static By alertViwes= (By) IOSdriver.findElementByAccessibilityId("Alert Views");
	private static By alertViwes=By.name("Alert Views");
	private static By textEntry= By.xpath("//*[@value='Text Entry']");
	private static By textField= By.className("XCUIElementTypeTextField");
	private static By ok=By.name("OK");
	
	
	public static void page1() {
		
		//setScreenOrientation("LANDSCAPE");
		String text=getElementText(alertViwes);
		System.out.println("text is "+text );
		click(alertViwes);		
		log.info("clicked on alert views");
		test.log(LogStatus.INFO, "clicked on alert views");
		tap(textEntry);
		log.info("clicked on textEntry");
		test.log(LogStatus.INFO, "clicked on textEntry");
		sendkeys(textField, "hello enhops");
		log.info("hello enhops entered in text field");
		test.log(LogStatus.INFO, "hello enhops entered in text field");
		//click(ok);
		longPress(ok, 3);
		log.info("clicked on ok");
		test.log(LogStatus.INFO, "clicked on ok");
		clickOnBackButton();
	}
	

}
