package interfaces;

public interface ILoginPage {
    void setUserName(String strUserName);
    void setPassword(String strPassword);
    void clickLogin();
    String getLoginTitle();
    void openLoginBox();
    void loginToInceHesap(String strUserName,String strPassword);
    boolean verifyLogin();
}
