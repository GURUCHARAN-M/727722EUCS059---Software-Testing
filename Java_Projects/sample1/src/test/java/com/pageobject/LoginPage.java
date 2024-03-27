package com.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// import com.relevantcodes.extentreports.model.Log;

public class LoginPage
{
    public WebDriver driver;
    @FindBy(name="uid")
    WebElement userid;

    @FindBy(name="password")
    WebElement pwd;

    @FindBy(name="btnLogin")
    WebElement  btnLogin;

    // constructor
    public LoginPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);

    }
    public  void setUserName(String uname)
    {
       userid.sendKeys(uname);
    }
    public void setPassword(String password)
    {
        pwd.sendKeys(password);
    }
    public void  buttonClick()
    {
        btnLogin.click();
    }


}
