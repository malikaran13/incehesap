package pages;

import interfaces.ILoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageObject implements ILoginPage {

    By username = By.id("top-user-username");
    By password = By.id("top-user-password");
    By title =By.xpath("//*[@class=\"logo\"]/a");
    By loginBox = By.className("login");
    By login = By.id("btn-ih-giris");


    public LoginPage(WebDriver driver){
        super(driver);
    }

    //Set user name in textbox
    public void setUserName(String strUserName){
        driver.findElement(username).sendKeys(strUserName);
    }

    //Set password in password textbox
    public void setPassword(String strPassword){
        driver.findElement(password).sendKeys(strPassword);
    }

    //Click on login button
    public void clickLogin(){
        driver.findElement(login).click();
    }

    //Get the title of Login Page
    public String getLoginTitle(){
        return    driver.findElement(title).getText();
    }


    public void openLoginBox(){
        driver.findElement(loginBox).click();
    }
    /**
     * This POM method will be exposed in test case to login in the application
     * @param strUserName
     * @param strPassword
     * @return
     */
    public void loginToInceHesap(String strUserName,String strPassword){
        openLoginBox();
        //Fill user name
        this.setUserName(strUserName);
        //Fill password
        this.setPassword(strPassword);
        //Click Login button
        this.clickLogin();
    }

}