package interfaces;

public interface IProductPage {
    String getProductName();
    String getProductPrice();
    void printProductInfoToTxtFile();
    void addProductToCart();
}
