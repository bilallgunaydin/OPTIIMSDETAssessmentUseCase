package PageObjectModel;

import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.ExcelUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Logger;

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
        /*FileInputStream inputStream = new FileInputStream(excelFilePath);
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        Cell Cell_UserName = null;
        Cell Cell_Password = null;
        for (Row row : sheet) {
            if (row.getRowNum() == 0) continue; //hearders
            {
                Cell_UserName = row.getCell(0);
                Cell_Password = row.getCell(1);
            }
        }

         */
        sendKey(userNameElement, ExcelUtils.getUserInformation().getEmail());
        click(loginNameElement);
        Thread.sleep(2000);
        sendKey(passwordElement, ExcelUtils.getUserInformation().getPassword());
        click(loginUserPasswordElement);
        // workbook.close();
    }
}
