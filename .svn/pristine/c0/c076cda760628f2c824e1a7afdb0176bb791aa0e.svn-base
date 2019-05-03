package paymatePages;


import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.relevantcodes.extentreports.LogStatus;
import Common.Screenshot;
import TestBase.TestBase;

public class ManageContacts extends TestBase {
	
	
	 static String number;
	 
	 public static String rowsx;
	private static By contacts=By.xpath("//*[@id='Ulmenu']/li[6]/a");
	private static By managecontacts=By.xpath("//*[@id='Ulmenu']/li[6]/ul/li[3]/a[text()='Manage Contacts']");
	private static By managecontacts_txt=By.xpath("//*[@id='UpnlHome']/div/div[1]/h1");
	private static By dropdown=By.xpath("//*[@id='ContentPlaceHolder1_gvContacts_length']/label/select");
	
	
	public ManageContacts(WebDriver driver){
		ManageContacts.driver=driver;
	}
	
	
   
	public static void manageContacts(String Phnum) throws InterruptedException, IOException{
		test.log(LogStatus.INFO, " **** Paymate manage contacts function starts ****");
		log.info("**** Paymate manage contacts function starts **** ");	
		click(contacts);
		test.log(LogStatus.INFO, "clicked on contact tab");
		log.info("clicked on contact tab ");
		click(managecontacts);
		test.log(LogStatus.INFO, "clicked on manage contacts tab");
		log.info("clicked on manage contacts tab ");
		String actualtxt=getElementText(managecontacts_txt);
		String expectedtxt="MANAGE CONTACTS";
		Assert.assertTrue(actualtxt.contains(expectedtxt));
		test.log(LogStatus.INFO, "MANAGE CONTACTS text matched");
		log.info("MANAGE CONTACTS text matched");
		Screenshot.infoScreenshot(driver, "manage contact page ");
		selectVisibleText(dropdown, "All");
		test.log(LogStatus.INFO, "selected 'All' option from shown entries");
		log.info("selected 'All' option from shown entries");
		Thread.sleep(5000);     
      
		String rowsXpath = "//*[@id='ContentPlaceHolder1_gvContacts']/tbody/tr";
		// manageContactTable(rowsXpath,"9123415645"); //9140445210
	      List<WebElement> webtable = driver.findElements(By.xpath(rowsXpath));
	      System.out.println("rows size is "+webtable.size());
	      test.log(LogStatus.INFO,"Total No of rows are found in MANAGE CONTACTS table : " + webtable.size());
	  	log.info("Total No of rows are found in MANAGE CONTACTS table : " + webtable.size());
	  	 	
	  	for (int i =1;i<webtable.size();i++)
	      {    
	          String phnnum= driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_gvContacts']/tbody/tr["+i+"]/td[3]")).getText();
	          if(phnnum.contains(Phnum)){      	
	          	 test.log(LogStatus.INFO,phnnum+" found in MANAGE CONTACTS table ");
	          	 log.info(phnnum+" found in MANAGE CONTACTS table" );
	          	break;
	          }
	      }
		
	
        test.log(LogStatus.INFO, " **** Paymate manage contacts function ends ****");
	    log.info("**** Paymate manage contacts function ends **** ");	
			
		
	}
}
