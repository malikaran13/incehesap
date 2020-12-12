import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;

public class TestInceHesap {

    String driverPath = "src\\main\\resources\\drivers\\geckodriver.exe";
    WebDriver driver;

    LoginPage loginPage;
    HomePage homePage;
    ProductPage productPage;
    CartPage cartPage;


    @BeforeTest
    public void setup(){

        System.setProperty("webdriver.gecko.driver", driverPath);
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //- https://www.incehesap.com/ sitesi açılır
        driver.get("https://www.incehesap.com/q/bilgisayar/");

    }

    /**
     *Insert comment!
     */

    @Test(priority=0)
    public void test_incehesap() throws IOException, InterruptedException {
        //Create Login Page object
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);

        //- Ana sayfanın açıldığı kontrol edilir
        String loginPageTitle = loginPage.getLoginTitle();
        Assert.assertEquals(loginPageTitle,"incehesap.com");

        //- Siteye login olunur
        loginPage.loginToInceHesap(loginPage.getUsername(),loginPage.getPassword());

        //- Login işlemi kontrol edilir.
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'Çıkış')]")).isDisplayed());
        homePage.acceptCookies();

        //- Arama kutucuğuna “bilgisayar” kelimesi girilir.
        homePage.queryProduct("bilgisayar");

        //- Sonuca göre sergilenen ürünlerden rastgele bir ürün seçilir.
        homePage.selectResultProduct();

        ////- Seçilen ürünün ürün bilgisi(ürün adı) ve tutar bilgisi text dosyasına yazdırılır.
        productPage.printProductInfoToTxtFile();

        //- Seçilen ürün sepete eklenir.
        productPage.addProductToCart();

        //- Ürün sayfasındaki fiyat ile sepette yer alan ürün fiyatının doğruluğu karşılaştırılır.
        Assert.assertEquals(homePage.getPriceFromTxt(),cartPage.getPriceOnCart());

        //- Adet arttırılarak ürün adedinin 2 olduğu doğrulanır.
        cartPage.raiseQuantity();
        Assert.assertEquals(cartPage.verifyQuantity(),"2 adet");

        //- Ürün sepetten silinerek sepetin boş olduğu kontrol edilir.
        cartPage.removeProduct();
        Assert.assertTrue(cartPage.verifyCartEmpty());
    }

    @AfterTest
    public void tearDown()
    {
        homePage.deleteFile("D:\\mali\\InceHesap\\src\\main\\resources\\data\\ProductInfo.txt");
        driver.quit();
    }
}