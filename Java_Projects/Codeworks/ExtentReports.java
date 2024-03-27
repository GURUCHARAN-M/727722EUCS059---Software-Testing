// package com.example;
import java.io.File;
// import static org.junit.Assert.assertTrue;
import java.lang.Thread;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
// import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
// import org.openqa.selenium.support.ui.WebDriverWait;
// import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.ExtentReports;
import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * Unit test for simple App.
 */
public class AppTest  {

    static ExtentReports report;
    static ExtentTest test;
    public static WebDriver driver;

    @BeforeTest
    public void beforeClass()
    {
        report=new ExtentReports("C:\\Users\\gurum\\Downloads\\Study_Materials\\Java_Projects\\sample1\\src\\main\\resources\\extentreport.html");
        test=report.startTest("Extent Report");
    }

    @Test
    public void testMethod() throws Exception
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.google.com");
        String title=driver.getTitle();
        if(title.equals("Google"))
        {
            test.log(LogStatus.PASS,"Tile Checked");
        }
        else{
            test.log(LogStatus.FAIL,"Tile Wrong");
            captureScreenshot();
        }
        Thread.sleep(1000);
    }

    @AfterTest
    public void afterClass() throws InterruptedException
    {
        report.endTest(test);
        report.flush();
        driver.quit();
    }

    public void captureScreenshot(){
        try{
           TakesScreenshot screenshot = (TakesScreenshot)driver;
           File src = screenshot.getScreenshotAs(OutputType.FILE);
           File dest = new File("C:\\Users\\gurum\\Downloads\\Study_Materials\\Java_Projects\\sample1\\src\\main\\resources\\extentreportscreenshot.png");
           // String path=dest.getAbsolutePath();
           FileUtils.copyFile(src, dest);
           // test.log(LogStatus.FAIL, "Screenshot below: " + test.addScreenCapture(path));
        //    test.log(LogStatus.FAIL,"screenshot",test.addScreenCapture(dest.getAbsolutePath()));
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

}