// package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AppTest {
    private WebDriver driver;

    @BeforeMethod           // Annotations
    public void setUp() {
        WebDriverManager.chromedriver().setup();    // Initialize WebDriver
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/login");
    }

    @Test               // Annotations
    public void testLogin() {
        driver.findElement(By.id("userName")).sendKeys("testuser");     // Perform login
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.id("login")).click();
        
        // return driver.findElement(By.id("newUser")).getText().contains("New User");     // Verify login successful
    }

    @AfterMethod            // Annotations
    public void close() {
        driver.quit();      // Close the browser
    }
}

