package PaymateTestcases;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LinkedIn {
	String name;
	//String HqPhone;
	String company;
	String location;
	String designation;
	
	WebDriver driver;

	@BeforeClass
	public void beforeTest() throws IOException, InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/resources/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.linkedin.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);

	}

	@Test
	public void CreateLead() throws Exception
	{
		driver.findElement(By.xpath("//input[@class='login-email']")).sendKeys("mia@enhops.com");
		driver.findElement(By.xpath("//input[@class='login-password']")).sendKeys("jeevan@123");
		driver.findElement(By.xpath("//input[@class='login submit-button']")).click();
		Thread.sleep(3000);
		String parentHandle = driver.getWindowHandle();
		driver.findElement(By.xpath("//span[contains(.,'Sales Nav')]")).click();
		
		Thread.sleep(5000);
		
		Set<String>s1=driver.getWindowHandles();
		Iterator<String> I1= s1.iterator();
		while(I1.hasNext())
		{
		  String child_window=I1.next();
		  if(!parentHandle.equals(child_window))
		  {
		    driver.switchTo().window(child_window);
		    System.out.println(driver.switchTo().window(child_window).getTitle()); 
		  }
		}
		   
		   Thread.sleep(5000);
		   WebElement element = driver.findElement(By.xpath("//button[contains(.,'Advanced')]"));
		   
	        Actions action = new Actions(driver);
	 
	        action.moveToElement(element).build().perform();
	        driver.findElement(By.xpath("//a[contains(.,'Search for leads')]")).click();
	        Thread.sleep(3000);
	        
	        driver.findElement(By.xpath("//*[@id=\"pagekey-sales-search3-people\"]/section/div[2]/div/p/div/section[2]/ul/li[1]/div")).click();
	        Thread.sleep(3000);
	     // Create instance of Javascript executor
	        
	        JavascriptExecutor je = (JavascriptExecutor) driver;
	         
	        //Identify the WebElement which will appear after scrolling down
	         
	        WebElement oprations = driver.findElement(By.xpath("//*[@id=\"pagekey-sales-search3-people\"]/section/div[2]/div/p/div/section[2]/ul/li[1]/div/ol[2]/li[18]/a"));
	         
	         
	         
	        // now execute query which actually will scroll until that element is not appeared on page.
	         
	        je.executeScript("arguments[0].scrollIntoView(true);",oprations);
	        driver.findElement(By.xpath("//*[@id=\"pagekey-sales-search3-people\"]/section/div[2]/div/p/div/section[2]/ul/li[1]/div/ol[2]/li[18]/a")).click();
	        Thread.sleep(1000);
	        WebElement it = driver.findElement(By.xpath("//*[@id='pagekey-sales-search3-people']/section/div[2]/div/p/div/section[2]/ul/li[1]/div/ol[2]/li[13]/a"));
	        je.executeScript("arguments[0].scrollIntoView(true);",it);
	        Thread.sleep(1000);
	        driver.findElement(By.xpath("//*[@id='pagekey-sales-search3-people']/section/div[2]/div/p/div/section[2]/ul/li[1]/div/ol[2]/li[13]/a")).click();
	        
	        Thread.sleep(1000);
	        WebElement qa = driver.findElement(By.xpath("//*[@id='pagekey-sales-search3-people']/section/div[2]/div/p/div/section[2]/ul/li[1]/div/ol[2]/li[22]/a"));
	        je.executeScript("arguments[0].scrollIntoView(true);",qa);
	        Thread.sleep(1000);
	        driver.findElement(By.xpath("//*[@id='pagekey-sales-search3-people']/section/div[2]/div/p/div/section[2]/ul/li[1]/div/ol[2]/li[22]/a")).click();
	        
	        Thread.sleep(1000);
	        WebElement pm = driver.findElement(By.xpath("//*[@id='pagekey-sales-search3-people']/section/div[2]/div/p/div/section[2]/ul/li[1]/div/ol[2]/li[19]/a"));
	        je.executeScript("arguments[0].scrollIntoView(true);",pm);
	        Thread.sleep(1000);
	        driver.findElement(By.xpath("//*[@id='pagekey-sales-search3-people']/section/div[2]/div/p/div/section[2]/ul/li[1]/div/ol[2]/li[19]/a")).click();
	        
	        Thread.sleep(1000);
	        WebElement ppm = driver.findElement(By.xpath("//*[@id='pagekey-sales-search3-people']/section/div[2]/div/p/div/section[2]/ul/li[1]/div/ol[2]/li[20]/a"));
	        je.executeScript("arguments[0].scrollIntoView(true);",ppm);
	        Thread.sleep(1000);
	        driver.findElement(By.xpath("//*[@id='pagekey-sales-search3-people']/section/div[2]/div/p/div/section[2]/ul/li[1]/div/ol[2]/li[20]/a")).click();
	        
	        Thread.sleep(1000);
	        WebElement op = driver.findElement(By.xpath("//*[@id='pagekey-sales-search3-people']/section/div[2]/div/p/div/section[2]/ul/li[1]/div/ol[2]/li[18]/a"));
	        je.executeScript("arguments[0].scrollIntoView(true);",op);
	        Thread.sleep(1000);
	        driver.findElement(By.xpath("//*[@id='pagekey-sales-search3-people']/section/div[2]/div/p/div/section[2]/ul/li[1]/div/ol[2]/li[18]/a")).click();
	        
	        Thread.sleep(1000);
	        WebElement mc = driver.findElement(By.xpath("//*[@id='pagekey-sales-search3-people']/section/div[2]/div/p/div/section[2]/ul/li[1]/div/ol[2]/li[16]/a"));
	        je.executeScript("arguments[0].scrollIntoView(true);",mc);
	        Thread.sleep(1000);
	        driver.findElement(By.xpath("//*[@id='pagekey-sales-search3-people']/section/div[2]/div/p/div/section[2]/ul/li[1]/div/ol[2]/li[16]/a")).click();
	        
	       //*************************************
	        
	        Thread.sleep(1000);
	        WebElement senioritylevel = driver.findElement(By.xpath("//*[@id='pagekey-sales-search3-people']/section/div[2]/div/p/div/section[2]/ul/li[3]/div"));
	        je.executeScript("arguments[0].scrollIntoView(true);",senioritylevel);
	        Thread.sleep(1000);
	        driver.findElement(By.xpath("//*[@id='pagekey-sales-search3-people']/section/div[2]/div/p/div/section[2]/ul/li[3]/div")).click();
	        
	        Thread.sleep(1000);
	        WebElement cxo = driver.findElement(By.xpath("//*[@id='pagekey-sales-search3-people']/section/div[2]/div/p/div/section[2]/ul/li[3]/div/ol[2]/li[1]/a"));
	        je.executeScript("arguments[0].scrollIntoView(true);",cxo);
	        Thread.sleep(1000);
	        driver.findElement(By.xpath("//*[@id='pagekey-sales-search3-people']/section/div[2]/div/p/div/section[2]/ul/li[3]/div/ol[2]/li[1]/a")).click();
	        
	        
	        Thread.sleep(1000);
	        WebElement partner = driver.findElement(By.xpath("//*[@id='pagekey-sales-search3-people']/section/div[2]/div/p/div/section[2]/ul/li[3]/div/ol[2]/li[2]/a"));
	        je.executeScript("arguments[0].scrollIntoView(true);",partner);
	        Thread.sleep(1000);
	        driver.findElement(By.xpath("//*[@id='pagekey-sales-search3-people']/section/div[2]/div/p/div/section[2]/ul/li[3]/div/ol[2]/li[2]/a")).click();
	        
	        
	        Thread.sleep(1000);
	        WebElement owner = driver.findElement(By.xpath("//*[@id='pagekey-sales-search3-people']/section/div[2]/div/p/div/section[2]/ul/li[3]/div/ol[2]/li[3]/a"));
	        je.executeScript("arguments[0].scrollIntoView(true);",owner);
	        Thread.sleep(1000);
	        driver.findElement(By.xpath("//*[@id='pagekey-sales-search3-people']/section/div[2]/div/p/div/section[2]/ul/li[3]/div/ol[2]/li[3]/a")).click();
	        
	        
	        Thread.sleep(1000);
	        WebElement vp = driver.findElement(By.xpath("//*[@id='pagekey-sales-search3-people']/section/div[2]/div/p/div/section[2]/ul/li[3]/div/ol[2]/li[4]/a"));
	        je.executeScript("arguments[0].scrollIntoView(true);",vp);
	        Thread.sleep(1000);
	        driver.findElement(By.xpath("//*[@id='pagekey-sales-search3-people']/section/div[2]/div/p/div/section[2]/ul/li[3]/div/ol[2]/li[4]/a")).click();
	        
	        Thread.sleep(1000);
	        WebElement director = driver.findElement(By.xpath("//*[@id='pagekey-sales-search3-people']/section/div[2]/div/p/div/section[2]/ul/li[3]/div/ol[2]/li[5]/a"));
	        je.executeScript("arguments[0].scrollIntoView(true);",director);
	        Thread.sleep(1000);
	        driver.findElement(By.xpath("//*[@id='pagekey-sales-search3-people']/section/div[2]/div/p/div/section[2]/ul/li[3]/div/ol[2]/li[5]/a")).click();
	        
	        Thread.sleep(2000);
	        WebElement manager = driver.findElement(By.xpath("//*[@id='pagekey-sales-search3-people']/section/div[2]/div/p/div/section[2]/ul/li[3]/div/ol[2]/li[1]/a"));
	        je.executeScript("arguments[0].scrollIntoView(true);",manager);
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id='pagekey-sales-search3-people']/section/div[2]/div/p/div/section[2]/ul/li[3]/div/ol[2]/li[1]/a")).click();
	        
	        
	        Thread.sleep(1000);
	        WebElement search = driver.findElement(By.xpath("//*[@id='pagekey-sales-search3-people']/section/div[2]/header/div[2]/button[1]"));
	        je.executeScript("arguments[0].scrollIntoView(true);",search);
	        Thread.sleep(1000);
	        driver.findElement(By.xpath("//*[@id='pagekey-sales-search3-people']/section/div[2]/header/div[2]/button[1]")).click();
	        
	       
	      //  driver.findElement(By.xpath("//button[@class=\"confirm-btn\"]")).click();
	        
	        Thread.sleep(100000);
		//Close child window   
		driver.close();
		driver.switchTo().window(parentHandle);
		System.out.println(driver.switchTo().window(parentHandle).getTitle());
		
		Thread.sleep(5000);
		
		
		
		
		/*List<ContactDetails> contactDetailsList = new ArrayList<ContactDetails>();
		try
		{

			// System.out.println(driver.findElement(By.xpath("/html/body/section[2]")).getText());

			for (int i = 1; i <= 1; i++)
			{
				driver.findElement(
						By.xpath("//a[contains(@href,'/people-search/Los+Angeles-Software-?pageNum=" + i + "')]"))
						.click();
				Thread.sleep(1000);
				System.out.println("Page No: " + i);
				System.out.println("============================================================");
				for (int j = 2; j <= 3; j++)
				{
						
						ContactDetails contactDetails = new ContactDetails();
						driver.findElement(By.xpath("/html/body/section[1]/div/div[3]/div[" + j + "]/div[1]/p/a")).click();
						Thread.sleep(1000);
					
						//***************Name*******************
						
						List<WebElement> NameElement = driver.findElements(By.xpath("/html/body/div[2]/div[2]/main/section[1]/div[2]/h1"));
						
						if (NameElement.size()>0) 
						{
							name = driver.findElement(By.xpath("/html/body/div[2]/div[2]/main/section[1]/div[2]/h1")).getText();
							System.out.println("Name: " + name);
						} else {
							System.out.println("Element not found");
						}
						
						//***************designation***************
						
						List<WebElement> designationElement = driver.findElements(By.xpath("/html/body/div[2]/div[2]/main/section[1]/div[2]/h2/span[1]"));
						if (designationElement.size()>0) 
						{
							designation = driver.findElement(By.xpath("/html/body/div[2]/div[2]/main/section[1]/div[2]/h2/span[1]")).getText();
							System.out.println("Designation: " + designation);
						} else {
							System.out.println("Element not found");
						}
						
					 //***************location***********************
						
						List<WebElement> locationElement = driver.findElements(By.xpath("/html/body/div[2]/div[2]/main/section[1]/div[2]/div/div[1]/span"));
						
						
						if (locationElement.size()>0) 
						{
							 location = driver.findElement(By.xpath("/html/body/div[2]/div[2]/main/section[1]/div[2]/div/div[1]/span")).getText();
							 System.out.println("Location: " + location);
						} else {
							System.out.println("Element not found");
						}
						
					//************company*******************
						
						List<WebElement> companyElement = driver.findElements(By.xpath("/html/body/div[2]/div[2]/main/section[1]/div[2]/div/div[2]/span/a"));
						
						
						if (companyElement.size()>0) 
						{
							company = driver.findElement(By.xpath("/html/body/div[2]/div[2]/main/section[1]/div[2]/div/div[2]/span/a")).getText();
							System.out.println("Company: " + company);
						} else {
							System.out.println("Element not found");
						}
					
						//************company*******************
						
						List<WebElement> HqPhoneElement = driver.findElements(By.xpath("/html/body/div[2]/div[2]/main/section[1]/div[2]/div/div[3]/span"));
						
						
						if (HqPhoneElement.size()>0) 
						{
							HqPhone = driver.findElement(By.xpath("/html/body/div[2]/div[2]/main/section[1]/div[2]/div/div[3]/span")).getText();
							System.out.println("HQPhone: " + HqPhone);
						} else {
							System.out.println("Element not found");
						}	
				
					
				

					contactDetails.setName(name);
					
					contactDetails.setCompany(company);
					
					contactDetails.setDesignation(designation);
					
					contactDetails.setLocation(location);
					
					contactDetails.setHqPhone(HqPhone);
					contactDetailsList.add(contactDetails);
					
					Thread.sleep(1000);
					
						for (int k=0; k<=10; k++)
						{
							try {
								if (driver.findElement(By.xpath("/html/body/section[1]/div/div[3]/div[1]/div[1]/h3")).isDisplayed()){
									break;	
								}
						
						}catch (Exception e) {
							driver.navigate().back();
							
						}
				
					}
			
					Thread.sleep(1000);
				

				}

			}

			/// people-search/Los+Angeles-Software-?pageNum=""

		} catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			NewCampaignExcelView newCampaignExcelView = new NewCampaignExcelView();
			newCampaignExcelView.buildExcelDocument(contactDetailsList);
		}
	*/
	}

	@AfterClass
	public void endreport()
	{
		driver.quit();

	}

}

	
	


