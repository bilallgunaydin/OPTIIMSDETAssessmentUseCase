package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasketPage extends BasePage {
    public BasketPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    By deleteProductElement = By.xpath("//a[@aria-label='Sepetten Çıkar']");

    public void deleteTheProduct() {
        click(deleteProductElement);
    }

    By checkTheEmptyBasketElement = By.xpath("//h1[contains(text(),'Sepetin şu an boş')]");

    public void checkTheEmptyBasket() {
        checkElementWithText(checkTheEmptyBasketElement, "sepetin şu an boş");
    }
}
