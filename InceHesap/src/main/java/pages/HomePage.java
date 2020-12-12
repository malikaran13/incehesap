package pages;
import interfaces.IHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.FileNotFoundException;

public class HomePage extends PageObject implements IHomePage {

    By query = By.id("query");

    public HomePage(WebDriver driver){
        super(driver);
    }

    public void acceptCookies(){
        driver.findElement(By.xpath("//*[@class=\"btn btn-primary btn-cerez\"]")).click();
    }

    public void queryProduct(String item){
        driver.findElement(query).sendKeys(item);
    }

    public void selectResultProduct() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/header/div[2]/section/div[1]/div/div/div[2]/ul/li[1]/a/span")).click();
    }

    public String getPriceFromTxt() throws FileNotFoundException {
        String price = super.readFromTxt().get(1);
        return price;
    }

}