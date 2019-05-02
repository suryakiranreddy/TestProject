package Common;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.LogStatus;



public class Screenshot {
	
	 public static String capture(WebDriver driver,String screenShotName) throws IOException
	    {
	       /* TakesScreenshot ts = (TakesScreenshot)driver;
	        File source = ts.getScreenshotAs(OutputType.FILE);
	        Calendar calendar = Calendar.getInstance();
			SimpleDateFormat formater = new SimpleDateFormat("dd_mm_yyyy_hh_mm_ss");
	        String dest = System.getProperty("user.dir") +"\\Reports\\Screenshots\\"+ screenShotName+formater.format(calendar.getTime())+".png";
	        File destination = new File(dest);
	        FileUtils.copyFile(source, destination); */
		 TakesScreenshot ts = (TakesScreenshot) driver;
	        String source = ts.getScreenshotAs(OutputType.BASE64);            
	        return source;
	    }

	 public static void infoScreenshot(WebDriver driver,String screenShotInfo) throws IOException
	    {
	        TakesScreenshot ts = (TakesScreenshot) driver;
	        String source = ts.getScreenshotAs(OutputType.BASE64);
	      // test.log(LogStatus.INFO, test.addBase64ScreenShot("data:image/png;base64,"+source)+screenShotInfo +" "+ timestamp() );
	        
	    }
	 
	 public static String timestamp() {
	        return new SimpleDateFormat("dd MMMM yyyy HH-mm-ss").format(new Date());
	    }
	 
	/*public static void infoScreenshot(WebDriver driver,String screenShotInfo) throws IOException
	    {
	        TakesScreenshot ts = (TakesScreenshot)driver;
	        File source = ts.getScreenshotAs(OutputType.FILE);
	        Calendar calendar = Calendar.getInstance();
			SimpleDateFormat formater = new SimpleDateFormat("dd_mm_yyyy_hh_mm_ss");
	        String dest = System.getProperty("user.dir") +"\\Reports\\Screenshots\\"+formater.format(calendar.getTime())+".png";
	        File destination = new File(dest);
	        FileUtils.copyFile(source, destination);        
	        logger.log(LogStatus.INFO, logger.addBase64ScreenShot(dest)+screenShotInfo);
	    }*/
}
