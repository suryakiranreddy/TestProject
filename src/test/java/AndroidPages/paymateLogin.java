package AndroidPages;

import org.openqa.selenium.By;

import TestBase.AndroidTestBase;

public class paymateLogin extends AndroidTestBase {
	/*private static By skip=By.xpath("//*[@text='SKIP']");
	private static By login_text=By.xpath("//*[@text='Login']");*/
	private static By email=By.xpath("(//*[@class='android.widget.EditText'])[1]");
	private static By password=By.xpath("(//*[@class='android.widget.EditText'])[2]");
	private static By login_btn=By.xpath("//android.widget.Button[@text='Login']");
	private static By Allow=By.xpath("//android.widget.Button[@text='Allow']");
	private static By NEXT=By.xpath("//android.widget.Button[@text='NEXT']");
	private static By GOT_IT=By.xpath("//android.widget.Button[@text='GOT IT']");
	//android.widget.Button[@text='Allow']//NEXT//GOT IT
	//com.flipkart.android/com.flipkart.android.activity.HomeFragmentHolderActivity
	public static void paymteLogin(){
		for(int i=1;i<=4;i++){
			click(Allow);
		}
		for(int j=1;j<=3;j++){
			click(NEXT);
		}
		click(GOT_IT);
		sendkeys(email, "enhopspaymate@gmail.com");
		//hideKeyBoard();
		//clickOnBackButton();
		sendkeys(password, "Paymate@1");
		//clickOnBackButton();
		click(login_btn);
	}
	
	

}
