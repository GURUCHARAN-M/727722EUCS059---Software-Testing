package com.example;

// import java.io.File;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;
// import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AppTest 
{
    private static final Logger log=Logger.getLogger(AppTest.class);
    @Test
    public void shouldAnswerWithTrue() throws Exception{
        PropertyConfigurator.configure("src/main/resources/log4j.properties");  // TO GET PROPERTY FROM BELOW FILE
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        log.info("Open Google in Chrome Software");     // LOGGING INFO IN PROPERTIES FILE
        driver.get("https://www.google.com");
        log.info("Google Website opened");
        Thread.sleep(5000);
        driver.quit();
    }
}



// CREATE FOLDER 'resources' IN 'src->main'  AND ADD 'log4j.properties' FILES WITH BELOW DATA

// # Define the root logger level and appender
// log4j.rootLogger=INFO, RollingAppender
// 
// # Define the rolling appender
// log4j.appender.RollingAppender=org.apache.log4j.DailyRollingFileAppender
// log4j.appender.RollingAppender.File=logs/app.log
// 
// # Define the rolling appender's layout
// log4j.appender.RollingAppender.layout=org.apache.log4j.PatternLayout
// log4j.appender.RollingAppender.layout.ConversionPattern=%d [%t] %-5p %c - %m%n
//  
// # Define the rolling appender's date pattern for rolling files daily
// log4j.appender.RollingAppender.DatePattern='.'yyyy-MM-dd