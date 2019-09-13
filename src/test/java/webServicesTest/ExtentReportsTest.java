package webServicesTest;

import java.awt.Color;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.relevantcodes.extentreports.LogStatus;

import Common.Screenshot;

public class ExtentReportsTest {
	
	public static WebDriver driver;
	public static com.aventstack.extentreports.ExtentReports extent;
	public static ExtentHtmlReporter reporter;
	public static ExtentTest test;
	public static ExtentTest ptest;
	public static ExtentTest ctest;
	String filename=System.getProperty("user.dir")+"/ExeutionReports/extentReport-";

	@BeforeTest
	public void Setup() {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
    	//extent = new ExtentReports (userDir +"\\test-output\\" + timeStamp + ".html", true);
		reporter = new ExtentHtmlReporter(filename+timeStamp+".html");
     
		reporter.loadXMLConfig("./src/main/resources/ConfigFiles/extent-config.xml");
 
        extent = new ExtentReports();
        extent.attachReporter(reporter);
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/resources/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		//driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.get(Repository.getProperty("url"));https://qa-cmol1.creditmantri.in
		driver.get("https://qa-cmol1.creditmantri.in");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
	}
	
	@Test(priority=1)
	public void test1() throws IOException{
		//ptest=extent.createTest("search option");
		ctest=ptest.createNode("<center><b> ' login1' </b></center>");
		ctest.log(Status.INFO, "step1");
		//ctest.log(Status.INFO, "  jhaskduiw", MediaEntityBuilder.createScreenCaptureFromBase64String("screen.png").build());
		ctest.log(Status.INFO, MarkupHelper.createLabel("label", ExtentColor.BLUE));
		ctest.log(Status.INFO, "step2");
		
		ctest=ptest.createNode("===============login2============");
		ctest.info("step1");
		ctest.info("step2");
		ctest=ptest.createNode("================login3============");
		test=ctest.createNode(" with valid data");
		test.info("step3");
		test.info("Step4");
		test=ctest.createNode("============with invalid data=============");
		test.info("step3");
		test.info("Step4");
		//driver.findElement(By.xpath("jahsuioa"));
						
						
	}
	@Test(priority=0)
	public void test2(){
		ptest=extent.createTest("login");
		ctest=ptest.createNode("=================login with valid=============");
		ctest.info("step1");
		ctest.info("step2");
		ctest=ptest.createNode("===============login with invalid=============");
		ctest.info("step1");
		ctest.info("step2");
		Assert.assertEquals(true, false);
						
	}
	
	@AfterTest
	public void testclose(){
		extent.flush();
		driver.close();
	}
	
	@AfterMethod
	public void getresult(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.SUCCESS) {
			
			ctest.log(Status.PASS, result.getName() + " test is pass");
		} else if (result.getStatus() == ITestResult.SKIP) {
			
			ctest.log(Status.SKIP, result.getName() + " test is skipped and skip reason is:-" + result.getThrowable());
		} else if (result.getStatus() == ITestResult.FAILURE) {
		
			ctest.log(Status.ERROR, result.getName() + " test is failed" + result.getThrowable());
		
		} else if (result.getStatus() == ITestResult.STARTED) {
			ctest.log(Status.INFO, result.getName() + " test is started in ");
		}
	}

}
