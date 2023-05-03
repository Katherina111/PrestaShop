package by.teachmeskills.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HeaderMenu extends BasePage {

    private static final By CALL_US_NOW = By.xpath("//span[@class='shop-phone']");
    private static final By CONTACT_US = By.xpath("//a[@title='Contact Us']");
    private static final By LANGUAGE = By.id("languages-block-top");
    private static final By CURRENCY = By.xpath("//form[@id='setCurrency']");
    private static final By SIGN_OUT = By.xpath("//a[@class='logout']");
    private static final By FULL_NAME = By.xpath("//a[@class='account']");

    public HeaderMenu(WebDriver driver) {
        super(driver);
    }

    public LoginPage logOut() {
        driver.findElement(SIGN_OUT).click();
        return new LoginPage(driver);
    }

    public boolean isDisplayedCallingNumber() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CALL_US_NOW));
        return driver.findElement(CALL_US_NOW).isDisplayed();
    }

    public boolean isDisplayedContact() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CONTACT_US));
        return driver.findElement(CONTACT_US).isDisplayed();
    }

    public boolean isDisplayedLanguage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LANGUAGE));
        return driver.findElement(LANGUAGE).isDisplayed();
    }

    public boolean isDisplayedCurrency() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CURRENCY));
        return driver.findElement(CURRENCY).isDisplayed();
    }

    public boolean isDisplayedAccountName() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(FULL_NAME));
        return driver.findElement(FULL_NAME).isDisplayed();
    }
}