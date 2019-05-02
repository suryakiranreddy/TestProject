package lunch2desk_TestCases;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Common.Screenshot;
import Common.TestDataProvider;
import TestBase.TestBase;
import lunch2Desk_pages.CustomerLogin;
import lunch2Desk_pages.Logout;
import lunch2Desk_pages.OrderFood;

public class TC04_OrderFoodTest extends TestBase {
	public OrderFood item;

	@DataProvider
	public Object[][] testData() throws Exception {
		Object data[][] = TestDataProvider.excelReader(Repository.getProperty("CreditMantriExcelPath"),
				"orderFood");
		return data;
	}

	@BeforeClass
	public void executionEngine() throws IOException {
		init();
		item = new OrderFood(driver);
	}

	@Test(dataProvider = "testData")
	public void orderItemTest(String uname, String password,String restarentName, String lastName, String email, String mobileNumber,
			String address) throws IOException {
		try {
			
			Screenshot.infoScreenshot(driver, "OrderItem");
			CustomerLogin.customerLogin(uname, password);
			item.restaurentSearch(restarentName);
			item.addCart();
			Screenshot.infoScreenshot(driver, "OrderItem");
			item.submitOrder(lastName, email, mobileNumber, address);
			Screenshot.infoScreenshot(driver, "OrderItem");
			Logout.logout();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
		
	}

	@AfterClass
	public void tearDown() {

	}
}