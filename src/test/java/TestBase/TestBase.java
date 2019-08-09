package TestBase;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.google.common.base.Function;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Common.Screenshot;
import Common.SendOutLookMail;
import Common.SentMail;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;


public class TestBase {

	public static Properties Repository = new Properties();
	public File f;
	public FileInputStream FI;
	public static WebDriver driver;
	public String startTime;
	public static int indexSI = 1;
	public static ExtentReports extent;
	public static ExtentTest test1;
	public static Actions action;
	
	public static Logger log = Logger.getLogger(TestBase.class);
	private static final long DEFAULT_WAIT_SECONDS = 60;
	private static String lastAction;
	public static Robot r;
	public static Screen s;
	
	public static String serviceUrl;	
	public static String url;
	public static CloseableHttpResponse closebaleHttpResponse;
	public static HashMap<String, String> headerMap = new HashMap<String, String>();
	public static String responseString;
	public static JSONObject responseJson;
	
	
	
	
	
	
	static {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		extent = new ExtentReports(System.getProperty("user.dir") + "/Reports/HtmlReports/Automaton Report"+".html", true);
		//extent = new ExtentReports(System.getProperty("user.dir") + "/Reports/HtmlReports/Automaton Report"+".html", false);

	}
	
	public static String timestamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
    }

	public void init() throws IOException {
		String log4jConfPath = "./src/main/resources/ConfigFiles/log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		loadPropertiesFile("kvbNetBanking");
		selectBrowser(Repository.getProperty("browser"));
		driver.manage().window().fullscreen();
		//driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(Repository.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
	}
	public void crossBrowserinit(String browser) throws IOException {
		String log4jConfPath = "./src/main/resources/ConfigFiles/log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		loadPropertiesFile("restWebservices");
		selectBrowser(browser);
		driver.get(Repository.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}
	

	public void loadPropertiesFile(String propertiesFileName) throws IOException {
		f = new File(System.getProperty("user.dir") + "//src//main//resources//ConfigFiles//"+propertiesFileName+".properties");
		FI = new FileInputStream(f);
		Repository.load(FI);
	}


	public void selectBrowser(String browser){
		if(System.getProperty("os.name").contains("Window")){
			if(browser.equalsIgnoreCase("firefox")){
				//https://github.com/mozilla/geckodriver/releases
				System.out.println(System.getProperty("user.dir"));
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/main/resources/Drivers/geckodriver.exe");			
				driver = new FirefoxDriver();
			}
			else if(browser.equalsIgnoreCase("chrome")){
				//https://chromedriver.storage.googleapis.com/index.html
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/resources/Drivers/chromedriver.exe");
				driver = new ChromeDriver();
				
			}
		}
		else if(System.getProperty("os.name").contains("Mac")){
			System.out.println(System.getProperty("os.name"));
			if(browser.equalsIgnoreCase("firefox")){
				System.out.println(System.getProperty("user.dir"));
				System.setProperty("webdriver.firefox.marionette", System.getProperty("user.dir")+"/drivers/geckodriver");
				driver = new FirefoxDriver();
				
			}
			else if(browser.equalsIgnoreCase("chrome")){
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/resources/MacBrowers/chromedriver");
				driver = new ChromeDriver();
				
			}else if(browser.equalsIgnoreCase("safari")){
				driver= new SafariDriver();
				
			}
		}
	}

	public void expliciteWait(WebElement element, int timeToWaitInSec) {
		WebDriverWait wait = new WebDriverWait(driver, timeToWaitInSec);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForPageToLoad(long timeOutInSeconds) {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		try {
			System.out.println("Waiting for page to load...");
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			wait.until(expectation);
		} catch (Throwable error) {
			System.out.println("Timeout waiting for Page Load Request to complete after " + timeOutInSeconds + " seconds");
			Assert.assertFalse(true, "Timeout waiting for Page Load Request to complete.");

		}
	}

	public void clickWhenReady(By locator, int timeout) {
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();

	}

	public WebElement fluentWait(final WebElement webElement, int timeinsec) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(timeinsec, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return webElement;
			}
		});

		return element;
	};

	public WebElement getWhenVisible(By locator, int timeout) {
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return element;

	}

	public void waitFor(int sec) throws InterruptedException {
		Thread.sleep(sec * 1000);
	}


	public  void getScreenShot(String fileName) throws IOException {
		File outputFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(outputFile, new File(System.getProperty("user.dir") + "//Reports//screenshots//" + fileName + ".jpg"));
	}

	public static String now(String format) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat fm = new SimpleDateFormat();
		return fm.format(cal.getTime());
	}

	public static void updateResult(int indexSI, String testCaseName, String testCaseStatus, String scriptName) throws IOException {
		String startDateTime = new SimpleDateFormat("MM-dd-yyyy_HH-ss").format(new GregorianCalendar().getTime());

		String userDirector = System.getProperty("user.dir");

		String resultFile = userDirector + "\\Reports\\HtmlReports\\TestHtmlReport.html";
		
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
			test1.log(LogStatus.PASS, result.getName() + " test is pass");
		} else if (result.getStatus() == ITestResult.SKIP) {
			updateResult(indexSI++, getClass().getName(), "Skip", "Test1");
			test1.log(LogStatus.SKIP, result.getName() + " test is skipped and skip reason is:-" + result.getThrowable());
		} else if (result.getStatus() == ITestResult.FAILURE) {
			updateResult(indexSI++, getClass().getName(), "Fail", "Test1");
			test1.log(LogStatus.ERROR, result.getName() + " test is failed" + result.getThrowable());
			String screen = Screenshot.capture(driver, getClass().getName());
			test1.log(LogStatus.FAIL, test1.addBase64ScreenShot("data:image/png;base64,"+screen));
			
		} else if (result.getStatus() == ITestResult.STARTED) {
			test1.log(LogStatus.INFO, result.getName() + " test is started in ");
		}
	}

	/*@AfterMethod()
	public void afterMethod(ITestResult result) throws IOException {
		getresult(result);
	}

	@BeforeMethod()
	public void beforeMethod(Method result) {
		
		test1 = extent.startTest(result.getName());
		test1.log(LogStatus.INFO, result.getName() + " test Started");
		
	}

	@AfterClass(alwaysRun = true)
	public void endTest() {
		closeBrowser();
	}

	public void closeBrowser()  {
		extent.endTest(test1);
		extent.flush();
		driver.quit();
		excelReport( );
		SentMail.sendEmail();
		SendOutLookMail.sendOutLookMail();
	}
	
*/	public String captureScreen(String fileName) {
		if (fileName == "") {
			fileName = "blank";
		}
		File destFile = null;
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "/src/main/java/com/test/automation/uiAutomation/screenshot/";
			destFile = new File((String) reportDirectory + fileName + "_" + formater.format(calendar.getTime()) + ".png");
			FileUtils.copyFile(scrFile, destFile);
			// This will help us to link the screen shot in testNG report
			Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destFile.toString();
	}
	public static WebDriver getdriver() {
		return driver;
		
	}
	
	/*//=========================================
				keywords
	===========================================*/
	
	//private static Map<String, WebDriver> drivers = new HashMap<>();

	
	
public static WebElement waitForClickable(By locator) {
		WebDriverWait wait = new WebDriverWait(getdriver(), DEFAULT_WAIT_SECONDS);
		wait.ignoring(ElementNotVisibleException.class);
		wait.ignoring(WebDriverException.class);
		wait.ignoring(ElementClickInterceptedException.class);
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
		
	}

public static boolean click(By locator) {
	
		
		WebElement elm = waitForClickable(locator);
		if (elm == null) {
			return false;
		} else {
			elm.click();
			log.info("Click: " +locator.toString());
			return true;
		}		
	}


public static WebElement waitForVisibile(By locator) {
	
	WebDriverWait wait = new WebDriverWait(getdriver(), DEFAULT_WAIT_SECONDS);
	wait.ignoring(ElementNotVisibleException.class);
	return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	
}


public static boolean sendkeys(By locator, String data) {
	WebElement elm = waitForVisibile(locator);
	if(elm==null) {
		return false;
	}else {
		elm.sendKeys(data);
		log.info("Input Text: " +data+" - "+locator.toString());
		return true;
	}
	
}

public static void selectVisibleText(By locator, String visibleText) {
	WebElement elm = waitForVisibile(locator);
	WebElement elm1 = driver.findElement(By.className(""));
	Select se=new Select(elm);
	se.selectByVisibleText(visibleText);
	log.info("Select visible text in the dropdown : "+locator.toString());
}

public static void mouseHover(By locator) {
	WebElement elm = waitForVisibile(locator);
	//WebElement hoverElement = driver.findElement(elm);
	action = new Actions(driver);
	action.moveToElement(elm);
	action.click().build().perform();
	log.info("Hover the element : "+locator.toString());
	
}

public static String getElementText(By locator) {
	TestBase.lastAction = "Get Element text: " + locator.toString();
	log.info(TestBase.lastAction);
	WebElement elm = waitForClickable(locator);
	return elm.getText().trim();
}
public static void handlingAlert() {
	driver.switchTo().alert().accept();
}

public static void clear(By locater) {
	WebElement elm = driver.findElement(locater);
	elm.clear();
}

public static String getLabelText(By locator) {
	TestBase.lastAction = "Get Element text: " + locator.toString();
	log.info(TestBase.lastAction);
	WebElement elm = waitForVisibile(locator);
	return elm.getText().trim();
}

public static void handlingWindow() {
	String child = null;
	
	Set<String> handler = driver.getWindowHandles();
	Iterator<String> iter = handler.iterator();
	log.info("total windows are--->" + handler.size());
	/*
	 * while(iter.hasNext()){ child=driver.getWindowHandle(); break; }
	 * log.info("loanprocess child window is--->"+child);
	 * driver.switchTo().window(child);
	 */
	String parentWindow = iter.next();
	log.info("loanprocess parentWindow  is--->" + parentWindow);
	String childWindow = iter.next();
	log.info("loanprocess child window is--->" + childWindow);
	driver.switchTo().window(childWindow);
	String tilte = driver.getTitle();
	log.info("loanprocess child windowtitle is--->" + tilte);
}
public static void frameHandling( String frameName) {
	WebDriverWait wait = new WebDriverWait(getdriver(), DEFAULT_WAIT_SECONDS);
	wait.ignoring(ElementNotVisibleException.class);
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameName));
}
public static void actionsclick(By locator) {
	WebElement elm = waitForVisibile(locator);
	// WebElement hoverElement = driver.findElement(elm);
	action = new Actions(driver);
	action.moveToElement(elm);
	action.click().build().perform();
	log.info("Hover the element : " + locator.toString());
}
public static void autosearch(By locater, String keyToSearch) throws InterruptedException {
	WebElement elm = waitForVisibile(locater);
	WebElement elm2 = driver.findElement(locater);
	elm2.click();
	Actions a = new Actions(driver);
	a.sendKeys(keyToSearch).build().perform();
	Thread.sleep(2000);
	a.sendKeys(Keys.DOWN).build().perform();
	Thread.sleep(2000);
	a.sendKeys(Keys.ENTER).build().perform();

	log.info("Input Text: " + keyToSearch + " - " + locater.toString());
}
public static void actionClick(int num) throws InterruptedException {
	
	Actions a = new Actions(driver);
	
	for(int i=0;i<=num-2;i++){
	a.sendKeys(Keys.DOWN).build().perform();
	}
	a.sendKeys(Keys.ENTER).build().perform();

	
}
public static void selectElement(int ElementIndex) throws AWTException, InterruptedException {
	Robot r = new Robot();
	for (int i = 0; i <= 51; i++) {
		r.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		r.keyRelease(KeyEvent.VK_TAB);
	}
	r.keyPress(KeyEvent.VK_ENTER);
	Thread.sleep(2000);
	r.keyRelease(KeyEvent.VK_ENTER);
}

public static void sendkeys(String value) throws AWTException {

	String text = value;
	StringSelection stringSelection = new StringSelection(text);
	Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	clipboard.setContents(stringSelection, stringSelection);
	r = new Robot();

	r.keyPress(KeyEvent.VK_CONTROL);
	r.keyPress(KeyEvent.VK_V);
	r.keyRelease(KeyEvent.VK_V);
	r.keyRelease(KeyEvent.VK_CONTROL);

}

public static void robotDropDown(int dropdownElementindex,int optionIndex) throws AWTException, InterruptedException {
	 r = new Robot();
	for (int i = 0; i <= dropdownElementindex; i++) {
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
	}
	r.keyPress(KeyEvent.VK_ENTER);
	r.keyRelease(KeyEvent.VK_ENTER);
	for(int i = 0; i <= dropdownElementindex; i++){
	r.keyPress(KeyEvent.VK_DOWN);
	r.keyRelease(KeyEvent.VK_DOWN);
	}
	r.keyPress(KeyEvent.VK_ENTER);
	Thread.sleep(2000);
	r.keyRelease(KeyEvent.VK_ENTER);
}

public static void skipElement(int numberOfneedToSkip) throws InterruptedException, AWTException {
	 r = new Robot();
	for (int i = 0; i < numberOfneedToSkip; i++) {
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
	}
}
public static void KeyUp(int numberOfkeyUps) throws InterruptedException, AWTException {
	System.out.println("keyup is started");
	 r = new Robot();
	for (int i = 0; i < numberOfkeyUps; i++) {
		r.keyPress(KeyEvent.VK_UP);
		r.keyRelease(KeyEvent.VK_UP);
	}
	r.keyPress(KeyEvent.VK_ENTER);
	r.keyRelease(KeyEvent.VK_ENTER);
	
}
public static void KeyDown(int numberOfkeyUps) throws InterruptedException, AWTException {
	System.out.println("keyup is started");
	 r = new Robot();
	for (int i = 0; i < numberOfkeyUps; i++) {
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
	}
	r.keyPress(KeyEvent.VK_ENTER);
	r.keyRelease(KeyEvent.VK_ENTER);
	
}
public static void sikuliclick(String imagePath) throws FindFailed{
	s=new Screen();
	s.click(imagePath);
}

public static String getDecodedString(String decodesring )
{
return new String(Base64.getDecoder().decode(decodesring.getBytes()));
}

public static void excelReport( )
{
	String userDirector = System.getProperty("user.dir");

	String resultFile = userDirector + "\\Reports\\ExcelReports";
	try {
		//Xl.generateReport(resultFile, "ExcelReports.xlsx");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

//****** webservices******
public void webServicesInit() throws IOException {
	String log4jConfPath = "./src/main/resources/ConfigFiles/log4j.properties";
	PropertyConfigurator.configure(log4jConfPath);
	loadPropertiesFile("restWebservices");
	
}
//1. GET Method without Headers:
	public static CloseableHttpResponse get(String url) throws ClientProtocolException, IOException{
	CloseableHttpClient httpClient = HttpClients.createDefault();
	HttpGet httpget = new HttpGet(url); //http get request
	CloseableHttpResponse closebaleHttpResponse =  httpClient.execute(httpget); //hit the GET URL
	
	return closebaleHttpResponse;
		
	}
	
	//2. GET Method with Headers:
		public static CloseableHttpResponse get(String url, HashMap<String, String> headerMap) throws ClientProtocolException, IOException{
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url); //http get request
		
		for(Map.Entry<String,String> entry : headerMap.entrySet()){
			httpget.addHeader(entry.getKey(), entry.getValue());
		}
		CloseableHttpResponse closebaleHttpResponse =  httpClient.execute(httpget); //hit the GET URL
		return closebaleHttpResponse;
			
		}
	
	//3. POST Method:
		public static CloseableHttpResponse post(String url, String entityString, HashMap<String, String> headerMap) throws ClientProtocolException, IOException{
			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpPost httppost = new HttpPost(url); //http post request
			
			httppost.setEntity(new StringEntity(entityString)); //for payload
			
			//for headers:
			for(Map.Entry<String,String> entry : headerMap.entrySet()){
				httppost.addHeader(entry.getKey(), entry.getValue());
			}
			
			CloseableHttpResponse closebaleHttpResponse = httpClient.execute(httppost);
			return closebaleHttpResponse;
			
			
		}
		public static CloseableHttpResponse post(String url, String entityString) throws ClientProtocolException, IOException{
			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpPost httppost = new HttpPost(url); //http post request
			
			httppost.setEntity(new StringEntity(entityString)); //for payload
						
			CloseableHttpResponse closebaleHttpResponse = httpClient.execute(httppost);
			return closebaleHttpResponse;
			
			
		}
		//3. PUT Method:
		public static CloseableHttpResponse put(String url, String entityString, HashMap<String, String> headerMap) throws ClientProtocolException, IOException{
			CloseableHttpClient httpClient = HttpClients.createDefault();
			
			HttpPut httpput = new HttpPut(url);
			httpput.setEntity(new StringEntity(entityString)); //for payload
			
			//for headers:
			for(Map.Entry<String,String> entry : headerMap.entrySet()){
				httpput.addHeader(entry.getKey(), entry.getValue());
			}
			
			CloseableHttpResponse closebaleHttpResponse = httpClient.execute(httpput);
			return closebaleHttpResponse;			
		}
		public static CloseableHttpResponse put(String url, String entityString) throws ClientProtocolException, IOException{
			CloseableHttpClient httpClient = HttpClients.createDefault();
			
			HttpPut httpput = new HttpPut(url);
			httpput.setEntity(new StringEntity(entityString)); //for payload
			CloseableHttpResponse closebaleHttpResponse = httpClient.execute(httpput);
			return closebaleHttpResponse;			
		}
		
		//1. Delete Method
		public static CloseableHttpResponse delete(String url) throws ClientProtocolException, IOException{
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpDelete httpdelete = new HttpDelete(url);//http get request
		CloseableHttpResponse closebaleHttpResponse =  httpClient.execute(httpdelete); //hit the delete URL
		
		return closebaleHttpResponse;
			
		}
		
				public static CloseableHttpResponse delete(String url, HashMap<String, String> headerMap) throws ClientProtocolException, IOException{
				CloseableHttpClient httpClient = HttpClients.createDefault();
				HttpDelete httpdelete = new HttpDelete(url);
				
				for(Map.Entry<String,String> entry : headerMap.entrySet()){
					httpdelete.addHeader(entry.getKey(), entry.getValue());					
				}
				CloseableHttpResponse closebaleHttpResponse =  httpClient.execute(httpdelete); //hit the GET URL
				return closebaleHttpResponse;
					
				}
		
		

		public static String getValueByJPath(JSONObject responsejson, String jpath) throws NumberFormatException, JSONException{
			Object obj = responsejson;
			for(String s : jpath.split("/")) 
				if(!s.isEmpty()) 
					if(!(s.contains("[") || s.contains("]")))
						obj = ((JSONObject) obj).get(s);
					else if(s.contains("[") || s.contains("]"))
						obj = ((JSONArray) ((JSONObject) obj).get(s.split("\\[")[0])).get(Integer.parseInt(s.split("\\[")[1].replace("]", "")));
			return obj.toString();
		}
	
		
		/*public void closeReport()  {
			extent.endTest(test1);
			extent.flush();
			excelReport( );					
		}
		*/
		public static void getAllHeaders(){
		Header[] headersArray = closebaleHttpResponse.getAllHeaders();
		HashMap<String, String> allHeaders = new HashMap<String, String>();
		for (Header header : headersArray) {
			allHeaders.put(header.getName(), header.getValue());
		}
		System.out.println("Headers Array-->"+allHeaders);
		//test1.log(LogStatus.INFO, "Headers Array-->"+allHeaders);
		log.info("Headers Array-->"+allHeaders);

		}

		public static JSONObject getResponseFromJson() throws ParseException, IOException {
			try{
			 responseString = EntityUtils.toString(closebaleHttpResponse.getEntity(), "UTF-8");
			 responseJson = new JSONObject(responseString);
			
			System.out.println("Response JSON from API---> " + responseJson);
			//test1.log(LogStatus.INFO, "Response JSON from API---> " + responseJson);
			log.info("Response JSON from API---> " + responseJson);
			
			}catch(Exception e){
				//test1.log(LogStatus.INFO, "Exception occured" +e.getMessage());
				log.info("Exception occured" +e.getMessage());
			}
			return responseJson;
			
		}
		public static  int getStatusCode()  {
			
			int statusCode = closebaleHttpResponse.getStatusLine().getStatusCode();
			return statusCode;
		}
		
		
		
		
}
