package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;

import org.testng.annotations.BeforeSuite;
import utils.ExtentManager;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;
    static ExtentReports extent;


    @BeforeSuite
    public void setup() {
        extent = ExtentManager.getInstance();
        if (driver == null) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            chromeOptions.addArguments("--disable-popup-blocking");
            chromeOptions.addArguments("--disable-notifications");
            chromeOptions.addArguments("--incognito");
            chromeOptions.addArguments("--start-maximized");
            chromeOptions.addArguments("--ignore-certificate-errors");
            chromeOptions.addArguments("--allow-insecure-localhost");
            chromeOptions.addArguments("--acceptInsecureCerts");
            chromeOptions.addArguments("--disable-blink-features=AutomationControlled");
            chromeOptions.addArguments("--disable-extensions");
            chromeOptions.addArguments("--remote-allow-origins=*");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(chromeOptions);
            driver.get("https://www.hepsiburada.com/");
            driver.manage().window().maximize();

        }
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
        extent.flush();
    }
}