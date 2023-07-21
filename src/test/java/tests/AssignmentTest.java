package tests;

import PageObjectModel.*;
import com.aventstack.extentreports.Status;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.ExtentManager;

import java.io.IOException;

public class AssignmentTest extends BaseTest {

    HomePage homePage;
    LoginPage loginPage;
    ProductPage productPage;
    LikesPage likesPage;
    BasketPage basketPage;


    @BeforeClass
    void createSomeInstances() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        likesPage = new LikesPage(driver);
        basketPage = new BasketPage(driver);
    }

    @Test(priority = 1)
    public void checkHomePage() {
        ExtentManager.createTest("CheckCurrentUrl");
        homePage.checkHomePage();
        ExtentManager.log(Status.INFO, "Açılan sayfanın hepsiburada.com olduğu doğrulandı.");
    }

    @Test(priority = 2)
    public void openHomePage() throws InterruptedException {
       ExtentManager.createTest("Accept The Cookies");
        homePage.acceptCookies();
        ExtentManager.log(Status.INFO, "Çerezler Kabul Edildi");
    }


    @Test(priority = 3)
    public void clickLoginButton() {
        ExtentManager.createTest("Click Login Button");
        homePage.clickLoginButton();
        ExtentManager.log(Status.INFO, "Login Ekranına Gidildi.");
    }

    @Test(priority = 4)
    public void login() throws InterruptedException, IOException {
      ExtentManager.createTest("Login Done");
        loginPage.login();
        ExtentManager.log(Status.INFO, "Giriş Yapıldı.");
    }

    @Test(priority = 5)
    public void search_a_product() {
       ExtentManager.createTest("Search 'samsung'");
        homePage.setClickSearchTextBox();
        homePage.typeProductName("samsung");
        homePage.clickSearchButton();
        ExtentManager.log(Status.INFO, "ürün Araması Yapıldı.");
    }

    @Test(priority = 6)
    public void clickPhoneMenu() throws InterruptedException {
        ExtentManager.createTest("Click Phone Menu");
        productPage.clickPhoneMenu();
        ExtentManager.log(Status.INFO, "Telefon menüsüne tıklandı");
        Thread.sleep(3000);
    }

    @Test(priority = 7)
    public void clickMobilePhoneMenu() {

        ExtentManager.createTest("Click Mobile Phone Menu");
        productPage.clickMobilePhoneMenu();
        ExtentManager.log(Status.INFO, "Cep Telefonu menüsüne tıklandı");
    }

    @Test(priority = 8)
    public void checkProductName() {
        ExtentManager.createTest("Is the product name 'samsung'");
        productPage.checkProductName();
        ExtentManager.log(Status.PASS, "Samsung ile ilgili sonuçların geldiği doğrulandı.");
    }

    @Test(priority = 9)
    public void checkCurrentUrlIsSecondResultPage() {
       ExtentManager.createTest("Check the url for second result page");
        productPage.checkCurrentUrlIsSecondResultPage();
        ExtentManager.log(Status.PASS, "2.sonuç sayfasına gelindiği doğrulandı.");
    }

    @Test(priority = 10)
    public void clickFifthProduct() throws InterruptedException {
        ExtentManager.createTest("Click fifth product");
        productPage.clickFifthProduct();
        ExtentManager.log(Status.PASS, "5.ürün açıldı");
    }

    @Test(priority = 11)
    public void likeTheProduct() throws InterruptedException {
        ExtentManager.createTest("Like the product");
        productPage.likeTheProduct();
        ExtentManager.log(Status.PASS, "Ürün beğenildi.");
        Thread.sleep(3000);
    }

    @Test(priority = 12)
    public void checkPopUpLikeList() {
        ExtentManager.createTest("Check pop up message");
        productPage.checkPopUpLikeList();
        ExtentManager.log(Status.INFO, "Ürünün beğeni listesine eklendiği Pop up mesajı ile kontrol edildi.");
        LikesPage.getProductName = productPage.getProduct();
    }

    @Test(priority = 13)
    public void clickLikeList() {
        ExtentManager.createTest("Click Like List");
        productPage.clickLikeList();
        ExtentManager.log(Status.INFO, "Beğendiklerim butonuna basıldı.");
    }

    @Test(priority = 14)
    public void checkTheLikeList() {
        ExtentManager.createTest("Check The Same Products");
        likesPage.checkEqualProduct();
        ExtentManager.log(Status.INFO, "Ürün sayfasındaki beğenilen ürün ile beğeni sayfasında yer alan ürünün aynı olduğu doğrulandı");
    }

    @Test(priority = 15)
    public void addProductToTheBasket() throws InterruptedException {
        ExtentManager.createTest("Add the product");
        likesPage.addProductToTheBasket();
        ExtentManager.log(Status.INFO, "Beğenilen ürünün üstüne gelinip sepete ekle butonuna basıldı.");
    }

    @Test(priority = 16)
    public void checkPopUpForBasket() throws InterruptedException {
        ExtentManager.createTest("Check The Basket PopUp Message");
        likesPage.checkPopUpLikeList();
        ExtentManager.log(Status.INFO, "Ürünün sepete eklendiği Pop up mesajı ile kontrol edildi.");
    }

    @Test(priority = 17)
    public void goToBasket() {
        ExtentManager.createTest("Click The 'Go To The Basket' Button");
        likesPage.goToBasket();
        ExtentManager.log(Status.INFO, "Sepete gidilmesi için butona basıldı.");
    }

    @Test(priority = 18)
    public void deleteTheProduct() {
        ExtentManager.createTest("Delete the product");
        basketPage.deleteTheProduct();
        ExtentManager.log(Status.INFO, "Ürün sepetten kaldırıldı");
    }

    @Test(priority = 19)
    public void checkTheEmptyBasket() {
        ExtentManager.createTest("Check the Empty Basket");
        basketPage.checkTheEmptyBasket();
        ExtentManager.log(Status.INFO, "Sepetin boş olduğu doğrulandı");
    }
}
