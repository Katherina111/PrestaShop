package by.teachmeskills.page;

import by.teachmeskills.util.testng.PropertiesLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Properties;


public class LoginPage extends BasePage{

    Properties properties = PropertiesLoader.loadProperties();
    String login = properties.getProperty("login");
    String password = properties.getProperty("password");

    private static final By EMAIL_ADDRESS = By.id("email");
    private static final By PASSWORD = By.id("passwd");
    private static final By SIGN_IN_BUTTON = By.id("SubmitLogin");
    public static final By PASSWORD_ERROR = By.xpath("//li[text()='Password is required.']");
    public static final By EMAIL_ADDRESS_ERROR = By.xpath("//li[text()='An email address required.']");

    private Logger log = LogManager.getLogger(LoginPage.class);

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage open() {
        Properties properties = PropertiesLoader.loadProperties();
        driver.get(properties.getProperty("base.url"));
        return this;
    }

    public boolean isOpened() {
        return driver.findElement(SIGN_IN_BUTTON).isDisplayed();
    }

    public ProductsPage loginAsRegisteredUser() {
        driver.findElement(EMAIL_ADDRESS).sendKeys(login);
        driver.findElement(PASSWORD).sendKeys(password);
        driver.findElement(SIGN_IN_BUTTON).click();
        return new ProductsPage(driver);
    }

    public LoginPage loginWithEmptyData() {
        driver.findElement(SIGN_IN_BUTTON).click();
        return new LoginPage(driver);
    }

    public LoginPage loginWithoutEmail() {
        driver.findElement(PASSWORD).sendKeys(password);
        driver.findElement(SIGN_IN_BUTTON).click();
        return new LoginPage(driver);
    }

    public LoginPage loginWithoutPassword() {
        driver.findElement(EMAIL_ADDRESS).sendKeys(login);
        driver.findElement(SIGN_IN_BUTTON).click();
        return new LoginPage(driver);
    }

    public static boolean getErrorMessageOfEmail() {
        return driver.findElement(EMAIL_ADDRESS_ERROR).isDisplayed();
    }

    public static boolean getErrorMessageOfPassword() {
        return driver.findElement(PASSWORD_ERROR).isDisplayed();
    }
}
