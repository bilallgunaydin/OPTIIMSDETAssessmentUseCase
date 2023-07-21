package PageObjectModel;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.ExcelUtils;

import java.io.IOException;


public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    //static String excelFilePath = "src/test/java/ExcelTools/Login Information.xlsx";
    By userNameElement = By.id("txtUserName");
    By passwordElement = By.id("txtPassword");
    By loginNameElement = By.id("btnLogin");
    By loginUserPasswordElement = By.name("btnEmailSelect");


    public void login() throws InterruptedException, IOException {
        sendKey(userNameElement, ExcelUtils.getUserInformation().getEmail());
        click(loginNameElement);
        Thread.sleep(2000);
        sendKey(passwordElement, ExcelUtils.getUserInformation().getPassword());
        click(loginUserPasswordElement);

    }
}
