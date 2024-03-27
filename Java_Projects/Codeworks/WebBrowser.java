// package com.example;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.chrome.ChromeOptions;
// import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
// PASTE THIS FILE IN APPTEST.JAVA FILE TO OPEN BROWSER
public class AppTest {
    @Test
    public static void main(String[] args) throws InterruptedException { 

        WebDriverManager.chromedriver().setup();            //      ChromeOptions co=new ChromeOptions();       IN PORTAL
        WebDriver driver = new ChromeDriver();                  //      driver=new RemoteWebDriver("http://localhost:4444/",co);    IN PORTAL
        driver.get("https://www.google.com/");

        driver.manage().window().maximize();  // Maximizes the window of browser
        Thread.sleep(5000);         // To wait for some time
        System.out.println("Hello World!");



        
        // BROWSER COMMANDS
        String title=driver.getTitle();         // Get the page
        String url=driver.getCurrentUrl();      // Get current URL

        String page_source = driver.getPageSource();        // Will return the page source
        int len_page_source=page_source.length();       // To return length of page source




        // NAVIGATION COMMANDS
        driver.navigate().back();     // Navigates back to previous page
        driver.navigate().forward();   // Navigates forward to next page
        
        driver.navigate().refresh();           // Refreshes the webpage
        int hash_code=driver.navigate().hashCode();           // Returns hash code of the document



        // WEB SELECTORS
        WebElement m = driver.findElement(By.id("input"));   // Find element by its id
        m.sendKeys("Automation Testing");

        driver.findElement(By.name("username")).click();            // Click on an element by name attribute
        driver.findElement(By.className("cta-button"));          // Finds  elements by their class name

        driver.findElement(By.linkText("Gmail")).click();       // Find element by Link (href)
        driver.findElement(By.xpath(""));
        driver.findElement(By.cssSelector("#link1"));                       // Finds the first element that matches




        // WEB ELEMENTS
        // Input Text Box
        driver.findElement(By.id("inputBoxId")).sendKeys("Text to input");
        String text = driver.findElement(By.id("inputBoxId")).getText();
        driver.findElement(By.id("inputBoxId")).clear();

        // Button
        driver.findElement(By.id("buttonId")).click();
        driver.findElement(By.id("buttonId")).submit();

        // Checkbox
        driver.findElement(By.id("checkboxId")).click();
        boolean isSelected = driver.findElement(By.id("checkboxId")).isSelected();

        // Radio Button
        driver.findElement(By.id("radioButtonId")).click();
        boolean isSelectedRadio = driver.findElement(By.id("radioButtonId")).isSelected();

        // Dropdown
        Select select = new Select( driver.findElement(By.id("dropdownId")));
        select.selectByIndex(0);
        select.selectByValue("value");
        select.selectByVisibleText("text");

        

        // WEB ACTIONS 
        // Mouse Actions
        Actions actions = new Actions(driver);
        WebElement d = driver.findElement(By.id("dropdownId"));
        actions.click(d).perform();
        actions.doubleClick(d).perform();
        actions.contextClick(d).perform();
        actions.moveToElement(d).perform();
        actions.clickAndHold(d).perform();
        actions.dragAndDrop(d, d).perform();
        
        // Keyboard Actions
        Actions.sendKeys("Text to input").perform();
        Actions.sendKeys(Keys.ENTER).perform();



        // WEB HANDLING
        // Window Handling
        String windowHandle = driver.getWindowHandle();
        driver.getWindowHandles();
        driver.switchTo().window(windowHandle);
        
        // Frame Handling
        driver.switchTo().frame(0);
        driver.switchTo().frame("frameName");
        driver.switchTo().frame(frameElement);
        
        // Alert Handling
        driver.switchTo().alert().dismiss();
        driver.switchTo().alert().accept();
        String alertText = driver.switchTo().alert().getText();
        driver.switchTo().alert().sendKeys("Text");


        System.out.println();
    }
}

