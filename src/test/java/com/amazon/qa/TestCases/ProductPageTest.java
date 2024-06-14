package com.amazon.qa.TestCases;

import com.amazon.qa.Base.TestBase;
import com.amazon.qa.PageActions.ProductPageActions;
import com.amazon.qa.PageActions.ShoePageActions;
import com.amazon.qa.Utill.Utils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

public class ProductPageTest extends TestBase  {
    ProductPageActions productPageActions;
    ShoePageActions shoePageActions;
    public String ExpectedCount;
    ExtentReports extent;
    ExtentSparkReporter extentSparkReporter;
    ExtentTest extentTest;
    public ProductPageTest() {
        super();
    }

    @BeforeTest
    public void setExtent(){
        extent = new ExtentReports();
        extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/ExtentReport.html");
        extent.attachReporter(extentSparkReporter);
        extent.setSystemInfo("Host Name", "Gowtham");
        extent.setSystemInfo("User Name", "Gowtham Gbook");
        extent.setSystemInfo("Environment", "QA");

    }

    @AfterTest
    public void endReport() throws IOException {
        extent.flush();
        Desktop.getDesktop().browse(new File("/test-output/ExtentReport.html").toURI());
        //extent.close();
    }


    @BeforeMethod
    public void setup(Method method) throws IOException {
        initializer();
        extentTest = extent.createTest(method.getName());
        shoePageActions = new ShoePageActions();
        productPageActions = new ProductPageActions();
        shoePageActions.hoverToRatingIcon();
       ExpectedCount = shoePageActions.getReviewCount();
       productPageActions = shoePageActions.clickSeeMoreReview();
    }

    @Test
    public void ProductReviewCountTest(Method m ) {
       // extent.createTest(m.getName());
        String ActualCount = productPageActions.GetProductRatingCount();
        Assert.assertEquals(ActualCount, ExpectedCount);



    }

    @Test
    public void SeeMoreReviewsLinkTest() throws InterruptedException {
        productPageActions.clickSeeMoreReviewLink();
    }

    @AfterMethod
        public void tearDown(ITestResult result) throws IOException{

            if(result.getStatus()==ITestResult.FAILURE){
                extentTest.fail( "TEST CASE FAILED IS "+result.getName()); //to add name in extent report
                extentTest.fail( "TEST CASE FAILED IS "+result.getThrowable()); //to add error/exception in extent report

                String screenshotPath = Utils.getScreenshot(driver, result.getName());
                extentTest.info("failed", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
                extentTest.info("ScreenShot added");//to add screenshot in extent report
                //extentTest.log(LogStatus.FAIL, extentTest.addScreencast(screenshotPath)); //to add screencast/video in extent report
            }
            else if(result.getStatus()==ITestResult.SKIP){
                extentTest.skip("Test Case SKIPPED IS " + result.getName());
            }
            else if(result.getStatus()==ITestResult.SUCCESS){
                extentTest.pass("Test Case PASSED IS " + result.getName());

            }


           //extent.endTest(extentTest);

        driver.quit();
    }

}
