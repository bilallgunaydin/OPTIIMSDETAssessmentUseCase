package tests;

import PageObjectModel.HomePage;
import PageObjectModel.LoginPage;
import PageObjectModel.ProductPage;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.ExtentManager;

import java.io.IOException;

public class AssignmentTest extends BaseTest {

    HomePage homePage;
    LoginPage loginPage;
    ProductPage productPage;
    ExtentTest test;

    @BeforeClass
    void createSomeInstances() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);

    }

    @Test(priority = 1)
    public void checkHomePage() throws InterruptedException {
        test = ExtentManager.createTest("CheckCurrentUrl");
        homePage.checkHomePage();
        test.log(Status.INFO, "Açılan sayfanın hepsiburada.com olduğu doğrulandı.");
    }

    @Test(priority = 2)
    public void openHomePage() throws InterruptedException {
        test = ExtentManager.createTest("Accept The Cookies");
        homePage.acceptCookies();
        test.log(Status.INFO, "Çerezler Kabul Edildi");
    }


    @Test(priority = 3)
    public void clickLoginButton() {
        test = ExtentManager.createTest("Click Login Button");
        homePage.clickLoginButton();
        test.log(Status.INFO, "Login Ekranına Gidildi.");
    }

    @Test(priority = 4)
    public void login() throws InterruptedException, IOException {
        test = ExtentManager.createTest("Login Done");
        loginPage.login();
        test.log(Status.INFO, "Giriş Yapıldı.");
    }

    @Test(priority = 5)
    public void search_a_product() throws InterruptedException {
        test = ExtentManager.createTest("Search 'samsung'");
        homePage.setClickSearchTextBox();
        homePage.typeProductName("samsung");
        homePage.clickSearchButton();
        test.log(Status.INFO, "ürün Araması Yapıldı.");
    }

    @Test(priority = 6)
    public void clickPhoneMenu() throws InterruptedException {
        test = ExtentManager.createTest("Click Phone Menu");
        productPage.clickPhoneMenu();
        test.log(Status.INFO, "Telefon menüsüne tıklandı");
        Thread.sleep(3000);
    }

    @Test(priority = 7)
    public void clickMobilePhoneMenu() throws InterruptedException {

        test = ExtentManager.createTest("Click Mobile Phone Menu");
        productPage.clickMobilePhoneMenu();
        test.log(Status.INFO, "Cep Telefonu menüsüne tıklandı");
    }

    @Test(priority = 8)
    public void checkProductName() throws InterruptedException {
        test = ExtentManager.createTest("Is the product name 'samsung'");
        productPage.checkProductName();
        test.log(Status.PASS, "Samsung ile ilgili sonuçların geldiği doğrulandı.");
    }

    @Test(priority = 9)
    public void checkCurrentUrlIsSecondResultPage() {
        test = ExtentManager.createTest("Check the url for second result page");
        productPage.checkCurrentUrlIsSecondResultPage();
        test.log(Status.PASS, "2.sonuç sayfasına gelindiği doğrulandı.");
    }

    @Test(priority = 10)
    public void clickFifthProduct() throws InterruptedException {
        test = ExtentManager.createTest("Click fifth product");
        productPage.clickFifthProduct();
        test.log(Status.PASS, "5.ürün açıldı");
    }

    @Test(priority = 11)
    public void likeTheProduct() throws InterruptedException {
        test = ExtentManager.createTest("Like the product");
        productPage.likeTheProduct();
        test.log(Status.PASS, "Ürün beğenildi.");
        Thread.sleep(3000);
    }

    @Test(priority = 12)
    public void checkPopUp() {
        test = ExtentManager.createTest("Check pop up message");
        productPage.checkPopUp();
        test.log(Status.INFO,"Pop up kontrol edildi.");
    }

    @Test(priority = 13)
    public void clickLikeList()
    {
        test=ExtentManager.createTest("Click Like List");
        productPage.clickLikeList();
        test.log(Status.INFO,"Beğendiklerim butonuna basıldı.");
    }
}
