package Common;

import java.util.ArrayList;
import java.util.List;
import org.testng.TestNG;



public class CreateTestNG_SuiteXMLFromSpreadsheet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("main method");
		XLSReader suite = new XLSReader("./AutomationControlSheet.xlsx");
		
		suite.getTests("select * from TestCase where Active='y' ");
		
		
		/*TestNG runner=new TestNG();
		TestListner testListner= new TestListner();
		//RetryListenerClass retryListener= new RetryListenerClass();
		// Create a list of String 
		List<String> suitefiles=new ArrayList<String>();
		// Add xml file which you have to execute
		suitefiles.add("./testng1.xml");
         runner.addListener(testListner);
       //  runner.addListener(retryListener);
		// now set xml file for execution
		runner.setTestSuites(suitefiles);
		// finally execute the runner using run method
		runner.run();*/
	}

}
