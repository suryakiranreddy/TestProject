package Common;

import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class ExtentManager {

	 
	private static ExtentReports extent;
    private  String reportFileName =  "./Reports/HtmlReports/Automaton Report - ";
    
    
    public  ExtentReports getInstance() {
        if (extent == null)
            createInstance();
        return extent;
    }
  //Create an extent report instance
    public  ExtentReports createInstance() {
        
    	String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
    	//extent = new ExtentReports (userDir +"\\test-output\\" + timeStamp + ".html", true);
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(reportFileName+timeStamp+".html");
      
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