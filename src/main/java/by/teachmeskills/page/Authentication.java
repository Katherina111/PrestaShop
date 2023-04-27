package by.teachmeskills.page;

import by.teachmeskills.util.testng.PropertiesLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Properties;

public class Authentication extends BasePage {

    private static final By SIGN_IN_BUTTON = By.xpath("//a[@class='login']");
    private static final By AUTHENTICATION_TITLE = By.xpath("//h1[@class='page-heading']");
    private static final By BLOCK_LANGUAGE = By.id("languages-block-top");
    private static final By LANGUAGE_ENGLISH = By.xpath("//ul[@id='first-languages']//span[text()='English']");
    private static final By SIGN_IN = By.xpath("//a[@class='login']");
    private static final By EMAIL_ADDRESS_FIELD = By.name("email_create");
    private static final By BUTTON_CREATE_AN_ACCOUNT = By.id("SubmitCreate");
    private static final By FIRST_NAME = By.id("customer_firstname");
    private static final By LAST_NAME = By.id("customer_lastname");
    private static final By PASSWORD = By.id("passwd");
    private static final By BUTTON_REGISTER = By.id("submitAccount");
    private static final By CREATE_AN_ACCOUNT_TITLE = By.xpath("//h1[@class='page-heading']");

    public static final String EMAIL_USER = "test14786@mail.ru";
    public static final String FIRST_NAME_USER = "Katya";
    public static final String LAST_NAME_USER = "Rewq";
    public static final String PASSWORD_USER = "123456";

    public Authentication(WebDriver driver) {
        super(driver);
    }

    public Authentication open() {
        Properties properties = PropertiesLoader.loadProperties();
        driver.get(properties.getProperty("base.url"));
        driver.findElement(SIGN_IN_BUTTON).click();
        return this;
    }

    public boolean isOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(AUTHENTICATION_TITLE));
        return driver.findElement(AUTHENTICATION_TITLE).isDisplayed();
    }

    public Authentication changeLanguageToEnglish() {
        driver.findElement(BLOCK_LANGUAGE).click();
        driver.findElement(LANGUAGE_ENGLISH).click();
        return new Authentication(driver);
    }

    public Authentication goToSinInPage() {
        driver.findElement(SIGN_IN).click();
        return new Authentication(driver);
    }

    public void getAuthenticationEmail() {
        driver.findElement(EMAIL_ADDRESS_FIELD).sendKeys(EMAIL_USER);
        driver.findElement(BUTTON_CREATE_AN_ACCOUNT).click();
    }

    public Authentication createAnAccount(String emailName) {
        driver.findElement(EMAIL_ADDRESS_FIELD).sendKeys(emailName);
        driver.findElement(BUTTON_CREATE_AN_ACCOUNT).click();
        return new Authentication(driver);
    }

    public Authentication getStepPersonalInformation(){
        driver.findElement(CREATE_AN_ACCOUNT_TITLE).isDisplayed();
        return this;
    }

    public PersonalPage getAuthenticationPersonalInformation() {
        driver.findElement(FIRST_NAME).sendKeys(FIRST_NAME_USER);
        driver.findElement(LAST_NAME).sendKeys(LAST_NAME_USER);
        driver.findElement(PASSWORD).sendKeys(PASSWORD_USER);
        driver.findElement(BUTTON_REGISTER).click();
        return new PersonalPage(driver);
    }

    public PersonalPage createAnAccountPersonalInformation(String firstlName, String lastName, String passwordName) {
        driver.findElement(FIRST_NAME).sendKeys(firstlName);
        driver.findElement(LAST_NAME).sendKeys(lastName);
        driver.findElement(PASSWORD).sendKeys(passwordName);
        driver.findElement(BUTTON_REGISTER).click();
        return new PersonalPage(driver);
    }
}