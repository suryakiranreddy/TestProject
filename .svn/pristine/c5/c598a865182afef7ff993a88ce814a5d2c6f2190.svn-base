package KvbPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import TestBase.TestBase;

public class NegativeSenario_MSME_Loan extends TestBase{

	
	private static By businessLoanLink=By.xpath("//*[@id='wrapper']/div[2]/div/form/div[8]/div/div[1]/ul/li/a");
	
	private static By applyLoanLink=By.xpath("//h3[text()='Apply Now ']");	
	
	private static By applyLoantxt=By.xpath("//div[text()=' Apply for a Loan ']");	
	
	//************************Borrower's Profile**********
	private static By name=By.xpath("//input[@name='txt_nameofborr']");
	
	private static By mobileNum=By.xpath("//input[@name='txt_mobno']");
	
	private static By constitution =By.xpath("//select[@id='sel_constitution']");
	
	//private static By aadharNumber =By.xpath("//input[@name='txt_aadharno']");
	
	private static By lineofActivity_present =By.xpath("//input[@name='txt_lnactpresent']");
	
	private static By lineofActivity_Proposed  =By.xpath("//input[@name='txt_lnactproposed']");
	
	private static By dateOfIncorporation   =By.xpath("//input[@name='txt_dateofincorp']");
	
	private static By industryType   =By.xpath("//select[@name='sel_industrytype']");
	
	private static By VAT_TIN_Number   =By.xpath("//input[@name='txt_cstno']");
	
	private static By PAN_Number   =By.xpath("//input[@name='txt_panno']");
	
	private static By emailId   =By.xpath("//input[@name='txt_emailid']");
	
	private static By state   =By.xpath("//select[@name='sel_State']");
	
	private static By district   =By.xpath("//select[@name='sel_City']");
	
	private static By branch   =By.xpath("//select[@name='txt_preferbranch']");
			
	private static By submit =By.xpath("//input[@name='Save']");
	
	public NegativeSenario_MSME_Loan(WebDriver driver)
	{
		Kvb_MSME_Loan.driver=driver;
	}
	
	public static void MSME_loan(){
		try{
			
		test.log(LogStatus.INFO, "****KVB MSME Loan process starts*****");
		log.info("****KVB MSME Loan process starts*****");
		click(businessLoanLink);
		test.log(LogStatus.INFO, "businessLoanLink clicking");
		log.info("businessLoanLink clicking");
		handlingWindow();
		test.log(LogStatus.INFO, "switching to another tab");
		log.info("switching to another tab");
		click(applyLoanLink);
		test.log(LogStatus.INFO, "applyLoanLink clicking");
		log.info("applyLoanLink clicking");
		String actualText=getElementText(applyLoantxt);
		test.log(LogStatus.INFO, "Actual Text is-->"+actualText);
		log.info("Actual Text is-->"+actualText);
		String ExpectedText=Repository.getProperty("ExpectedResult_applyLoantxt");
		test.log(LogStatus.INFO, "Expected Text is-->"+ExpectedText);
		log.info("Expected Text is-->"+ExpectedText);
		Assert.assertTrue(actualText.contains(ExpectedText));
		test.log(LogStatus.INFO, ExpectedText+" Text matched");
		log.info(ExpectedText+" Text matched");
		log.info("****Borrower's Profile process end*****");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public static void borrowers_Profile(String namee,String mobileNumm,String constitutionn,String lineofActivitypresent,String lineofActivityProposed,
			String dateOfIncorporationn,String industryTypee,String VAT_TIN_Numberr,String PAN_Numberr,String emailIdd,
			String statee,String districtt,String branchh ){
		try{
			log.info("****Borrower's Profile process starts*****");
		test.log(LogStatus.INFO, "****Borrower's Profile process starts*****");
		sendkeys(name, namee);
		test.log(LogStatus.INFO, namee+" name entered");
		clear(mobileNum);
		sendkeys(mobileNum, mobileNumm);
		test.log(LogStatus.INFO, mobileNumm+" mobile number entered");
		selectVisibleText(constitution, constitutionn);//Individuals
		test.log(LogStatus.INFO, constitutionn+" constitution selected");
		sendkeys(lineofActivity_present, lineofActivitypresent);
		test.log(LogStatus.INFO, lineofActivity_present+" line of Activity present entered");
		sendkeys(lineofActivity_Proposed, lineofActivityProposed);
		test.log(LogStatus.INFO, lineofActivityProposed+" line of Activity Proposed entered");
		sendkeys(dateOfIncorporation, dateOfIncorporationn);//06/13/2018
		test.log(LogStatus.INFO, dateOfIncorporationn+" date Of Incorporation entered");
		selectVisibleText(industryType, industryTypee);//MANUFACTURING
		test.log(LogStatus.INFO, industryTypee+" industry Type selected");
		sendkeys(VAT_TIN_Number, VAT_TIN_Numberr);//54545112344
		test.log(LogStatus.INFO, VAT_TIN_Numberr+" VAT TIN Number entered");
		sendkeys(PAN_Number, PAN_Numberr);//ASDFG1234H
		test.log(LogStatus.INFO, PAN_Numberr+" PAN Number entered");
		sendkeys(emailId, emailIdd);
		test.log(LogStatus.INFO, emailIdd+" email Id entered");
		selectVisibleText(state, statee);//ANDHRA PRADESH
		test.log(LogStatus.INFO, statee+" state selected");
		selectVisibleText(district, districtt);//KRISHNA
		test.log(LogStatus.INFO, districtt+" district selected");
		selectVisibleText(branch, branchh);//GANNAVARAM
		test.log(LogStatus.INFO, branchh+" branch selected");
		test.log(LogStatus.INFO, "****Borrower's Profile process end*****");
		log.info("****Borrower's Profile process end*****");
		click(submit);
		String actualText=getElementText(applyLoantxt);
		test.log(LogStatus.INFO, "Actual Text is-->"+actualText);
		log.info("Actual Text is-->"+actualText);
		String ExpectedText=Repository.getProperty("NegativeSenarioExpectedResult_applyLoantxt");
		test.log(LogStatus.INFO, "Expected Text is-->"+ExpectedText);
		log.info("Expected Text is-->"+ExpectedText);
		Assert.assertTrue(actualText.contains(ExpectedText));
		test.log(LogStatus.INFO, ExpectedText+" Text matched");
		log.info(ExpectedText+" Text matched");
		
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	
	


}
