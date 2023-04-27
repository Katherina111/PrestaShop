package by.teachmeskills;

import by.teachmeskills.page.CartPage;
import by.teachmeskills.page.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartPageTest extends BaseTest {

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
}
