package pages;

import interfaces.ICartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends PageObject implements ICartPage {
    public CartPage(WebDriver driver){
        super(driver);
    }

    public String getPriceOnCart(){
        return driver.findElement(By.xpath("//*[@class=\"price-large\"]")).getText();
    }

    public void raiseQuantity(){
        driver.findElement(By.xpath("//*[@class=\"up btn-to-cart1\"]")).click();
    }

    public String verifyQuantity() throws InterruptedException {
        Thread.sleep(2000);
        return driver.findElement(By.xpath("//*[@class=\"info\"]/em")).getText();
    }

    public void removeProduct(){
        driver.findElement(By.xpath("//a[contains(text(),'Sil')]")).click();
        driver.findElement(By.xpath("//*[@class=\"btn btn-dialog ih-yes\"]")).click();
    }

    public boolean verifyCartEmpty(){
        return driver.findElement(By.xpath("//*[@class=\"tar\"]/span[contains(text(),'Sepetiniz Boş')]")).isDisplayed();
    }

}
