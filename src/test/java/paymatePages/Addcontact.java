package paymatePages;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.relevantcodes.extentreports.LogStatus;
import Common.Screenshot;
import TestBase.TestBase;

public class Addcontact extends TestBase{
	
	
	private static By contact=By.xpath("//*[@id='Ulmenu']/li[6]/a");
	private static By addcontact=By.xpath("//*[@id='Ulmenu']/li[6]/ul/li[2]/a[text()='Add Contacts']");
	private static By addcontact_txt=By.xpath("//*[@class='page-title col-xs-12']/h1");
	private static By emaiid=By.id("ContentPlaceHolder1_txtEmail");
    private static By companyname=By.id("ContentPlaceHolder1_txtCompanyName");
    private static By firstname=By.id("ContentPlaceHolder1_txtFirstName");
    private static By lastname=By.id("ContentPlaceHolder1_txtLastName");
    private static By nicknmae=By.id("ContentPlaceHolder1_txtNickName");
    private static By mobilenum=By.id("ContentPlaceHolder1_txtMobileNo");
    private static By referencecode=By.id("ContentPlaceHolder1_txtReferenceCode");
    private static By companyaddress=By.id("ContentPlaceHolder1_txtCompanyAddress");
    private static By bankacnum=By.id("ContentPlaceHolder1_txtBankAccountNo");
    private static By ifsccode=By.id("ContentPlaceHolder1_txtIFSCode");
    private static By gstin=By.id("ContentPlaceHolder1_txtGSTIN");
    private static By save=By.id("ContentPlaceHolder1_btnSave");
    private static By managecontacts=By.xpath("//*[@class='page-title col-xs-12']/h1");
    
    public Addcontact(WebDriver driver){
    	Addcontact.driver=driver;
    }
    		
    public static void addContact(String emailid, String companynamee,String firstnamee,String lastnamee,String nicknamee,String moblienumm,
    		String refcode,String companyaddres, String bankacnumm,String ifsccodee,String gstinnum) throws InterruptedException, IOException{
    	
    	test.log(LogStatus.INFO, " **** Paymate Addcontact function starts ****");
		log.info("**** Paymate Addcontact function starts **** ");	
    	click(contact);
    	test.log(LogStatus.INFO, "clicked on contact tab");
		log.info("clicked on contact tab ");	
    	click(addcontact);
    	test.log(LogStatus.INFO, "clicked on add contact link");
		log.info("clicked on add contact link ");	
    	String actualtxt=getElementText(addcontact_txt);
    	String expectedTxt="ADD A NEW CONTACT";
    	Assert.assertTrue(actualtxt.contains(expectedTxt));
    	test.log(LogStatus.INFO, "ADD A NEW CONTACT text matched");
    	log.info("ADD A NEW CONTACT text matched ");
    	Screenshot.infoScreenshot(driver, "Addcontact page ");   	   	
    	sendkeys(emaiid,emailid );//"surya12345@grr.la"
    	test.log(LogStatus.INFO, emailid+"-  email entered");
    	log.info(emailid+" - email entered");
    	sendkeys(companyname,companynamee );//"enhops"
    	test.log(LogStatus.INFO, companynamee+" - company name entered");
    	log.info(companynamee+" - company name entered");
    	sendkeys(firstname,firstnamee );//"surya"
    	test.log(LogStatus.INFO, firstnamee+" - first name entered");
    	log.info(firstnamee+" - first name entered");
    	sendkeys(lastname,lastnamee );//"tiyyagura"
    	test.log(LogStatus.INFO, lastnamee+" - last name entered");
    	log.info(lastnamee+" - last name entered");
    	sendkeys(nicknmae,nicknamee );//"reddy"
    	test.log(LogStatus.INFO, nicknamee+" - nick name entered");
    	log.info(nicknamee+" - nick name entered");
    	sendkeys(mobilenum, moblienumm);//"9161805161"
    	test.log(LogStatus.INFO, moblienumm+" - mobile number entered");
    	log.info(moblienumm+" - mobile number entered");
    	sendkeys(referencecode, refcode);//"814725"
    	test.log(LogStatus.INFO, refcode+" - reference code entered");
    	log.info(refcode+" - reference code entered");
    	sendkeys(companyaddress,companyaddres );//"Hyderabad"
    	test.log(LogStatus.INFO, companyaddres+"  company address entered");
    	log.info(companyaddres+"  company address entered");
    	sendkeys(bankacnum, bankacnumm);//11499718396"
    	test.log(LogStatus.INFO, bankacnumm+" -  bank account number entered");
    	log.info(bankacnumm+" - bank account number entered");
    	sendkeys(ifsccode, ifsccodee);//"SBIN0002798"
    	test.log(LogStatus.INFO, ifsccodee+" - IFSC code entered");
    	log.info(ifsccodee+" - IFSC code entered");
    	sendkeys(gstin, gstinnum);//"22AAAAA0000A1Z5"
    	test.log(LogStatus.INFO, gstinnum+" - gstin entered");
    	log.info(gstinnum+" -  gstin entered");
    	click(save);
    	test.log(LogStatus.INFO,"clicked on save button");
    	log.info("clicked on save button");
    	Thread.sleep(10000);
    	String managecontacts_actualtxt=getElementText(managecontacts);
    	String managecontacts_expectedTxt="MANAGE CONTACTS";
    	Assert.assertTrue(managecontacts_actualtxt.contains(managecontacts_expectedTxt));
    	test.log(LogStatus.INFO, "MANAGE CONTACTS text matched");  	
    	log.info("MANAGE CONTACTS text matched");
    	test.log(LogStatus.INFO, " **** Paymate Addcontact function ends ****");
		log.info("**** Paymate Addcontact function ends **** ");
		
    }
	
	

}
