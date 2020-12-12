package pages;

import constants.CartPageXPATHConstants;
import interfaces.ICartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends PageObject implements ICartPage {
    public CartPage(WebDriver driver){
        super(driver);
    }

    public String getPriceOnCart(){
        return driver.findElement(By.xpath(CartPageXPATHConstants.PRODUCT_PRICE)).getText();
    }

    public void raiseQuantity(){
        driver.findElement(By.xpath(CartPageXPATHConstants.RAISE_QUANTITY)).click();
    }

    public String verifyQuantity() throws InterruptedException {
        Thread.sleep(2000);
        return driver.findElement(By.xpath(CartPageXPATHConstants.VERIFY_QUANTITY)).getText();
    }

    public void removeProduct(){
        driver.findElement(By.xpath(CartPageXPATHConstants.REMOVE_PRODUCT)).click();
        driver.findElement(By.xpath(CartPageXPATHConstants.REMOVE_SUBMIT)).click();
    }

    public boolean verifyCartEmpty(){
        return driver.findElement(By.xpath(CartPageXPATHConstants.VERIFY_CART_EMPTY)).isDisplayed();
    }

}
