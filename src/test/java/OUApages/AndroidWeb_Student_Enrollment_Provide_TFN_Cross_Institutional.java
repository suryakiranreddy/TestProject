package OUA_Pages;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import com.relevantcodes.extentreports.LogStatus;
import Common.Screenshot;
import TestBase.AndroidTestBase;
import io.appium.java_client.MobileElement;

public class AndroidWeb_Student_Enrollment_Provide_TFN_Cross_Institutional extends AndroidTestBase {
	
	private static ArrayList<String> tabs = null;
	public static String OUAID = null;
	
	// Sitecore Login
	private static By Sitecore_HamburgerIcon = By.xpath("//div[@class='navbar-header-buttons']/button");
	private static By Sitecore_Signin = By.xpath("//a[text()='Sign in']");
	private static By Sitecore_email = By.id("email");
	private static By Sitecore_password = By.id("password");
	private static By Sitecore_sigin_btn = By.id("_login");

	// sitecore logout
	private static By Sitecore_studentHub = By.xpath("//*[@id='dropdownLoggedIn']/a/span");
	private static By Sitecore_siginOut = By.xpath("//a[text()='Sign out']");
	
	// subjectEnroll in site core
	private static By searchSubject_txtBox = By.id("searchTxt");
	private static By searchBtn = By.id("searchBtn");
	private static By leadReject = By.id("btn-modalMoreInfo-reject");
	private static By subject_getTxt = By.xpath("//div[@class='banner-content']/h1");
	private static By select_year = By.xpath("//ul[@id='tabversion']/li/a");
	private static By feee = By.xpath("//*[@id='_fee']/span[1]");
	private static By enroll_btn = By.id("unit-enrol-btn");
	private static By Continue_without_sign = By.id("continue");

	// registration in site core
	private static By firstname = By.id("firstname");
	private static By lastname = By.id("lastname");
	private static By registerEmail = By.id("registerEmail");
	private static By registerPassword = By.id("registerPassword");
	private static By confirmpassword = By.id("confirmpassword");
	private static By register_btn = By.id("btn-register-page-register");
	
	private static By addDegree = By.xpath("// *[@class='card-action']/button[@id='LAT-HUN-DEG-2019']");
	private static By core = By.id("Core");
	private static By health_Pathway = By.id("Health Pathway");
	private static By citizenship_selection = By.xpath("//select[@data-testid='citizenship-selection']");
	private static By logo = By.xpath("//a[@class='navbar-brand ']/img");
	private static By enrol_subjects = By.id("enrol-subjects");
	public static By apply = By.xpath("//button[text()='Apply']");
	public static By continue_btn = By.xpath("//button[text()='Continue']");

	// PersonalInfomation
	public static By selecttitle = By.id("title");
	public static By dateofbirth = By.id("dateOfBirth");
	public static By gender = By.xpath("//label[contains(text(),'Male')]");
	public static By EmploymentStatus = By.xpath("//select[@name='employmentStatus']");
	public static By Save = By.id("btn-information-page-personal-information");
	public static By MobileNumber = By.id("mobile");
	public static By streetAdress = By.id("mailingStreet1");
	public static By SubrubStreet = By.id("mailingSuburb");
	public static By state = By.id("mailingState");
	public static By statecode = By.id("mailingPostCode");
	public static By Contactsave = By.id("btn-information-page-contact-details");
	public static By postal_address = By.xpath("//label[contains(text(),'Same as postal address')]");
	public static By ResidentAdressSave = By.id("btn-information-page-residential-address");
	public static By Education = By.id("secondEdu");
	public static By yearofcomplete = By.id("secondEduYear");
	public static By postgraduate = By.xpath("(//label[contains(text(),'Never commenced')])[1]");
	public static By bachelor_level = By.xpath("(//label[contains(text(),'Never commenced')])[2]");
	public static By subdegree_level = By.xpath("(//label[contains(text(),'Never commenced')])[3]");
	public static By subdegreeVET = By.xpath("(//label[contains(text(),'Never commenced')])[4]");
	public static By VET_award_level_course = By.xpath("(//label[contains(text(),'Never commenced')])[5]");
	public static By other_qualification = By.xpath(" (//label[contains(text(),'Never commenced')])[6]");
	public static By HighestLeveofeducation = By.xpath("//select[@name='parentHighestLevelOfEducation']");
	public static By HighestLeveofeducationParent = By.xpath("//select[@name='parentOtherHighestLevelOfEducation']");
	public static By ReasonFortakingSubject = By.id("reasonForCourseOrUnit");
	public static By Saveandcontinue = By.id("btn-information-page-education");
	public static By PermanentHomeResident = By.xpath("(//label[contains(text(),'Same as residential address')])[1]");
	public static By PermanentHomeResidence = By.xpath("(//label[contains(text(),'Same as residential address')])[2]");
	public static By CountryOfBirth = By.xpath("//select[@id='countryOfBirth']");
	public static By Counrty = By.xpath("//*[@id='countryOfBirth_chosen']/div/div/input");
	public static By AreyouofAustralianAboriginal = By.xpath("//select[@name='aboriginalOrTorresStraitIslanderDescent']");
	public static By SaveResidentAddress = By.id("btn-information-page-residence");
	public static By SpecialNeeds = By.xpath("(//label[contains(text(),'No')])[2]");
	public static By SaveSpecialNeeds = By.id("btn-information-page-disability-assistance");
	public static By ContinueToPayment = By.id("continueToPayment");
	public static By backToSearch = By.xpath("(//label[contains(text(),'No')])[2]");
	public static By undergraduateinformation_continue_btn = By.id("btn-undergraduate-information");
	public static By OUA_Satus = By.xpath("//*[@id=\"wrap\"]/main/div[1]/div/div/div[1]/section/div/div/div/span");

	// Residency status
	public static By Residencystatus = By.xpath("//h2[@class='panel-heading']/a/span");
	public static By totalcost = By.xpath("//p[@class='total-cost']/span/strong");
	public static By you_live_in_Australia = By.xpath("//label[contains(text(),'Yes, for the entire degree.')]");
	public static By save_continue1 = By.xpath("//button[text()='Save and Continue']");
	public static By Entryrequirements = By.xpath("//label[contains(text(),'Work and life experience')]");
	public static By fileUpload = By.xpath("//a[text()='click to browse']");
	public static By personalStatement = By.xpath("//*[@id='workandlifeexperience']/div/div/div/div/input");
	public static By save_continue2 = By.xpath("//button[text()='Save and continue']");
	public static By Isyourpresentnamedifferent = By.xpath("(//label[text()='No'])[1]");
	public static By save_continue3 = By.xpath("(//button[text()='Save and continue'])[1]");
	public static By previousdegreesorsubjectsinEnglish = By.xpath("(//label[text()='Yes'])[2]");
	public static By save_continue4 = By.xpath("(//button[text()='Save and continue'])[1]");
	public static By continuee = By.xpath("//button[text()='Continue']");
	public static By HECS_HELPloan = By.xpath("//span[text()='HECS-HELP loan']");
	public static By Checkyoureligibility = By.xpath("//label[text()='Yes']");
	public static By save_continue5 = By.xpath("(//button[text()='Save and continue'])[1]");
	public static By TaxFileNumber_yes = By.xpath("(//label[text()='Yes'])[2]");
	public static By TaxFileNumber = By.id("tfnNumber");
	public static By save_continue6 = By.xpath("//button[text()='Save and Continue']");
	public static By SubmittoConfirm = By.id("btn-hecs-container");
	public static By conformationmessage = By.xpath("//div[@class='col-md-8 mainContent']/h1");
	public static By goToDashBoard = By.xpath("//a[text()='Go to dashboard']");
	
	public static By subName = By.xpath("//div[@class='offerContainer']/div/p[2]");
	public static By acceptoffer_btn = By.xpath("//button[contains(text(),'Accept offer and continue to funding')]");
	public static By youRequest = By
			.xpath("//*[@id='wrap']/main/div[1]/div/div/section/div/div/div[1]/div[3]/form/div[3]/div[1]/label");
	public static By youUnderstand1 = By
			.xpath("//*[@id='wrap']/main/div[1]/div/div/section/div/div/div[1]/div[3]/form/div[3]/div[2]/label");
	public static By youDeclare = By
			.xpath("//*[@id='wrap']/main/div[1]/div/div/section/div/div/div[1]/div[3]/form/div[3]/div[3]/label");
	public static By youUnderstand2 = By
			.xpath("//*[@id='wrap']/main/div[1]/div/div/section/div/div/div[1]/div[3]/form/div[3]/div[4]/label");
	public static By signature_yes = By.xpath("//*[@id='signature']");
	public static By youAgree = By
			.xpath("//*[@id='wrap']/main/div[1]/div/div/section/div/div/div[1]/div[3]/form/div[3]/div[6]/label");
	public static By completeenrolment_btn = By.xpath("//button[contains(text(),'Complete enrolment')]");
	public static By returntoStudentHub = By.xpath("//a[contains(text(),'Return to Student Hub')]");
	public static By PaybyHECS_HELP = By.xpath("//a[contains(text(),'Pay by HECS-HELP')]");

	
	
	public static void androidWeb_Student_Enrollment_Provide_TFN_Cross_Institutional() throws Exception {
		
		List<String> newTab = new List<String>(driver.getWindowHandles());
        driver.switchTo().window(newTab.get(1));
        

		test.log(LogStatus.INFO,"<b style=\"color:brown;\">==================== Subject Enrollment ==========================</b>");
		log.info("==================== Subject Enrollment  ==========================");
		infoScreenshot(androidDriver, "OUA site core Homepage");
		subjectEnroll("Introduction to Nutrition", "1,169");
		click(addDegree);
		test.log(LogStatus.INFO, "Clicked on <b style=\"color:green;\"> 'Add degree' </b> ");
		log.info("Clicked on Add degree ");
		click(core);
		test.log(LogStatus.INFO, "Clicked on <b style=\"color:green;\"> 'core' </b> ");
		log.info("Clicked on core ");
		click(health_Pathway);
		test.log(LogStatus.INFO, "Clicked on <b style=\"color:green;\"> 'health Pathway' </b> ");
		log.info("Clicked on health Pathway ");
		Thread.sleep(2000);
		click(logo);
		test.log(LogStatus.INFO, "Clicked on <b style=\"color:green;\"> 'logo' </b> ");
		log.info("Clicked on logo ");

		subjectEnroll("Issues in Contemporary Art", "820");
		selectVisibleText(citizenship_selection, "Australian Citizen");
		click(enrol_subjects);
		registration("enhops", "testing", Repository.getProperty("email"), "Test1234");
		Thread.sleep(20000);
		click(apply);
		test.log(LogStatus.INFO, "Clicked on <b style=\"color:green;\"> 'Apply' </b>  button");
		log.info("Clicked on Apply button ");
		Thread.sleep(2000);
		click(continue_btn);
		test.log(LogStatus.INFO, "Clicked on <b style=\"color:green;\"> 'CONTINUE' </b>  button");
		log.info("Clicked on CONTINUE button ");
		youriInformation("Mr", "23121991", "Male", "Full-time employed", "0123456789", "Enhops Hyderabad", "Automation",
				"Australian Capital Territory", "1234", "Secondary College/High School", "2014", "Bachelor",
				"Not applicable", "Other", "Australia", "Australian Aboriginal");
		residencystatus(Repository.getProperty("TFNNumber"));
		siteCoreMobileWebLogOut();
		Thread.sleep(10000);
		
		openNewTab("https://www.uat1.env.opendev.edu.au/",1);
		Thread.sleep(10000);
		siteCoreMobileWebLogin("enhposautomation132@test.com", "Test1234");
		Thread.sleep(20000);
		//acceptOfferInSiteCore();
		siteCoreMobileWebLogOut();
	}
	
	
	public static void siteCoreMobileWebLogin(String emaill, String passwordd) throws Exception {
		test.log(LogStatus.INFO,"<b style=\"color:brown;\">==================== SiteCore Login started ==========================</b>");
		log.info("==================== SiteCore started ==========================");
		click(Sitecore_HamburgerIcon);
		test.log(LogStatus.INFO, "<b style=\"color:green;\">'Sitecore HamburgerIcon'</b> button clicked");
		log.info("'Sitecore HamburgerIcon' button clicked");
		Thread.sleep(5000);
		click(Sitecore_Signin);
		test.log(LogStatus.INFO, "<b style=\"color:green;\">'Sign In'</b> button clicked");
		log.info("'Sign In' button clicked");
		sendkeys(Sitecore_email, emaill);
		test.log(LogStatus.INFO, "<b style=\"color:green;\">'" + emaill + "'</b>  email entered");
		log.info(emaill + " email entered");
		sendkeys(Sitecore_password, passwordd);
		test.log(LogStatus.INFO, "<b style=\"color:green;\">" + " '***************' " + "</b> password entered");
		log.info(" ********** password entered");
		click(Sitecore_sigin_btn);
		test.log(LogStatus.INFO, "clicked on <b style=\"color:green;\">'Sign In'</b> button ");
		log.info("clicked on 'Sign In' button");
		test.log(LogStatus.INFO,"<b style=\"color:brown;\">==================== SiteCore Login ended ==========================</b>");
		log.info("==================== SiteCore Login ended==========================");
		Thread.sleep(10000);

		}
	
	
	public static void siteCoreMobileWebLogOut() throws Exception {
		test.log(LogStatus.INFO,"<b style=\"color:brown;\">==================== SiteCore Logout started ==========================</b>");
		log.info("==================== SiteCore Logout started==========================");
		Thread.sleep(3000);
		click(Sitecore_HamburgerIcon);
		test.log(LogStatus.INFO, "<b style=\"color:green;\">'Sitecore HamburgerIcon'</b> button clicked");
		log.info("'Sitecore HamburgerIcon' button clicked");
		Thread.sleep(5000);
		click(Sitecore_studentHub);
		test.log(LogStatus.INFO, "Clicked on <b style=\"color:green;\">'Student Hub'</b>");
		log.info("Clicked on Student Hub");
		Thread.sleep(5000);
		click(Sitecore_siginOut);
		test.log(LogStatus.INFO, "Clicked on <b style=\"color:green;\"> 'Sign Out' </b> button");
		log.info("Clicked on Sign Out button");
		test.log(LogStatus.INFO,"<b style=\"color:brown;\">==================== SiteCore Logout ended==========================</b>");
		log.info("==================== SiteCore Logout ended==========================");
	}
	public static void subjectEnroll(String Subject1, String feez) throws Exception {

		sendkeys(searchSubject_txtBox, Subject1);// Introduction to Nutrition
		log.info(Subject1 + " subject entered in search box");
		test.log(LogStatus.INFO,
				"<b style=\"color:green;\"> '" + Subject1 + "'</b> subject/degree entered in search box");
		click(searchBtn);
		test.log(LogStatus.INFO, "Clicked on <b style=\"color:green;\"> 'search icon' </b>");
		log.info("Clicked on search icon");
		click(By.xpath("//p[contains(text(),'" + Subject1 + "')]"));
		log.info(Subject1 + " clicked from the list of subjects");
		test.log(LogStatus.INFO,
				"<b style=\"color:green;\"> '" + Subject1 + "'</b> clicked from the list of subject/degree(s)");
		try {
			click(leadReject);
			test.log(LogStatus.INFO, "Clicked on <b style=\"color:green;\"> 'No Thanks' </b> in lead form");
			log.info("Clicked on No Thanks in lead form");
		} catch (Exception e) {
			e.getMessage();
		}
		Thread.sleep(5000);
		infoScreenshot(androidDriver, Subject1 + " selected page");
		String subject_name = getElementText(subject_getTxt);
		System.out.println(subject_name);
		log.info("Actual Subject name :- '" + subject_name + "'");
		test.log(LogStatus.INFO, "Actual Subject name :- <b style=\"color:green;\">'" + Subject1 + "'</b>");
		log.info("Expected Subject name :- '" + subject_name + "'");
		test.log(LogStatus.INFO, "Expected Subject name :- <b style=\"color:green;\">'" + Subject1 + "'</b>");
		Assert.assertTrue(subject_name.contains(Subject1));
		test.log(LogStatus.INFO, " Subject name <b style=\"color:green;\">'" + Subject1 + "'</b> matched");
		log.info("Subject name '" + Subject1 + "'matched");
		Thread.sleep(5000);
		//click(select_year);
		test.log(LogStatus.INFO, "Clicked on <b style=\"color:green;\"> '2019' </b> year");
		log.info("Clicked on 2019 year");
		String fee = getElementText(feee);
		System.out.println(fee);
		log.info("Actual Subject fee :- '" + fee + "'");
		test.log(LogStatus.INFO, "Actual Subject fee :- <b style=\"color:green;\">'" + fee + "'</b>");
		log.info("Expected Subject fee :- '" + feez + "'");
		test.log(LogStatus.INFO, "Expected Subject fee :- <b style=\"color:green;\">'" + feez + "'</b>");
		Assert.assertTrue(fee.contains(feez));// 1,169
		test.log(LogStatus.INFO, " Subject fee <b style=\"color:green;\">'" + fee + "'</b> matched");
		log.info("Subject fee '" + fee + "'matched");
		click(enroll_btn);
		test.log(LogStatus.INFO, "Clicked on <b style=\"color:green;\"> 'Enroll' </b> button");
		log.info("Clicked on Enroll button");
		try {
			click(Continue_without_sign);
			test.log(LogStatus.INFO, "Clicked on <b style=\"color:green;\"> 'Continue Without Sigin' </b> button");
			log.info("Clicked on Continue Without Sigin button");
		} catch (Exception e4) {
			e4.getMessage();
		}
	}
	
	public static void registration(String FirstName, String LastName, String Email, String Password) throws Exception {
		Thread.sleep(3000);
		sendkeys(firstname, FirstName);
		test.log(LogStatus.INFO, "<b style=\"color:green;\">'" + FirstName + "'</b>  Firstname entered");
		log.info(FirstName + " Firstname entered");
		Thread.sleep(1000);
		sendkeys(lastname, LastName);
		test.log(LogStatus.INFO, "<b style=\"color:green;\">'" + LastName + "'</b>  Lastname entered");
		log.info(LastName + " Lastname entered");
		Thread.sleep(1000);
		sendkeys(registerEmail, Email);
		test.log(LogStatus.INFO, "<b style=\"color:green;\">'" + Email + "'</b>  email entered");
		log.info(Email + " email entered");
		Thread.sleep(1000);
		sendkeys(registerPassword, Password);
		test.log(LogStatus.INFO, "<b style=\"color:green;\">" + "' ***************' " + "</b> password entered");
		log.info(" ********** password entered");
		Thread.sleep(1000);
		sendkeys(confirmpassword, Password);
		test.log(LogStatus.INFO,
				"<b style=\"color:green;\">" + "' ***************' " + "</b> Confirm password entered");
		log.info(" ********** Confirm password entered");
		Thread.sleep(4000);
		infoScreenshot(androidDriver, "Registaration page in site core");
		click(register_btn);
		test.log(LogStatus.INFO, "Clicked on <b style=\"color:green;\"> 'Register' </b> button");
		log.info("Clicked on Register button");
		Thread.sleep(3000);

	}
	
	
	public static void acceptOfferInSiteCore() throws Exception {
		test.log(LogStatus.INFO,"<b style=\"color:brown;\">==================== Accept offer and continue to funding ==========================</b>");
		log.info("==================== Accept offer and continue to funding ==========================");
		Thread.sleep(3000);
		click(acceptoffer_btn);
		test.log(LogStatus.INFO,"clicked on  <b style=\"color:green;\">'Accept offer and continue to funding '</b> button ");
		log.info("clicked on  'Accept offer and continue to funding' button ");
		Thread.sleep(3000);
		// declaration and signature
		click(youRequest);
		test.log(LogStatus.INFO,"clicked on  <b style=\"color:green;\">'the Government lends you the student contribution amount for subjects "
						+ "in your degree outstanding at the census date and pays the outstanding amount to your provider on your behalf '</b> check box ");
		log.info("clicked on  'the Government lends you the student contribution amount for subjects in your degree outstanding at the census date"
						+ " and pays the outstanding amount to your provider on your behalf' check box ");
		Thread.sleep(1000);
		click(youUnderstand1);
		test.log(LogStatus.INFO,"clicked on  <b style=\"color:green;\">'HELP debt will be indexed annually in line with the Act '</b> check box ");
		log.info("clicked on  'HELP debt will be indexed annually in line with the Act' check box ");
		Thread.sleep(1000);
		click(youDeclare);
		test.log(LogStatus.INFO,"clicked on  <b style=\"color:green;\">'read and understood the notes and information in this form '</b> check box ");
		log.info("clicked on  'read and understood the notes and information in this form.' check box ");
		Thread.sleep(1000);
		click(youUnderstand2);
		test.log(LogStatus.INFO,"clicked on  <b style=\"color:green;\">'by signing this form, you consent to the collection, use and disclosure of your personal information '</b> check box ");
		log.info("clicked on  'by signing this form, you consent to the collection, use and disclosure of your personal information' check box ");
		Thread.sleep(1000);
		sendkeys(signature_yes, "yes");
		test.log(LogStatus.INFO, "Entered  <b style=\"color:green;\">'YES '</b>for agree all the statements above ");
		log.info("Entered  ' 'YES 'for agree all the statements above ");
		Thread.sleep(1000);
		click(youAgree);
		test.log(LogStatus.INFO, "clicked on  <b style=\"color:green;\">'I agree '</b> button ");
		log.info("clicked on  'I agree' button ");
		Thread.sleep(1000);
		click(completeenrolment_btn);
		test.log(LogStatus.INFO, "clicked on  <b style=\"color:green;\">'Complete enrolment '</b> button ");
		log.info("clicked on  'Complete enrolment' button ");
		Thread.sleep(3000);
		click(returntoStudentHub);
		test.log(LogStatus.INFO, "clicked on  <b style=\"color:green;\">'Return to Student Hub'</b> button ");
		log.info("clicked on  'Return to Student Hub' button ");
		Thread.sleep(20000);
		click(PaybyHECS_HELP);
		test.log(LogStatus.INFO, "clicked on  <b style=\"color:green;\">'Pay by HECS-HELP'</b> button ");
		log.info("clicked on  'Pay by HECS-HELP' button ");
		Thread.sleep(3000);
		click(youRequest);
		test.log(LogStatus.INFO,"clicked on  <b style=\"color:green;\">'the Government lends you the student contribution amount for subjects "
						+ "in your degree outstanding at the census date and pays the outstanding amount to your provider on your behalf '</b> check box ");
		log.info("clicked on  'the Government lends you the student contribution amount for subjects in your degree outstanding at the census date"
						+ " and pays the outstanding amount to your provider on your behalf' check box ");
		Thread.sleep(1000);
		click(youUnderstand1);
		test.log(LogStatus.INFO,"clicked on  <b style=\"color:green;\">'HELP debt will be indexed annually in line with the Act '</b> check box ");
		log.info("clicked on  'HELP debt will be indexed annually in line with the Act' check box ");
		Thread.sleep(1000);
		click(youDeclare);
		test.log(LogStatus.INFO,"clicked on  <b style=\"color:green;\">'read and understood the notes and information in this form '</b> check box ");
		log.info("clicked on  'read and understood the notes and information in this form.' check box ");
		Thread.sleep(1000);
		click(youUnderstand2);
		test.log(LogStatus.INFO,"clicked on  <b style=\"color:green;\">'by signing this form, you consent to the collection, use and disclosure of your personal information '</b> check box ");
		log.info("clicked on  'by signing this form, you consent to the collection, use and disclosure of your personal information' check box ");
		Thread.sleep(1000);
		sendkeys(signature_yes, "yes");
		test.log(LogStatus.INFO, "Entered  <b style=\"color:green;\">'YES '</b>for agree all the statements above ");
		log.info("Entered  ' 'YES 'for agree all the statements above ");
		Thread.sleep(1000);
		click(youAgree);
		test.log(LogStatus.INFO, "clicked on  <b style=\"color:green;\">'I agree '</b> button ");
		log.info("clicked on  'I agree' button ");
		Thread.sleep(1000);
		click(completeenrolment_btn);
		test.log(LogStatus.INFO, "clicked on  <b style=\"color:green;\">'Complete enrolment '</b> button ");
		log.info("clicked on  'Complete enrolment' button ");
		Thread.sleep(3000);
		click(returntoStudentHub);
		test.log(LogStatus.INFO, "clicked on  <b style=\"color:green;\">'Return to Student Hub'</b> button ");
		log.info("clicked on  'Return to Student Hub' button ");
		Thread.sleep(20000);

		List<MobileElement> noOfSubjects = androidDriver.findElements(By.xpath("//div[@class='cards-container']/div"));

		for (int i = 1; i <= noOfSubjects.size(); i++) {
			String SubjectName = androidDriver.findElement(By.xpath("(//*[@class='card-content']/p[2])[" + i + "]")).getText();
			String Status = androidDriver.findElement(By.xpath("(//div[@class='card-footer']/div[1]/span)[" + i + "]")).getText();
			System.out.println("SubjectName:- " + SubjectName + ", Status:- " + Status);

			if (SubjectName.contains(Repository.getProperty("subject1"))&& Status.contains(Repository.getProperty("status"))) {

				Assert.assertTrue(SubjectName.contains(Repository.getProperty("subject1"))&& Status.contains(Repository.getProperty("status")));
				test.log(LogStatus.INFO, "SubjectName:- <b style=\"color:green;\">'" + SubjectName
						+ "'</b>, Status:- <b style=\"color:green;\">'" + Status + "'</b> verified");
				log.info("SubjectName:- '" + SubjectName + "', Status:- '" + Status + "'");

			} else {
				Assert.assertTrue(SubjectName.contains(Repository.getProperty("subject2"))&& Status.contains(Repository.getProperty("status")));
				test.log(LogStatus.INFO, "SubjectName:- <b style=\"color:green;\">'" + SubjectName
						+ "'</b>, Status:- <b style=\"color:green;\">'" + Status + "'</b> verified");

			}
		}

	}
	public static void youriInformation(String Selecttitle, String Dateofbirth, String Gender, String employmentStatus,
			String mobileNumber, String StreetAdress, String subrubStreet, String State, String Postcode,
			String secondaryeducation, String yearOfcomplete, String HighestLeveofEducation,
			String HighestLevelofeducationParent, String ReasonForTakingSubject, String counrty,
			String AustralianAboriginalOrTorresStraitIslanderdescent) throws Exception {
		// Personal information
		test.log(LogStatus.INFO,"<b style=\"color:brown;\">==================== Your Information ==========================</b>");
		log.info("==================== Your Information ==========================");
		selectVisibleText(selecttitle, Selecttitle);
		test.log(LogStatus.INFO, "<b style=\"color:green;\">'" + Selecttitle + "'</b>  title selected");
		log.info(Selecttitle + "  title selected");
		Thread.sleep(1000);
		sendkeys(dateofbirth, Dateofbirth);
		test.log(LogStatus.INFO, "<b style=\"color:green;\">'" + Dateofbirth + "'</b>  Dateofbirth entered");
		log.info(Dateofbirth + "  Dateofbirth entered");
		Thread.sleep(1000);
		click(By.xpath("//label[contains(text(),'" + Gender + "')]"));
		test.log(LogStatus.INFO, "<b style=\"color:green;\">'" + Gender + "'</b>  gender selected");
		log.info(Gender + "  gender selected");
		Thread.sleep(1000);
		selectVisibleText(EmploymentStatus, employmentStatus);
		test.log(LogStatus.INFO,"<b style=\"color:green;\">'" + employmentStatus + "'</b>  employment status selected");
		log.info(employmentStatus + "  employment status selected");
		Thread.sleep(1000);
		click(Save);
		test.log(LogStatus.INFO, "Clicked on <b style=\"color:green;\"> 'SAVE AND CONTINUE' </b> button");
		log.info("Clicked on SAVE AND CONTINUE button");
		Thread.sleep(3000);
		// Contact details
		test.log(LogStatus.INFO,"<b style=\"color:brown;\">==================== Contact Details ==========================</b>");
		log.info("==================== Contact Details ==========================");
		sendkeys(MobileNumber, mobileNumber);
		test.log(LogStatus.INFO, "<b style=\"color:green;\">'" + mobileNumber + "'</b>  mobile number entered");
		log.info(mobileNumber + "  mobileNumber entered");
		Thread.sleep(1000);
		sendkeys(streetAdress, StreetAdress);
		test.log(LogStatus.INFO, "<b style=\"color:green;\">'" + StreetAdress + "'</b>  street address entered");
		log.info(StreetAdress + "  StreetAdress entered");
		Thread.sleep(1000);
		sendkeys(SubrubStreet, subrubStreet);
		test.log(LogStatus.INFO, "<b style=\"color:green;\">'" + subrubStreet + "'</b>  Suburb entered");
		log.info(subrubStreet + "  Suburb entered");
		Thread.sleep(1000);
		selectVisibleText(state, State);
		test.log(LogStatus.INFO, "<b style=\"color:green;\">'" + State + "'</b>  state entered");
		log.info(State + "  state entered");
		Thread.sleep(1000);
		sendkeys(statecode, Postcode);
		test.log(LogStatus.INFO, "<b style=\"color:green;\">'" + Postcode + "'</b>  Postcode entered");
		log.info(Postcode + "  Postcode entered");
		Thread.sleep(1000);
		click(Contactsave);
		test.log(LogStatus.INFO, "Clicked on <b style=\"color:green;\"> 'SAVE AND CONTINUE' </b> button");
		log.info("Clicked on SAVE AND CONTINUE button");
		Thread.sleep(3000);
		// Residential address
		test.log(LogStatus.INFO,"<b style=\"color:brown;\">==================== Residential Address ==========================</b>");
		log.info("==================== Residential Address ==========================");
		click(postal_address);
		test.log(LogStatus.INFO, "Select <b style=\"color:green;\"> 'Same as postal address' </b> check box");
		log.info("Select 'Same as postal address'  check box");
		Thread.sleep(1000);
		click(ResidentAdressSave);
		test.log(LogStatus.INFO, "Clicked on <b style=\"color:green;\"> 'SAVE AND CONTINUE' </b> button");
		log.info("Clicked on SAVE AND CONTINUE button");
		Thread.sleep(3000);
		// Education history
		test.log(LogStatus.INFO,"<b style=\"color:brown;\">==================== Education History ==========================</b>");
		log.info("==================== Education History ==========================");
		selectVisibleText(Education, secondaryeducation);
		test.log(LogStatus.INFO, "<b style=\"color:green;\">'" + secondaryeducation
				+ "'</b>  final year of secondary education selected");
		log.info(secondaryeducation + "  final year of secondary education selected");
		Thread.sleep(1000);
		selectVisibleText(yearofcomplete, yearOfcomplete);
		test.log(LogStatus.INFO, "<b style=\"color:green;\">'" + yearOfcomplete + "'</b>  year of completion selected");
		log.info(yearOfcomplete + "  year of completion selected");
		Thread.sleep(1000);
		click(postgraduate);
		test.log(LogStatus.INFO,"Have you commenced and/or completed a postgraduate level course? - <b style=\"color:green;\">'Never commenced' </b>");
		log.info("Have you commenced and/or completed a postgraduate level course? - 'Never commenced'");
		click(bachelor_level);
		Thread.sleep(1000);
		test.log(LogStatus.INFO,"Have you commenced and/or completed a bachelor level course (such as a bachelor's degree)? - <b style=\"color:green;\">'Never commenced' </b>");
		log.info("Have you commenced and/or completed a bachelor level course (such as a bachelor's degree)?- 'Never commenced'");
		click(subdegree_level);
		Thread.sleep(1000);
		test.log(LogStatus.INFO,"Have you commenced and/or completed a sub-degree level course (such as an associate degree)? - <b style=\"color:green;\">'Never commenced' </b>");
		log.info("Have you commenced and/or completed a sub-degree level course (such as an associate degree)? - 'Never commenced'");
		click(subdegreeVET);
		Thread.sleep(1000);
		test.log(LogStatus.INFO,"Have you commenced and/or completed a sub-degree VET (ie at TAFE) level course (such as a diploma)? - <b style=\"color:green;\">'Never commenced' </b>");
		log.info("Have you commenced and/or completed a sub-degree VET (ie at TAFE) level course (such as a diploma)? - 'Never commenced'");
		click(VET_award_level_course);
		Thread.sleep(1000);
		test.log(LogStatus.INFO,"Have you commenced and/or completed a VET award level course (such as Certificate III or IV)? - <b style=\"color:green;\">'Never commenced' </b>");
		log.info("Have you commenced and/or completed a VET award level course (such as Certificate III or IV)? - 'Never commenced'");
		click(other_qualification);
		Thread.sleep(1000);
		test.log(LogStatus.INFO,"Have you completed any other qualification (such as a Certificate of Attainment or Certificate of Competence)? - <b style=\"color:green;\">'Never commenced' </b>");
		log.info("Have you completed any other qualification (such as a Certificate of Attainment or Certificate of Competence)? - 'Never commenced'");
		Thread.sleep(1000);
		selectVisibleText(HighestLeveofeducation, HighestLeveofEducation);
		test.log(LogStatus.INFO,"Highest level of education completed by any of your parents or guardians? - <b style=\"color:green;\">'"+ HighestLeveofEducation + "' </b>");
		log.info("What is the highest level of education completed by any of your parents or guardians? - '"+ HighestLeveofEducation + "'");
		Thread.sleep(1000);
		selectVisibleText(HighestLeveofeducationParent, HighestLevelofeducationParent);
		test.log(LogStatus.INFO,"Highest level of education completed by your other parent or guardian? - <b style=\"color:green;\">'"+ HighestLevelofeducationParent + "' </b>");
		log.info("What is the highest level of education completed by your other parent or guardian? - '"+ HighestLevelofeducationParent + "'");
		Thread.sleep(1000);
		selectVisibleText(ReasonFortakingSubject, ReasonForTakingSubject);
		test.log(LogStatus.INFO, "Reason for undertaking this degree or subject? - <b style=\"color:green;\">'"+ ReasonForTakingSubject + "' </b>");
		log.info("Reason for undertaking this degree or subject? - '" + ReasonForTakingSubject + "'");
		Thread.sleep(1000);
		click(Saveandcontinue);
		test.log(LogStatus.INFO, "Clicked on <b style=\"color:green;\"> 'SAVE AND CONTINUE' </b> button");
		log.info("Clicked on SAVE AND CONTINUE button");
		Thread.sleep(3000);
		// Residence, origin and ethnicity
		test.log(LogStatus.INFO,"<b style=\"color:brown;\">==================== Residence, origin and ethnicity ==========================</b>");
		log.info("==================== Residence, origin and ethnicity ==========================");
		click(PermanentHomeResident);
		test.log(LogStatus.INFO,"Select permanent home residence:- <b style=\"color:green;\"> 'Same as residential address' </b> ");
		log.info("Select permanent home residence:- Same as residential address");
		Thread.sleep(1000);
		click(PermanentHomeResidence);
		test.log(LogStatus.INFO,"Select <b style=\"color:green;\"> 'Same as residential address' </b> for reside while studying with Open Universities Australia? ");
		log.info("Select 'Same as residential address'for reside while studying with Open Universities Australia? ");
		Thread.sleep(2000);
		selectVisibleText(CountryOfBirth, counrty);
		test.log(LogStatus.INFO, "Select <b style=\"color:green;\"'>" + counrty + "'</b> as Country of birth");
		log.info("Select " + counrty + " as Country of birth");
		Thread.sleep(2000);
		selectVisibleText(AreyouofAustralianAboriginal, AustralianAboriginalOrTorresStraitIslanderdescent);
		test.log(LogStatus.INFO,"Select <b style=\"color:green;\"'>" + AustralianAboriginalOrTorresStraitIslanderdescent+ "'</b> as Australian Aboriginal or Torres Strait Islander descent");
		log.info("Select " + AustralianAboriginalOrTorresStraitIslanderdescent+ "' as Australian Aboriginal or Torres Strait Islander descent");
		Thread.sleep(1000);
		click(SaveResidentAddress);
		test.log(LogStatus.INFO, "Clicked on <b style=\"color:green;\"> 'SAVE AND CONTINUE' </b> button");
		log.info("Clicked on SAVE AND CONTINUE button");
		Thread.sleep(4000);
		// Special needs
		test.log(LogStatus.INFO,"<b style=\"color:brown;\">==================== Special needs ==========================</b>");
		log.info("==================== Special needs ==========================");
		click(SpecialNeeds);
		test.log(LogStatus.INFO, "Do you have a disability:- <b style=\"color:green;\"> 'NO' </b> ");
		log.info("Do you have a disability:-  'NO' ");
		Thread.sleep(1000);
		click(SaveSpecialNeeds);
		test.log(LogStatus.INFO, "Clicked on <b style=\"color:green;\"> 'SAVE AND CONTINUE' </b> button");
		log.info("Clicked on SAVE AND CONTINUE button");
		Thread.sleep(3000);
		// Your information
		
		infoScreenshot(androidDriver, "Your Information page");
		click(ContinueToPayment);
		test.log(LogStatus.INFO,
				"Clicked on <b style=\"color:green;\"> 'CONTINUE' </b> button after submiting Information");
		log.info("Clicked on CONTINUE button after submiting Information");
		Thread.sleep(5000);
		// Supporting documents
		test.log(LogStatus.INFO,"<b style=\"color:brown;\">==================== Supporting documents ==========================</b>");
		log.info("==================== Supporting documents ==========================");
		click(undergraduateinformation_continue_btn);
		test.log(LogStatus.INFO,
				"Clicked on <b style=\"color:green;\"> 'CONTINUE' </b> button in Supporting documents page");
		log.info("Clicked on CONTINUE button in Supporting documents page");
		Thread.sleep(3000);

	}

	public static void residencystatus(String TaxFilenumber) throws InterruptedException, AWTException, Exception {
		// Undergraduate degree application
		Thread.sleep(3000);
		String Residencystatus_txt = getElementText(Residencystatus);
		System.out.println(Residencystatus_txt);
		test.log(LogStatus.INFO,"<b style=\"color:brown;\">==================== Undergraduate degree application ==========================</b>");
		log.info("==================== Undergraduate degree application ==========================");
		List<MobileElement> noOfSub = androidDriver.findElements(By.xpath("//div[@data-testid='subject-summary-item']"));
		for (int i = 1; i <= noOfSub.size(); i++) {
			String SubjectName = androidDriver.findElement(By.xpath("//div[@class='cart-summary-subjects cart-selected-subjects']/div[" + i + "]/p[3]")).getText();
			String SubjectPrice = androidDriver.findElement(By.xpath("//div[@class='cart-summary-subjects cart-selected-subjects']/div[" + i + "]/p[1]")).getText();
			System.out.println("SubjectName:- " + SubjectName + ", SubjectPrice:- " + SubjectPrice);
			if (SubjectName.contains(Repository.getProperty("subject1"))&& SubjectPrice.contains(Repository.getProperty("price1"))) {
				Assert.assertTrue(SubjectName.contains(Repository.getProperty("subject1"))&& SubjectPrice.contains(Repository.getProperty("price1")));
				test.log(LogStatus.INFO, " SubjectName:- <b style=\"color:green;\">'" + SubjectName+ "'</b> and SubjectPrice:- <b style=\"color:green;\">'</b>" + SubjectPrice + "' verified");
				log.info(" SubjectName:- '" + SubjectName + "' and SubjectPrice:- '" + SubjectPrice + "' verified");

			} else {
				Assert.assertTrue(SubjectName.contains(Repository.getProperty("subject2"))&& SubjectPrice.contains(Repository.getProperty("price2")));
				log.info(" SubjectName:- '" + SubjectName + "' and SubjectPrice:- '" + SubjectPrice + "' verified");
				test.log(LogStatus.INFO, " SubjectName:- <b style=\"color:green;\">'" + SubjectName+ "'</b> and SubjectPrice:- <b style=\"color:green;\">'</b>" + SubjectPrice + "' verified");

			}
		}

		String totalCost = getElementText(totalcost);
		System.out.println("totalCost:- " + totalCost);
		Assert.assertTrue(totalCost.contains(Repository.getProperty("TotalCost")));
		test.log(LogStatus.INFO, " TotalCost:- <b style=\"color:green;\">'" + totalCost + "'</b> verified");
		log.info("TotalCost:- '" + totalCost + "' verified");
		// Residency status
		test.log(LogStatus.INFO,"<b style=\"color:brown;\">==================== Residency status ==========================</b>");
		log.info("==================== Residency status ==========================");
		Thread.sleep(1000);
		click(you_live_in_Australia);
		test.log(LogStatus.INFO," Will you live in Australia while you study for this degree? <b style=\"color:green;\">' Yes, for the entire degree.'</b> verified");
		log.info("TotalCost:- '" + totalCost + "' verified");
		Thread.sleep(1000);
		click(save_continue1);
		test.log(LogStatus.INFO, "Clicked on <b style=\"color:green;\"> 'SAVE AND CONTINUE' </b> button");
		log.info("Clicked on SAVE AND CONTINUE button");
		Thread.sleep(3000);
		// Entry requirements
		test.log(LogStatus.INFO,"<b style=\"color:brown;\">==================== Entry requirements ==========================</b>");
		log.info("==================== Entry requirements ==========================");
		click(Entryrequirements);
		Thread.sleep(3000);
		test.log(LogStatus.INFO, "Clicked on <b style=\"color:green;\"> 'Work and life experience' </b> button");
		log.info("Clicked on Work and life experience button");
		
		
		System.out.println("androidDriver.getContext()"+androidDriver.getContext());
		// sendkeys(personalStatement, "./test-output/bullet_point.png");
		click(fileUpload);
		Set<String> contexts = androidDriver.getContextHandles();
		for (String context : contexts) {
		    System.out.println(contexts);
		    if (context.equals("NATIVE_APP")) {
		    	androidDriver.context(context);
		    	System.out.println("Enter into NATIVE_APP");
		        break;
		    }
		}
      
		 Thread.sleep(3000);
		  click(By.id("com.android.packageinstaller:id/permission_deny_button"));
        Thread.sleep(3000);
        click(By.id("com.android.documentsui:id/icon_thumb"));
		Thread.sleep(10000);
		androidDriver.context("CHROMIUM");
		System.out.println("Enter into Webview");
		
		
		
		click(save_continue2);
		test.log(LogStatus.INFO, "Clicked on <b style=\"color:green;\"> 'SAVE AND CONTINUE' </b> button");
		log.info("Clicked on SAVE AND CONTINUE button");
		Thread.sleep(3000);
		// Name change
		test.log(LogStatus.INFO,"<b style=\"color:brown;\">==================== Name change ==========================</b>");
		log.info("==================== Name change ==========================");
		click(Isyourpresentnamedifferent);
		test.log(LogStatus.INFO,"Select present name different to that on your academic transcripts? :- <b style=\"color:green;\"> 'NO' </b>");
		log.info("Select present name different to that on your academic transcripts?  'NO'");
		Thread.sleep(3000);
		click(save_continue3);
		test.log(LogStatus.INFO, "Clicked on <b style=\"color:green;\"> 'SAVE AND CONTINUE' </b> button");
		log.info("Clicked on SAVE AND CONTINUE button");
		// English language proficiency
		test.log(LogStatus.INFO,"<b style=\"color:brown;\">==================== English language proficiency ==========================</b>");
		log.info("==================== English language proficiency ==========================");
		Thread.sleep(3000);
		click(previousdegreesorsubjectsinEnglish);
		test.log(LogStatus.INFO,"Select previous degrees or subjects in English? :- <b style=\"color:green;\"> 'YES' </b>");
		log.info("Select previous degrees or subjects in English?  'YES'");
		Thread.sleep(3000);
		Screenshot.capture(androidDriver, " Undergraduate degree application ");
		click(save_continue4);
		test.log(LogStatus.INFO, "Clicked on <b style=\"color:green;\"> 'SAVE AND CONTINUE' </b> button");
		log.info("Clicked on SAVE AND CONTINUE button");
		Thread.sleep(3000);
		click(continuee);
		test.log(LogStatus.INFO,"Clicked on <b style=\"color:green;\"> 'SAVE AND CONTINUE' </b> button for Undergraduate degree application");
		log.info("Clicked on SAVE AND CONTINUE button for Undergraduate degree application");
		// Funding
		test.log(LogStatus.INFO,"<b style=\"color:brown;\">==================== Funding ==========================</b>");
		log.info("==================== Funding ==========================");
		Thread.sleep(3000);
		click(HECS_HELPloan);
		test.log(LogStatus.INFO, "Select  :- <b style=\"color:green;\"> 'HECS-HELP loan' </b> for payment");
		log.info("Select 'HECS-HELP loan' for payment");
		Thread.sleep(3000);
		click(Checkyoureligibility);
		test.log(LogStatus.INFO,"Select  :- <b style=\"color:green;\"> 'YES' </b> for studying at least part of  degree while living in Australia");
		log.info("Select 'YES' for studying at least part of  degree while living in Australia");
		Thread.sleep(3000);
		click(save_continue5);
		test.log(LogStatus.INFO,"Clicked on <b style=\"color:green;\"> 'SAVE AND CONTINUE' </b> button for Undergraduate degree application");
		log.info("Clicked on SAVE AND CONTINUE button for Undergraduate degree application");
		Thread.sleep(3000);
		// Your tax file number
		click(TaxFileNumber_yes);
		test.log(LogStatus.INFO,"Do you have a valid Tax File Number (TFN)  :- <b style=\"color:green;\"> 'YES' </b> ");
		log.info("Do you have a valid Tax File Number (TFN)  :-  'YES'  ");
		Thread.sleep(3000);
		sendkeys(TaxFileNumber, TaxFilenumber);
		test.log(LogStatus.INFO, "<b style=\"color:green;\">'" + TaxFilenumber + "'</b> TaxFileNumber entered");
		log.info(TaxFilenumber + "  TaxFileNumber entered");
		Thread.sleep(3000);
		click(save_continue6);
		test.log(LogStatus.INFO,"Clicked on <b style=\"color:green;\"> 'SAVE AND CONTINUE' </b> button for Undergraduate degree application");
		log.info("Clicked on SAVE AND CONTINUE button for Undergraduate degree application");
		infoScreenshot(androidDriver, "funding page");
		Thread.sleep(3000);
		click(SubmittoConfirm);
		test.log(LogStatus.INFO,"Clicked on <b style=\"color:green;\"> 'Submit to Confirm' </b> button for Undergraduate degree application");
		log.info("Clicked on Submit to Confirm button for Undergraduate degree application");
		Thread.sleep(3000);
		String conformation_message = getElementText(conformationmessage);
		System.out.println("conformation_message:- " + conformation_message);
		Assert.assertTrue(conformation_message.contains("Your application is complete!"));
		test.log(LogStatus.INFO, "<b style=\"color:green;\"> 'Your application is complete!' </b> message verified");
		log.info(" 'Your application is complete!' </b> message verified");
		Thread.sleep(3000);
		infoScreenshot(androidDriver, "'Your application is complete!' in sitecore");
		click(goToDashBoard);
		test.log(LogStatus.INFO, "Clicked on <b style=\"color:green;\"> 'Go to dashboard' </b> button");
		log.info("Clicked on Go to dashboard button ");
		String title = getElementText(OUA_Satus);
		String[] arrSplit = title.split("\\s+");
		OUAID = arrSplit[3];
		System.out.println("OUA id is " + arrSplit[3]);
		test.log(LogStatus.INFO, "OUA id is <b style=\"color:green;\"'> " + OUAID + "' </b> ");
		log.info("OUA id is ' " + OUAID + "' </b> ");
		infoScreenshot(androidDriver, "OUA ID in sitecore");

	}
	public static void openNewTab(String url, int tabNum) {
		((JavascriptExecutor) androidDriver).executeScript("window.open()");
		tabs = new ArrayList<String>(androidDriver.getWindowHandles());
		System.out.println(tabs.size());
		androidDriver.switchTo().window(tabs.get(tabNum));
		androidDriver.navigate().to(url);
		test.log(LogStatus.INFO,"<b style=\"color:black;\">**************** Navigarting to '" + url+ "' ***********************</b>");
		log.info("==================== Navigarting to '" + url + "'  ==========================");
		androidDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

}
