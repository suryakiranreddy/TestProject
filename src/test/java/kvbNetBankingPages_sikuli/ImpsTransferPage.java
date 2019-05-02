package kvbNetBankingPages_sikuli;

import java.awt.AWTException;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Match;

import TestBase.TestBase;

public class ImpsTransferPage extends TestBase {
	private static By userName=By.name("fldLoginUserId");
	private static By passWord=By.name("fldPassword");
	private static By logIn=By.className("buttsignin");
	
	private static String paymentsLinkImage="./ElementImages/payments.PNG";
	private static String IMPSLinkImage="./ElementImages/impslink.PNG";
	private static String selectAccountdropDown="./ElementImages/selectAccountdropDown.PNG";
	private static String amounttextbox="./ElementImages/amountTextBox.PNG";
	private static String beneficiaryidlookupImage="./ElementImages/beneficiary id lookupImage.PNG";
	private static String lookupsubmit="./ElementImages/lookup.PNG";
	private static String narrativeTextbox="./ElementImages/narrativeTextbox.PNG";
	private static String impssubmit="/ElementImages/impssubmit.PNG";
	private static String impsconfirm="/ElementImages/impsconfirm.PNG";
	
	public ImpsTransferPage(WebDriver driver)
	{
		ImpsTransferPage.driver=driver;
	}

	public void login(String username,String password){
		sendkeys(userName,username);
		sendkeys(passWord,password);
		click(logIn);
		// driver.findElement(By.className("buttsignin")).click();
	}
	
	public void impsTransfer(String amount,String narativeText) throws InterruptedException, AWTException{
		try {
			handlingWindow();
			sikuliclick(paymentsLinkImage);
			sikuliclick(IMPSLinkImage);
			sikuliclick(selectAccountdropDown);
			KeyDown(1);
		/*	Iterator<Match> textbox = s.findAll(amounttextbox);
			while(textbox.hasNext()){
				textbox.next();
			s.type(amounttextbox, amount);
				break;
			}*/
			s.type(amounttextbox, amount);
			//s.findAll("beneficiaryidlookupImage");
			//Set<Match>t=s.findAll(beneficiaryidlookupImage);
			Iterator<Match> it = s.findAll(beneficiaryidlookupImage);
			while(it.hasNext()){
			   it.next().click();
			   break;
			}
		   Thread.sleep(3000);
			handlingWindow();
			sikuliclick(lookupsubmit);
			sikuliclick(paymentsLinkImage);
			s.type(narrativeTextbox, narativeText);
			sikuliclick(impssubmit);
			sikuliclick(impsconfirm);
		} catch (FindFailed e) {
		e.printStackTrace();
		}
	 
		
	}


}
