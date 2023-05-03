package by.teachmeskills.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage{

    private static final By REDIRECT_TO_PRODUCT = By.xpath("//p[@class='product-name']");
    private static final By NAME_OF_PRODUCT = By.xpath("//h1[@itemprop='name']");
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage isOpened() {
        driver.findElement(REDIRECT_TO_PRODUCT).click();
        driver.findElement(NAME_OF_PRODUCT).isDisplayed();
        return new ProductPage(driver);
    }
}
