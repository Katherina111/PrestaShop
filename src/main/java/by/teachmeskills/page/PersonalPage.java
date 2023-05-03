package by.teachmeskills.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PersonalPage extends BasePage {

    public static final By ORDER_HISTORY_AND_DETAILS = By.xpath("//*[span='Order history and details']");
    public static final By MY_CREDIT_SLIPS = By.xpath("//*[span='My credit slips']");
    public static final By MY_ADDRESSES = By.xpath("//*[span='My addresses']");
    public static final By MY_PERSONAL_INFORMATION = By.xpath("//*[span='My personal information']");
    public static final By MY_WISHLISTS = By.xpath("//*[span='My wishlists']");
    public static final By MY_ACCOUNT = By.xpath("//h1[@class='page-heading']");
    public static final By BUTTON_HOME = By.xpath("//a[contains(@title, 'Home')]");

    public PersonalPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getOrderHistoryAndDetails() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ORDER_HISTORY_AND_DETAILS));
        return driver.findElement(ORDER_HISTORY_AND_DETAILS);
    }

    public WebElement getMyCreditSlips() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(MY_CREDIT_SLIPS));
        return driver.findElement(MY_CREDIT_SLIPS);
    }

    public WebElement getMyAddresses() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(MY_ADDRESSES));
        return driver.findElement(MY_ADDRESSES);
    }

    public WebElement getMyPersonalInformation() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(MY_PERSONAL_INFORMATION));
        return driver.findElement(MY_PERSONAL_INFORMATION);
    }

    public WebElement getMyWishLists() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(MY_WISHLISTS));
        return driver.findElement(MY_WISHLISTS);
    }

    public PersonalPage getPersonalPage() {
        driver.findElement(MY_ACCOUNT).isDisplayed();
        return new PersonalPage(driver);
    }

    public boolean isOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(MY_ACCOUNT));
        return driver.findElement(MY_ACCOUNT).isDisplayed();
    }

    public ProductsPage isRedirectedToHomePage() {
        driver.findElement(BUTTON_HOME).click();
        return new ProductsPage(driver);
    }
}
