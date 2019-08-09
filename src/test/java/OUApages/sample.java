package OUA_Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import TestBase.AndroidTestBase;
import TestBase.TestBase;
import io.appium.java_client.MobileElement;

public class sample extends TestBase {

	
	private static ArrayList<String> tabs=null;
	private static List<WebElement> frames=null;
	public static String OUAID=null;
	
	
	    // Sitecore Login
		private static By Sitecore_Signin = By.id("hideLogin");
		private static By Sitecore_email = By.id("email");
		private static By Sitecore_password = By.id("password");
		private static By Sitecore_sigin_btn = By.id("_login");

		// sitecore logout
		private static By Sitecore_studentHub = By.xpath("//*[@id='dropdownLoggedIn']/a");
		private static By Sitecore_siginOut = By.xpath("//*[@id='dropdownLoggedIn']/ul/li[7]/a");
	
		// salesforce login
		public static By salesForce_userName = By.id("username");
		public static By salesForce_password = By.id("password");
		public static By salesForce_login = By.id("Login");
				
		//salesforce logout
		public static By logoutImg = By.xpath("//*[@id='oneHeader']/div[2]/span/ul/li[9]/button/div/span[1]/div/span");
		public static By logout = By.xpath("//a[text()='Log Out']");
		
		//Campus login
		public static By Campus_userID = By.id("userid");
		public static By Campus_password = By.id("pwd");
		public static By Campus_signIn = By.xpath("//*[@id='login']/div/div[1]/div[8]/input");
	
		//Campus logOut
		public static By  Campus_hamburgerIcon = By.xpath("//*[@id='win0hdrdivPT_ACTION_MENU']/span/a");
		public static By  Campus_signout = By.xpath("//*[@id='win0hdrdivPT_LOGOUT_MENU']/span/a");
	
	    //subjectEnroll in site core
		private static By searchSubject_txtBox = By.id("searchTxt");
		private static By searchBtn = By.id("searchBtn");
		private static By leadReject = By.id("btn-modalMoreInfo-reject");
		private static By subject_getTxt = By.xpath("//div[@class='banner-content']/h1");
		private static By select_year = By.xpath("//*[@id='2019']/a");
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
	private static By your_information = By.xpath("//div[@class='col-md-8 mainContent']/h1");
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
	public static By CountryOfBirth = By.id("countryOfBirth");
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

	

	// search_Account_Salesforce
	public static By OUA_id = By.xpath("//div[@class='banner-content']/div/span");
	public static By searchUserId = By.xpath("//input[@title='Search Salesforce']");
	public static By AccountName = By
			.xpath("(//*[@id='brandBand_75']//span[@class='slds-grid slds-grid--align-spread']/a)[1]");
	public static By applicationStudent = By.xpath("(//span[contains(@title,'Applications (Student)')])");
	public static By OUA_ApplicationNum = By
			.xpath("//*[@id='brandBand_4']/div/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr/th/span/a");
	public static By stage = By.xpath(
			"//*[@class='test-id__section-content slds-section__content section__content slds-p-top--none']/div/div[3]/div[1]/div/div[2]/span/span");
	public static By stageIcon = By.xpath("//*[@id='edit']");
	//"(//div[@class='slds-form-element__control slds-grid itemBody']/button/lightning-primitive-icon)[11]
	public static By save = By.xpath("//*[@data-aura-class='uiTab']/div/div/div[4]/div/div[2]/div/div/button[2]/span");
	public static By stageDrp = By.xpath("//a[contains(text(),'Submitted')]");
	public static By comments = By.xpath("(//textarea[@class=' textarea'])[1]");
	
	
	
	public static By subName = By.xpath("//div[@class='offerContainer']/div/p[2]");
	public static By acceptoffer_btn = By.xpath("//button[contains(text(),'Accept offer and continue to funding')]");
	public static By youRequest = By.xpath("//*[@id='wrap']/main/div[1]/div/div/section/div/div/div[1]/div[3]/form/div[3]/div[1]/label");
	public static By youUnderstand1 = By.xpath("//*[@id='wrap']/main/div[1]/div/div/section/div/div/div[1]/div[3]/form/div[3]/div[2]/label");
	public static By youDeclare = By.xpath("//*[@id='wrap']/main/div[1]/div/div/section/div/div/div[1]/div[3]/form/div[3]/div[3]/label");
	public static By youUnderstand2 = By.xpath("//*[@id='wrap']/main/div[1]/div/div/section/div/div/div[1]/div[3]/form/div[3]/div[4]/label");
	public static By signature_yes = By.xpath("//*[@id='signature']");
	public static By youAgree = By.xpath("//*[@id='wrap']/main/div[1]/div/div/section/div/div/div[1]/div[3]/form/div[3]/div[6]/label");
	public static By completeenrolment_btn = By.xpath("//button[contains(text(),'Complete enrolment')]");
	public static By returntoStudentHub = By.xpath("//a[contains(text(),'Return to Student Hub')]");
	public static By PaybyHECS_HELP = By.xpath("//a[contains(text(),'Pay by HECS-HELP')]");
	public static By asserts = By.xpath("(//span[contains(text(),'Assets ')])");
	
	
	
	public static By Campus_navigator = By.xpath("//*[@id='PT_NAVBAR']/img");
	public static By ClassicHome = By.id("PTNUI_CHP_ICN$3");
	public static By Campus_Community = By.xpath("//a[text()='Campus Community']");
	public static By Student_Services_Center = By.xpath("//*[@id='crefli_HC_SCC_STDCTR_ADMIN']/a");
	public static By recordsAndEnrollment = By.xpath("//a[text()='Records and Enrollment']");
	public static By enrollStudents = By.id("fldra_HCSR_ENROLL_STUDENT");
	public static By enrollment = By.xpath("//*[@id='crefli_HC_STDNT_ENRL_GBL']/a");
	public static By Campus_SearchOUAID = By.id("STDNT_TERM_SRCH_EMPLID");
	public static By Campus_SearchBtn = By.id("#ICSearch");
	public static By AUS_Student_Enroll = By.xpath("//*[@id='ICTAB_5']/span");
	public static By liability_Status = By.xpath("//*[@id='SSR_STDENRL_AUS_SSR_HECS_XMPT_STAT$0']");
	public static By liability_Status_Description = By.xpath("//*[@id='SSF_HECS_EX_TBL_DESCR$0']");
	public static By EnrollmentSummaries = By.xpath("//a[text()='Enrollment Summaries']");
	public static By EnrollmentSummary = By.xpath("//a[text()='Enrollment Summary']");
	


	public static void student_Enrollment_Provide_TFN_Cross_Institutional() throws Exception {
		
		
		
		
		
		
		
		Thread.sleep(5000);
		
		subjectEnroll("Introduction to Nutrition", "1,169");
		click(addDegree);
		click(core);
		click(health_Pathway);
		Thread.sleep(2000);
		click(logo);
		subjectEnroll("Issues in Contemporary Art", "820");
		selectVisibleText(citizenship_selection, "Australian Citizen");
		click(enrol_subjects);
		registration("enhops", "testing", "enhposAutomationTest02@test.com", "Test1234");
		Thread.sleep(20000);
		click(apply);
		Thread.sleep(2000);
		click(continue_btn);
		youriInformation("Mr","23121991","Male","Full-time employed","0123456789","Enhops Hyderabad","Automation","Australian Capital Territory","1234",
				"Secondary College/High School","2014","Bachelor","Not applicable","Other","Australia","Australian Aboriginal");
		residencystatus();
		siteCoreLogOut();
		
		Thread.sleep(1000);
		openNewTab("https://test.salesforce.com/",1);
		Thread.sleep(10000);
		salesForceLogin("smunnangi@open.edu.au.uat1", "salesforce@123");
		Thread.sleep(10000);
		search_Account_Salesforce(OUAID);
		Thread.sleep(10000);
		salesForceLogOut();
		
		openNewTab("https://www.uat1.env.opendev.edu.au/",2);
		siteCoreLogin("enhposAutomationTest02@test.com", "Test1234");
		Thread.sleep(20000);
		acceptOfferInSiteCore();
		Thread.sleep(10000);
		siteCoreLogOut();
		
		openNewTab("https://test.salesforce.com/",3);
		Thread.sleep(10000);
		salesForceLogin("smunnangi@open.edu.au.uat1", "salesforce@123");
		Thread.sleep(10000);
		searchAsserts(OUAID);
		salesForceLogOut();
				
		openNewTab("https://campus.uat1.env.opendev.edu.au/psp/cs92uat1/?cmd=login&languageCd=ENG&",4);
		CampusLogin("michael.williams", "michael.williams");
		searchOUAID_PeopleSoft("1346182");
		CampusLogOut();
		
		
	}

	public static void siteCoreLogin(String emaill, String passwordd) throws Exception {
		test.log(LogStatus.INFO, "<b style=\"color:green;\">==================== SiteCore Login started ==========================</b>");
		log.info("==================== SiteCore started ==========================");
		click(Sitecore_Signin);
		test.log(LogStatus.INFO, "<b style=\"color:brown;\">'Sign In'</b> button clicked");
		log.info("'Sign In' button clicked");
		sendkeys(Sitecore_email, emaill);
		test.log(LogStatus.INFO, "<b style=\"color:brown;\">'"+emaill+"'</b>  email entered");
		log.info( emaill+" email entered");
		sendkeys(Sitecore_password, passwordd);
		test.log(LogStatus.INFO, "<b style=\"color:brown;\">"+" '***************' "+"</b> password entered");
		log.info( " ********** password entered");
		click(Sitecore_sigin_btn);
		test.log(LogStatus.INFO, "clicked on <b style=\"color:brown;\">'Sign In'</b> button ");
		log.info("clicked on 'Sign In' button");
		test.log(LogStatus.INFO, "<b style=\"color:green;\">==================== SiteCore Login ended ==========================</b>");
		log.info("==================== SiteCore Login ended==========================");
		Thread.sleep(10000);

	}
	public static void siteCoreLogOut() throws Exception {
		test.log(LogStatus.INFO, "<b style=\"color:green;\">==================== SiteCore Logout started ==========================</b>");
		log.info("==================== SiteCore Logout started==========================");
		Thread.sleep(2000);
		click(Sitecore_studentHub);
		click(Sitecore_studentHub);
		test.log(LogStatus.INFO, "Clicked on <b style=\"color:brown;\">'Student Hub'</b>");
		log.info("Clicked on Student Hub");
		Thread.sleep(1000);
		click(Sitecore_siginOut);
		test.log(LogStatus.INFO, "Clicked on <b style=\"color:brown;\"> 'Sign Out' </b> button");
		log.info("Clicked on Sign Out button");
		test.log(LogStatus.INFO, "<b style=\"color:green;\">==================== SiteCore Logout ended==========================</b>");
		log.info("==================== SiteCore Logout ended==========================");
	}
	public static void CampusLogin(String userID, String passwordd) throws Exception {
		test.log(LogStatus.INFO, "<b style=\"color:green;\">==================== Campus Login started ==========================</b>");
		log.info("==================== Campus Login stared==========================");
		sendkeys(Campus_userID, userID);
		test.log(LogStatus.INFO, "<b style=\"color:brown;\">'"+userID+"'</b>  user ID entered");
		log.info( userID+" user ID entered");
		sendkeys(Campus_password, passwordd);
		test.log(LogStatus.INFO, "<b style=\"color:brown;\">"+"' ***************' "+"</b> password entered");
		log.info( " ********** password entered");
		click(Campus_signIn);
		test.log(LogStatus.INFO, "clicked on <b style=\"color:brown;\">'Sign In'</b> button ");
		log.info("clicked on 'Sign In' button");
		test.log(LogStatus.INFO, "<b style=\"color:green;\">==================== Campus Login ended ==========================</b>");
		log.info("==================== Campus Login ended ==========================");
		Thread.sleep(5000);
	}

	
	public static void CampusLogOut() throws Exception {
		test.log(LogStatus.INFO, "<b style=\"color:green;\">==================== Campus Logout started ==========================</b>");
		log.info("==================== Campus Logout stared==========================");
		Thread.sleep(2000);
		click(Campus_hamburgerIcon);
		test.log(LogStatus.INFO, "Clicked on <b style=\"color:brown;\"> 'Hamburger Icon' </b> button");
		log.info("Clicked on Hamburger Icon button");
		Thread.sleep(1000);
		click(Campus_signout);
		test.log(LogStatus.INFO, "Clicked on <b style=\"color:brown;\"> 'Sign Out' </b> button");
		log.info("Clicked on Sign Out button");		
		test.log(LogStatus.INFO, "<b style=\"color:green;\">==================== Campus Logout ended ==========================</b>");
		log.info("==================== Campus Logout ended==========================");
	}
	
   public static void salesForceLogin(String userName, String password) throws Exception {
	   test.log(LogStatus.INFO, "<b style=\"color:green;\">==================== Salesforce Login started ==========================</b>");
		log.info("==================== Salesforce Login started ==========================");
		Thread.sleep(10000);
		sendkeys(salesForce_userName, userName);
		test.log(LogStatus.INFO, "<b style=\"color:brown;\">'"+userName+"'</b>  Username entered");
		log.info( userName+" Username entered");
		sendkeys(salesForce_password, password);
		test.log(LogStatus.INFO, "<b style=\"color:brown;\">"+"' ***************' "+"</b> password entered");
		log.info( " ********** password entered");
		click(salesForce_login);
		test.log(LogStatus.INFO, "Clicked on <b style=\"color:brown;\"> 'Login' </b> button");
		log.info("Clicked on Login button");		
		test.log(LogStatus.INFO, "<b style=\"color:green;\">==================== Salesforce Login ended ==========================</b>");
		log.info("==================== Salesforce Login ended==========================");
		Thread.sleep(10000);
	}

	public static void salesForceLogOut() throws Exception {
		 test.log(LogStatus.INFO, "<b style=\"color:green;\">==================== Salesforce Logout started ==========================</b>");
			log.info("==================== Salesforce Logout started ==========================");
		Thread.sleep(5000);
		click(logoutImg);
		test.log(LogStatus.INFO, "Clicked on <b style=\"color:brown;\"> 'Logout image icon' </b> button");
		log.info("Clicked on Logout image icon button");
		Thread.sleep(1000);
		click(logout);
		test.log(LogStatus.INFO, "Clicked on <b style=\"color:brown;\"> 'Logout' </b> button");
		log.info("Clicked on Logout button");
		test.log(LogStatus.INFO, "<b style=\"color:green;\">==================== Salesforce Logout ended ==========================</b>");
		log.info("==================== Salesforce Logout ended==========================");
	}
	public static void subjectEnroll(String Subject1, String feez) throws Exception {

		sendkeys(searchSubject_txtBox, Subject1);// Introduction to Nutrition
		log.info(Subject1+" subject entered in search box");
		test.log(LogStatus.INFO, "<b style=\"color:brown;\"> '"+Subject1+"'</b> subject entered in search box");
		click(searchBtn);
		test.log(LogStatus.INFO, "Clicked on <b style=\"color:brown;\"> 'search icon' </b>");
		log.info("Clicked on search icon");
		click(By.xpath("//p[contains(text(),'" + Subject1 + "')]"));
		log.info(Subject1+" clicked from the list of subjects");
		test.log(LogStatus.INFO, "<b style=\"color:brown;\"> '"+Subject1+"'</b> clicked from the list of subjects");
		try {
			click(leadReject);
			test.log(LogStatus.INFO, "Clicked on <b style=\"color:brown;\"> 'No Thanks' </b> in lead form");
			log.info("Clicked on No Thanks in lead form");
		} catch (Exception e) {
			e.getMessage();
		}
		Thread.sleep(5000);
		String subject_name = getElementText(subject_getTxt);
		System.out.println(subject_name);		
		log.info("Actual Subject name :- '"+subject_name+"'");
		test.log(LogStatus.INFO, "Actual Subject name :- <b style=\"color:brown;\">'"+Subject1+"'</b>");
		log.info("Expected Subject name :- '"+subject_name+"'");
		test.log(LogStatus.INFO, "Expected Subject name :- <b style=\"color:brown;\">'"+Subject1+"'</b>");
		Assert.assertTrue(subject_name.contains(Subject1));
		test.log(LogStatus.INFO, " Subject name <b style=\"color:brown;\">'"+Subject1+"'</b> matched");		
		click(select_year);
		test.log(LogStatus.INFO, "Clicked on <b style=\"color:brown;\"> '2019' </b> year");
		log.info("Clicked on 2019 year");		
		String fee = getElementText(feee);
		System.out.println(fee);
		log.info("Actual Subject fee :- '"+fee+"'");
		test.log(LogStatus.INFO, "Actual Subject fee :- <b style=\"color:brown;\">'"+fee+"'</b>");
		log.info("Expected Subject fee :- '"+feez+"'");
		test.log(LogStatus.INFO, "Expected Subject fee :- <b style=\"color:brown;\">'"+feez+"'</b>");
		Assert.assertTrue(fee.contains(feez));// 1,169		
		test.log(LogStatus.INFO, " Subject fee <b style=\"color:brown;\">'"+fee+"'</b> matched");			
		click(enroll_btn);
		test.log(LogStatus.INFO, "Clicked on <b style=\"color:brown;\"> 'Enroll' </b> button");
		log.info("Clicked on Enroll button");		
		try {
			click(Continue_without_sign);
			test.log(LogStatus.INFO, "Clicked on <b style=\"color:brown;\"> 'Continue Without Sigin' </b> button");
			log.info("Clicked on Continue Without Sigin button");
		} catch (Exception e4) {
			e4.getMessage();
		}
	}
	
	

	public static void registration(String FirstName, String LastName, String Email, String Password)throws Exception {
		Thread.sleep(3000);
		sendkeys(firstname, FirstName);
		test.log(LogStatus.INFO, "<b style=\"color:brown;\">'"+FirstName+"'</b>  Firstname entered");
		log.info( FirstName+" Firstname entered");
		Thread.sleep(1000);
		sendkeys(lastname, LastName);
		test.log(LogStatus.INFO, "<b style=\"color:brown;\">'"+LastName+"'</b>  Lastname entered");
		log.info( LastName+" Lastname entered");
		Thread.sleep(1000);
		sendkeys(registerEmail, Email);
		test.log(LogStatus.INFO, "<b style=\"color:brown;\">'"+Email+"'</b>  email entered");
		log.info( Email+" email entered");
		Thread.sleep(1000);
		sendkeys(registerPassword, Password);
		test.log(LogStatus.INFO, "<b style=\"color:brown;\">"+"' ***************' "+"</b> password entered");
		log.info( " ********** password entered");
		Thread.sleep(1000);
		sendkeys(confirmpassword, Password);
		test.log(LogStatus.INFO, "<b style=\"color:brown;\">"+"' ***************' "+"</b> Confirm password entered");
		log.info( " ********** Confirm password entered");
		Thread.sleep(4000);
		click(register_btn);
		test.log(LogStatus.INFO, "Clicked on <b style=\"color:brown;\"> 'Register' </b> button");
		log.info("Clicked on Register button");	
		Thread.sleep(3000);

	}
	/*youriInformation("Mr","23121991","Male","Full-time employed","0123456789","Enhops Hyderabad","Automation","Australian Capital Territory","1234",
			"Secondary College/High School","2014","Bachelor","Not applicable","Other","Australia","Australian Aboriginal");*/
	public static void youriInformation(String Selecttitle, String Dateofbirth, String Gender, String employmentStatus, String mobileNumber,
			String StreetAdress,String subrubStreet,String State,String Postcode,String secondaryeducation,String yearOfcomplete,String HighestLeveofEducation,
			String HighestLevelofeducationParent,String ReasonForTakingSubject,String counrty,String AustralianAboriginalOrTorresStraitIslanderdescent) throws InterruptedException {
		//Personal information
		 test.log(LogStatus.INFO, "<b style=\"color:green;\">==================== Personal Information ==========================</b>");
			log.info("==================== Personal Information ==========================");
		selectVisibleText(selecttitle, Selecttitle);
		test.log(LogStatus.INFO, "<b style=\"color:brown;\">'"+Selecttitle+"'</b>  title selected");
		log.info( Selecttitle+"  title selected");
		Thread.sleep(1000);
		sendkeys(dateofbirth, Dateofbirth);
		test.log(LogStatus.INFO, "<b style=\"color:brown;\">'"+Dateofbirth+"'</b>  Dateofbirth entered");
		log.info( Dateofbirth+"  Dateofbirth entered");
		Thread.sleep(1000);
		click(By.xpath("//label[contains(text(),'"+Gender+"')]"));
		test.log(LogStatus.INFO, "<b style=\"color:brown;\">'"+Gender+"'</b>  gender selected");
		log.info( Gender+"  gender selected");
		Thread.sleep(1000);
		selectVisibleText(EmploymentStatus,employmentStatus );
		test.log(LogStatus.INFO, "<b style=\"color:brown;\">'"+employmentStatus+"'</b>  employment status selected");
		log.info( employmentStatus+"  employment status selected");
		Thread.sleep(1000);
		click(Save);
		test.log(LogStatus.INFO, "Clicked on <b style=\"color:brown;\"> 'SAVE AND CONTINUE' </b> button");
		log.info("Clicked on SAVE AND CONTINUE button");			
		Thread.sleep(3000);
		//Contact details
		 test.log(LogStatus.INFO, "<b style=\"color:green;\">==================== Contact Details ==========================</b>");
			log.info("==================== Contact Details ==========================");
		sendkeys(MobileNumber, mobileNumber);
		test.log(LogStatus.INFO, "<b style=\"color:brown;\">'"+mobileNumber+"'</b>  mobile number entered");
		log.info( mobileNumber+"  mobileNumber entered");
		Thread.sleep(1000);
		sendkeys(streetAdress, StreetAdress);
		test.log(LogStatus.INFO, "<b style=\"color:brown;\">'"+StreetAdress+"'</b>  street address entered");
		log.info( StreetAdress+"  StreetAdress entered");
		Thread.sleep(1000);
		sendkeys(SubrubStreet, subrubStreet);
		test.log(LogStatus.INFO, "<b style=\"color:brown;\">'"+subrubStreet+"'</b>  Suburb entered");
		log.info( subrubStreet+"  Suburb entered");
		Thread.sleep(1000);
		selectVisibleText(state,State );
		test.log(LogStatus.INFO, "<b style=\"color:brown;\">'"+State+"'</b>  state entered");
		log.info( State+"  state entered");
		Thread.sleep(1000);
		sendkeys(statecode, Postcode);
		test.log(LogStatus.INFO, "<b style=\"color:brown;\">'"+Postcode+"'</b>  Postcode entered");
		log.info( Postcode+"  Postcode entered");
		Thread.sleep(1000);
		click(Contactsave);
		test.log(LogStatus.INFO, "Clicked on <b style=\"color:brown;\"> 'SAVE AND CONTINUE' </b> button");
		log.info("Clicked on SAVE AND CONTINUE button");			
		Thread.sleep(3000);	
		//Residential address
		 test.log(LogStatus.INFO, "<b style=\"color:green;\">==================== Residential Address ==========================</b>");
			log.info("==================== Residential Address ==========================");
		click(postal_address);
		test.log(LogStatus.INFO, "Select <b style=\"color:brown;\"> 'Same as postal address' </b> check box");
		log.info("Select 'Same as postal address'  check box");
		Thread.sleep(1000);
		click(ResidentAdressSave);
		test.log(LogStatus.INFO, "Clicked on <b style=\"color:brown;\"> 'SAVE AND CONTINUE' </b> button");
		log.info("Clicked on SAVE AND CONTINUE button");
		Thread.sleep(3000);
		//Education history
		 test.log(LogStatus.INFO, "<b style=\"color:green;\">==================== Education History ==========================</b>");
			log.info("==================== Education History ==========================");
		selectVisibleText(Education, secondaryeducation);
		test.log(LogStatus.INFO, "<b style=\"color:brown;\">'"+secondaryeducation+"'</b>  final year of secondary education selected");
		log.info( secondaryeducation+"  final year of secondary education selected");
		Thread.sleep(1000);
		selectVisibleText(yearofcomplete, yearOfcomplete);
		test.log(LogStatus.INFO, "<b style=\"color:brown;\">'"+yearOfcomplete+"'</b>  year of completion selected");
		log.info( yearOfcomplete+"  year of completion selected");
		Thread.sleep(1000);
		click(postgraduate);
		test.log(LogStatus.INFO, "Have you commenced and/or completed a postgraduate level course? - <b style=\"color:brown;\">'Never commenced' </b>");
		log.info("Have you commenced and/or completed a postgraduate level course? - 'Never commenced'");
		click(bachelor_level);
		Thread.sleep(1000);
		test.log(LogStatus.INFO, "Have you commenced and/or completed a bachelor level course (such as a bachelor's degree)? - <b style=\"color:brown;\">'Never commenced' </b>");
		log.info("Have you commenced and/or completed a bachelor level course (such as a bachelor's degree)?- 'Never commenced'");		
		click(subdegree_level);
		Thread.sleep(1000);
		test.log(LogStatus.INFO, "Have you commenced and/or completed a sub-degree level course (such as an associate degree)? - <b style=\"color:brown;\">'Never commenced' </b>");
		log.info("Have you commenced and/or completed a sub-degree level course (such as an associate degree)? - 'Never commenced'");	
		click(subdegreeVET);
		Thread.sleep(1000);
		test.log(LogStatus.INFO, "Have you commenced and/or completed a sub-degree VET (ie at TAFE) level course (such as a diploma)? - <b style=\"color:brown;\">'Never commenced' </b>");
		log.info("Have you commenced and/or completed a sub-degree VET (ie at TAFE) level course (such as a diploma)? - 'Never commenced'");		
		click(VET_award_level_course);
		Thread.sleep(1000);
		test.log(LogStatus.INFO, "Have you commenced and/or completed a VET award level course (such as Certificate III or IV)? - <b style=\"color:brown;\">'Never commenced' </b>");
		log.info("Have you commenced and/or completed a VET award level course (such as Certificate III or IV)? - 'Never commenced'");		
		click(other_qualification);
		Thread.sleep(1000);
		test.log(LogStatus.INFO, "Have you completed any other qualification (such as a Certificate of Attainment or Certificate of Competence)? - <b style=\"color:brown;\">'Never commenced' </b>");
		log.info("Have you completed any other qualification (such as a Certificate of Attainment or Certificate of Competence)? - 'Never commenced'");
		Thread.sleep(1000);
		selectVisibleText(HighestLeveofeducation, HighestLeveofEducation);
		test.log(LogStatus.INFO, "Highest level of education completed by any of your parents or guardians? - <b style=\"color:brown;\">'"+HighestLeveofEducation +"' </b>");
		log.info("What is the highest level of education completed by any of your parents or guardians? - '"+HighestLeveofEducation+"'");		
		Thread.sleep(1000);
		selectVisibleText(HighestLeveofeducationParent,HighestLevelofeducationParent );
		test.log(LogStatus.INFO, "Highest level of education completed by your other parent or guardian? - <b style=\"color:brown;\">'"+HighestLevelofeducationParent +"' </b>");
		log.info("What is the highest level of education completed by your other parent or guardian? - '"+HighestLevelofeducationParent+"'");			
		Thread.sleep(1000);
		selectVisibleText(ReasonFortakingSubject,ReasonForTakingSubject );
		test.log(LogStatus.INFO, "Reason for undertaking this degree or subject? - <b style=\"color:brown;\">'"+ReasonForTakingSubject +"' </b>");
		log.info("Reason for undertaking this degree or subject? - '"+ReasonForTakingSubject+"'");			
		Thread.sleep(1000);
		click(Saveandcontinue);
		test.log(LogStatus.INFO, "Clicked on <b style=\"color:brown;\"> 'SAVE AND CONTINUE' </b> button");
		log.info("Clicked on SAVE AND CONTINUE button");
		Thread.sleep(3000);
		//Residence, origin and ethnicity
		test.log(LogStatus.INFO, "<b style=\"color:green;\">==================== Residence, origin and ethnicity ==========================</b>");
		log.info("==================== Residence, origin and ethnicity ==========================");		
		click(PermanentHomeResident);
		test.log(LogStatus.INFO, "Select permanent home residence:- <b style=\"color:brown;\"> 'Same as residential address' </b> ");
		log.info("Select permanent home residence:- Same as residential address");
		Thread.sleep(1000);	
		click(PermanentHomeResidence);
		test.log(LogStatus.INFO, "Select <b style=\"color:brown;\"> 'Same as residential address' </b> for reside while studying with Open Universities Australia? ");
		log.info("Select 'Same as residential address'for reside while studying with Open Universities Australia? ");
		Thread.sleep(1000);
		click(CountryOfBirth);
		Thread.sleep(2000);
		actionsclick(Counrty, counrty);
		test.log(LogStatus.INFO, "Select <b style=\"color:brown;\"'>" +counrty+ "'</b> as Country of birth");
		log.info("Select " +counrty+ " as Country of birth");
		Thread.sleep(2000);
		selectVisibleText(AreyouofAustralianAboriginal,AustralianAboriginalOrTorresStraitIslanderdescent );
		test.log(LogStatus.INFO, "Select <b style=\"color:brown;\"'>" +AustralianAboriginalOrTorresStraitIslanderdescent+ "'</b> as Australian Aboriginal or Torres Strait Islander descent");
		log.info("Select " +AustralianAboriginalOrTorresStraitIslanderdescent+ "' as Australian Aboriginal or Torres Strait Islander descent");	
		Thread.sleep(1000);
		click(SaveResidentAddress);
		test.log(LogStatus.INFO, "Clicked on <b style=\"color:brown;\"> 'SAVE AND CONTINUE' </b> button");
		log.info("Clicked on SAVE AND CONTINUE button");
		Thread.sleep(4000);
		
		click(SpecialNeeds);
		Thread.sleep(3000);
		click(SaveSpecialNeeds);
		Thread.sleep(3000);
		click(ContinueToPayment);
		Thread.sleep(5000);
		click(undergraduateinformation_continue_btn);
		Thread.sleep(3000);

	}

	public static void residencystatus() throws InterruptedException, AWTException {
		String Residencystatus_txt = getElementText(Residencystatus);
		System.out.println(Residencystatus_txt);
		List<WebElement> noOfSub = driver.findElements(By.xpath("//div[@data-testid='subject-summary-item']"));
		for (int i = 1; i <= noOfSub.size(); i++) {
			String SubjectName = driver
					.findElement(By
							.xpath("//div[@class='cart-summary-subjects cart-selected-subjects']/div[" + i + "]/p[3]"))
					.getText();
			String SubjectPrice = driver
					.findElement(By
							.xpath("//div[@class='cart-summary-subjects cart-selected-subjects']/div[" + i + "]/p[1]"))
					.getText();
			System.out.println("SubjectName:- " + SubjectName + ", SubjectPrice:- " + SubjectPrice);
		}

		String totalCost = getElementText(totalcost);
		System.out.println("totalCost:- " + totalCost);
		Thread.sleep(10000);
		click(you_live_in_Australia);
		Thread.sleep(3000);
		click(save_continue1);
		Thread.sleep(3000);
		click(Entryrequirements);
		Thread.sleep(3000);
	
		// sendkeys(personalStatement, "./test-output/bullet_point.png");
		click(fileUpload);
		Thread.sleep(3000);
		uploadFileUsingRobot("E:/surya automation/TestProject/test-output/bullet_point.png");
		Thread.sleep(3000);
		click(save_continue2);
		Thread.sleep(3000);
		click(Isyourpresentnamedifferent);
		Thread.sleep(3000);
		click(save_continue3);
		Thread.sleep(3000);
		click(previousdegreesorsubjectsinEnglish);
		Thread.sleep(3000);
		click(save_continue4);
		Thread.sleep(3000);
		click(continuee);
		Thread.sleep(3000);
		click(HECS_HELPloan);
		Thread.sleep(3000);
		click(Checkyoureligibility);
		Thread.sleep(3000);
		click(save_continue5);
		Thread.sleep(3000);
		click(TaxFileNumber_yes);
		Thread.sleep(3000);
		sendkeys(TaxFileNumber, "224553346");
		Thread.sleep(3000);
		click(save_continue6);
		Thread.sleep(3000);
		click(SubmittoConfirm);
		Thread.sleep(3000);
		String conformation_message = getElementText(conformationmessage);
		System.out.println("totalCost:- " + conformation_message);
		Thread.sleep(3000);
		click(goToDashBoard);
		
		String title= getElementText(OUA_Satus);
        String[] arrSplit = title.split("\\s+");
        OUAID = arrSplit[3];
        System.out.println("OUA id is "+ arrSplit[3]);



	}
	
	public static void openNewTab(String url, int tabNum){
		((JavascriptExecutor)driver).executeScript("window.open()");
		// driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
		  tabs = new ArrayList<String> (driver.getWindowHandles());
		 System.out.println(tabs.size());
		 driver.switchTo().window(tabs.get(tabNum));
		   // driver.navigate().to("https://test.salesforce.com/");
		// driver.navigate().to("https://www.uat1.env.opendev.edu.au/");
		 driver.navigate().to(url);
	}
	

	

	public static void search_Account_Salesforce(String OUA_ID) throws Exception {
		Thread.sleep(5000);
		List<WebElement> noOfTabs =driver.findElements(By.xpath("//*[@id='oneHeader']/div[3]/div/div[2]/div/div/ul[2]/li"));
		System.out.println("noOfTabs.size() "+noOfTabs.size());
		
		if(noOfTabs.size()==0){
			System.out.println("no tabls open");
		}else{
			for(int i=0;i<noOfTabs.size()-1;i++){
				Thread.sleep(2000);
				System.out.println("inside for loop"+i);
				click(By.xpath("//*[@id='oneHeader']/div[3]/div/div[2]/div/div/ul[2]/li[2]/div[2]/button/lightning-primitive-icon"));
			}
		}
					
		
		Thread.sleep(5000);
		
		actionsclickk(searchUserId, OUA_ID);
		Thread.sleep(10000);
		String AccountNamee=getElementText(By.xpath("//*[@data-aura-class='forceBrandBand']/div/div/div[2]/div/div/div/div/div/div[1]/div[1]/div[2]/div/div/div/div[2]/div[2]/div[1]/div/div/table/tbody/tr/th/span/a"));
		Thread.sleep(1000);
		String ouaID=getElementText(By.xpath("//*[@data-aura-class='forceBrandBand']/div/div/div[2]/div/div/div/div/div/div[1]/div[1]/div[2]/div/div/div/div[2]/div[2]/div[1]/div/div/table/tbody/tr/td[2]/span/span"));
		Thread.sleep(1000);
		String Dob=getElementText(By.xpath("//*[@data-aura-class='forceBrandBand']/div/div/div[2]/div/div/div/div/div/div[1]/div[1]/div[2]/div/div/div/div[2]/div[2]/div[1]/div/div/table/tbody/tr/td[4]/span/span"));
		Thread.sleep(1000);
		String mobile=getElementText(By.xpath("//*[@data-aura-class='forceBrandBand']/div/div/div[2]/div/div/div/div/div/div[1]/div[1]/div[2]/div/div/div/div[2]/div[2]/div[1]/div/div/table/tbody/tr/td[5]/span/span"));
		Thread.sleep(1000);
		String Email=getElementText(By.xpath("//*[@data-aura-class='forceBrandBand']/div/div/div[2]/div/div/div/div/div/div[1]/div[1]/div[2]/div/div/div/div[2]/div[2]/div[1]/div/div/table/tbody/tr/td[6]/span/span"));
		Thread.sleep(1000);
		String AccountType=getElementText(By.xpath("//*[@data-aura-class='forceBrandBand']/div/div/div[2]/div/div/div/div/div/div[1]/div[1]/div[2]/div/div/div/div[2]/div[2]/div[1]/div/div/table/tbody/tr/td[7]/span/span"));
		Thread.sleep(1000);
		System.out.println("AccountNamee"+AccountNamee);
		System.out.println("ouaID"+ouaID);
		System.out.println("Dob"+Dob);
		System.out.println("mobile"+mobile);
		System.out.println("Email"+Email);
		System.out.println("AccountType"+AccountType);
		Thread.sleep(1000);
		//account name
		click(By.xpath("//*[@data-aura-class='forceBrandBand']/div/div/div[2]/div/div/div/div/div/div[1]/div[1]/div[2]/div/div/div/div[2]/div[2]/div[1]/div/div/table/tbody/tr/th/span/a"));
		Thread.sleep(10000);
		click(applicationStudent);
		Thread.sleep(3000);
		//appication num
		click(By.xpath("//*[@data-aura-class='forceBrandBand']/div/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr/th/span/a"));
		Thread.sleep(3000);
		String stage_status1=getElementText(stage);
		Thread.sleep(3000);
		System.out.println("stage_status"+stage_status1);
		Actions action = new Actions(driver);
		//stage dropdown
		action.moveToElement(driver.findElement(By.xpath("//*[@class='test-id__section-content slds-section__content section__content slds-p-top--none']/div/div[3]/div[1]/div/div[2]/span/span"))).doubleClick().perform();
		Thread.sleep(10000);
		//stage drp
		/* WebElement button =driver.findElement(By.xpath("(//div[@data-aura-class='uiMenu']/div[1]/div/div/a)[12]"));
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("arguments[0].click();", button);*/
		//click(By.xpath("(//div[@data-aura-class='uiMenu']/div[1]/div/div/a)[12]"));
		 click(By.xpath("(//a[text()='"+stage_status1+"'])[1]"));
		Thread.sleep(3000);
		click(By.xpath("//a[text()='Offered']"));
		Thread.sleep(3000);
		sendkeys(comments, "testing");
		Thread.sleep(3000);
		click(save);
		String stage_status2=getElementText(stage);
		Thread.sleep(3000);
		System.out.println("stage_status"+stage_status2);
	
		
	}
	private static void sendkeys(Keys enter) {
		// TODO Auto-generated method stub
		
	}

	public static void acceptOfferInSiteCore() throws Exception{
		
		
		Thread.sleep(3000);
		String subjectName=getElementText(subName);		
		System.out.println("stage_status"+subjectName);
		Thread.sleep(3000);
		click(acceptoffer_btn);
		Thread.sleep(3000);
		click(youRequest);
		Thread.sleep(3000);
		click(youUnderstand1);
		Thread.sleep(3000);
		click(youDeclare);
		Thread.sleep(3000);
		click(youUnderstand2);
		Thread.sleep(3000);
		sendkeys(signature_yes, "yes");
		Thread.sleep(3000);
		click(youAgree);
		Thread.sleep(3000);
		click(completeenrolment_btn);
		Thread.sleep(3000);
		click(returntoStudentHub);
		Thread.sleep(20000);
		click(PaybyHECS_HELP);
		Thread.sleep(3000);
		click(youRequest);
		Thread.sleep(3000);
		click(youUnderstand1);
		Thread.sleep(3000);
		click(youDeclare);
		Thread.sleep(3000);
		click(youUnderstand2);
		Thread.sleep(3000);
		sendkeys(signature_yes, "yes");
		Thread.sleep(3000);
		click(youAgree);
		Thread.sleep(3000);
		click(completeenrolment_btn);
		Thread.sleep(3000);
		click(returntoStudentHub);
		Thread.sleep(20000);
			
		List<WebElement> noOfSubjects=driver.findElements(By.xpath("//div[@class='cards-container']/div"));
		
		for (int i = 1; i <=noOfSubjects.size(); i++) {
			String SubjectName = driver.findElement(By.xpath("(//*[@class='card-content']/p[2])["+i+"]")).getText();
			String Status = driver.findElement(By.xpath("(//div[@class='card-footer']/div[1]/span)["+i+"]")).getText();
			System.out.println("SubjectName:- " + SubjectName + ", Status:- " + Status);
		}
			
	}
	public static void uploadFileUsingRobot(String filePath) throws AWTException, InterruptedException {
		StringSelection s=new StringSelection(filePath);
		    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s,null);
		    Robot r=new Robot();
		    r.keyPress(KeyEvent.VK_CONTROL);
		    r.keyPress(KeyEvent.VK_V);
		    r.keyRelease(KeyEvent.VK_V);
		    r.keyRelease(KeyEvent.VK_CONTROL);
		    Thread.sleep(5000);
		    r.keyPress(KeyEvent.VK_ENTER);
		    r.keyRelease(KeyEvent.VK_ENTER);
		  
		    
		}

	
	public static void searchAsserts(String OUA_ID) throws Exception{
		Thread.sleep(10000);
		List<WebElement> noOfTabs =driver.findElements(By.xpath("//*[@id='oneHeader']/div[3]/div/div[2]/div/div/ul[2]/li"));
		System.out.println("noOfTabs.size() "+noOfTabs.size());
		
		if(noOfTabs.size()==0){
			System.out.println("no tabls open");
		}else{
			for(int i=0;i<noOfTabs.size()-1;i++){
				Thread.sleep(2000);
				System.out.println("inside for loop"+i);
				click(By.xpath("//*[@id='oneHeader']/div[3]/div/div[2]/div/div/ul[2]/li[2]/div[2]/button/lightning-primitive-icon"));
			}
		}
		Thread.sleep(3000);
		actionsclickk(searchUserId, OUA_ID);
		
		//account name
		click(By.xpath("//*[@data-aura-class='forceBrandBand']/div/div/div[2]/div/div/div/div/div/div[1]/div[1]/div[2]/div/div/div/div[2]/div[2]/div[1]/div/div/table/tbody/tr/th/span/a"));
		
		Thread.sleep(10000);
		click(asserts);
		Thread.sleep(10000);
		//itemList=(//p[@class='slds-text-body--small']/force-list-view-manager-status-info/div/span[1])[1]
		List<WebElement> list=driver.findElements(By.xpath("//*[@data-aura-class='forceBrandBand']/div/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr"));
				for (int i = 1; i <=list.size(); i++) {
		String AssetName = driver.findElement(By.xpath("//*[@data-aura-class='forceBrandBand']/div/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr["+i+"]/th/span")).getText();
		String University = driver.findElement(By.xpath("//*[@data-aura-class='forceBrandBand']/div/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr["+i+"]/td[2]/span")).getText();
		String Degree_Subject = driver.findElement(By.xpath("//*[@data-aura-class='forceBrandBand']/div/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr["+i+"]/td[3]/span/span/a")).getText();
		String status = driver.findElement(By.xpath("//*[@data-aura-class='forceBrandBand']/div/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr["+i+"]/td[4]/span/span")).getText();
		System.out.println("AssetName:- "+AssetName+", University:- "+University+", Degree/Subject:- "+Degree_Subject+", status:- "+status);
		
				}
				
				click(By.xpath("//*[@data-aura-class='forceBrandBand']/div/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr[1]/th/span"));		
				
						String integrationStatus = getElementText(By.xpath("(//*[@class='test-id__section-content slds-section__content section__content']/div/div[1]/div[1]/div/div[2]/span/span)[19]"));
						System.out.println("IntegrationStatus:- " + integrationStatus);
						Thread.sleep(3000);
		
	}
	public static void searchOUAID_PeopleSoft(String OUA_ID) throws Exception{
		Thread.sleep(3000);	
		click(Campus_navigator);
		Thread.sleep(10000);
		frames =driver.findElements(By.tagName("iframe"));
		System.out.println("frames.size()"+frames.size());
		driver.switchTo().frame(frames.get(0));
		actionsclick(ClassicHome);
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		click(recordsAndEnrollment);
		Thread.sleep(3000);
		click(enrollStudents);
		Thread.sleep(3000);
		click(enrollment);
		Thread.sleep(3000);
		System.out.println("frames.size()"+frames.size());
		
		Thread.sleep(3000);
	//	driver.switchTo().frame(frames.get(0));
		driver.switchTo().frame("ptifrmtgtframe");
		
		System.out.println("njhjcbn");
		System.out.println(driver.findElement(By.xpath("//*[@id='app_label']")).getText());
		clear(Campus_SearchOUAID);
		sendkeys(Campus_SearchOUAID, OUA_ID);
		Thread.sleep(3000);
		click(Campus_SearchBtn);
		Thread.sleep(3000);
		click(AUS_Student_Enroll);
		Thread.sleep(3000);
		String Liability_Status = driver.findElement(By.xpath("//*[@id='SSR_STDENRL_AUS_SSR_HECS_XMPT_STAT$0']")).getAttribute("value");
		System.out.println("Liability_Status:-"+Liability_Status);		
		String Liability_Status_Description = getElementText(liability_Status_Description);
		System.out.println("Liability_Status:-"+Liability_Status_Description);
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		click(recordsAndEnrollment);
		Thread.sleep(3000);
	
		click(EnrollmentSummaries);
		Thread.sleep(3000);
		click(EnrollmentSummary);
		Thread.sleep(3000);
		driver.switchTo().frame("ptifrmtgtframe");
		Thread.sleep(3000);
		//table[@id="ACE_$ICField21$0"]/tbody/tr[2]/td[2] 11
		//table[@id="ACE_$ICField21$0"]/tbody/tr[3]/td[2] 12
		//table[@id="ACE_$ICField21$0"]/tbody/tr[6]/td[2] 11
		for (int i = 2; i <=11; i++) {
			String SubjectName = driver.findElement(By.xpath("//table[@id='ACE_$ICField21$0']/tbody/tr[2]/td["+i+"]")).getText();			
			System.out.print(" " + SubjectName + " | ");
		}
		System.out.println("");
		String Status1 = driver.findElement(By.xpath("//table[@id='ACE_$ICField21$0']/tbody/tr[3]/td[2]")).getText();
		System.out.print(" " + Status1 + " | ");
		for (int i = 4; i <=12; i++) {			
			String Status = driver.findElement(By.xpath("//table[@id='ACE_$ICField21$0']/tbody/tr[3]/td["+i+"]")).getText();
			System.out.print(" " + Status + " | ");
		}
		System.out.println("");
		for (int i = 2; i <=11; i++) {
			String Statuss = driver.findElement(By.xpath("//table[@id='ACE_$ICField21$0']/tbody/tr[6]/td["+i+"]")).getText();
			System.out.print(" " + Statuss + " | ");
		}
	}
	
	
	
	

}
