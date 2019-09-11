package TestBase;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.BrowserType;
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
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.appium.java_client.touch.TapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;
import static io.appium.java_client.touch.offset.PointOption.point;
import static io.appium.java_client.touch.WaitOptions.waitOptions;

public class AndroidTestBase {
	public static AndroidDriver<MobileElement>	androidDriver;
	//public static AppiumDriver androidDriver1;
	public static Properties Repository = new Properties();
	public static File f;
	public static FileInputStream FI;
	public static Logger log = Logger.getLogger(AndroidTestBase.class);
	public static ExtentReports extent;
	public static ExtentTest test;
	public static int indexSI = 1;
	private static  long DEFAULT_WAIT_SECONDS = 60;
	public static TouchAction action;
	private static String lastAction;
	private static AppiumDriverLocalService service;
	private static AppiumServiceBuilder builder;
	private static DesiredCapabilities cap;
	private static   String appiumServiceUrl;
	    
	
	static {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		extent = new ExtentReports(System.getProperty("user.dir") + "/Reports/HtmlReports/Android Automaton Report"+".html", true);
		//extent = new ExtentReports(System.getProperty("user.dir") + "/Reports/HtmlReports/Automaton Report"+".html", false);

	}
	
	public static String timestamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
    }
	
	public static void loadPropertiesFile(String propertiesFileName) throws IOException {
		f = new File(System.getProperty("user.dir") + "//src//main//resources//ConfigFiles//"+propertiesFileName+".properties");
		FI = new FileInputStream(f);
		Repository.load(FI);
	}

	public  static void androidInit() throws IOException {
		System.out.println("x");
		String log4jConfPath = "./src/main/resources/ConfigFiles/log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		loadPropertiesFile("androidConfig");
	
		
		/*int port = 4723;
		if(!checkIfServerIsRunnning(port)) {
			System.out.println("***********");
			startServer();
			System.out.println("ssssssss");
			//appiumServer.stopServer();
		} else {
			System.out.println("Appium Server already running on Port - " + port);
		}*/
		//desiredCapabilities();
		
	}
	/*public void startServer() throws MalformedURLException {
		//Set Capabilities
		System.out.println("start");
		 service = AppiumDriverLocalService.buildDefaultService();
			service.start();
	        appiumServiceUrl = service.getUrl().toString();
	        System.out.println("Appium Service Address : - "+ appiumServiceUrl);
		 File appDir = new File(System.getProperty("user.dir"), "/Apps/");
			File app = new File(appDir, Repository.getProperty("Apkname")+".apk");
	        System.out.println(app);
	       
	        
	        DesiredCapabilities capabilities = new DesiredCapabilities();
	        
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, Repository.getProperty("deviceName"));//Google Nexus 4 - 4.2.2 - API 17 - 768x1280_1
			capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
			
			androidDriver = new AndroidDriver(new URL(appiumServiceUrl), capabilities);
			androidDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	public void stopServer() {
		service.stop();
	}
	*/
	
	public static void startServerr() {
		CommandLine cmd = new CommandLine("C:\\Program Files (x86)\\Appium\\node.exe");
		cmd.addArgument("C:\\Program Files (x86)\\Appium\\node_modules\\appium\\bin\\Appium.js");
		cmd.addArgument("--address");
		cmd.addArgument("127.0.0.1");
		cmd.addArgument("--port");
		cmd.addArgument("4723");
		
		DefaultExecuteResultHandler handler = new DefaultExecuteResultHandler();
		DefaultExecutor executor = new DefaultExecutor();
		executor.setExitValue(1);
		try {
			executor.execute(cmd, handler);
			Thread.sleep(10000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void stopServer1() {
		Runtime runtime = Runtime.getRuntime();
		try {
			runtime.exec("taskkill /F /IM node.exe");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void startServer() {
		//Set Capabilities
		cap = new DesiredCapabilities();
		cap.setCapability("noReset", "false");
		
		//Build the Appium service
		builder = new AppiumServiceBuilder();
		builder.withIPAddress("127.0.0.1");
		builder.usingPort(4723);
		builder.withCapabilities(cap);
		builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
		builder.withArgument(GeneralServerFlag.LOG_LEVEL,"error");
		
		//Start the server with the builder
		service = AppiumDriverLocalService.buildService(builder);
		service.start();
	}
	
	public void stopServer() {
		service.stop();
	}

	public static boolean checkIfServerIsRunnning(int port) {
		
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
	

	public static String executeCommand(String cmd)
	{
	    String commandresponse="";
	    try
	    {
	        Runtime run = Runtime.getRuntime();
	        Process proc=run.exec(cmd);
	        BufferedReader stdInput = new BufferedReader(new 
	                InputStreamReader(proc.getInputStream()));

	        BufferedReader stdError = new BufferedReader(new 
	                InputStreamReader(proc.getErrorStream()));

	        String response=null;
	        while ((response = stdInput.readLine()) != null) 
	        {
	            if(response.length()>0)
	            {
	                commandresponse=commandresponse+response;
	            }
	        }

	        while ((response = stdError.readLine()) != null) 
	        {
	            commandresponse=commandresponse+response;

	        }
	    }
	    catch(Exception e)
	    {
	        e.printStackTrace();
	    }
	    //System.out.println(commandresponse);
	    return commandresponse;
	}
	
	public static void desiredCapabilities() throws MalformedURLException{
		
       //androidDriver.installApp(System.getProperty("user.dir")+"/Apps/"+ Repository.getProperty("Apkname")+".apk");
		
		/*String cmd = "adb shell getprop ro.build.version.release";

		String osVersion=executeCommand(cmd);
		    if(osVersion.contains("7"))
		    {
		        //uninstall io.appium.settings
		        cmd="adb uninstall  io.appium.settings";
		        executeCommand(cmd);
		        System.out.println("uninstall io.appium.settings");

		        //uninstall io.appium.unlock
		        cmd="adb uninstall  io.appium.unlock";
		        executeCommand(cmd);
		        System.out.println("uninstall io.appium.unlock");

		    }*/
		    File appDir = new File(System.getProperty("user.dir"), "/Apps/");
			File app = new File(appDir, Repository.getProperty("Apkname")+".apk");
	        System.out.println(app);
		   
	        DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, Repository.getProperty("deviceName"));//Google Nexus 4 - 4.2.2 - API 17 - 768x1280_1
			capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
			/*capabilities.setCapability("appPackage", "com.flipkart.android");
			capabilities.setCapability("appActivity", "com.flipkart.android.activity.HomeFragmentHolderActivity");*/
		
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		
		androidDriver = new AndroidDriver<MobileElement>(url, capabilities);
		
		
		androidDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("getContext: "+androidDriver.getContext());
		System.out.println("currentActivity: "+androidDriver.currentActivity());
		System.out.println("isLocked: "+androidDriver.isDeviceLocked());
		
		//System.out.println("isAppInstalled: "+androidDriver.isAppInstalled(System.getProperty("user.dir")+"/Apps/"+ Repository.getProperty("Apkname")+".apk"));
		//driver.isAppInstalled("com.example.AppName");
		//System.out.println(androidDriver.getCurrentPackage());
	}
	
	public static void webDesiredCapabilities() throws IOException{
		
		String log4jConfPath = "./src/main/resources/ConfigFiles/log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		loadPropertiesFile("androidConfig");
		//DesiredCapabilities capabilities = DesiredCapabilities.android();
		 DesiredCapabilities capabilities = new DesiredCapabilities();
		
		
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Andriod");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, Repository.getProperty("deviceName"));
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, BrowserType.CHROME);
		/*URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver(url, capabilities);*/
		//androidDriver.manage().deleteAllCookies();
		//driver.get(Repository.getProperty("url"));
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		androidDriver = new AndroidDriver(url, capabilities);
		androidDriver.get(Repository.getProperty("url"));
		androidDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	public static void updateResult(int indexSI, String testCaseName, String testCaseStatus, String scriptName) throws IOException {
		String startDateTime = new SimpleDateFormat("MM-dd-yyyy_HH-ss").format(new GregorianCalendar().getTime());

		String userDirector = System.getProperty("user.dir");

		String resultFile = userDirector + "\\Reports\\HtmlReports\\AndroidTestHtmlReport.html";
		
		File file = new File(resultFile);
		System.out.println(file.exists());

		if (!file.exists()) {
			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("<html>" + "\n");
			bw.write("<head><title>" + "Test execution report" + "</title>" + "\n");
			bw.write("</head>" + "\n");
			bw.write("<body>");
			bw.write("<font face='Tahoma'size='2'>" + "\n");
			bw.write("<u><h1 align='center'>" + "Test execution report" + "</h1></u>" + "\n");
			bw.flush();
			bw.close();
		}	
		BufferedWriter bw1 = new BufferedWriter(new FileWriter(file, true));
		if (indexSI == 1) {
			bw1.write("<table align='center' border='0' width='70%' height='10'>");
			bw1.write("<tr><td width='70%' </td></tr>");
			bw1.write("<table align='center' border='1' width='70%' height='47'>");
			bw1.write("<tr>");
			bw1.write("<td colspan='2' align='center'><b><font color='#000000' face='Tahoma' size='2'>ScriptName :&nbsp;&nbsp;&nbsp;</font><font color='#0000FF'' face='Tahoma' size='2'>" + scriptName + " </font></b></td>");
			bw1.write("<td colspan='1' align='left'><b><font color='#000000' face='Tahoma' size='1'>Start Time :&nbsp;</font></b><font color='#0000FF'' face='Tahoma' size='1'>" + startDateTime + " </font></td>");
			bw1.write("</tr>");
			bw1.write("</tr>");
			bw1.write("<td  bgcolor='#CCCCFF' align='center'><b><font color='#000000' face='Tahoma' size='2'>S.No</font></b></td>");
			bw1.write("<td  bgcolor='#CCCCFF' align='left'><b><font color='#000000' face='Tahoma' size='2'>Test case ID : Test case Description </font></b></td>");

			bw1.write("<td  bgcolor='#CCCCFF' align='center'><b><font color='#000000' face='Tahoma' size='2'>Result </font></b></td>");
			bw1.write("</tr>");
		}
		bw1.write("<tr>" + "\n");
		bw1.write("<td bgcolor='#FFFFDC'align='Center'><font color='#000000' face='Tahoma' size='2'>" + indexSI + "</font></td>" + "\n");
		bw1.write("<td  bgcolor='#FFFFDC' valign='middle' align='left'><b><font color='#000000' face='Tahoma' size='2'>" + testCaseName + "</font></b></td>" + "\n");
		if (testCaseStatus == "Pass") {
			bw1.write("<td  bgcolor='#FFFFDC' valign='middle' align='center'><b><font color='Green' face='Tahoma' size='2'>" + testCaseStatus + "</font></b></td>" + "\n");
		} else {
			bw1.write("<td  bgcolor='#FFFFDC' valign='middle' align='center'><b><font color='red' face='Tahoma' size='2'>" + testCaseStatus + "</font></b></td>" + "\n");
		}
		bw1.write("</tr>" + "\n");
		bw1.write("</body>" + "\n");
		bw1.write("</html>");
		bw1.flush();
		bw1.close();

	}
	public void getresult(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.SUCCESS) {
			updateResult(indexSI++, getClass().getName(), "Pass", "Test1");
			test.log(LogStatus.PASS, result.getName() + " test is pass");
		} else if (result.getStatus() == ITestResult.SKIP) {
			updateResult(indexSI++, getClass().getName(), "Skip", "Test1");
			test.log(LogStatus.SKIP, result.getName() + " test is skipped and skip reason is:-" + result.getThrowable());
		} else if (result.getStatus() == ITestResult.FAILURE) {
			updateResult(indexSI++, getClass().getName(), "Fail", "Test1");
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

	/*@AfterClass(alwaysRun = true)
	public void endTest() {
		closeBrowser();
	}*/
	
	public static void excelReport( )
	{
		String userDirector = System.getProperty("user.dir");

		String resultFile = userDirector + "\\Reports\\ExcelReports";
		try {
			//Xl.generateReport(resultFile, "AndroidExcelReports.xlsx");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		excelReport( );
		
	}
	public static void closedriver()  {
		
		androidDriver.quit();				
	}
	public static WebDriver getdriver() {
		return androidDriver;
		
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

public static void clickOnBackButton(){
	androidDriver.pressKeyCode(AndroidKeyCode.BACK);
	log.info("Back button clicked: ");
}

public static void hideKeyBoard(){
	//boolean isKeyboardShown = androidDriver.isKeyboardShown();
	
	if(androidDriver.isKeyboardShown()){
	androidDriver.hideKeyboard();
	log.info("hide Keyboard ");
	}else{
		log.info("Keyboard is not shown ");
	}
		
}

public static void clickOnHomeButton(){
	androidDriver.pressKeyCode(AndroidKeyCode.HOME);
	log.info("Home button clicked: ");
}

public static void setScreenOrientation(String Orientation){
	if(Orientation.equalsIgnoreCase("LANDSCAPE")){
	androidDriver.rotate(ScreenOrientation.LANDSCAPE);
	log.info("Orientation: "+androidDriver.getOrientation());
	}else{
		androidDriver.rotate(ScreenOrientation.PORTRAIT);
		log.info("Orientation: "+androidDriver.getOrientation());
	}
}

public static void installApp(){
	
	androidDriver.installApp("/Users/johndoe/path/to/app.apk");
	log.info("Back button clicked: ");
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
public static boolean doublecClick(By locator) {
	
	
	MobileElement  elm = waitForClickable(locator);
	if (elm == null) {
		return false;
	} else {
		action= new TouchAction(androidDriver);
		//action.tap(elm).tap(elm).perform();
		action.tap(tapOptions().withElement(element(elm))).perform();
		/*TouchActions action = new TouchActions(androidDriver);
		action.doubleTap(elm);
		action.perform();
*/

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


public static void scrollToParticularElement(String text){
	
	//androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Preference\"));").click();
	androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));");	
	log.info("Scrolled to particular element");
	
}
public static boolean tap(By locator){	
	MobileElement  elm = waitForClickable(locator);
	if(elm==null) {
		return false;
	}else {
		action= new TouchAction(androidDriver);
		action.tap(tapOptions().withElement(element(elm))).perform();
		log.info("Tap: "+locator.toString());
		return true;
	}
	
}
public static String getElementText(By locator) {
	AndroidTestBase.lastAction = "Get Element text: " + locator.toString();
	log.info(AndroidTestBase.lastAction);
	MobileElement  elm = waitForClickable(locator);	
	return elm.getText().trim();
	
}

public static boolean longPress(By locator, int seconds){
	MobileElement  elm = waitForClickable(locator);
	if(elm==null) {
		return false;
	}else {
		action= new TouchAction(androidDriver);
		action.longPress(longPressOptions().withElement(element(elm)).withDuration(ofSeconds(seconds))).release().perform();
		log.info("Long Press: "+locator.toString());
		return true;
	}
		
}

public static boolean swipe(By source,By destination,int seconds ){
	MobileElement  elm1 = waitForVisibile(source);
	MobileElement  elm2 = waitForVisibile(destination);
	if(elm1==null && elm2==null) {
		return false;
	}else {
		action= new TouchAction(androidDriver);
		action.longPress(longPressOptions().withElement(element(elm1)).withDuration(ofSeconds(seconds))).moveTo(element(elm2)).release().perform();
		log.info("Swipe from: "+source.toString() +" to: "+destination.toString() );
		return true;
	}
	
}
public static boolean dragAndDrop(By source,By destination, int seconds){
	MobileElement  elm1 = waitForClickable(source);
	MobileElement  elm2 = waitForClickable(destination);
	if(elm1==null && elm2==null) {
		return false;
	}else {
		action= new TouchAction(androidDriver);
		action.longPress(longPressOptions().withElement(element(elm1)).withDuration(ofSeconds(seconds))).moveTo(element(elm2)).release().perform();
		log.info("Swipe from: "+source.toString() +" to: "+destination.toString() );
		return true;
	}
	
}
public static void verticalSwipedown( double startPercentage, double finalPercentage, int duration) throws Exception {
Dimension size = androidDriver.manage().window().getSize();
int width = (int)(size.getWidth()/2);
int startPoint = (int)(size.getHeight()*startPercentage);
int endPoint = (int)(size.getHeight()*finalPercentage);
System.out.println(size);
System.out.println(width);
System.out.println(startPoint);
System.out.println(endPoint);
new TouchAction(androidDriver).press(point(width,startPoint)).waitAction(waitOptions(Duration.ofSeconds(duration))).moveTo(point(width, endPoint)).release().perform();
}
public static void verticalSwipeup(double startPercentage, double finalPercentage, int duration) throws Exception {

Dimension size = androidDriver.manage().window().getSize();
int width = (int)(size.getWidth()/2);
int startPoint = (int)(size.getHeight()*startPercentage);
int endPoint = (int)(size.getHeight()*finalPercentage);
new TouchAction(androidDriver).press(point(width,endPoint)).waitAction(waitOptions(Duration.ofSeconds(duration))).moveTo(point(width, startPoint)).release().perform();

}  
public static void swipeLefttoRight(double startPercentage, double finalPercentage, int duration) throws Exception {

Dimension size = androidDriver.manage().window().getSize();
int Hight = (int)(size.getHeight()/2);
int width = (int)(size.getWidth()/2);
int startPoint = (int)(size.getWidth()*startPercentage);
int endPoint = (int)(size.getWidth()*finalPercentage);
new TouchAction(androidDriver).press(point(Hight,width)).waitAction(waitOptions(Duration.ofSeconds(duration))).moveTo(point(startPoint, endPoint)).release().perform();

}  

/*public void hortizonalSwipe()
{
	Dimension dim = androidDriver.manage().window().getSize();
	int height = dim.getHeight();
	int width = dim.getWidth();
	int y = (int)(height*0.20);
	int startx = (int)(width*0.75);
	int endx = (int)(width*0.35);
	
	action.press(y, startx).moveTo(y, endx).release().perform();
}
public static void verticalSwipe()
{
	Dimension dim = androidDriver.manage().window().getSize();
	int height = dim.getHeight();
	int width = dim.getWidth();
	int x = width/2;
	int starty = (int)(height*0.8);
	int endy = (int)(height*0.2);
	System.out.println(height +"  "+width + "  " + x +"  " +"  "+starty +" " +endy );
	action.press(x, starty).moveTo(x, endy).release().perform();
	
}
public static void verticalSwipedown(AndroidDriver<MobileElement> androidDriver, double startPercentage, double finalPercentage, int duration) throws Exception {
Dimension size = androidDriver.manage().window().getSize();
int width = (int)(size.getWidth()/2);
int startPoint = (int)(size.getHeight()*startPercentage);
int endPoint = (int)(size.getHeight()*finalPercentage);
new TouchAction(androidDriver).press(point(width,startPoint)).waitAction(waitOptions(Duration.ofMillis(duration)))
.moveTo(point(anchor, endPoint)).release().perform();
new TouchAction(driver).press(point(anchor, startPoint)).waitAction(waitOptions(Duration.ofMillis(duration)))
.moveTo(point(anchor, endPoint)).release().perform();
//new TouchAction(androidDriver).press(width, startPoint).waitAction(duration).moveTo(width, endPoint).release().perform();
}
public static void verticalSwipeup(double startPercentage, double finalPercentage, int duration) throws Exception {

Dimension size = androidDriver.manage().window().getSize();
int width = (int)(size.getWidth()/2);
int startPoint = (int)(size.getHeight()*startPercentage);
int endPoint = (int)(size.getHeight()*finalPercentage);
new TouchAction(androidDriver).press(width,endPoint).waitAction(Duration.ofMillis(duration)).moveTo(width, startPoint).release().perform();
}  
public static void swipeLefttoRight(double startPercentage, double finalPercentage, int duration) throws Exception {

Dimension size = androidDriver.manage().window().getSize();
int Hight = (int)(size.getHeight()/2);
int width = (int)(size.getWidth()/2);
int startPoint = (int)(size.getWidth()*startPercentage);
int endPoint = (int)(size.getWidth()*finalPercentage);
new TouchAction(androidDriver).press(Hight,width).waitAction(Duration.ofMillis(duration)).moveTo(startPoint, endPoint).release().perform();
}  
public static boolean moveTo(By locator){
	MobileElement  elm = waitForVisibile(locator);
	if(elm==null) {
		return false;
	}else {
		action= new TouchAction(androidDriver);
		action.moveTo(elm).perform();
		log.info("move To: "+locator.toString());
		return true;
	}
		
}


	@AfterSuite
	public void sendMail(){
		SentMail.sendEmail();
		SendOutLookMail.sendOutLookMail();
	}*/
}
