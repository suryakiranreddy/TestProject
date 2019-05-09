package Common;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class ExtentManager {
	
	private static ExtentReports extent;
    private static String reportFileName =  "./Reports/HtmlReports/Automaton Report"+".html";
    
    
    public static ExtentReports getInstance() {
        if (extent == null)
            createInstance();
        return extent;
    }
  //Create an extent report instance
    public static ExtentReports createInstance() {
        
        
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(reportFileName);
      
       /* htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle(reportFileName);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName(reportFileName);*/
        htmlReporter.loadXMLConfig("./src/main/resources/ConfigFiles/extent-config.xml");
 
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
 
        return extent;
    }
	
}