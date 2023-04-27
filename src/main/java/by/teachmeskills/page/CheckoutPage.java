package by.teachmeskills.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    private static final By CHECKOUT_STEP_SUMMARY = By.id("order_step");
    private static final By PROCEED_TO_CHECKOUT_STEP_SUMMARY = By.xpath("//a[span='Proceed to checkout']");
    private static final By PROCEED_TO_CHECKOUT_STEP_ADDRESS = By.xpath("//button[@name='processAddress']");
    private static final By PROCEED_TO_CHECKOUT_STEP_SHIPPING = By.xpath("//button[@name='processCarrier']");
    private static final By TITLE_ADDRESSES = By.xpath("//h1[@class='page-heading']");
    private static final By TITLE_SHIPPING = By.xpath("//h1[@class='page-heading']");
    private static final By CHECKBOX_AGREEMENT = By.xpath("//input[@type='checkbox']");
    private static final By VALIDATION_MESSAGE_EMPTY_CART = By.xpath("//p[@class='alert alert-warning']");
    private static final By VALIDATION_MESSAGE_SHIPPING_WITHOUT_CHECKBOX = By.xpath("//p[@class='fancybox-error']");
    private static final By BUTTON_MINUS_QTY = By.xpath("//i[@class='icon-minus']");
    private static final By TITLE_PAYMENT = By.xpath("//h1[@class='page-heading']");;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public static boolean isOpened() {
        return driver.findElement(CHECKOUT_STEP_SUMMARY).isDisplayed();
    }
    public CheckoutPage checkStepSummaryAndGoToStepAddress() {
        driver.findElement(PROCEED_TO_CHECKOUT_STEP_SUMMARY).click();
        return new CheckoutPage(driver);
    }

    public static boolean isDisplayedTitleAddresses() {
        return driver.findElement(TITLE_ADDRESSES).isDisplayed();
    }

    public CheckoutPage checkStepAddressAndGoToStepShipping() {
        driver.findElement(PROCEED_TO_CHECKOUT_STEP_ADDRESS).click();
        return new CheckoutPage(driver);
    }

    public static boolean isDisplayedTitleShipping() {
        return driver.findElement(TITLE_SHIPPING).isDisplayed();
    }
    public CheckoutPage checkStepShippingAndGoToPayment() {
        driver.findElement(PROCEED_TO_CHECKOUT_STEP_SHIPPING).click();
        driver.findElement(CHECKBOX_AGREEMENT).isSelected();
        return new CheckoutPage(driver);
    }

    public CheckoutPage checkStepShippingWithoutCheckbox() {
        driver.findElement(PROCEED_TO_CHECKOUT_STEP_SHIPPING).click();
        return new CheckoutPage(driver);
    }

    public static boolean isDisplayedValidationMessageCheckbox() {
        return driver.findElement(VALIDATION_MESSAGE_SHIPPING_WITHOUT_CHECKBOX).isDisplayed();
    }

    public static boolean isDisplayedTitlePayment() {
        return driver.findElement(TITLE_PAYMENT).isDisplayed();
    }

    public static boolean isDisplayedValidationMessage() {
        return driver.findElement(VALIDATION_MESSAGE_EMPTY_CART).isDisplayed();
    }

    public CheckoutPage clickMinusOneProduct() {
        driver.findElement(BUTTON_MINUS_QTY).click();
        return new CheckoutPage(driver);
    }

    public CheckoutPage checkTotalPrice() {
        driver.findElement(BUTTON_MINUS_QTY).isDisplayed();
        return new CheckoutPage(driver);
    }
}