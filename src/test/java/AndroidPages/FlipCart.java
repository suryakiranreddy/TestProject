package AndroidPages;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;

import TestBase.AndroidTestBase;

public class FlipCart extends AndroidTestBase {
	
	private static By serachBox1=By.xpath("//android.widget.TextView[@text=' Search for Products, Brands and More']");
	private static By serachBox2=By.xpath("//android.widget.EditText[@text='Search for Products, Brands..']");//iphone xs 
	//Apple iPhone XS Max (Silver, 512 GB)
	private static By phonename=By.xpath("//android.widget.TextView[@text='nexus']");
	private static By phoneLink=By.xpath("//android.widget.TextView[@text='Nexus 5X (Carbon, 32 GB)']");
	private static By BYNOW1=By.xpath("//android.widget.TextView[@text='BUY NOW']");
	private static By BYNOW2=By.xpath("//android.widget.TextView[@text='BUY NOW']");
	private static By continue_btn=By.xpath("//*[@text='CONTINUE']");
	
	public static void flipcart(){
		tap(serachBox1);
		sendkeys(serachBox2, "nexus");
		click(phonename);
		scrollToParticularElement("Nexus 5X (Carbon, 32 GB)");
		click(phoneLink);
		click(BYNOW1);
		click(BYNOW2);
		click(continue_btn);
	}
	
	
}
