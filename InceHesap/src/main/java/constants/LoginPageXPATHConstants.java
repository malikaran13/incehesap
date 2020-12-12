package constants;

import org.openqa.selenium.By;

public class LoginPageXPATHConstants {
    public static By USERNAME = By.id("top-user-username");
    public static By PASSWORD = By.id("top-user-password");
    public static By TITLE =By.xpath("//*[@class=\"logo\"]/a");
    public static By LOGINBOX = By.className("login");
    public static By LOGINBTN = By.id("btn-ih-giris");
    public static String LOGOUTBTN = "//*[contains(text(),'Çıkış')]";
}
