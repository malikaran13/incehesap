package pages;
import constants.HomePageXPATHConstants;
import interfaces.IHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.FileNotFoundException;

public class HomePage extends PageObject implements IHomePage {

    public HomePage(WebDriver driver){
        super(driver);
    }

    public void acceptCookies(){
        driver.findElement(By.xpath(HomePageXPATHConstants.ACCEPT_COOKIES)).click();
    }

    public void queryProduct(String item){
        driver.findElement(By.id("query")).sendKeys(item);
    }

    public void selectResultProduct() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(HomePageXPATHConstants.RESULT_PRODUCT)).click();
    }

    public String getPriceFromTxt() throws FileNotFoundException {
        String price = super.readFromTxt().get(1);
        return price;
    }

}