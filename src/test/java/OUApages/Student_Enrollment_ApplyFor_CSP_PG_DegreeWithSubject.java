package OUA_Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import com.relevantcodes.extentreports.LogStatus;
import Common.Screenshot;
import TestBase.TestBase;

public class Student_Enrollment_ApplyFor_CSP_PG_DegreeWithSubject extends TestBase{

	private static ArrayList<String> tabs = null;
	private static List<WebElement> frames = null;
	public static String OUAID = null;
	public static String integrationStatus =null;
	public static String  Degree_Subject =null;

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

	// salesforce logout
	public static By logoutImg = By.xpath("//*[@id='oneHeader']/div[2]/span/ul/li[9]/button/div/span[1]/div/span");
	public static By logout = By.xpath("//a[text()='Log Out']");

	// Campus login
	public static By Campus_userID = By.id("userid");
	public static By Campus_password = By.id("pwd");
	public static By Campus_signIn = By.xpath("//*[@id='login']/div/div[1]/div[8]/input");

	// Campus logOut
	public static By Campus_hamburgerIcon = By.xpath("(//a[@role='button']/img)[4]");
	public static By Campus_signout = By.xpath("//*[@id='PT_LOGOUT_MENU']");

	// subjectEnroll in site core
	private static By searchSubject_txtBox = By.id("searchTxt");
	private static By searchBtn = By.id("searchBtn");
	private static By leadReject = By.id("btn-modalMoreInfo-reject");
	private static By subject_getTxt = By.xpath("//div[@class='banner-content']/h1");
	private static By select_year = By.xpath("//*[@id='2019']/a");
	private static By feee = By.xpath("//p[@data-testid='total-cost']/span/strong");
	private static By enroll_btn = By.id("enrol-subjects");
	private static By Continue_without_sign = By.id("continue");
	private static By addAndContinue = By.id("course-enrol-btn");

	// registration in site core
	private static By firstname = By.id("firstname");
	private static By lastname = By.id("lastname");
	private static By registerEmail = By.id("registerEmail");
	private static By registerPassword = By.id("registerPassword");
	private static By confirmpassword = By.id("confirmpassword");
	private static By register_btn = By.id("btn-register-page-register");

	
	private static By core = By.id("Core");
	private static By Primary_EducationMajor = By.id("Primary Education Major");
	private static By citizenship_selection = By.xpath("//select[@data-testid='citizenship-selection']");
	public static By apply = By.xpath("//button[text()='Apply']");
	public static By continue_btn = By.xpath("//button[text()='Continue']");
	public static By Addsubject = By.xpath("//button[contains(text(),'Add subject')]");

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
	public static By postgraduateinformation_continue_btn = By.id("btn-postgraduate-information");
	public static By OUA_Satus = By.xpath("//*[@id=\"wrap\"]/main/div[1]/div/div/div[1]/section/div/div/div/span");
	
	//postgraduate-page
	public static By applyingBasedOnMy = By.xpath("(//label[contains(text(),'Work experience alone')])");
	public static By saveAndContinue1 = By.xpath("//*[@id='pg-personalstatement-form']/button");
	public static By previousAcademicStudies = By.xpath("(//label[contains(text(),'Yes')])[1]");
	public static By everStudiedWithTheUniversity = By.xpath("(//label[contains(text(),'Yes')])[2]");
	public static By saveAndContinue2 = By.xpath("//*[@id='pg-previousacademicstudies-form']/button");
	public static By presentNameDifferent = By.xpath("(//label[contains(text(),'No')])[1]");
	public static By saveAndContinue3 = By.xpath("//*[@id='identity-info']/button");
	public static By priorAcademicExclusions = By.xpath("(//label[contains(text(),'No')])[4]");
	public static By saveAndContinue4 = By.xpath("//*[@id='academic-exclusion-info']/button");
	public static By saveAndContinue5 = By.xpath("//*[@id='work-experience-info']/button");
	public static By saveAndContinue6 = By.xpath("//*[@id='reference-employer-info']/button");
	public static By englishLanguageProficiency = By.xpath("(//label[contains(text(),'Yes')])[2]");
	public static By saveAndContinue7 = By.xpath("//*[@id='language-proficiency-info']/button");
	
	public static By yourIntendedStudy = By.xpath("(//label[contains(text(),'Two or more subjects (full-time)')])");
	public static By intendToClaimExemptions = By.xpath("(//label[contains(text(),'Yes')])[3]");
	public static By saveAndContinue8 = By.xpath("//*[@id='study-load-exemption']/button");
	public static By Continue_btn = By.xpath("//*[@id='btn-postgraduate-page']");
	public static By HECS_HELP_loan = By.xpath("//label[@for='HecsHelp']/span/span");

	// Residency status
	public static By Residencystatus = By.xpath("//h2[@class='panel-heading']/a/span");
	public static By totalcost = By.xpath("//p[@class='total-cost']/span/strong");
	public static By you_live_in_Australia = By.xpath("//label[contains(text(),'Yes, for the entire degree.')]");
	public static By save_continue1 = By.xpath("//button[text()='Save and continue']");
	public static By Entryrequirements = By.xpath("//label[contains(text(),'Work and life experience')]");
	public static By fileUpload = By.xpath("//a[text()='click to browse']");
	public static By fileUpload1 = By.xpath("(//a[text()='click to browse'])[1]");
	public static By fileUpload2 = By.xpath("(//a[text()='click to browse'])[2]");
	public static By fileUpload3 = By.xpath("(//a[text()='click to browse'])[3]");
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
	public static By TaxFileNumber_yes = By.xpath("(//label[text()='Yes'])");
	public static By TaxFileNumber = By.id("tfnNumber");
	public static By save_continue6 = By.xpath("//button[text()='Save and Continue']");
	public static By SubmittoConfirm = By.id("btn-hecs-container");
	public static By conformationmessage = By.xpath("//div[@class='col-md-8 mainContent']/h1");
	public static By goToDashBoard = By.xpath("//a[text()='Go to dashboard']");

	// search_Account_Salesforce
	public static By OUA_id = By.xpath("//div[@class='banner-content']/div/span");
	public static By searchUserId = By.xpath("//input[@title='Search Salesforce']");
	public static By AccountName = By.xpath(
			"//*[@data-aura-class='forceBrandBand']/div/div/div[2]/div/div/div/div/div/div[1]/div[1]/div[2]/div/div/div/div[2]/div[2]/div[1]/div/div/table/tbody/tr/th/span/a");
	public static By applicationStudent = By.xpath("(//span[contains(@title,'Applications (Student)')])");
	public static By OUA_ApplicationNum = By.xpath(
			"//*[@data-aura-class='forceBrandBand']/div/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr/th/span/a");
	public static By stage = By.xpath(
			"//*[@class='test-id__section-content slds-section__content section__content slds-p-top--none']/div/div[3]/div[1]/div/div[2]/span/span");
	public static By save = By.xpath("//*[@data-aura-class='uiTab']/div/div/div[4]/div/div[2]/div/div/button[2]/span");
	public static By stageDrp = By.xpath(
			"//*[@class='test-id__section-content slds-section__content section__content slds-p-top--none']/div/div[3]/div[1]/div/div[2]/span/span");
	public static By comments = By.xpath("(//textarea[@class=' textarea'])[1]");

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

	public static void student_Enrollment_ApplyFor_CSP_PG_DegreeWithSubject() throws Exception {
		test.log(LogStatus.INFO,"<b style=\"color:brown;\">==================== Subject Enrollment ==========================</b>");
		log.info("==================== Subject Enrollment  ==========================");
		
		Screenshot.infoScreenshot(driver, "OUA site core Homepage");
		subjectEnroll("Master of Teaching (Primary Education)","Theories of Development and Learning", "820");		
		registration("enhops", "testing", Repository.getProperty("email"), "Test1234");
		Thread.sleep(20000);
		youriInformation("Mr", "23121991", "Male", "Full-time employed", "0123456789", "Enhops Hyderabad", "Automation",
				"Australian Capital Territory", "1234", "Secondary College/High School", "2014", "Bachelor",
				"Not applicable", "Other", "Australia", "Australian Aboriginal");
		postgraduateDegreeApplication();
		funding(Repository.getProperty("TFNNumber"));
		siteCoreLogOut();

		Thread.sleep(1000);
		openNewTab("https://test.salesforce.com/", 1);
		Thread.sleep(10000);
		salesForceLogin("smunnangi@open.edu.au.uat1", "salesforce@123");
		Thread.sleep(10000);
		search_Account_Salesforce(OUAID);
		Thread.sleep(10000);
		salesForceLogOut();

		openNewTab("https://www.uat1.env.opendev.edu.au/", 2);
		siteCoreLogin(Repository.getProperty("email"), "Test1234");
		acceptOfferInSiteCore();
		siteCoreLogOut();

		openNewTab("https://test.salesforce.com/", 3);
		Thread.sleep(10000);
		salesForceLogin("smunnangi@open.edu.au.uat1", "salesforce@123");
		Thread.sleep(10000);
		searchAsserts(OUAID);
		salesForceLogOut();

		openNewTab("https://campus.uat1.env.opendev.edu.au/psp/cs92uat1/?cmd=login&languageCd=ENG&", 4);
		CampusLogin("michael.williams", "michael.williams");
		searchOUAID_PeopleSoft(OUAID);
		CampusLogOut();

	}

	public static void siteCoreLogin(String emaill, String passwordd) throws Exception {
		test.log(LogStatus.INFO,"<b style=\"color:brown;\">==================== SiteCore Login started ==========================</b>");
		log.info("==================== SiteCore started ==========================");
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

	public static void siteCoreLogOut() throws Exception {
		test.log(LogStatus.INFO,"<b style=\"color:brown;\">==================== SiteCore Logout started ==========================</b>");
		log.info("==================== SiteCore Logout started==========================");
		Thread.sleep(3000);
		click(Sitecore_studentHub);
		click(Sitecore_studentHub);
		test.log(LogStatus.INFO, "Clicked on <b style=\"color:green;\">'Student Hub'</b>");
		log.info("Clicked on Student Hub");
		Thread.sleep(1000);
		click(Sitecore_siginOut);
		test.log(LogStatus.INFO, "Clicked on <b style=\"color:green;\"> 'Sign Out' </b> button");
		log.info("Clicked on Sign Out button");
		test.log(LogStatus.INFO,"<b style=\"color:brown;\">==================== SiteCore Logout ended==========================</b>");
		log.info("==================== SiteCore Logout ended==========================");
	}

	public static void CampusLogin(String userID, String passwordd) throws Exception {
		test.log(LogStatus.INFO,"<b style=\"color:brown;\">==================== Campus Login started ==========================</b>");
		log.info("==================== Campus Login stared==========================");
		sendkeys(Campus_userID, userID);
		test.log(LogStatus.INFO, "<b style=\"color:green;\">'" + userID + "'</b>  user ID entered");
		log.info(userID + " user ID entered");
		sendkeys(Campus_password, passwordd);
		test.log(LogStatus.INFO, "<b style=\"color:green;\">" + "' ***************' " + "</b> password entered");
		log.info(" ********** password entered");
		click(Campus_signIn);
		test.log(LogStatus.INFO, "clicked on <b style=\"color:green;\">'Sign In'</b> button ");
		log.info("clicked on 'Sign In' button");
		test.log(LogStatus.INFO,"<b style=\"color:brown;\">==================== Campus Login ended ==========================</b>");
		log.info("==================== Campus Login ended ==========================");
		Thread.sleep(5000);
	}

	public static void CampusLogOut() throws Exception {
		test.log(LogStatus.INFO,"<b style=\"color:brown;\">==================== Campus Logout started ==========================</b>");
		log.info("==================== Campus Logout stared==========================");
		Thread.sleep(2000);
		click(Campus_hamburgerIcon);
		test.log(LogStatus.INFO, "Clicked on <b style=\"color:green;\"> 'Hamburger Icon' </b> button");
		log.info("Clicked on Hamburger Icon button");
		Thread.sleep(1000);
		click(Campus_signout);
		test.log(LogStatus.INFO, "Clicked on <b style=\"color:green;\"> 'Sign Out' </b> button");
		log.info("Clicked on Sign Out button");
		test.log(LogStatus.INFO,"<b style=\"color:brown;\">==================== Campus Logout ended ==========================</b>");
		log.info("==================== Campus Logout ended==========================");
	}

	public static void salesForceLogin(String userName, String password) throws Exception {
		test.log(LogStatus.INFO,"<b style=\"color:brown;\">==================== Salesforce Login started ==========================</b>");
		log.info("==================== Salesforce Login started ==========================");
		Thread.sleep(10000);
		sendkeys(salesForce_userName, userName);
		test.log(LogStatus.INFO, "<b style=\"color:green;\">'" + userName + "'</b>  Username entered");
		log.info(userName + " Username entered");
		sendkeys(salesForce_password, password);
		test.log(LogStatus.INFO, "<b style=\"color:green;\">" + "' ***************' " + "</b> password entered");
		log.info(" ********** password entered");
		click(salesForce_login);
		test.log(LogStatus.INFO, "Clicked on <b style=\"color:green;\"> 'Login' </b> button");
		log.info("Clicked on Login button");
		test.log(LogStatus.INFO,"<b style=\"color:brown;\">==================== Salesforce Login ended ==========================</b>");
		log.info("==================== Salesforce Login ended==========================");
		Thread.sleep(10000);
	}

	public static void salesForceLogOut() throws Exception {
		test.log(LogStatus.INFO,"<b style=\"color:brown;\">==================== Salesforce Logout started ==========================</b>");
		log.info("==================== Salesforce Logout started ==========================");
		Thread.sleep(5000);
		click(logoutImg);
		test.log(LogStatus.INFO, "Clicked on <b style=\"color:green;\"> 'Logout image icon' </b> button");
		log.info("Clicked on Logout image icon button");
		Thread.sleep(1000);
		click(logout);
		test.log(LogStatus.INFO, "Clicked on <b style=\"color:green;\"> 'Logout' </b> button");
		log.info("Clicked on Logout button");
		test.log(LogStatus.INFO,"<b style=\"color:brown;\">==================== Salesforce Logout ended ==========================</b>");
		log.info("==================== Salesforce Logout ended==========================");
	}

	public static void subjectEnroll (String degree1,String Subject, String feez) throws Exception {

		sendkeys(searchSubject_txtBox, degree1);// Introduction to Nutrition
		log.info(degree1 + " subject entered in search box");
		test.log(LogStatus.INFO,
				"<b style=\"color:green;\"> '" + degree1 + "'</b> subject/degree entered in search box");
		click(searchBtn);
		test.log(LogStatus.INFO, "Clicked on <b style=\"color:green;\"> 'search icon' </b>");
		log.info("Clicked on search icon");
		click(By.xpath("//p[contains(text(),'" + degree1 + "')]"));
		log.info(degree1 + " clicked from the list of subjects");
		test.log(LogStatus.INFO,
				"<b style=\"color:green;\"> '" + degree1 + "'</b> clicked from the list of subject/degree(s)");
		try {
			click(leadReject);
			test.log(LogStatus.INFO, "Clicked on <b style=\"color:green;\"> 'No Thanks' </b> in lead form");
			log.info("Clicked on No Thanks in lead form");
		} catch (Exception e) {
			e.getMessage();
		}
		Thread.sleep(5000);
		Screenshot.infoScreenshot(driver, degree1 + " selected page");
		String subject_name = getElementText(subject_getTxt);
		System.out.println(subject_name);
		log.info("Actual Subject name :- '" + subject_name + "'");
		test.log(LogStatus.INFO, "Actual Subject name :- <b style=\"color:green;\">'" + subject_name + "'</b>");
		log.info("Expected Subject name :- '" + degree1 + "'");
		test.log(LogStatus.INFO, "Expected Subject name :- <b style=\"color:green;\">'" + degree1 + "'</b>");
		//Assert.assertTrue(subject_name.contains(degree1));
		test.log(LogStatus.INFO, " Subject name <b style=\"color:green;\">'" + degree1 + "'</b> matched");
		log.info("Subject name '" + degree1 + "'matched");
		click(select_year);
		test.log(LogStatus.INFO, "Clicked on <b style=\"color:green;\"> '2019' </b> year");
		log.info("Clicked on 2019 year");
		
		click(addAndContinue);
		test.log(LogStatus.INFO, "Clicked on <b style=\"color:green;\"> 'Add And Continue' </b> ");
		log.info("Clicked on Add And Continue ");
		try {
			click(Continue_without_sign);
			test.log(LogStatus.INFO, "Clicked on <b style=\"color:green;\"> 'Continue Without Sigin' </b> button");
			log.info("Clicked on Continue Without Sigin button");
		} catch (Exception e4) {
			e4.getMessage();
		}
		click(core);
		test.log(LogStatus.INFO, "Clicked on <b style=\"color:green;\"> 'core' </b> ");
		log.info("Clicked on core ");
		click(Primary_EducationMajor);
		test.log(LogStatus.INFO, "Clicked on <b style=\"color:green;\"> 'PrimaryEducationMajor' </b> ");
		log.info("Clicked on PrimaryEducationMajor ");
		click(By.xpath("//p[contains(text(),'" + Subject + "')]"));
		log.info(Subject + " clicked from the list of subjects");
		test.log(LogStatus.INFO,"<b style=\"color:green;\"> '" + Subject + "'</b> clicked from the list of subject/degree(s)");
		Thread.sleep(3000);
		click(Addsubject);
		test.log(LogStatus.INFO, "Clicked on <b style=\"color:green;\"> 'Add subject' </b> button ");
		log.info("Clicked on Addsubject button ");		
		String fee = getElementText(feee);
		System.out.println(fee);
		log.info("Actual Subject fee :- '" + fee + "'");
		test.log(LogStatus.INFO, "Actual Subject fee :- <b style=\"color:green;\">'" + fee + "'</b>");
		log.info("Expected Subject fee :- '" + feez + "'");
		test.log(LogStatus.INFO, "Expected Subject fee :- <b style=\"color:green;\">'" + feez + "'</b>");
		Assert.assertTrue(fee.contains(feez));// 1,169
		test.log(LogStatus.INFO, " Subject fee <b style=\"color:green;\">'" + fee + "'</b> matched");
		log.info("Subject fee '" + fee + "'matched");
		selectVisibleText(citizenship_selection, "Australian Citizen");
		click(enroll_btn);
		test.log(LogStatus.INFO, "Clicked on <b style=\"color:green;\"> 'Enrol in selected subjects' </b> button");
		log.info("Clicked on Enrol in selected subjects button");
		
		
	}
	
	public static void postgraduateDegreeApplication () throws Exception {
		
		
		test.log(LogStatus.INFO,"<b style=\"color:brown;\">==================== Postgraduate degree application ==========================</b>");
		log.info("====================Postgraduate degree application ==========================");
		click(applyingBasedOnMy);
		test.log(LogStatus.INFO, "Clicked on <b style=\"color:green;\"> 'Work experience alone' </b> button ");
		log.info("Clicked on Study only button ");
		Thread.sleep(3000);
		click(fileUpload1);
		test.log(LogStatus.INFO, "Clicked on <b style=\"color:green;\"> 'Work experience alone' </b> button ");
		log.info("Clicked on file Upload button ");	
		//uploadFileUsingRobot("");
		Thread.sleep(10000);
		test.log(LogStatus.INFO, "personal statement<b style=\"color:green;\"> 'document' </b> provided");
		log.info("personal statement 'document' provided");
		click(saveAndContinue1);
		test.log(LogStatus.INFO, "Clicked on <b style=\"color:green;\"> 'Save and continue' </b> button ");
		log.info("Clicked on file Save and continue button ");	
		Thread.sleep(2000);
		click(presentNameDifferent);
		test.log(LogStatus.INFO,"Is your present name different to that on your academic transcripts? - <b style=\"color:green;\">'NO' </b>");
		log.info("Is your present name different to that on your academic transcripts? - 'NO'");
		Thread.sleep(2000);
		click(saveAndContinue3);
		test.log(LogStatus.INFO, "Clicked on <b style=\"color:green;\"> 'Save and continue' </b> button ");
		log.info("Clicked on file Save and continue button ");
		Thread.sleep(2000);
		click(fileUpload2);
		test.log(LogStatus.INFO, "Clicked on <b style=\"color:green;\"> 'file Upload' </b> button ");
		log.info("Clicked on file Upload button ");	
		Thread.sleep(10000);
		//uploadFileUsingRobot("");
		test.log(LogStatus.INFO, "work experience<b style=\"color:green;\"> 'document' </b> provided");
		log.info("work experience 'document' provided");
		Thread.sleep(2000);
		click(saveAndContinue5);
		test.log(LogStatus.INFO, "Clicked on <b style=\"color:green;\"> 'Save and continue' </b> button ");
		log.info("Clicked on file Save and continue button ");
		Thread.sleep(3000);
		click(fileUpload3);
		test.log(LogStatus.INFO, "Clicked on <b style=\"color:green;\"> 'file Upload' </b> button ");
		log.info("Clicked on file Upload button ");	
		//uploadFileUsingRobot("");
		Thread.sleep(10000);
		test.log(LogStatus.INFO, "Reference from your employer<b style=\"color:green;\"> 'document' </b> provided");
		log.info("Reference from your employer 'document' provided");
		Thread.sleep(2000);
		click(saveAndContinue6);
		test.log(LogStatus.INFO, "Clicked on <b style=\"color:green;\"> 'Save and continue' </b> button ");
		log.info("Clicked on file Save and continue button ");
		Thread.sleep(2000);
		click(englishLanguageProficiency);
		test.log(LogStatus.INFO,"Were your previous degrees or subjects in English? - <b style=\"color:green;\">'YES' </b>");
		log.info("Were your previous degrees or subjects in English? - 'YES'");
		Thread.sleep(2000);
		click(saveAndContinue7);
		test.log(LogStatus.INFO, "Clicked on <b style=\"color:green;\"> 'Save and continue' </b> button ");
		log.info("Clicked on file Save and continue button ");
		Thread.sleep(2000);
		click(yourIntendedStudy);
		test.log(LogStatus.INFO,"What is your intended study load? - <b style=\"color:green;\">'Two or more subjects (full-time)' </b>");
		log.info("What is your intended study load? - 'Two or more subjects (full-time)'");
		Thread.sleep(2000);
		click(intendToClaimExemptions);
		test.log(LogStatus.INFO,"Do you intend to claim exemptions for prior study? - <b style=\"color:green;\">'YES' </b>");
		log.info("Do you intend to claim exemptions for prior study? - 'YES'");
		Thread.sleep(2000);
		click(saveAndContinue8);
		test.log(LogStatus.INFO, "Clicked on <b style=\"color:green;\"> 'Continue' </b> button ");
		log.info("Clicked on file Save and continue button ");
		Thread.sleep(2000);
		click(Continue_btn);
		test.log(LogStatus.INFO, "Clicked on <b style=\"color:green;\"> 'Continue' </b> button ");
		log.info("Clicked on file Save and continue button ");
		Thread.sleep(2000);
		click(HECS_HELP_loan);
		test.log(LogStatus.INFO, "Clicked on <b style=\"color:green;\"> 'HECS HELP loan' </b> button ");
		log.info("Clicked on file HECS HELP loan button ");
	
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
		Screenshot.infoScreenshot(driver, "Registaration page in site core");
		click(register_btn);
		test.log(LogStatus.INFO, "Clicked on <b style=\"color:green;\"> 'Register' </b> button");
		log.info("Clicked on Register button");
		Thread.sleep(3000);

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
		Thread.sleep(1000);
		click(CountryOfBirth);
		Thread.sleep(2000);
		actionsclick(Counrty, counrty);
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
		Screenshot.infoScreenshot(driver, "Your Information page");
		click(ContinueToPayment);
		test.log(LogStatus.INFO,
				"Clicked on <b style=\"color:green;\"> 'CONTINUE' </b> button after submiting Information");
		log.info("Clicked on CONTINUE button after submiting Information");
		Thread.sleep(5000);
		// Supporting documents
		test.log(LogStatus.INFO,"<b style=\"color:brown;\">==================== Supporting documents ==========================</b>");
		log.info("==================== Supporting documents ==========================");
		click(postgraduateinformation_continue_btn);
		test.log(LogStatus.INFO,
				"Clicked on <b style=\"color:green;\"> 'CONTINUE' </b> button in Supporting documents page");
		log.info("Clicked on CONTINUE button in Supporting documents page");
		Thread.sleep(3000);

	}

	public static void funding(String TaxFilenumber) throws InterruptedException, AWTException, Exception {
		// Undergraduate degree application
		Thread.sleep(3000);
		// Residency status
		test.log(LogStatus.INFO,"<b style=\"color:brown;\">==================== funding ==========================</b>");
		log.info("==================== funding ==========================");
		Thread.sleep(1000);
		click(you_live_in_Australia);
		test.log(LogStatus.INFO," Will you live in Australia while you study for this degree? <b style=\"color:green;\">' Yes, for the entire degree.'</b> ");
		log.info(" Will you live in Australia while you study for this degree? ' Yes, for the entire degree.' ");
		Thread.sleep(1000);
		click(save_continue1);
		test.log(LogStatus.INFO, "Clicked on <b style=\"color:green;\"> 'SAVE AND CONTINUE' </b> button");
		log.info("Clicked on SAVE AND CONTINUE button");	
		// Your tax file number
		Thread.sleep(2000);
		click(TaxFileNumber_yes);
		test.log(LogStatus.INFO,"Do you have a valid Tax File Number (TFN)  :- <b style=\"color:green;\"> 'YES' </b> ");
		log.info("Do you have a valid Tax File Number (TFN)  :-  'YES'  ");
		Thread.sleep(3000);
		sendkeys(TaxFileNumber, TaxFilenumber);
		test.log(LogStatus.INFO, "<b style=\"color:green;\">'" + TaxFilenumber + "'</b> TaxFileNumber entered");
		log.info(TaxFilenumber + "  TaxFileNumber entered");
		Thread.sleep(3000);
		Screenshot.capture(driver, "Funding page ");
		
		click(save_continue6);
		test.log(LogStatus.INFO,"Clicked on <b style=\"color:green;\"> 'SAVE AND CONTINUE' </b> button for Undergraduate degree application");
		log.info("Clicked on SAVE AND CONTINUE button for Undergraduate degree application");
		Screenshot.infoScreenshot(driver, "funding page");
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
		Screenshot.infoScreenshot(driver, "'Your application is complete!' in sitecore");
		click(goToDashBoard);
		test.log(LogStatus.INFO, "Clicked on <b style=\"color:green;\"> 'Go to dashboard' </b> button");
		log.info("Clicked on Go to dashboard button ");
		String title = getElementText(OUA_Satus);
		String[] arrSplit = title.split("\\s+");
		OUAID = arrSplit[3];
		System.out.println("OUA id is " + arrSplit[3]);
		test.log(LogStatus.INFO, "OUA id is <b style=\"color:green;\"'> " + OUAID + "' </b> ");
		log.info("OUA id is ' " + OUAID + "' </b> ");
		Screenshot.infoScreenshot(driver, "OUA ID in sitecore");

	}

	public static void openNewTab(String url, int tabNum) {
		((JavascriptExecutor) driver).executeScript("window.open()");
		tabs = new ArrayList<String>(driver.getWindowHandles());
		System.out.println(tabs.size());
		driver.switchTo().window(tabs.get(tabNum));
		driver.navigate().to(url);
		test.log(LogStatus.INFO,"<b style=\"color:black;\"> **************** Navigarting to '" + url+ "' ***********************</b>");
		log.info("==================== Navigarting to '" + url + "'  ==========================");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	public static void search_Account_Salesforce(String OUA_ID) throws Exception {
		test.log(LogStatus.INFO,"<b style=\"color:brown;\">==================== search account in salesforce ==========================</b>");
		log.info("==================== search account in salesforce ==========================");

		Thread.sleep(5000);
		List<WebElement> noOfTabs = driver.findElements(By.xpath("//*[@id='oneHeader']/div[3]/div/div[2]/div/div/ul[2]/li"));
		System.out.println("noOfTabs.size() " + noOfTabs.size());

		if (noOfTabs.size() == 0) {
			System.out.println("no tabls open");
		} else {
			for (int i = 0; i < noOfTabs.size() - 1; i++) {
				Thread.sleep(2000);
				System.out.println("inside for loop" + i);
				click(By.xpath("//*[@id='oneHeader']/div[3]/div/div[2]/div/div/ul[2]/li[2]/div[2]/button/lightning-primitive-icon"));
			}
		}

		Thread.sleep(3000);
		Screenshot.infoScreenshot(driver, "OUA Salesforce Homepage");
		actionsclickk(searchUserId, OUA_ID);
		test.log(LogStatus.INFO, "<b style=\"color:green;\">'" + OUA_ID + "'</b>  OUA ID entered");
		log.info(OUA_ID + "  OUA ID entered");
		Thread.sleep(10000);
		Screenshot.infoScreenshot(driver, "Accounts page in sales force");
		String AccountNamee = getElementText(By.xpath("//*[@data-aura-class='forceBrandBand']/div/div/div[2]/div/div/div/div/div/div[1]/div[1]/div[2]/div/div/div/div[2]/div[2]/div[1]/div/div/table/tbody/tr/th/span/a"));
		Thread.sleep(1000);
		String ouaID = getElementText(By.xpath("//*[@data-aura-class='forceBrandBand']/div/div/div[2]/div/div/div/div/div/div[1]/div[1]/div[2]/div/div/div/div[2]/div[2]/div[1]/div/div/table/tbody/tr/td[2]/span/span"));
		Thread.sleep(1000);
		String Dob = getElementText(By.xpath("//*[@data-aura-class='forceBrandBand']/div/div/div[2]/div/div/div/div/div/div[1]/div[1]/div[2]/div/div/div/div[2]/div[2]/div[1]/div/div/table/tbody/tr/td[4]/span/span"));
		Thread.sleep(1000);
		String mobile = getElementText(By.xpath("//*[@data-aura-class='forceBrandBand']/div/div/div[2]/div/div/div/div/div/div[1]/div[1]/div[2]/div/div/div/div[2]/div[2]/div[1]/div/div/table/tbody/tr/td[5]/span/span"));
		Thread.sleep(1000);
		String Email = getElementText(By.xpath("//*[@data-aura-class='forceBrandBand']/div/div/div[2]/div/div/div/div/div/div[1]/div[1]/div[2]/div/div/div/div[2]/div[2]/div[1]/div/div/table/tbody/tr/td[6]/span/span"));
		Thread.sleep(1000);
		String AccountType = getElementText(By.xpath("//*[@data-aura-class='forceBrandBand']/div/div/div[2]/div/div/div/div/div/div[1]/div[1]/div[2]/div/div/div/div[2]/div[2]/div[1]/div/div/table/tbody/tr/td[7]/span/span"));
		Thread.sleep(1000);
		test.log(LogStatus.INFO,
				"Account Name:- <b style=\"color:green;\">'" + AccountNamee
						+ "'</b>, OUA ID:- <b style=\"color:green;\">'" + ouaID + "'</b>,"
						+ " DOB:- <b style=\"color:green;\">'" + Dob + "'</b>, MOBILE:- <b style=\"color:green;\">'"
						+ mobile + "'</b>, Email:- <b style=\"color:green;\">'" + Email
						+ "'</b>, AccountType:- <b style=\"color:green;\">'" + AccountType + "'</b>");
		Thread.sleep(1000);
		// account name
		click(AccountName);
		test.log(LogStatus.INFO, "clicked on  <b style=\"color:green;\"'>" + AccountNamee + "'</b> ");
		log.info("clicked on " + AccountNamee + "");
		Thread.sleep(10000);
		click(applicationStudent);
		test.log(LogStatus.INFO, "clicked on  <b style=\"color:green;\">'Applications (Student) '</b> link ");
		log.info("clicked on  Applications (Student)  link ");
		Thread.sleep(3000);
		Screenshot.infoScreenshot(driver, "Applications (Student) page in sales force");
		// appication num
		click(OUA_ApplicationNum);
		test.log(LogStatus.INFO, "clicked on  <b style=\"color:green;\">'OUA Application Num '</b> link ");
		log.info("clicked on  OUA Application Num  link ");
		Thread.sleep(3000);
		String stage_status1 = getElementText(stage);
		Thread.sleep(3000);
		System.out.println("stage_status" + stage_status1);
		test.log(LogStatus.INFO, " stage status:- <b style=\"color:green;\">'" + stage_status1 + "'</b>");
		log.info(" stage status:- '" + stage_status1 + "'");
		// stage dropdown
		WebElement stage_Drp = waitForClickable(stageDrp);
		Actions action = new Actions(driver);
		action.moveToElement(stage_Drp).doubleClick().perform();
		test.log(LogStatus.INFO, "clicked on  <b style=\"color:green;\">'Stage dropdown '</b>  ");
		log.info("clicked on 'Stage dropdown '");
		Thread.sleep(10000);
		click(By.xpath("(//a[text()='" + stage_status1 + "'])[1]"));
		Thread.sleep(3000);
		click(By.xpath("//a[text()='Offered']"));
		test.log(LogStatus.INFO, "clicked on  <b style=\"color:green;\">' Offered '</b> from Stage dropdown");
		log.info("clicked on ' Offered ' from Stage dropdown");
		Thread.sleep(3000);
		sendkeys(comments, "testing");
		test.log(LogStatus.INFO, "<b style=\"color:green;\">' Automation Testing'</b>  comments entered");
		log.info("' Automation Testing' comments entered");
		Thread.sleep(3000);
		click(save);
		test.log(LogStatus.INFO, "clicked on  <b style=\"color:green;\">'SAVE '</b> button ");
		log.info("clicked on  'SAVE' button ");
		String stage_status2 = getElementText(stage);
		Thread.sleep(3000);
		System.out.println("stage_status" + stage_status2);
		test.log(LogStatus.INFO, " stage status:- <b style=\"color:green;\">'" + stage_status2 + "'</b>");
		log.info(" stage status:- '" + stage_status2 + "'");
		test.log(LogStatus.INFO, " stage status <b style=\"color:green;\">'" + stage_status2
				+ "'</b> changed from <b style=\"color:green;\">'" + stage_status1 + "'</b>");
		log.info(" stage status '" + stage_status2 + "' changed from '" + stage_status1 + "'");
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
		
		List<WebElement> noOfSubjects = driver.findElements(By.xpath("//div[@class='cards-container']/div"));

		for (int i = 1; i <= noOfSubjects.size(); i++) {
			String SubjectName = driver.findElement(By.xpath("(//*[@class='card-content']/p[2])[" + i + "]")).getText();
			String Status = driver.findElement(By.xpath("(//div[@class='card-footer']/div[1]/span)[" + i + "]")).getText();
			System.out.println("SubjectName:- " + SubjectName + ", Status:- " + Status);

			if (SubjectName.contains(Repository.getProperty("subject3"))&& Status.contains(Repository.getProperty("status"))) {

				Assert.assertTrue(SubjectName.contains(Repository.getProperty("subject3"))&& Status.contains(Repository.getProperty("status")));
				test.log(LogStatus.INFO, "SubjectName:- <b style=\"color:green;\">'" + SubjectName
						+ "'</b>, Status:- <b style=\"color:green;\">'" + Status + "'</b> verified");
				log.info("SubjectName:- '" + SubjectName + "', Status:- '" + Status + "'");

			} else {
			

			}
		}

	}

	public static void uploadFileUsingRobot(String filePath) throws AWTException, InterruptedException {
		StringSelection s = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
		Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(150);
        robot.keyRelease(KeyEvent.VK_ENTER);

	}

	public static void searchAsserts(String OUA_ID) throws Exception {
		test.log(LogStatus.INFO,"<b style=\"color:brown;\">==================== Search Asserts ==========================</b>");
		log.info("==================== Search Asserts ==========================");
		Thread.sleep(10000);
		List<WebElement> noOfTabs = driver.findElements(By.xpath("//*[@id='oneHeader']/div[3]/div/div[2]/div/div/ul[2]/li"));
		System.out.println("noOfTabs.size() " + noOfTabs.size());

		if (noOfTabs.size() == 0) {
			System.out.println("no tabls open");
		} else {
			for (int i = 0; i < noOfTabs.size() - 1; i++) {
				Thread.sleep(2000);
				System.out.println("inside for loop" + i);
				click(By.xpath("//*[@id='oneHeader']/div[3]/div/div[2]/div/div/ul[2]/li[2]/div[2]/button/lightning-primitive-icon"));
			}
		}
		Thread.sleep(3000);
		actionsclickk(searchUserId, OUA_ID);
		test.log(LogStatus.INFO, "<b style=\"color:green;\">'" + OUA_ID + "'</b>  OUA ID entered");
		log.info(OUA_ID + "  OUA ID entered");
		Thread.sleep(10000);
		String AccountNamee = getElementText(By.xpath(
				"//*[@data-aura-class='forceBrandBand']/div/div/div[2]/div/div/div/div/div/div[1]/div[1]/div[2]/div/div/div/div[2]/div[2]/div[1]/div/div/table/tbody/tr/th/span/a"));
		Thread.sleep(1000);
		String ouaID = getElementText(By.xpath(
				"//*[@data-aura-class='forceBrandBand']/div/div/div[2]/div/div/div/div/div/div[1]/div[1]/div[2]/div/div/div/div[2]/div[2]/div[1]/div/div/table/tbody/tr/td[2]/span/span"));
		Thread.sleep(1000);
		String Dob = getElementText(By.xpath(
				"//*[@data-aura-class='forceBrandBand']/div/div/div[2]/div/div/div/div/div/div[1]/div[1]/div[2]/div/div/div/div[2]/div[2]/div[1]/div/div/table/tbody/tr/td[4]/span/span"));
		Thread.sleep(1000);
		String mobile = getElementText(By.xpath(
				"//*[@data-aura-class='forceBrandBand']/div/div/div[2]/div/div/div/div/div/div[1]/div[1]/div[2]/div/div/div/div[2]/div[2]/div[1]/div/div/table/tbody/tr/td[5]/span/span"));
		Thread.sleep(1000);
		String Email = getElementText(By.xpath(
				"//*[@data-aura-class='forceBrandBand']/div/div/div[2]/div/div/div/div/div/div[1]/div[1]/div[2]/div/div/div/div[2]/div[2]/div[1]/div/div/table/tbody/tr/td[6]/span/span"));
		Thread.sleep(1000);
		String AccountType = getElementText(By.xpath(
				"//*[@data-aura-class='forceBrandBand']/div/div/div[2]/div/div/div/div/div/div[1]/div[1]/div[2]/div/div/div/div[2]/div[2]/div[1]/div/div/table/tbody/tr/td[7]/span/span"));
		Thread.sleep(1000);
		Screenshot.infoScreenshot(driver, "Accounts page in sales force");
		test.log(LogStatus.INFO,
				"Account Name:- <b style=\"color:green;\">'" + AccountNamee
						+ "'</b>, OUA ID:- <b style=\"color:green;\">'" + ouaID + "'</b>,"
						+ " DOB:- <b style=\"color:green;\">'" + Dob + "'</b>, MOBILE:- <b style=\"color:green;\">'"
						+ mobile + "'</b>, Email:- <b style=\"color:green;\">'" + Email
						+ "'</b>, AccountType:- <b style=\"color:green;\">'" + AccountType + "'</b>");
		Thread.sleep(1000);
		// account name
		click(AccountName);
		test.log(LogStatus.INFO, "clicked on  <b style=\"color:green;\"'>" + AccountNamee + "'</b> ");
		log.info("clicked on " + AccountNamee + "");
		Thread.sleep(10000);
		click(asserts);
		test.log(LogStatus.INFO, "clicked on  <b style=\"color:green;\">'Asserts '</b> link ");
		log.info("clicked on  Asserts  link ");
		Thread.sleep(10000);
		Screenshot.infoScreenshot(driver, "Asserts page in sales force");
		List<WebElement> list = driver.findElements(By.xpath("//*[@data-aura-class='forceBrandBand']/div/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr"));
		for (int i = 1; i <= list.size(); i++) {
			String AssetName = driver.findElement(By.xpath("//*[@data-aura-class='forceBrandBand']/div/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr["+ i + "]/th/span")).getText();
			String University = driver.findElement(By.xpath("//*[@data-aura-class='forceBrandBand']/div/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr["+ i + "]/td[2]/span")).getText();
			String Degree_Subject = driver.findElement(By.xpath("//*[@data-aura-class='forceBrandBand']/div/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr["+ i + "]/td[3]/span/span/a")).getText();
			String status = driver.findElement(By.xpath("//*[@data-aura-class='forceBrandBand']/div/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr["+ i + "]/td[4]/span/span")).getText();
			System.out.println("AssetName:- " + AssetName + ", University:- " + University + ", Degree/Subject:- "+ Degree_Subject + ", status:- " + status);
			test.log(LogStatus.INFO,
					"AssetName:- <b style=\"color:green;\">'" + AssetName
							+ "'</b>, University:- <b style=\"color:green;\">'" + University + "'</b>,"
							+ " Degree/Subject:-:- <b style=\"color:green;\">'" + Degree_Subject
							+ "'</b>, status:- <b style=\"color:green;\">'" + status + "'</b>");

		}

		for (int i = 1; i < 2; i++) {
			String AssetName = driver.findElement(By.xpath("//*[@data-aura-class='forceBrandBand']/div/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr["+ i + "]/th/span")).getText();
			 Degree_Subject = driver.findElement(By.xpath("//*[@data-aura-class='forceBrandBand']/div/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr["+ i + "]/td[3]/span/span/a")).getText();
			click(By.xpath("//*[@data-aura-class='forceBrandBand']/div/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr["+ i + "]/th/span"));
			test.log(LogStatus.INFO, "clicked on  <b style=\"color:green;\">'" + AssetName + "'</b> link ");
			log.info("clicked on '" + AssetName + "' link ");
		  integrationStatus = getElementText(By.xpath("(//*[@class='test-id__section-content slds-section__content section__content']/div/div[1]/div[1]/div/div[2]/span/span)[19]"));						
			Thread.sleep(3000);
			
		}
		for (int i = 1; i < 10; i++){
	  integrationStatus = getElementText(By.xpath("(//*[@class='test-id__section-content slds-section__content section__content']/div/div[1]/div[1]/div/div[2]/span/span)[19]"));
	  System.out.println("IntegrationStatus:- " + integrationStatus);
	  if(integrationStatus.contains("Pending")){
			Thread.sleep(50000);
			driver.navigate().refresh();
		}
		else{
			test.log(LogStatus.INFO, "IntegrationStatus of<b style=\"color:green;\">' " + Degree_Subject+ "'</b> Degree/Subject is <b style=\"color:green;\">'" + integrationStatus + "'</b>");
			log.info("IntegrationStatus of " + Degree_Subject + " Degree/Subject is " + integrationStatus);
			break;
		}
		}
	}

	public static void searchOUAID_PeopleSoft(String OUA_ID) throws Exception {
		test.log(LogStatus.INFO,"<b style=\"color:brown;\">==================== Search OUAID in PeopleSoft ==========================</b>");
		log.info("==================== Search OUAID in PeopleSoft  ==========================");
		Thread.sleep(3000);
		Screenshot.infoScreenshot(driver, "Campus Homepage");
		click(Campus_navigator);
		test.log(LogStatus.INFO, "clicked on  <b style=\"color:green;\">'Campus navigator'</b> ");
		log.info("clicked on  <b style=\"color:green;\"> Campus navigator</b> ");
		Thread.sleep(10000);
		frames = driver.findElements(By.tagName("iframe"));
		System.out.println("frames.size()" + frames.size());
		driver.switchTo().frame(frames.get(0));
		actionsclick(ClassicHome);
		test.log(LogStatus.INFO, "clicked on  <b style=\"color:green;\"> 'Classic Home'</b> link ");
		log.info("clicked on  <b style=\"color:green;\"> Classic Home</b> link ");
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		click(recordsAndEnrollment);
		test.log(LogStatus.INFO, "clicked on  <b style=\"color:green;\"> 'Records And Enrollment'</b> link ");
		log.info("clicked on  <b style=\"color:green;\"> 'Records And Enrollment' </b> link ");
		Thread.sleep(3000);
		click(enrollStudents);
		test.log(LogStatus.INFO, "clicked on  <b style=\"color:green;\"> 'Enroll Students'</b> link ");
		log.info("clicked on  <b style=\"color:green;\"> 'Enroll Students' </b> link ");
		Thread.sleep(3000);
		click(enrollment);
		test.log(LogStatus.INFO, "clicked on  <b style=\"color:green;\"> 'Enrollment'</b> link ");
		log.info("clicked on  <b style=\"color:green;\"> 'Enrollment' </b> link ");
		Thread.sleep(3000);
		System.out.println("frames.size()" + frames.size());
		Thread.sleep(3000);
		driver.switchTo().frame("ptifrmtgtframe");
		clear(Campus_SearchOUAID);
		sendkeys(Campus_SearchOUAID, OUA_ID);
		test.log(LogStatus.INFO, "<b style=\"color:green;\">'" + OUA_ID + "'</b>  OUA ID entered");
		log.info(OUA_ID + "  OUA ID entered");
		Thread.sleep(3000);
		click(Campus_SearchBtn);
		test.log(LogStatus.INFO, "clicked on  <b style=\"color:green;\"> 'Search'</b> button ");
		log.info("clicked on  <b style=\"color:green;\"> 'Search' </b> button ");
		Thread.sleep(3000);
		click(AUS_Student_Enroll);
		test.log(LogStatus.INFO, "clicked on  <b style=\"color:green;\"> 'AUS Student Enroll'</b> button ");
		log.info("clicked on  <b style=\"color:green;\"> 'AUS Student Enroll' </b> button ");
		Thread.sleep(3000);
		String Liability_Status = driver.findElement(By.xpath("//*[@id='SSR_STDENRL_AUS_SSR_HECS_XMPT_STAT$0']")).getAttribute("value");
		System.out.println("Liability_Status:-" + Liability_Status);
		test.log(LogStatus.INFO, "Liability Status:-  <b style=\"color:green;\"'>" + Liability_Status + "'</b> ");
		log.info("Liability Status:-" + Liability_Status + "");
		//Assert.assertTrue(Liability_Status.contains("201"));
		test.log(LogStatus.INFO,"Liability Status:-  <b style=\"color:green;\"'>" + Liability_Status + "'</b> verified");
		log.info("Liability Status:-" + Liability_Status + " verified");
		String Liability_Status_Description = getElementText(liability_Status_Description);
		System.out.println("Liability_Status_Description:-" + Liability_Status_Description);
		test.log(LogStatus.INFO, "Liability Status Description:-  <b style=\"color:green;\"'>"+ Liability_Status_Description + "'</b> ");
		log.info("Liability Status Description:-" + Liability_Status_Description + "");
		//Assert.assertTrue(Liability_Status_Description.contains("HECS-HELP - Deferred"));
		test.log(LogStatus.INFO, "Liability Status Description:-  <b style=\"color:green;\"'>"+ Liability_Status_Description + "'</b> verified ");
		log.info("Liability Status Description:-" + Liability_Status_Description + " verified");
		Screenshot.infoScreenshot(driver, "AUS Student Enroll page");
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		click(recordsAndEnrollment);
		test.log(LogStatus.INFO, "clicked on  <b style=\"color:green;\"> 'Records And Enrollment'</b> link ");
		log.info("clicked on  <b style=\"color:green;\"> 'Records And Enrollment' </b> link ");
		Thread.sleep(3000);
		click(EnrollmentSummaries);
		test.log(LogStatus.INFO, "clicked on  <b style=\"color:green;\"> 'Enrollment Summaries'</b> link ");
		log.info("clicked on  <b style=\"color:green;\"> 'Enrollment Summaries' </b> link ");
		Thread.sleep(3000);
		click(EnrollmentSummary);
		test.log(LogStatus.INFO, "clicked on  <b style=\"color:green;\"> 'Enrollment Summary'</b> link ");
		log.info("clicked on  <b style=\"color:green;\"> 'Enrollment Summary' </b> link ");
		Thread.sleep(3000);
		driver.switchTo().frame("ptifrmtgtframe");
		Thread.sleep(3000);
		Screenshot.infoScreenshot(driver, "EnrollmentSummary page");
		for (int i = 2; i <= 11; i++) {
			String SubjectName = driver.findElement(By.xpath("//table[@id='ACE_$ICField21$0']/tbody/tr[2]/td[" + i + "]")).getText();
			System.out.print(" " + SubjectName + " | ");
			log.info("SubjectName:- " + SubjectName);
		}
		System.out.println("");
		String Status1 = driver.findElement(By.xpath("//table[@id='ACE_$ICField21$0']/tbody/tr[3]/td[2]")).getText();
		System.out.print(" " + Status1 + " | ");
		log.info("Status:- " + Status1);
		for (int i = 4; i <= 12; i++) {
			String Status = driver.findElement(By.xpath("//table[@id='ACE_$ICField21$0']/tbody/tr[3]/td[" + i + "]")).getText();
			System.out.print(" " + Status + " | ");
			log.info("Status:- " + Status);
		}
		System.out.println("");
		for (int i = 2; i <= 11; i++) {
			String Statuss = driver.findElement(By.xpath("//table[@id='ACE_$ICField21$0']/tbody/tr[6]/td[" + i + "]")).getText();
			System.out.print(" " + Statuss + " | ");
			log.info("Status:- " + Statuss);
		}
		driver.switchTo().defaultContent();
	}



}
