package pages;

import constants.LoginPageXPATHConstants;
import interfaces.ILoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageObject implements ILoginPage {




    public LoginPage(WebDriver driver){
        super(driver);
    }

    //Set user name in textbox
    public void setUserName(String strUserName){
        driver.findElement(LoginPageXPATHConstants.USERNAME).sendKeys(strUserName);
    }

    //Set password in password textbox
    public void setPassword(String strPassword){
        driver.findElement(LoginPageXPATHConstants.PASSWORD).sendKeys(strPassword);
    }

    //Click on login button
    public void clickLogin(){
        driver.findElement(LoginPageXPATHConstants.LOGINBTN).click();
    }

    //Get the title of Login Page
    public String getLoginTitle(){
        return    driver.findElement(LoginPageXPATHConstants.TITLE).getText();
    }


    public void openLoginBox(){
        driver.findElement(LoginPageXPATHConstants.LOGINBOX).click();
    }

    public void loginToInceHesap(String strUserName,String strPassword){
        openLoginBox();
        //Fill user name
        this.setUserName(strUserName);
        //Fill password
        this.setPassword(strPassword);
        //Click Login button
        this.clickLogin();
    }

    public boolean verifyLogin(){
        return driver.findElement(By.xpath(LoginPageXPATHConstants.LOGOUTBTN)).isDisplayed();
    }

}