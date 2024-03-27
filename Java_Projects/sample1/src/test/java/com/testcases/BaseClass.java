package com.testcases;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass
{
    public String url="https://demo.guru99.com/v3/index.php";
    public String username="mngr563082";
    public String password="yreqyjY";
    public WebDriver driver;

    @BeforeClass
    public void setup()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        // driver.get(url);
    }
    @AfterClass
    public void close()
    {
        driver.quit();
    }
}
