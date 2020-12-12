package pages;

import constants.ProductPageXPATHConstants;
import interfaces.IProductPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends PageObject implements IProductPage {

    public ProductPage(WebDriver driver){
        super(driver);
    }
    public String getProductName(){
        return driver.findElement(By.xpath(ProductPageXPATHConstants.PRODUCT_NAME)).getText();
    }

    public String getProductPrice(){
        return driver.findElement(By.xpath(ProductPageXPATHConstants.PRODUCT_PRICE)).getText();
    }

    public void printProductInfoToTxtFile(){
        super.printToTxt(getProductName());
        super.printToTxt(getProductPrice());
    }

    public void addProductToCart(){
        driver.findElement(By.xpath(ProductPageXPATHConstants.ADD_TO_CART)).click();
    }
}
