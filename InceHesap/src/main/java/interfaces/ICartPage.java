package interfaces;

public interface ICartPage {
    String getPriceOnCart();
    void raiseQuantity();
    String verifyQuantity() throws InterruptedException;
    void removeProduct();
    boolean verifyCartEmpty();
}
