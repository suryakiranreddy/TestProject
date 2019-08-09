package com.creditmantri.Moneymontra.api;

import junit.framework.Assert;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java.io.IOException;

public class MoneymantraTest {

    ExtentReports extent;
    ExtentTest logger;

    @BeforeSuite
    public void Setup() throws IOException
    {
        extent = new ExtentReports(System.getProperty("user.dir") +"/test-output/STMExtentReport.html", true);
        extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/STMExtentReport.html",true);
    }

    Moneymantra money = new Moneymantra();

    @Test
    public void Leadalreadyexists() throws JSONException, IOException {
        JSONObject data=new JSONObject();
        data.put("mobileNumber","9943969192");
        data.put("firstName","balamurugan");
        data.put("lastName","thayalan");
        data.put("pan","bgbpb6361h");
        data.put("dob","1990-07-14");
        data.put("gender","male");
        data.put("pinCode","600017");
        data.put("employmentType","Salaried");
        data.put("salaryPat","20000");
        int output=money.moneymontra(data);
        //Response response=new Gson().fromJson(output, Response.class);
        //System.out.println(response.getStatus());
        Assert.assertEquals(200,output);
        logger = extent.startTest("Leadalreadyexists");
        logger.log(LogStatus.PASS,"\"Test Case Passed\"");
        extent.flush();

    }
    @Test
    public void Mobilenumberisrequired() throws JSONException, IOException {
        JSONObject data = new JSONObject();
        //  data.put("mobileNumber","9943969192");
        data.put("firstName","balamurugan");
        data.put("lastName","thayalan");
        data.put("pan","bgbpb6361h");
        data.put("dob","1990-07-14");
        data.put("gender","male");
        data.put("pinCode","600017");
        data.put("employmentType","Salaried");
        data.put("salaryPat","20000");
        int output=money.moneymontra(data);
        Assert.assertEquals(400,output);
        logger = extent.startTest("Mobilenumberisrequired");
        logger.log(LogStatus.PASS,"\"Test Case Passed\"");
        extent.flush();

    }
    @Test
    public void Firstnameisrequired() throws JSONException, IOException {
        JSONObject data = new JSONObject();
        data.put("mobileNumber","9943969192");
        //data.put("firstName","balamurugan");
        data.put("lastName","thayalan");
        data.put("pan","bgbpb6361h");
        data.put("dob","1990-07-14");
        data.put("gender","male");
        data.put("pinCode","600017");
        data.put("employmentType","Salaried");
        data.put("salaryPat","20000");
        int output=money.moneymontra(data);
        Assert.assertEquals(400,output);
        logger = extent.startTest("Firstnameisrequired");
        logger.log(LogStatus.PASS,"\"Test Case Passed\"");
        extent.flush();

    }
    @Test
    public void Lastnameisrequired() throws JSONException, IOException {
        JSONObject data = new JSONObject();
        data.put("mobileNumber","9943969192");
        data.put("firstName","balamurugan");
        //data.put("lastName","thayalan");
        data.put("pan","bgbpb6361h");
        data.put("dob","1990-07-14");
        data.put("gender","male");
        data.put("pinCode","600017");
        data.put("employmentType","Salaried");
        data.put("salaryPat","20000");
        int output = money.moneymontra(data);
        Assert.assertEquals(400,output);
        logger = extent.startTest("Lastnameisrequired");
        logger.log(LogStatus.PASS,"\"Test Case Passed\"");
        extent.flush();

    }
    @Test
    public void PANisrequired() throws JSONException, IOException {
        JSONObject data = new JSONObject();
        data.put("mobileNumber","9943969192");
        data.put("firstName","balamurugan");
        data.put("lastName","thayalan");
        //data.put("pan","bgbpb6361h");
        data.put("dob","1990-07-14");
        data.put("gender","male");
        data.put("pinCode","600017");
        data.put("employmentType","Salaried");
        data.put("salaryPat","20000");
        int output = money.moneymontra(data);
        Assert.assertEquals(400,output);
        logger = extent.startTest("PANisrequired");
        logger.log(LogStatus.PASS,"\"Test Case Passed\"");
        extent.flush();

    }
    @Test
    public void DOBisrequired() throws JSONException, IOException {
        JSONObject data = new JSONObject();
        data.put("mobileNumber", "9943969192");
        data.put("firstName", "balamurugan");
        data.put("lastName", "thayalan");
        data.put("pan", "bgbpb6361h");
        //data.put("dob","1990-07-14");
        data.put("gender", "male");
        data.put("pinCode", "600017");
        data.put("employmentType", "Salaried");
        data.put("salaryPat", "20000");
        int output = money.moneymontra(data);
        Assert.assertEquals(400, output);
        logger = extent.startTest("DOBisrequired");
        logger.log(LogStatus.PASS,"\"Test Case Passed\"");
        extent.flush();
    }
    @Test
    public void Genderisrequired() throws JSONException, IOException {
        JSONObject data = new JSONObject();
        data.put("mobileNumber", "9943969192");
        data.put("firstName", "balamurugan");
        data.put("lastName", "thayalan");
        data.put("pan", "bgbpb6361h");
        data.put("dob","1990-07-14");
        //data.put("gender", "male");
        data.put("pinCode", "600017");
        data.put("employmentType", "Salaried");
        data.put("salaryPat", "20000");
        int output = money.moneymontra(data);
        Assert.assertEquals(400, output);
        logger = extent.startTest("Genderisrequired");
        logger.log(LogStatus.PASS,"\"Test Case Passed\"");
        extent.flush();
    }
    @Test
    public void Pincodeisrequired() throws JSONException, IOException {
        JSONObject data = new JSONObject();
        data.put("mobileNumber", "9943969192");
        data.put("firstName", "balamurugan");
        data.put("lastName", "thayalan");
        data.put("pan", "bgbpb6361h");
        data.put("dob","1990-07-14");
        data.put("gender", "male");
        //data.put("pinCode", "600017");
        data.put("employmentType", "Salaried");
        data.put("salaryPat", "20000");
        int output = money.moneymontra(data);
        Assert.assertEquals(400, output);
        logger = extent.startTest("Pincodeisrequired");
        logger.log(LogStatus.PASS,"\"Test Case Passed\"");
        extent.flush();
    }
    @Test
    public void Employmenttypeisrequired() throws JSONException, IOException {
        JSONObject data = new JSONObject();
        data.put("mobileNumber", "9943969192");
        data.put("firstName", "balamurugan");
        data.put("lastName", "thayalan");
        data.put("pan", "bgbpb6361h");
        data.put("dob","1990-07-14");
        data.put("gender", "male");
        data.put("pinCode", "600017");
        //data.put("employmentType", "Salaried");
        data.put("salaryPat", "20000");
        int output = money.moneymontra(data);
        Assert.assertEquals(400, output);
        logger = extent.startTest("Employmenttypeisrequired");
        logger.log(LogStatus.PASS,"\"Test Case Passed\"");
        extent.flush();
    }
    @Test
    public void SalaryPatisrequired() throws JSONException, IOException {
        JSONObject data = new JSONObject();
        data.put("mobileNumber", "9943969192");
        data.put("firstName", "balamurugan");
        data.put("lastName", "thayalan");
        data.put("pan", "bgbpb6361h");
        data.put("dob","1990-07-14");
        data.put("gender", "male");
        data.put("pinCode", "600017");
        data.put("employmentType", "Salaried");
        //data.put("salaryPat", "20000");
        int output = money.moneymontra(data);
        Assert.assertEquals(400, output);
        logger = extent.startTest("SalaryPatisrequired");
        logger.log(LogStatus.PASS,"\"Test Case Passed\"");
        extent.flush();
    }

}