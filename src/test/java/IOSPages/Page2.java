package IOSPages;

import org.openqa.selenium.By;

import com.relevantcodes.extentreports.LogStatus;

import TestBase.IOSTestBase;

public class Page2 extends IOSTestBase{
	
	private static By Steppers=By.xpath("//XCUIElementTypeStaticText[@name='Steppers']");
	
	private static By Increment1=By.xpath("(//XCUIElementTypeButton[@name=\"Increment\"])[1]");
	private static By Decrement1=By.xpath("(//XCUIElementTypeButton[@name=\"Decrement\"])[1]");
	
	private static By Increment2=By.xpath("(//XCUIElementTypeButton[@name=\"Increment\"])[2]");
	private static By Decrement2=By.xpath("(//XCUIElementTypeButton[@name=\"Decrement\"])[2]");
	
	private static By Increment3=By.xpath("(//XCUIElementTypeButton[@name=\"Increment\"])[3]");
	private static By Decrement3=By.xpath("(//XCUIElementTypeButton[@name=\"Decrement\"])[3]");
	
	private static By PickerView=By.xpath("//XCUIElementTypeStaticText[@name=\"Picker View\"]");
	
	private static By drp1=By.xpath("//XCUIElementTypePickerWheel[@name=\"Red color component value\"]");
	private static By drp2=By.xpath("//XCUIElementTypePickerWheel[@name=\"Green color component value\"]");
	private static By drp3=By.xpath("//XCUIElementTypePickerWheel[@name=\"Blue color component value\"]");
	
	public static void page2() throws Exception {
		
		verticalSwipedown(0.60, 0.10, 1);
		test.log(LogStatus.INFO, "scroll upto steppers link");
		log.info("scroll upto steppers link");
		click(Steppers);
		test.log(LogStatus.INFO, "click on steppers link");
		log.info("click on steppers link");
		click(Increment1);
		test.log(LogStatus.INFO, "Default increment By 1");
		log.info("Default increment By 1");
		click(Increment1);
		test.log(LogStatus.INFO, "Default increment By 1");
		log.info("Default increment By 1");
		click(Increment1);
		test.log(LogStatus.INFO, "Default increment By 1");
		log.info("Default increment By 1");
		click(Increment1);
		test.log(LogStatus.INFO, "Default increment By 1");
		log.info("Default increment By 1");
		click(Decrement1);
		test.log(LogStatus.INFO, "Default decrement By 1");
		log.info("Default decrement By 1");
		click(Decrement1);
		test.log(LogStatus.INFO, "Default decrement By 1");
		log.info("Default decrement By 1");
		click(Increment2);
		test.log(LogStatus.INFO, "Tinted increment By 1");
		log.info("Tinted increment By 1");
		click(Increment2);
		test.log(LogStatus.INFO, "Tinted increment By 1");
		log.info("Tinted increment By 1");
		click(Increment2);	
		test.log(LogStatus.INFO, "Tinted increment By 1");
		log.info("Tinted increment By 1");
		click(Decrement2);
		test.log(LogStatus.INFO, "Tinted decrement By 1");
		log.info("Tinted derement By 1");
		click(Increment3);
		test.log(LogStatus.INFO, "Custom increment By 1");
		log.info("Custom increment By 1");
		click(Increment3);
		test.log(LogStatus.INFO, "Custom increment By 1");
		log.info("Custom increment By 1");
		click(Decrement3);
		test.log(LogStatus.INFO, "Custom decrement By 1");
		log.info("Custom decrement By 1");
		click(Decrement3);
		test.log(LogStatus.INFO, "Custom decrement By 1");
		log.info("Custom decrement By 1");
	   clickOnBackButton();
	   test.log(LogStatus.INFO, "click on back button");
		log.info("click on back button");
	   click(PickerView);
	   test.log(LogStatus.INFO, "click on PickerView link");
		log.info("click on PickerView link");
	   sendkeys(drp1, "85");
	   test.log(LogStatus.INFO, "Select 85 in dropdown 1");
		log.info("Select 85 in dropdown 1");
	   sendkeys(drp2, "220");
	   test.log(LogStatus.INFO, "Select 220 in dropdown 1");
		log.info("Select 220 in dropdown 1");
	   sendkeys(drp3, "135");
	   test.log(LogStatus.INFO, "Select 135 in dropdown 1");
		log.info("Select 135 in dropdown 1");
	   clickOnBackButton();
	   test.log(LogStatus.INFO, "click on back button");
	   log.info("click on back button");
	
	}

}
