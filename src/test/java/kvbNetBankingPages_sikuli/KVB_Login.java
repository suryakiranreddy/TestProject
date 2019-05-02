package kvbNetBankingPages_sikuli;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import KvbPages.Kvb_MSME_Loan;
import TestBase.TestBase;

public class KVB_Login extends TestBase{
	
	/*private static By loginLink=By.xpath("//*[@id='wrapper']/div[2]/div/form/div[1]/div[2]/p/a[1]/img");
	
	private static By continueToLogin=By.xpath("//*[@id='#login-keyboard-controls']/td[2]/a");
	
	private static By continueToLogin=By.xpath("//*[@id='#login-keyboard-controls']/td[2]/a");
	
	private static By continueToLogin=By.xpath("//*[@id='#login-keyboard-controls']/td[2]/a");*/
	
	
	public KVB_Login(WebDriver driver)
	{
		Kvb_MSME_Loan.driver=driver;
	}
	
	
	public void login(String username , String passowrd) throws InterruptedException{
		
		
		/*driver.findElement(By.xpath("//*[@id='wrapper']/div[2]/div/form/div[1]/div[2]/p/a[1]/img")).click();
		handlingWindow();
		driver.findElement(By.xpath("//*[@id='#login-keyboard-controls']/td[2]/a")).click();
		handlingWindow();*/
	       driver.findElement(By.name("fldLoginUserId")).sendKeys(username);
           driver.findElement(By.name("fldPassword")).sendKeys(passowrd);
           Thread.sleep(2000);
           driver.findElement(By.className("buttsignin")).click();
           System.out.println("hudfuidhnfjkd");
           Thread.sleep(10000);
          
           
	}

}
