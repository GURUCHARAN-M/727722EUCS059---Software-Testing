package com.testcases;

import org.testng.annotations.Test;

import com.example.AppTest;
import com.pageobject.LoginPage;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoginTest extends BaseClass
{
    static Logger log =Logger.getLogger(AppTest.class);
    @Test
    public void firstTest() throws InterruptedException
    {
        PropertyConfigurator.configure("F:\\Java\\New folder\\basic_hybrid\\src\\test\\java\\com\\resource\\log4j.properties");
        driver.get(url);
        log.info("Opening Browser");
        Thread.sleep(5000);
        LoginPage login = new LoginPage(driver);
        login.setUserName(username);
        log.info("UserName Entered Succesfully");
        login.setPassword(password);
        log.info("Password Entered Succesfully");
        login.buttonClick();
    }

    

}
