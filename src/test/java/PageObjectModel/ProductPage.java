package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Iterator;
import java.util.Set;
import java.util.logging.Logger;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    By phoneMenuElement = By.xpath("//div[text()='Telefon']");

    public void clickPhoneMenu() {
        click(phoneMenuElement);
    }

    By productMobilePhoneMenuElement = By.xpath("/html/body/div[3]/main/div[2]/div/div[6]/div[1]/div/div/div/div/div/div/div/div/div/div/div/div/div[1]/div/div/div/div/div/div[2]/div[2]/div/div[1]/div");

    public void clickMobilePhoneMenu() {
        click(productMobilePhoneMenuElement);
    }

    By checkProductNameElement = By.xpath("//div[@class='searchResultSummaryBar-CbyZhv5896ASVcYBLKmx'][1]");

    public void checkProductName() {
        checkElementWithTexts(checkProductNameElement, "samsung, bulduk");
    }

    public void checkCurrentUrlIsSecondResultPage() {
        scrollToTargetPage("&sayfa=2");
        checkUrl("&sayfa=2");
    }

    By fifthProductElement = By.xpath("(//h3[@type='comfort'])[5]");

    public void clickFifthProduct() throws InterruptedException {
        refreshCurrentPage();
        WebElement templateProductElement = findElement(fifthProductElement);
        scrollToElement(templateProductElement);
        Thread.sleep(2000);
        click(fifthProductElement);
        Thread.sleep(3000);
    }


    By likeTheProductElement = By.xpath("//div[contains(text(),'Beğen')]");

    public void likeTheProduct() throws InterruptedException {
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();
        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
            if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                WebElement allSellers = findElement(likeTheProductElement);
                scrollToElement(allSellers);
                click(likeTheProductElement);
            }
        }
    }

    By checkPopUpMessageElement = By.xpath("(//div[normalize-space()='Ürün listenize eklendi.'])");

    public void checkPopUp() {

        checkElementWithText(checkPopUpMessageElement, "ürün listenize eklendi.");
    }

    By getProductNameElement = By.id("product-name");

    public void getProduct() {

    }

    By howerMyAccountElement = By.xpath("//span[contains(text(),'Hesabım')]");
    By likeListElement = By.xpath("//a[contains(text(),'Beğendiklerim')]");

    public void clickLikeList() {
        WebElement myAccount = findElement(howerMyAccountElement);
        action.moveToElement(myAccount).perform();
        click(likeListElement);
    }
}
