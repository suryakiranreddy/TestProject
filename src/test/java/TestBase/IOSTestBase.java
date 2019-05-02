package TestBase;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofSeconds;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class IOSTestBase {

	public static IOSDriver IOSdriver;	
	public static Properties Repository = new Properties();
	public static File f;
	public static FileInputStream FI;
	public static Logger log = Logger.getLogger(AndroidTestBase.class);
	public static ExtentReports extent;
	public static ExtentTest test;
	public static int indexSI = 1;
	private static long DEFAULT_WAIT_SECONDS = 60;
	public static TouchAction action;
	private static String lastAction;
	private  static AppiumDriverLocalService service;
	private static AppiumServiceBuilder builder;
	private static DesiredCapabilities capabilities;

	static {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		extent = new ExtentReports(
				System.getProperty("user.dir") + "/Reports/HtmlReports/Android Automaton Report" + ".html", true);
		// extent = new ExtentReports(System.getProperty("user.dir") +
		// "/Reports/HtmlReports/Automaton Report"+".html", false);

	}

	public static String timestamp() {
		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}

	public static void loadPropertiesFile(String propertiesFileName) throws IOException {
		f = new File(System.getProperty("user.dir") + "//src//main//resources//ConfigFiles//" + propertiesFileName
				+ ".properties");
		FI = new FileInputStream(f);
		Repository.load(FI);
	}

	public static void IosInit() throws IOException {
		System.out.println("x");
		String log4jConfPath = "./src/main/resources/ConfigFiles/log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		loadPropertiesFile("IosConfig");

	}

	public static void desiredCapabilities() throws MalformedURLException {
		

		File appDir = new File(System.getProperty("user.dir"), "/Apps/");
		File app = new File(appDir, Repository.getProperty("Apkname")+".app");

		capabilities = new DesiredCapabilities();

		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, Repository.getProperty("deviceName"));
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "IOS");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);

		capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

		URL url = new URL("http://0.0.0.0:4723/wd/hub");

		IOSdriver = new IOSDriver<MobileElement>(url, capabilities);
		// driver = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);

		IOSdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
public static void desiredCapabilities(String deviceName , int wda, int port) throws MalformedURLException {
	
	service=new AppiumServiceBuilder().usingPort(Integer.valueOf(port)).build();
	service.start();
	if(service==null || !service.isRunning()) {
		throw new AppiumServerHasNotBeenStartedLocallyException("Appium server not started ");
	}

		File appDir = new File(System.getProperty("user.dir"), "/Apps/");
		File app = new File(appDir, Repository.getProperty("Apkname")+".app");

		capabilities = new DesiredCapabilities();

		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "IOS");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);

		capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

		capabilities.setCapability(IOSMobileCapabilityType.WDA_LOCAL_PORT, wda);
		IOSdriver = new IOSDriver<MobileElement>(service.getUrl(), capabilities);
		
		// driver = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);

		IOSdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public static void browDesiredCapabilities() throws MalformedURLException	{

	DesiredCapabilities dc = new DesiredCapabilities();

	dc.setCapability(MobileCapabilityType.BROWSER_NAME, Repository.getProperty("browserName"));//safari
	dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
	dc.setCapability(MobileCapabilityType.DEVICE_NAME, Repository.getProperty("deviceName"));
	dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "IOS");

	IOSdriver = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"), dc);


	IOSdriver.get(Repository.getProperty("url"));
	IOSdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	

	}
	
	public void getresult(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.SUCCESS) {
			
			test.log(LogStatus.PASS, result.getName() + " test is pass");
		} else if (result.getStatus() == ITestResult.SKIP) {
			
			test.log(LogStatus.SKIP, result.getName() + " test is skipped and skip reason is:-" + result.getThrowable());
		} else if (result.getStatus() == ITestResult.FAILURE) {
			
			test.log(LogStatus.ERROR, result.getName() + " test is failed" + result.getThrowable());
			//String screen = Screenshot.capture(androidDriver, getClass().getName());
			//test.log(LogStatus.FAIL, test.addBase64ScreenShot("data:image/png;base64,"+screen));
			
		} else if (result.getStatus() == ITestResult.STARTED) {
			test.log(LogStatus.INFO, result.getName() + " test is started in ");
		}
	}

	@AfterMethod()
	public void afterMethod(ITestResult result) throws IOException {
		getresult(result);
	}

	@BeforeMethod()
	public void beforeMethod(Method result) {
		
		test = extent.startTest(result.getName());
		test.log(LogStatus.INFO, result.getName() + " test Started");
		
	}
	
	
	public static void infoScreenshot(WebDriver androidDriver,String screenShotInfo) throws IOException
    {
        TakesScreenshot ts = (TakesScreenshot) androidDriver;
        String source = ts.getScreenshotAs(OutputType.BASE64);
        test.log(LogStatus.INFO, test.addBase64ScreenShot("data:image/png;base64,"+source)+screenShotInfo +" "+ timestamp() );
        
    }
	public void closeReport()  {
		extent.endTest(test);
		extent.flush();
		
	}
	
public static void closedriver()  {
		
	IOSdriver.quit();				
	}
	public static WebDriver getdriver() {
		return IOSdriver;
		
	}
	
	public static MobileElement  waitForClickable(By locator) {
		WebDriverWait wait = new WebDriverWait(getdriver(), DEFAULT_WAIT_SECONDS);
		wait.ignoring(ElementNotVisibleException.class);
		wait.ignoring(WebDriverException.class);
		wait.ignoring(ElementClickInterceptedException.class);
		return  (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(locator));
		
	}



public static MobileElement  waitForVisibile(By locator) {
	
	WebDriverWait wait = new WebDriverWait(getdriver(), DEFAULT_WAIT_SECONDS);
	wait.ignoring(ElementNotVisibleException.class);
	return (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	
}
public static boolean click(By locator) {
	
	
	MobileElement  elm = waitForClickable(locator);
	if (elm == null) {
		return false;
	} else {
		elm.click();
		log.info("Click: " +locator.toString());
		return true;
	}
	
}

public static boolean sendkeys(By locator, String data) {
	MobileElement  elm = waitForVisibile(locator);
	if(elm==null) {
		return false;
	}else {
		elm.sendKeys(data);
		log.info("Input Text: " +data+" - "+locator.toString());
		return true;
	}
}

public static void clickOnBackButton(){
	IOSdriver.navigate().back();
	log.info("Back button clicked: ");
}

public static void setScreenOrientation(String Orientation){
	if(Orientation.equalsIgnoreCase("LANDSCAPE")){
		IOSdriver.rotate(ScreenOrientation.LANDSCAPE);
	log.info("Orientation: "+IOSdriver.getOrientation());
	}else{
		IOSdriver.rotate(ScreenOrientation.PORTRAIT);
		log.info("Orientation: "+IOSdriver.getOrientation());
	}
}

public static String getElementText(By locator) {
	IOSTestBase.lastAction = "Get Element text: " + locator.toString();
	log.info(IOSTestBase.lastAction);
	MobileElement  elm = waitForClickable(locator);	
	return elm.getText().trim();
	
}

public static boolean tap(By locator){	
	MobileElement  elm = waitForClickable(locator);
	if(elm==null) {
		return false;
	}else {
		action= new TouchAction(IOSdriver);
		action.tap(tapOptions().withElement(element(elm))).perform();
		log.info("Tap: "+locator.toString());
		return true;
	}
	
}

public static boolean longPress(By locator, int seconds){
	MobileElement  elm = waitForClickable(locator);
	if(elm==null) {
		return false;
	}else {
		action= new TouchAction(IOSdriver);
		action.longPress(longPressOptions().withElement(element(elm)).withDuration(ofSeconds(seconds))).release().perform();
		log.info("Long Press: "+locator.toString());
		return true;
	}
}
	

public static boolean dragAndDrop(By source,By destination, int seconds){
	MobileElement  elm1 = waitForClickable(source);
	MobileElement  elm2 = waitForClickable(destination);
	if(elm1==null && elm2==null) {
		return false;
	}else {
		action= new TouchAction(IOSdriver);
		action.longPress(longPressOptions().withElement(element(elm1)).withDuration(ofSeconds(seconds))).moveTo(element(elm2)).release().perform();
		log.info("Swipe from: "+source.toString() +" to: "+destination.toString() );
		return true;
	}
	
}
public static void verticalSwipedown( double startPercentage, double finalPercentage, int duration) throws Exception {
Dimension size = IOSdriver.manage().window().getSize();
int width = (int)(size.getWidth()/2);
int startPoint = (int)(size.getHeight()*startPercentage);
int endPoint = (int)(size.getHeight()*finalPercentage);
System.out.println(size);
System.out.println(width);
System.out.println(startPoint);
System.out.println(endPoint);
new TouchAction(IOSdriver).press(point(width,startPoint)).waitAction(waitOptions(Duration.ofSeconds(duration))).moveTo(point(width, endPoint)).release().perform();
}
public static void verticalSwipeup(double startPercentage, double finalPercentage, int duration) throws Exception {

Dimension size = IOSdriver.manage().window().getSize();
int width = (int)(size.getWidth()/2);
int startPoint = (int)(size.getHeight()*startPercentage);
int endPoint = (int)(size.getHeight()*finalPercentage);
new TouchAction(IOSdriver).press(point(width,endPoint)).waitAction(waitOptions(Duration.ofSeconds(duration))).moveTo(point(width, startPoint)).release().perform();

}  
public static void swipeLefttoRight(double startPercentage, double finalPercentage, int duration) throws Exception {

Dimension size = IOSdriver.manage().window().getSize();
int Hight = (int)(size.getHeight()/2);
int width = (int)(size.getWidth()/2);
int startPoint = (int)(size.getWidth()*startPercentage);
int endPoint = (int)(size.getWidth()*finalPercentage);
new TouchAction(IOSdriver).press(point(Hight,width)).waitAction(waitOptions(Duration.ofSeconds(duration))).moveTo(point(startPoint, endPoint)).release().perform();

}  

public void startServer() {
	//Set Capabilities
	capabilities = new DesiredCapabilities();
	capabilities.setCapability("noReset", "false");
	
	//Build the Appium service
	builder = new AppiumServiceBuilder();
	builder.withIPAddress("0.0.0.0");
	builder.usingPort(4723);
	builder.withCapabilities(capabilities);
	builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
	builder.withArgument(GeneralServerFlag.LOG_LEVEL,"error");
	
	//Start the server with the builder
	service = AppiumDriverLocalService.buildService(builder);
	service.start();
	log.info("Appium server started");
}

public void stopServer() {
	service.stop();
	log.info("Appium server shutting down");
}

public boolean checkIfServerIsRunnning(int port) {
	
	boolean isServerRunning = false;
	ServerSocket serverSocket;
	try {
		serverSocket = new ServerSocket(port);
		serverSocket.close();
	} catch (IOException e) {
		//If control comes here, then it means that the port is in use
		isServerRunning = true;
	} finally {
		serverSocket = null;
	}
	return isServerRunning;
}	


}
