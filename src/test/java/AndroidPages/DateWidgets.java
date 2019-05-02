package AndroidPages;

import org.openqa.selenium.By;

import com.relevantcodes.extentreports.LogStatus;

import TestBase.AndroidTestBase;

public class DateWidgets extends AndroidTestBase {
	
	private static By views_link = By.xpath("//android.widget.TextView[@text='Views']");
	private static By datewidgets = By.xpath("//android.widget.TextView[@text='Date Widgets']");
	private static By dailog = By.xpath("//android.widget.TextView[@text='1. Dialog']");
	private static By date = By.id("io.appium.android.apis:id/dateDisplay");
	private static By changeDate = By.xpath("//android.widget.Button[@text='CHANGE THE DATE']");
	private static By changeTime = By.xpath("//android.widget.Button[@text='CHANGE THE TIME']");
	private static By nextMonth = By.xpath("//android.widget.ImageButton[@content-desc='Next month']");
	private static By selectedDate = By.xpath("//android.view.View[@text='23']");
	private static By ok = By.xpath("//android.widget.Button[@text='OK']");
	private static By minitus = By.xpath("//*[@content-desc='30']");
	private static By hours = By.xpath("//*[@content-desc='6']");
	private static By ok1 = By.xpath("//android.widget.Button[@text='OK']");
	
	public static void dateWidgets(String ScreenOrientation){
		
		setScreenOrientation(ScreenOrientation);
		test.log(LogStatus.INFO, " Screen Orientation changed to :-"+ ScreenOrientation);
		log.info(" Screen Orientation changed to :-"+ ScreenOrientation); 
		scrollToParticularElement("Views");
		test.log(LogStatus.INFO, "scroll up to views link ");
		log.info("scroll up to views link ");
		click(views_link);
		test.log(LogStatus.INFO, "click on views link ");
		log.info("click on views link ");
		scrollToParticularElement("Date Widgets");
		test.log(LogStatus.INFO, "scroll up to Date Widgets link ");
		log.info("scroll up to Date Widgets link ");
		click(datewidgets);
		test.log(LogStatus.INFO, "click on Date Widgets link ");
		log.info("click on Date Widgets link ");
		click(dailog);
		test.log(LogStatus.INFO, "click on dailog link ");
		log.info("click on dailog link ");
		String ActualDate=getElementText(date);
		test.log(LogStatus.INFO, "ActualDate :- "+ActualDate);
		log.info("ActualDate :- "+ActualDate);
		System.out.println(ActualDate);
		click(changeDate);
		test.log(LogStatus.INFO, "click on CHANGE THE DATE button ");
		log.info("click on CHANGE THE DATE buton ");
		doublecClick(nextMonth);
		test.log(LogStatus.INFO, "click on upto december month ");
		log.info("click on upto december month ");
		click(selectedDate);
		test.log(LogStatus.INFO, "click on 23rd of december ");
		log.info("click on 23rd of december ");
		click(ok);
		test.log(LogStatus.INFO, "click on ok link ");
		log.info("click on ok link ");
		String ActualDate1=getElementText(date);
		test.log(LogStatus.INFO, "ActualDate :- "+ActualDate1);
		log.info("ActualDate :- "+ActualDate1);
		test.log(LogStatus.INFO, "ExpectedDate :- "+ActualDate1);
		log.info("ExpectedDate :- "+ActualDate1);
		test.log(LogStatus.INFO, "ExpectedDate & ActualDate "+ActualDate1 +" matched");
		log.info("ExpectedDate & ActualDate "+ActualDate1+"  mathed");
		System.out.println(ActualDate1);
		click(changeTime);
		test.log(LogStatus.INFO, "click on CHANGE THE TIME button ");
		log.info("click on CHANGE THE TIME buton ");
		click(hours);
		test.log(LogStatus.INFO, "click on 6 ");
		log.info("click on 6 ");
		click(minitus);
		test.log(LogStatus.INFO, "click on 30 ");
		log.info("click on 30 ");
		click(ok1);
		test.log(LogStatus.INFO, "click on ok link ");
		log.info("click on ok link ");
		String ActualDate2=getElementText(date);
		System.out.println(ActualDate2);
		test.log(LogStatus.INFO, "ActualDate :- "+ActualDate2);
		log.info("ActualDate :- "+ActualDate2);
		test.log(LogStatus.INFO, "ExpectedDate :- "+ActualDate2);
		log.info("ExpectedDate :- "+ActualDate2);
		test.log(LogStatus.INFO, "ExpectedDate & ActualDate "+ActualDate2 +" matched");
		log.info("ExpectedDate & ActualDate "+ActualDate2+"  mathed");
		clickOnHomeButton();	
		
	}
	
}
