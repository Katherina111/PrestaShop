package by.teachmeskills.page;

import by.teachmeskills.util.testng.PropertiesLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductsPage extends BasePage {

    private static final By PRODUCTS_TITLE = By.xpath("//img[@class='logo img-responsive']");
    private static final By BLOCK_LANGUAGE = By.id("languages-block-top");
    private static final By LANGUAGE_ENGLISH = By.xpath("//ul[@id='first-languages']//span[text()='English']");
    private static final By SIGN_IN = By.xpath("//a[@class='login']");
    private static final By SIGN_OUT = By.xpath("//a[@class='logout']");
    private static final By CART = By.xpath("//div[@class='shopping_cart']");
    private static final By PERSONAL_PAGE = By.xpath("//a[@class='account']");
    private static final By YOUR_LOGO = By.xpath("//img[@class='logo img-responsive']");
    private static final By POPULAR = By.xpath("//a[@class='homefeatured']");
    private static final By BEST_SELLERS = By.xpath("//a[@class='blockbestsellers']");
    private static final By PRODUCT_CARD_LOCATOR = By.xpath("//h5[@itemprop='name']//a[@title='Faded Short Sleeve T-shirts']");
    private static final By ADD_TO_CART_BUTTON_LOCATOR = By.xpath("//span[text()='Add to cart']");
    private static final By PROCEED_TO_CHECKOUT = By.xpath("//div[@class='button-container']//a[@title='Proceed to checkout']");
    private static final By WOMEN_CATEGORY = By.xpath("//a[@href='http://prestashop.qatestlab.com.ua/en/3-women']");
    private static final By DRESSES_CATEGORY = By.xpath("//a[@href='http://prestashop.qatestlab.com.ua/en/8-dresses']");
    private static final By T_SHIRTS_CATEGORY = By.xpath("//a[@href='http://prestashop.qatestlab.com.ua/en/5-tshirts']");
    private static final By ADDED_TO_CART = By.xpath("//i[@class='icon-ok']");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public ProductsPage open() {
        driver.get(PropertiesLoader.loadProperties().getProperty("base.url"));
        isOpened();
        waitForPageLoaded();
        return this;
    }

    public ProductsPage changeLanguageToEnglish() {
        driver.findElement(BLOCK_LANGUAGE).click();
        driver.findElement(LANGUAGE_ENGLISH).click();
        return new ProductsPage(driver);
    }

    public boolean isOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(PRODUCTS_TITLE));
        return driver.findElement(PRODUCTS_TITLE).isDisplayed();
    }

    public LoginPage goToSignInPage() {
        driver.findElement(SIGN_IN).click();
        return new LoginPage(driver);
    }

    public ProductsPage goToSinOutPage() {
        driver.findElement(SIGN_OUT).click();
        return new ProductsPage(driver);
    }

    public CartPage addProductToCart() {
        driver.findElement(PRODUCT_CARD_LOCATOR).click();
        driver.findElement(ADD_TO_CART_BUTTON_LOCATOR).click();
        driver.findElement(PROCEED_TO_CHECKOUT).click();
        return new CartPage(driver);
    }

    public PersonalPage goToPersonalPage() {
        driver.findElement(PERSONAL_PAGE).click();
        return new PersonalPage(driver);
    }

    public ProductsPage goToProductsPage() {
        driver.findElement(YOUR_LOGO).click();
        return new ProductsPage(driver);
    }

    public boolean checkIsDisplayedWomenCategory() {
        return driver.findElement(WOMEN_CATEGORY).isDisplayed();
    }

    public boolean checkIsDisplayedDressesCategory() {
        return driver.findElement(DRESSES_CATEGORY).isDisplayed();
    }

    public boolean checkIsDisplayedTShirtsCategory() {
        return driver.findElement(T_SHIRTS_CATEGORY).isDisplayed();
    }

    public boolean checkIsDisplayedPopularCategory() {
        return driver.findElement(POPULAR).isDisplayed();
    }

    public ProductsPage clickBestSellers() {
        driver.findElement(BEST_SELLERS).click();
        return new ProductsPage(driver);
    }

    public boolean checkProductIsAddedToCart() {
        return driver.findElement(ADDED_TO_CART).isDisplayed();
    }
}
