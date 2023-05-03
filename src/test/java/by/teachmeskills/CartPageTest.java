package by.teachmeskills;

import by.teachmeskills.page.ProductsPage;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CartPageTest extends BaseTest {

    @Test
    public void checkAddProductToCart() {
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.open()
                    .changeLanguageToEnglish()
                    .goToSignInPage()
                    .loginAsRegisteredUser()
                    .goToProductsPage()
                    .addProductToCart();
        assertThat(productsPage.checkProductIsAddedToCart()).as("The product is not added.");
    }
}
