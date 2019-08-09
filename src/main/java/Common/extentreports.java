package Common;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import TestBase.TestBase;

@Listeners({Common.TestListner.class})
public class extentreports extends TestBase {
	
	@Test(description="Invalid Login Scenario with empty username and password.")
	public void getAPIWithoutHeadersTest() throws ClientProtocolException, IOException {
ExtentTestManager.startNode("node1");
ExtentTestManager.getTest().log(Status.INFO, "hiiiii-0");
ExtentTestManager.startNode("node2");
ExtentTestManager.getTest().log(Status.INFO, "hiiiii-1");

	}
	@Test(description="Invalid Login Scenario with empty username and password.")
	public void getAPIWithoutHeadersTestt() throws ClientProtocolException, IOException {
		ExtentTestManager.startNode("node3");
		ExtentTestManager.getTest().log(Status.INFO, "hiiiii-2");
		ExtentTestManager.startNode("node4");
		ExtentTestManager.getTest().log(Status.INFO, "hiiiii-3");

	}

}
