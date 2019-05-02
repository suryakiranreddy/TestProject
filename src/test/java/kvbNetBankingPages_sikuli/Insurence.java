package kvbNetBankingPages_sikuli;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import TestBase.TestBase;

public class Insurence extends TestBase{
	private static By userName=By.name("fldLoginUserId");
	private static By passWord=By.name("fldPassword");
	private static By logIn=By.className("buttsignin");
	
	
	public Insurence(WebDriver driver)
	{
		Insurence.driver=driver;
	}

	public void login(String username,String password){
		sendkeys(userName,username);
		sendkeys(passWord,password);
		click(logIn);
		
	}
	
	public void insurenceProcess(){
		handlingWindow();
		
		
	}
		
		
	}


