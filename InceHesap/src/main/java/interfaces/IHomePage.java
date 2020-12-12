package interfaces;

import java.io.FileNotFoundException;

public interface IHomePage {
    void queryProduct(String item);
    void acceptCookies();
    void selectResultProduct() throws InterruptedException;
    String getPriceFromTxt() throws FileNotFoundException;
}
