// package com.example;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class AppTest {

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() throws IOException {
        String excelFilePath = "C:\\Users\\gurum\\Downloads\\Study_Materials\\Java_Projects\\sample1\\src\\main\\resources\\login.xlsx";   // Specify the path of the Excel file       // File file=new File(excelFilePath);
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));     // Create a FileInputStream to read the Excel file

        Workbook workbook = new XSSFWorkbook(inputStream);  // Create a Workbook object for the Excel file
        Sheet sheet = workbook.getSheetAt(0);   // Get the first sheet of the Excel workbook
        int rowCount = sheet.getPhysicalNumberOfRows();      // Get the number of rows in the sheet
        System.out.println(rowCount);
        Object[][] data = new Object[rowCount][2];  // Create a 2D array to store test data  // Subtract 1 for header row
        
        for (int i = 1; i < rowCount; i++) {         // Iterate over all the rows in the Excel sheet (skipping the header row)
            Row row = sheet.getRow(i);
            String username = row.getCell(0).getStringCellValue();      // Get data from columns
            String password = row.getCell(1).getStringCellValue();

            data[i - 1][0] = username;      // Store data in the array
            data[i - 1][1] = password;
            System.out.println(username);
            System.out.println(password);
        }

        workbook.close();       // Close the workbook and input stream
        inputStream.close();
        System.out.println(data);
        return data;
    }


    
    @Test(dataProvider = "loginData")
    public void testLogin(String username, String password) throws Exception {
        String testResult = "Pass"; 
        System.out.println("Logging in with username: " + username + " and password: " + password);     // Perform login using username and password
        
        WebDriverManager.chromedriver().setup();        // Add your test steps/assertions here
        WebDriver driver = new ChromeDriver();      // Initialize ChromeDriver
        driver.get("https://practicetestautomation.com/practice-test-login/");       // Navigate to the login page of your web application

        WebElement usernameField = driver.findElement(By.id("username"));       // Find the username and password fields and enter the provided credentials
        usernameField.sendKeys(username);
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(password);

        WebElement loginButton = driver.findElement(By.id("submit"));       // Find and click the login button
        loginButton.click();
        Thread.sleep(5000);

        driver.quit();          // Close the browser
        writeTestResultToExcel(username, testResult);   // Write test result back to Excel file
    }
    
    public void writeTestResultToExcel(String username, String testResult) throws IOException {
        FileInputStream inputStream = new FileInputStream(new File("C:\\Users\\gurum\\Downloads\\Study_Materials\\Java_Projects\\sample1\\src\\main\\resources\\login.xlsx"));
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
    
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            Cell cell = row.createCell(2); // Create a new cell for test result
            if (row.getCell(0).getStringCellValue().equals(username)) {
                cell.setCellValue(testResult);
                
            }
        }
        inputStream.close();
        FileOutputStream outputStream = new FileOutputStream(new File("C:\\Users\\gurum\\Downloads\\Study_Materials\\Java_Projects\\sample1\\src\\main\\resources\\login.xlsx"));
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
}
