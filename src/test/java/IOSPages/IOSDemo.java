package IOSPages;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import TestBase.IOSTestBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class IOSDemo extends IOSTestBase{
	
	public  IOSDriver driver;
	@Test
	public void sample() throws MalformedURLException {
		
		//startServer();
		
		System.out.println("hello world");
		 File appDir = new File(System.getProperty("user.dir"), "/Apps/");
			File app = new File(appDir, "UICatalog.app");
		
		DesiredCapabilities capabilities = new DesiredCapabilities();

		//capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
		

		//capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.0");

		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 8 Plus");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "IOS");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);

		capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		System.out.println("hello world1");
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new IOSDriver<MobileElement>(url, capabilities);
		//driver = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		System.out.println("hello world2");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("hello world3");
		driver.findElementByAccessibilityId("Alert Views").click();
		
		System.out.println("hello world4");
		driver.findElementByXPath("//*[@value='Text Entry']").click();
		driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("hello");
		driver.findElementByName("OK").click();
		driver.navigate().back();

		 /*Dimension size = driver.manage().window().getSize();
		        int x = size.getWidth() / 2;
		        int starty = (int) (size.getHeight() * 0.60);
		        int endy = (int) (size.getHeight() * 0.10);
		       driver.swipe(x, starty, x, endy, 2000);
		        driver.findElementByAccessibilityId("Steppers").click();
		        driver.findElementByAccessibilityId("Increment").click();
		        driver.findElementByAccessibilityId("Increment").click();
		        System.out.println(driver.findElementsByClassName("XCUIElementTypeStaticText").get(1).getText());
		        
		        System.out.println(driver.findElementsByClassName("XCUIElementTypeStaticText").get(2).getText());
		        driver.findElementByAccessibilityId("Decrement").click();
		        
		        System.out.println(driver.findElementsByClassName("XCUIElementTypeStaticText").get(1).getText());
		        driver.navigate().back();
		        driver.findElementByAccessibilityId("Picker View").click();
		        driver.findElementByName("Green color component value").sendKeys("220");
		        driver.findElementsByClassName("XCUIElementTypePickerWheel").get(0).sendKeys("55");
		        driver.findElementByXPath("//*[@name='Blue color component value']").sendKeys("130");
		*/
		Dimension size = driver.manage().window().getSize();
		int width = (int)(size.getWidth()/2);
		int startPoint = (int)(size.getHeight()*0.60);
		int endPoint = (int)(size.getHeight()*0.10);
		System.out.println(size);
		System.out.println(width);
		System.out.println(startPoint);
		System.out.println(endPoint);
		new TouchAction(driver).press(point(width,startPoint)).waitAction(waitOptions(Duration.ofSeconds(1))).moveTo(point(width, endPoint)).release().perform();
		driver.findElementByAccessibilityId("Steppers").click();
        driver.findElementByAccessibilityId("Increment").click();
        driver.findElementByAccessibilityId("Increment").click();
        driver.findElementByAccessibilityId("Decrement").click();
        driver.navigate().back();
        driver.findElementByAccessibilityId("Picker View").click();
        driver.findElementByName("Green color component value").sendKeys("220");
       // driver.findElementsByClassName("XCUIElementTypePickerWheel").get(0).sendKeys("55");
        driver.findElementByXPath("//*[@name='Blue color component value']").sendKeys("130");        
		       // stopServer();


	}
	

}
