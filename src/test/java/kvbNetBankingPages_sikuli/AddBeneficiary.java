package kvbNetBankingPages_sikuli;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import KvbPages.Kvb_MSME_Loan;
import TestBase.TestBase;


public class AddBeneficiary extends TestBase {
	
	public AddBeneficiary(WebDriver driver)
	{
		Kvb_MSME_Loan.driver=driver;
	}
	
	public void addBeneficiary() throws Exception{
		
		Screen screen=new Screen();
		 Robot robot = new Robot();
		Pattern accountNum = new Pattern("./SikuliScreenshots/accountNum.PNG");
		Pattern BaccountType = new Pattern("./SikuliScreenshots/accountType.PNG");
		Pattern add = new Pattern("./SikuliScreenshots/add.PNG");
		Pattern beneficiaryLink = new Pattern("./SikuliScreenshots/beneficiaryLink.PNG");
		Pattern beneficiaryName = new Pattern("./SikuliScreenshots/beneficiaryName.PNG");
		Pattern CreateBeneficiary = new Pattern("./SikuliScreenshots/CreateBeneficiary.PNG");
		Pattern ifsc = new Pattern("./SikuliScreenshots/ifscradio.PNG");
		Pattern ifsccode = new Pattern("./SikuliScreenshots/ifsccode.PNG");
		Pattern Ifsccodee = new Pattern("./SikuliScreenshots/Ifsccodee.PNG");
		Pattern nickName = new Pattern("./SikuliScreenshots/nickName.PNG");
		Pattern paymentsLink = new Pattern("./SikuliScreenshots/paymentsLink.PNG");
		Pattern search = new Pattern("./SikuliScreenshots/search.PNG");
		Pattern select = new Pattern("./SikuliScreenshots/select.PNG");
		Pattern Type = new Pattern("./SikuliScreenshots/Type.PNG");
		Pattern conform = new Pattern("./SikuliScreenshots/conform.PNG");
		
		Thread.sleep(1000);
		screen.click(paymentsLink);
		Thread.sleep(1000);
		screen.click(beneficiaryLink);
		Thread.sleep(3000);
		screen.click(Type);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		screen.click(CreateBeneficiary);
		Thread.sleep(2000);
		screen.type(nickName,"suryakiran enhops");
		Thread.sleep(1000);
		screen.type(beneficiaryName,"suryakiran reddy");
		Thread.sleep(1000);
		screen.click(ifsc);
		screen.type(accountNum,"11499718396");
		Thread.sleep(1000);
		screen.click(BaccountType);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		screen.click(ifsccode);
		Thread.sleep(2000);
		handlingWindow();
		Thread.sleep(2000);
		screen.type(Ifsccodee,"SBIN0002798");
		Thread.sleep(1000);
		screen.click(search);
		Thread.sleep(5000);
		screen.click(select);
		Thread.sleep(2000);
		screen.click(add);
		Thread.sleep(5000);
		screen.click(conform);
		Thread.sleep(5000);
	}
	
	

}
