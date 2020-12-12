package pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    By userInceHesap = By.name("uid");

    By passwordInceHesap = By.name("password");

    By titleText =By.className("barone");

    By login = By.name("btnLogin");

    public LoginPage(WebDriver driver){

        this.driver = driver;

    }

    //Set user name in textbox

    public void setUserName(String strUserName){

        driver.findElement(userInceHesap).sendKeys(strUserName);

    }

    //Set password in password textbox

    public void setPassword(String strPassword){

        driver.findElement(passwordInceHesap).sendKeys(strPassword);

    }

    //Click on login button

    public void clickLogin(){

        driver.findElement(login).click();

    }

    //Get the title of Login Page

    public String getLoginTitle(){

        return    driver.findElement(titleText).getText();

    }

    /**

     * This POM method will be exposed in test case to login in the application

     * @param strUserName

     * @param strPassword

     * @return

     */

    public void loginToInceHesap(String strUserName,String strPassword){

        //Fill user name

        this.setUserName(strUserName);

        //Fill password

        this.setPassword(strPassword);

        //Click Login button

        this.clickLogin();
    }

}