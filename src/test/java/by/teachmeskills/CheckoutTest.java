package by.teachmeskills;

import by.teachmeskills.page.CartPage;
import by.teachmeskills.page.CheckoutPage;
import by.teachmeskills.page.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    @Test
    public void checkAddProductToCart() {
        new ProductsPage(driver).open()
                .changeLanguageToEnglish()
                .goToSinInPage()
                .loginAsRegisteredUser()
                .goToProductsPage()
                .addProductToCart();
        Assert.assertTrue(new CartPage(driver).isOpened(), "The product is not added.");
    }

    @Test
    public void checkIsDisplayedProductInCart() {
        new ProductsPage(driver).open()
                .changeLanguageToEnglish()
                .goToSinInPage()
                .loginAsRegisteredUser()
                .goToProductsPage()
                .addProductToCart();
        new CartPage(driver).isDisplayedPicture();
        new CartPage(driver).isDisplayedDescription();
        new CartPage(driver).getProductPrice();
        Assert.assertTrue(new CartPage(driver).isOpened(), "The product is not added.");
    }

    @Test
    public void checkIsDeletedProduct() {
        new ProductsPage(driver).open()
                .changeLanguageToEnglish()
                .goToSinInPage()
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
                .goToSinInPage()
                .loginAsRegisteredUser()
                .goToProductsPage()
                .addProductToCart();
        new CheckoutPage(driver).clickMinusOneProduct()
                .checkTotalPrice();
        Assert.assertEquals("26.90", "0.00", "The sum of the expected result is not equal to the sum of the actual result.");
    }

    @Test
    public void checkIsClickableButtonAndRedirectToStepAddress() {
        new ProductsPage(driver).open()
                .changeLanguageToEnglish()
                .goToSinInPage()
                .loginAsRegisteredUser()
                .goToProductsPage()
                .addProductToCart();
        new CheckoutPage(driver).checkStepSummaryAndGoToStepAddress();
        Assert.assertTrue(CheckoutPage.isDisplayedTitleAddresses(), "Error on summary page. Check the data.");
    }

    @Test
    public void checkIsClickableButtonAndRedirectToStepShipping() {
        new ProductsPage(driver).open()
                .changeLanguageToEnglish()
                .goToSinInPage()
                .loginAsRegisteredUser()
                .goToProductsPage()
                .addProductToCart();
        new CheckoutPage(driver).checkStepSummaryAndGoToStepAddress()
                                .checkStepAddressAndGoToStepShipping();
        Assert.assertTrue(CheckoutPage.isDisplayedTitleShipping(), "Error on address page. Check the data.");
    }

    @Test
    public void checkIsClickableButtonAndRedirectToStepPayment() {
        new ProductsPage(driver).open()
                .changeLanguageToEnglish()
                .goToSinInPage()
                .loginAsRegisteredUser()
                .goToProductsPage()
                .addProductToCart();
        new CheckoutPage(driver).checkStepSummaryAndGoToStepAddress()
                                .checkStepAddressAndGoToStepShipping()
                                .checkStepShippingAndGoToPayment();
        Assert.assertTrue(CheckoutPage.isDisplayedTitlePayment(), "Error on shipping page. Check the data.");
    }

    @Test
    public void checkStepShippingWithoutCheckbox() {
        new ProductsPage(driver).open()
                .changeLanguageToEnglish()
                .goToSinInPage()
                .loginAsRegisteredUser()
                .goToProductsPage()
                .addProductToCart();
        new CheckoutPage(driver).checkStepSummaryAndGoToStepAddress()
                .checkStepAddressAndGoToStepShipping()
                .checkStepShippingWithoutCheckbox();
        Assert.assertTrue(CheckoutPage.isDisplayedValidationMessageCheckbox(), "Error on shipping page. Click on checkbox.");
    }
}
