package by.teachmeskills;

import by.teachmeskills.page.CartPage;
import by.teachmeskills.page.CheckoutPage;
import by.teachmeskills.page.ProductsPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    @Test
    public void checkAddProductToCart() {
        new ProductsPage(driver).open()
                .changeLanguageToEnglish()
                .goToSignInPage()
                .loginAsRegisteredUser()
                .goToProductsPage()
                .addProductToCart();
        Assert.assertTrue(new CartPage(driver).isOpened(), "The product is not added.");
    }

    @Test
    public void checkIsDisplayedProductInCart() {
        new ProductsPage(driver).open()
                .changeLanguageToEnglish()
                .goToSignInPage()
                .loginAsRegisteredUser()
                .goToProductsPage()
                .addProductToCart();
        CartPage cartPage = new CartPage(driver);
        cartPage.isDisplayedPicture();
        cartPage.isDisplayedDescription();
        cartPage.getProductPrice();
        Assert.assertTrue(cartPage.isOpened(), "The product is not added.");
    }

    @Test
    public void checkIsDeletedProduct() {
        new ProductsPage(driver).open()
                .changeLanguageToEnglish()
                .goToSignInPage()
                .loginAsRegisteredUser()
                .goToProductsPage()
                .addProductToCart();
        new CartPage(driver).removeProductFromCart()
                .checkout();
        Assert.assertTrue(CheckoutPage.isDisplayedValidationMessage(), "An error message should be displayed");
    }

    @Test
    public void checkIsQty0() {
        new ProductsPage(driver).open()
                .changeLanguageToEnglish()
                .goToSignInPage()
                .loginAsRegisteredUser()
                .goToProductsPage()
                .addProductToCart();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.clickMinusOneProduct();
        Assert.assertEquals(checkoutPage.checkTotalPrice(), "0.00",
                "The sum of the expected result is not equal to the sum of the actual result.");
    }

    @Test
    public void checkIsClickableButtonAndRedirectToStepAddress() {
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.open()
                    .changeLanguageToEnglish()
                    .goToSignInPage()
                    .loginAsRegisteredUser()
                    .goToProductsPage()
                    .addProductToCart();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.checkStepSummaryAndGoToStepAddress();
        Assert.assertTrue(driver.findElement(By.xpath("//h1[@class='page-heading']"))
                .isDisplayed(), "Error on summary page. Check the data.");
    }

    @Test
    public void checkIsClickableButtonAndRedirectToStepShipping() {
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.open()
                    .changeLanguageToEnglish()
                    .goToSignInPage()
                    .loginAsRegisteredUser()
                    .goToProductsPage()
                    .addProductToCart();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.checkStepSummaryAndGoToStepAddress()
                    .checkStepAddressAndGoToStepShipping();
        Assert.assertTrue(driver.findElement(By.xpath("//h1[@class='page-heading']"))
                .isDisplayed(), "Error on address page. Check the data.");
    }

    @Test
    public void checkIsClickableButtonAndRedirectToStepPayment() {
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.open()
                    .changeLanguageToEnglish()
                    .goToSignInPage()
                    .loginAsRegisteredUser()
                    .goToProductsPage()
                    .addProductToCart();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.checkStepSummaryAndGoToStepAddress()
                                .checkStepAddressAndGoToStepShipping()
                                .checkStepShippingAndGoToPayment();
        Assert.assertTrue(driver.findElement(By.xpath("//h1[@class='page-heading']"))
                .isDisplayed(), "Error on shipping page. Check the data.");
    }

    @Test
    public void checkStepShippingWithoutCheckbox() {
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.open()
                    .changeLanguageToEnglish()
                    .goToSignInPage()
                    .loginAsRegisteredUser()
                    .goToProductsPage()
                    .addProductToCart();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.checkStepSummaryAndGoToStepAddress()
                    .checkStepAddressAndGoToStepShipping()
                    .checkStepShippingWithoutCheckbox();
        Assert.assertTrue(CheckoutPage.isDisplayedValidationMessageCheckbox(), "Error on shipping page. Click on checkbox.");
    }
}
