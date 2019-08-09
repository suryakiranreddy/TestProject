package Common;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.util.FileUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import TestBase.TestBase;
import aj.org.objectweb.asm.Type;

public class TestListner extends TestBase implements ITestListener {
	/*static ExtentManager extentManager=new ExtentManager();
	// Extent Report Declarations
	private static ExtentReports extent = extentManager.createInstance();
	//private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
	public static ExtentTest test;

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Extent Reports Version 3 Test Suite started!");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println(("Extent Reports Version 3  Test Suite is ending!"));
		extent.flush();
	}

	@Override
	public   void onTestStart(ITestResult result) {
		System.out.println((result.getMethod().getMethodName() + " started!"));
		System.out.println((result.getMethod().getDescription() + " started!"));
		test= extent.createTest(result.getName() + " - " + result.getMethod().getDescription());
	//	ExtentTest extentTest = extent.createTest(result.getName() , result.getMethod().getDescription());

		//test.set(extentTest);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println((result.getMethod().getMethodName() + " passed!"));
		test.pass(result.getMethod().getMethodName() + " passed!");
		//test.get().pass("Test passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println((result.getMethod().getMethodName() + " failed!"));
		test.fail(result.getMethod().getMethodName() + " failed!");
		//test.get().fail(result.getThrowable());

		TakesScreenshot ts = (TakesScreenshot) driver;
		String source = ts.getScreenshotAs(OutputType.BASE64);
		try {
     test.addScreenCaptureFromBase64String("data:image/png;base64," + source);
			//test.get().log(Status.FAIL, result.getMethod().getMethodName() + " failed!",
			//		MediaEntityBuilder.createScreenCaptureFromBase64String("data:image/png;base64," + source).build());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println((result.getMethod().getMethodName() + " skipped!"));
		test.skip(result.getMethod().getMethodName() + " skipped!");
		//test.get().skip(result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println(("onTestFailedButWithinSuccessPercentage for " + result.getMethod().getMethodName()));

	}
*/
	public void onStart(ITestContext context) {
		System.out.println("*** Test Suite " + context.getName() + " started ***");
	}

	public void onFinish(ITestContext context) {
		System.out.println(("*** Test Suite " + context.getName() + " ending ***"));
		ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();
	}

	public void onTestStart(ITestResult result) {
		System.out.println(("*** Running test method " + result.getMethod().getMethodName() + "..."));
		ExtentTestManager.startTest(result.getMethod().getMethodName()+ " - " + result.getMethod().getDescription());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("*** Executed " + result.getMethod().getMethodName() + " test successfully...");
		ExtentTestManager.getTest().log(Status.PASS, "Test passed");
	}

	public void onTestFailure(ITestResult result) {
		/*System.out.println("*** Test execution " + result.getMethod().getMethodName() + " failed...");
		ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");*/
		log.info("*** Test execution " + result.getMethod().getMethodName() + " failed...");
		log.info((result.getMethod().getMethodName() + " failed!"));
		 try {
			String screenShot=TestListner.destination(driver, result.getMethod().getMethodName() + " failed...");
			ExtentTestManager.getTest().addScreencastFromPath(screenShot);
		 } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			}

	public void onTestSkipped(ITestResult result) {
		System.out.println("*** Test " + result.getMethod().getMethodName() + " skipped...");
		ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("*** Test failed but within percentage % " + result.getMethod().getMethodName());
	}
	 public static String destination(WebDriver driver,String screenShotInfo) throws IOException
	    {
		 
	    String timeStamp=new SimpleDateFormat("dd MMMM yyyy HH-mm-ss").format(new Date());
	    
	        TakesScreenshot ts = (TakesScreenshot) driver;
	        File source = ts.getScreenshotAs(OutputType.FILE);
	        String destination = System.getProperty("user.dir")+"/screenshots/"+screenShotInfo+"-"+timeStamp+".png";
	        File fianlDestination= new File(destination);
	        FileUtil.copyFile(source,fianlDestination);
	        return destination;
	       // String source = ts.getScreenshotAs(OutputType.BASE64);
	      // test.log(LogStatus.INFO, test.addBase64ScreenShot("data:image/png;base64,"+source)+screenShotInfo +" "+ timestamp() );
	        
	    }
	}