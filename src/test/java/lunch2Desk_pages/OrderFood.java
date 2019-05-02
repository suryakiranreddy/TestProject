package lunch2Desk_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import TestBase.TestBase;


public class OrderFood extends TestBase {
	private static By nextButton=By.xpath("//a[text()='Next ']");
	private static By addButton=By.xpath("//*[@id='menu-item-list-16870']/ul/li[1]/div[3]/a/i");
	private static By ExpectedSubTotall=By.xpath("//*[@id='dev-menu-orders-list']/div/ul/li/span/em");
	private static By confirmOrder=By.xpath("//*[@id='main']/div/div/div/div/div/div[3]/div/div/div/a");
	private static By itemsList=By.xpath("//*[@id='menu-item-list-16870']/ul/li/child::div[2]/child::h6");
	private static By lastNameTextBox=By.xpath("//input[@name='trans_last_name']");
	private static By emailTextBox=By.xpath("//input[@name='trans_email']");
	private static By mobileNumberTextBox=By.xpath("//input[@name='trans_phone_number']");
	private static By addressTextBox=By.xpath("//textarea[@name='trans_address']");
	private static By submitButton=By.xpath("//button[@id='register-restaurant-order']");
	private static By completionMessage=By.xpath("//*[@id='main']/div/div/div/child::span");
	
	public OrderFood(WebDriver driver) {
		OrderFood.driver = driver;
	}
	
public void restaurentSearch(String restarentName){
	try{
	String restaurentName=driver.findElement(By.xpath("//a[text()='" + restarentName + "']")).getText();
	log.info("reasturent is---->"+restaurentName);
	
    for(int i=0;i<=100;i++){
	if(restaurentName.equalsIgnoreCase(restarentName)){
		test.log(LogStatus.INFO, "restarent has found"+restarentName);
		log.info("restarentName has found");
		driver.findElement(By.xpath("//a[text()='" + restarentName + "']")).click();
		test.log(LogStatus.INFO, "restarent is clicked as-->"+restarentName);
		log.info("restarentName link is clicked");
		break;
	}else{
		click(nextButton);
		test.log(LogStatus.INFO, "Unable to find the restaurent in current page so next is clicked" );
		log.info("Unable to find the restaurent in current page so next is clicked");
		Thread.sleep(5000);
	}
}}catch(Exception e){
	e.printStackTrace();
}
}
public void addCart(){
	try{
	click(addButton);
	test.log(LogStatus.INFO, "addbutton is clicked" );
	log.info("addbutton is clicked");
	String ExpectedSubTotal=getLabelText(ExpectedSubTotall);
	test.log(LogStatus.INFO, "ExpectedSubTotal is displaying as "+ExpectedSubTotal);
	log.info("ExpectedSubTotal is----->"+ExpectedSubTotal);
	String ActualSubTotal= Repository.getProperty("ActualSubTotal");
	test.log(LogStatus.INFO, "ExpectedSubTotal is displaying as "+ActualSubTotal);
	Assert.assertEquals(ExpectedSubTotal,ActualSubTotal);
	click(confirmOrder);
	test.log(LogStatus.INFO, "confirmOrder is clicked" );
	log.info("confirmOrder is clicked");
	}catch(Exception e){
		e.printStackTrace();
	}
}
public void submitOrder(String lastName,String email,String mobileNumber,String address){
	try{
	sendkeys(lastNameTextBox,lastName);
	test.log(LogStatus.INFO, "lastNameTextBox is entered as"+lastName );
	log.info("lastNameTextBox is entered as"+ lastName);
	clear(emailTextBox);
	sendkeys(emailTextBox,email);
	test.log(LogStatus.INFO, "emailTextBox is entered as"+email );
	log.info("emailTextBox is entered as"+ email);
	sendkeys(mobileNumberTextBox,mobileNumber);
	test.log(LogStatus.INFO, "mobileNumberTextBox is entered as"+mobileNumber );
	log.info("mobileNumberTextBox is entered as"+ mobileNumber);
	sendkeys(addressTextBox,address);
	test.log(LogStatus.INFO, "addressTextBox is entered as"+address );
	log.info("addressTextBox is entered as"+ address);
	click(submitButton);
	test.log(LogStatus.INFO, "submitButton is clicked");
	log.info("submitButton is clicked");
	
	String ExpectedConfirmationMessage=getLabelText(completionMessage);
	test.log(LogStatus.INFO, "ExpectedConfirmationMessage is displayed as"+ExpectedConfirmationMessage);
	log.info("ExpectedConfirmationMessage IS ---->"+ExpectedConfirmationMessage);
	
	String ActaulMessage=Repository.getProperty("ActualConfirmationMessage");
	test.log(LogStatus.INFO, "ActaulMessage is "+ActaulMessage);
	log.info("AtualConfirmationMessage IS ---->"+ActaulMessage);
	Assert.assertEquals(ActaulMessage, ExpectedConfirmationMessage);
	}catch(Exception e){
		e.printStackTrace();
	}
}
}	
	