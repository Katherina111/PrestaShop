package by.teachmeskills.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {

    private static final By CART_TITLE = By.id("cart_title");
    private static final By NAME_DESCRIPTION = By.xpath("//p[@class='product-name']/ancestor::td[@class='cart_description']");
    private static final By PRICE_PRODUCT = By.xpath("//span[@class='price']");
    private static final By BUTTON_PROCEED_TO_CHECKOUT = By.xpath("//a[span='Proceed to checkout']");
    private static final By REMOVE_BUTTON = By.xpath("//i[@class='icon-trash']");
    private static final By PICTURE_PRODUCT = By.xpath("//td[@class='cart_product']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CART_TITLE));
        return driver.findElement(CART_TITLE).isDisplayed();
    }

    public boolean isDisplayedDescription() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(NAME_DESCRIPTION));
        return driver.findElement(NAME_DESCRIPTION).isDisplayed();
    }

    public boolean isDisplayedPicture() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(PICTURE_PRODUCT));
        return driver.findElement(PICTURE_PRODUCT).isDisplayed();
    }

    public boolean getProductPrice() {
        return driver.findElement(PRICE_PRODUCT).isDisplayed();
    }

    public CheckoutPage checkout() {
        driver.findElement(BUTTON_PROCEED_TO_CHECKOUT).click();
        return new CheckoutPage(driver);
    }

    public CartPage removeProductFromCart() {
        driver.findElement(REMOVE_BUTTON).click();
        return this;
    }
}
