package tests;

import PageObjectModel.HomePage;
import PageObjectModel.LoginPage;
import com.aventstack.extentreports.Status;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class AssignmentTest extends BaseTest {

    HomePage homePage;
    LoginPage loginPage;

    @BeforeClass
    void createSomeInstances() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        // mainPage = new MainPage(driver);
        //searchPage = new SearchPage(driver);

    }

    @Test(priority = 0)
    public void checkHomePage() throws InterruptedException {
        test = extent.createTest("CheckCurrentUrl");
        homePage.checkHomePage();
        test.log(Status.INFO, "Açılan sayfanın hepsiburada.com olduğu doğrulandı.");
    }

    @Test(priority = 1)
    public void openHomePage() throws InterruptedException {
        test = extent.createTest("Accept The Cookies");
        homePage.acceptCookies();
        test.log(Status.INFO, "Çerezler Kabul Edildi");
    }


    @Test(priority = 2)
    public void clickLoginButton() {
        test = extent.createTest("Click Login Button");
        homePage.clickLoginButton();
        test.log(Status.INFO, "Login Ekranına Gidildi.");
    }

    @Test(priority = 3)
    public void login() throws InterruptedException, IOException {
        test = extent.createTest("Login Done");
        loginPage.login();
        test.log(Status.INFO, "Giriş Yapıldı.");
    }
    @Test(priority = 4)
    public void search_a_product() throws InterruptedException {
        test = extent.createTest("Search 'samsung' ");
        homePage.typeProductName("samsung");
        homePage.clickSearchButton();
        test.log(Status.INFO,"ürün Araması Yapıldı.");
    }
}
