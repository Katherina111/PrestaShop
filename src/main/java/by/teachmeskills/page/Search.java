package by.teachmeskills.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Search extends BasePage {

    private static final By SEARCH_FIELD = By.id("search_query_top");
    private static final By SEARCH_BUTTON = By.name("submit_search");
    private static final By SEARCH_VALIDATION_MESSAGE = By.xpath("//p[@class='alert alert-warning']");
    private static final By VALID_RESULT = By.xpath("//h1[@class='page-heading  product-listing']");
    private static final By INVALID_RESULT = By.xpath("//p[@class='alert alert-warning']");

    public Search(WebDriver driver) {
        super(driver);
    }

    public ProductsPage resultOfSearch(String inputText) {
        driver.findElement(SEARCH_FIELD).sendKeys(inputText);
        driver.findElement(SEARCH_BUTTON).click();
        return new ProductsPage(driver);
    }

    public static boolean getMessageForEmpty() {
        return driver.findElement(SEARCH_VALIDATION_MESSAGE).isDisplayed();
    }

    public boolean isOpenedWithValid() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(VALID_RESULT));
        return driver.findElement(VALID_RESULT).isDisplayed();
    }

    public boolean isOpenedWithInValid() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(INVALID_RESULT));
        return driver.findElement(INVALID_RESULT).isDisplayed();
    }
}
