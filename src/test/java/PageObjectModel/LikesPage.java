package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LikesPage extends BasePage {

    public LikesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public static String getProductName;
    By checkEqualProductElement = By.xpath("//h3[@data-test-id='product-card-name']");

    public void checkEqualProduct() {
        checkElementWithText(checkEqualProductElement, getProductName);
    }

    By clickBasketElement = By.xpath("//div[contains(text(),'Sepete ekle')]");

    public void addProductToTheBasket() throws InterruptedException {
        WebElement howerTheProductElement = findElement(checkEqualProductElement);
        action.moveToElement(howerTheProductElement).perform();
        Thread.sleep(1000);
        click(clickBasketElement);
    }

    By checkPopUpMessageElement = By.xpath("/html/body/div[3]/div/div/div[2]/div[1]");

    public void checkPopUpLikeList() throws InterruptedException {
        Thread.sleep(1000);
        checkElementWithText(checkPopUpMessageElement, "ürün sepete eklendi");
    }

    By goToBasketElement = By.xpath("//a[normalize-space()='Sepete git']");

    public void goToBasket() {
        click(goToBasketElement);
    }
}
