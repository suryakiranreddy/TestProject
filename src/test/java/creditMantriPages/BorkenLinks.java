package creditMantriPages;

import org.openqa.selenium.By;
import TestBase.TestBase;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

public class BorkenLinks extends TestBase {
	/*String homePage = "https://www.lunch2desk.co.in/n/";
	static String url = "https://www.lunch2desk.co.in/n/";*/
	static String response = "";
	static int responseCode;
	static HttpURLConnection connection;
	
	private static By phoneNum = By.xpath("//input[@name='phone_home']");
	private static By getStartedNow = By.xpath("//input[@value='Get Started Now']");
	private static By otp = By.id("otpid");
	private static By verifyMobile = By.xpath("(//input[@value='Verify Mobile'])[3]");

	
	public static void login(){
		sendkeys(phoneNum, "9618840516");
		click(getStartedNow);
		sendkeys(otp, "1111111");
		//click(verifyMobile);
	}

	public static List<WebElement> findAllLinks(WebDriver driver) {
		List<WebElement> elementList = new ArrayList<WebElement>();
		elementList = driver.findElements(By.tagName("a"));
		elementList.addAll(driver.findElements(By.tagName("img")));
		List<WebElement> finalList = new ArrayList<WebElement>();
		for (WebElement element : elementList ) {
			if (element.getAttribute("href") != null && !element.getAttribute("href").contains("javascript")) {
				finalList.add(element);
			}
		}
		return finalList;
	}

	public static String isLinkBroken(URL url) throws Exception {
		connection = (HttpURLConnection) url.openConnection();
		try {
			connection.connect();
			response = connection.getResponseMessage();
			responseCode = connection.getResponseCode();
			connection.disconnect();
			return response;
		} catch (Exception exp) {
			return exp.getMessage();
		}
	}

	public  static void bokenLinks () throws Exception {
		System.out.println("bokenLinks");
		List<WebElement> allLinks = findAllLinks(driver);
		System.out.println("Total number of links found : " + allLinks.size());
		test.log(LogStatus.INFO, "Total number of links found : " + allLinks.size());
		log.info("Total number of links found : " + allLinks.size());
		for (WebElement element : allLinks) {
			try{
		
				test.log(LogStatus.INFO, "URL: " + element.getAttribute("href") + " --> returned "
						+ isLinkBroken(new URL(element.getAttribute("href"))) + " --> Resonse code" + responseCode);
				log.info("URL: " + element.getAttribute("href") + " --> returned "
						+ isLinkBroken(new URL(element.getAttribute("href"))) + " --> Response code-" + responseCode);
			}catch(Exception e)	{
				e.getMessage();
			}
		}
	}
}
