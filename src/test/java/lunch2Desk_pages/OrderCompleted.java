package lunch2Desk_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import TestBase.TestBase;

public class OrderCompleted extends TestBase {
	
	private static By orderStatus_drp = By.xpath("//*[@id='filter_status_chosen']/a/span");
	private static By processingStatus = By.xpath("//ul[@class='chosen-results']/li[2]");
	private static By orderStatus = By.xpath("//ul[@class='table-generic']/li[2]/div[6]/span");
	private static By orderId = By.xpath("//ul[@class='table-generic']/li[2]/div[1]/a");
	private static By orderAmount = By.xpath("//ul[@class='table-generic']/li[2]/div[5]");
	private static By detailsIcon = By.xpath("//ul[@class='table-generic']/li[2]/div[7]/a/i");
	
	private static By orderIdd = By.xpath("(//li[@class='order-number']/span)[2]");
	private static By orderamountt = By.xpath("(//li[@class='order-type total-price']/span)[2]");
	private static By orderrStatuss1 = By.xpath("(//*[@id='order_inquiry_status_chosen']/a/span)[1]");
	
	
	private static By ordersatu = By.xpath("//li[@class='order-heading-titles']/div[6]/span");
	
	public OrderCompleted(WebDriver driver) {
		OrderCompleted.driver = driver;
	}
	
	public static void orderCompleted() throws InterruptedException{
		
		//***order details verification***
		click(orderStatus_drp);
		test.log(LogStatus.INFO, "order status dropdown clicked");
		log.info("order status dropdown clicked");
		click(processingStatus);
		test.log(LogStatus.INFO, "processing status selected");
		log.info("processing status selected");
		Thread.sleep(3000);
		String orderStatuss=getElementText(orderStatus);
		System.out.println(orderStatuss);//Processing!
		test.log(LogStatus.INFO, "order status is:- "+orderStatuss);
		log.info("order status is:- "+orderStatuss);
		String orderid=getElementText(orderId);
		System.out.println(orderid);//Order-17618
		test.log(LogStatus.INFO, "order id is:- "+orderid);
		log.info("order id is:- "+orderid);
		String orderAmountt=getElementText(orderAmount);
		System.out.println(orderAmountt);//?30.00
		test.log(LogStatus.INFO, "order amount is:- "+orderAmountt);
		log.info("order amount is:- "+orderAmountt);
		click(detailsIcon);
		
		//****order details verification in popup ****
		test.log(LogStatus.INFO, "details icon clicked");
		log.info("details icon clicked");
		String orderrIdd=getElementText(orderIdd);
		System.out.println(orderrIdd);//17618
		Assert.assertTrue(orderid.contains(orderrIdd));
		test.log(LogStatus.INFO, "'" + orderrIdd + "' order id matched ");
		log.info("'" + orderrIdd + "' order id matched ");
		String orderrAmountt=getElementText(orderamountt);
		System.out.println(orderrAmountt);
		Assert.assertTrue(orderAmountt.contains(orderrAmountt));
		test.log(LogStatus.INFO, "'" + orderrAmountt + "' order amount matched ");
		log.info("'" + orderrAmountt + "' order amount matched ");
		
		click(orderrStatuss1);
		test.log(LogStatus.INFO, "order status dropdown clicked");
		log.info("order status dropdown clicked");
		Actions a = new Actions(driver);
		a.sendKeys(Keys.DOWN).build().perform();
		a.sendKeys(Keys.DOWN).build().perform();
		a.sendKeys(Keys.ENTER).build().perform();
		test.log(LogStatus.INFO, "completed status selected");
		log.info("completed status selected");
		Thread.sleep(10000);
		test.log(LogStatus.INFO, "closed the popup");
		log.info("closed the popup");
		
		//****order status verification on completed order****
		getdriver().navigate().refresh();
		String orderrStatuss=getElementText(ordersatu);
		System.out.println(orderrStatuss);
		test.log(LogStatus.INFO, "status changeed to complete");
		log.info("status changeed to complete");
		
	}

	
	
}

