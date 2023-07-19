package PageObjectModel;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Logger;

public class HomePage extends BasePage {
    Actions action;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        action = new Actions(driver);
    }



    public void checkHomePage() {
        checkUrl("https://www.hepsiburada.com/");
    }

    By cookieElement = By.id("onetrust-accept-btn-handler");

    public void acceptCookies() throws InterruptedException {
        Thread.sleep(2000);
        click(cookieElement);
    }


    By clickSearchTextBox = By.xpath("(//div[@class='searchBoxOld-M1esqHPyWSuRUjMCALPK'])[1]");

    public void setClickSearchTextBox() {
        click(clickSearchTextBox);
    }
    By productNameElement = By.xpath("//input[@aria-autocomplete='list']");
    public void typeProductName(String productName) {

        sendKey(productNameElement, productName);
    }

    By searchButtonElement = By.xpath("//div[contains(text(),'ARA')]");

    public void clickSearchButton() {
        click(searchButtonElement);
    }

    By loginHoverElement = By.xpath("//span[@title='Giriş Yap']");

    By loginButtonElement = By.xpath("//a[@id='login']");

    public void clickLoginButton() {
        WebElement login = findElement(loginHoverElement);
        action.moveToElement(login).perform();
        click(loginButtonElement);
    }

}
