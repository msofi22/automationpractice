package basetest;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;

import base.BasePage;

import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.*;
import com.google.common.io.Files;

public class BaseTest extends BasePage {
    protected ExtentReports extent;
    protected ExtentTest logger;
    ExtentHtmlReporter htmlReporter;
    //Path for the HTML report to be saved
    String htmlReportPath="C:\\Users\\DELL-5567\\Desktop\\TESTING AND DEV\\My repo\\automationpractice\\src\\test\\resources\\reports\\Report1.html";


  public BaseTest(){
    super(driver);
  }
  
  @BeforeTest
  public void setUpReport(){
    htmlReporter = new ExtentHtmlReporter(htmlReportPath);
    extent= new ExtentReports();
    extent.attachReporter(htmlReporter);
  }
    @AfterMethod
    //This method takes a screenshot if the test has FAILED and saves it in screenshots folder
    public void takeAScreenshotIfFailed(ITestResult result){
      if(ITestResult.FAILURE==result.getStatus()){
      var camera= (TakesScreenshot)driver;
      File screenshot= camera.getScreenshotAs(OutputType.FILE);
      //System.out.println("Screenshot taken in: "+ screenshot.getAbsolutePath());
      try{
        Files.move(screenshot, new File("src/test/resources/screenshots/"+result.getName()+".png"));
      }catch(IOException e){
        e.printStackTrace();
      }
    }
  }
    //Added the extent report method in case of Fail, success or skip tests
    public void getResult(ITestResult result) throws Exception{
      if(result.getStatus()==ITestResult.FAILURE){
        logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+"Test Case FAILED ", ExtentColor.RED));
        logger.fail(result.getThrowable());
      }
      else if(result.getStatus()==ITestResult.SUCCESS){
        logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+ "Test Case PASSED", ExtentColor.GREEN));
      }
      else if(result.getStatus()==ITestResult.SKIP){
        logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+ "Test Case SKIPPED", ExtentColor.BLUE));
      }
    }

    @AfterClass
    public void testEnd() throws Exception{
        extent.flush();
    }
    
    @AfterSuite
    public void tearDown(){
      driver.quit();
    }
}
