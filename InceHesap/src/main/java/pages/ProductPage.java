package pages;

import interfaces.IProductPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends PageObject implements IProductPage {

    public ProductPage(WebDriver driver){
        super(driver);
    }
    public String getProductName(){
        return driver.findElement(By.xpath("//*[@class=\"detail\"]/h1")).getText();
    }

    public String getProductPrice(){
        return driver.findElement(By.xpath("//*[@class=\"arti-indirimli-fiyat cur\"]")).getText();
    }

    public void printProductInfoToTxtFile(){
        super.printToTxt(getProductName());
        super.printToTxt(getProductPrice());
    }

    public void addProductToCart(){
        driver.findElement(By.xpath("//*[@class=\"btn btn-to-cart\"]")).click();
    }
}
