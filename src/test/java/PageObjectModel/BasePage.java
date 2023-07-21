package PageObjectModel;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import java.util.List;


public abstract class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;
    Actions action;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        action = new Actions(driver);
    }

    /**
     * @param key
     * @return WebElement
     */
    public WebElement findElement(By key) {
        WebElement element = presenceElement(key);
        scrollToElement(element);
        return element;
    }

    /**
     * @param key
     * @return List<WebElement>
     */
    public List<WebElement> findElements(By key) {
        List<WebElement> elements = presenceElements(key);
        scrollToElement(elements.get(0));
        return elements;
    }

    /**
     * @param key
     */


    public void click(By key) {
        wait.until(ExpectedConditions.elementToBeClickable(key)).click();
    }


    /**
     * @param key
     * @param text
     */
    public void sendKey(By key, String text) {
        wait.until(ExpectedConditions.elementToBeClickable(key)).clear();
        wait.until(ExpectedConditions.elementToBeClickable(key)).sendKeys(text);
    }

    public String getText(By key) {
        WebElement element = findElement(key);
        if (element != null)
            return findElement(key).getText();
        return null;
    }


    /**
     * @param text
     */
    public void checkUrl(String text) {
        Assert.assertTrue(driver.getCurrentUrl().contains(text));
    }



    /**
     * @param key
     * @param text
     */
    public void checkElementWithText(By key, String text) {
        boolean find = false;
        List<WebElement> elements = findElements(key);
        for (WebElement element : elements) {
            if (element.getText().toLowerCase().contains(text)) {
                find = true;
                break;
            }
        }
        Assert.assertEquals(true, find);
    }

    /**
     * @param key
     * @param text
     */
    public void checkElementWithTexts(By key, String text) {
        boolean find = false;
        String[] keywords = text.toLowerCase().split(",");
        WebElement element = findElement(key);
        String regex = ".*" + String.join(".*", keywords) + ".*";
        if (element.getText().toLowerCase().matches(regex))
            find = true;

        Assert.assertEquals(true, find);
    }




    /**
     * @param key
     * @return WebElement
     */
    public WebElement presenceElement(By key) {
        WebElement element = null;
        try {
            element = wait.until(ExpectedConditions.presenceOfElementLocated(key));
        } catch (TimeoutException ignored) {

        }
        return element;
    }

    /**
     * @param key
     * @return List<WebElement>
     */
    public List<WebElement> presenceElements(By key) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(key));
    }

    /**
     * @param element
     */
    public void scrollToElement(WebElement element) {
        if (element != null) {
            String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                    + "var elementTop = arguments[0].getBoundingClientRect().top;" + "window.scrollBy(0, elementTop-(viewPortHeight/2));";
            ((JavascriptExecutor) driver).executeScript(scrollElementIntoMiddle, element);
        }

    }

    public void scrollToTargetPage(String targetPageKeywords) {
        while (!driver.getCurrentUrl().contains(targetPageKeywords)) {
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 200);");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void refreshCurrentPage() throws InterruptedException {
        driver.navigate().refresh();
        Thread.sleep(3000);
    }

}
