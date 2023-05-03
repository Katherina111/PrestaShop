package by.teachmeskills;

import by.teachmeskills.page.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsPageTest extends BaseTest {

    @Test
    public void checkCategoriesOnProductsPage() {
        new ProductsPage(driver).open()
                                .changeLanguageToEnglish()
                                .goToSignInPage()
                                .loginAsRegisteredUser();
        Assert.assertTrue(new ProductsPage(driver).isOpened(), "Product Page is not opened.");
        new ProductsPage(driver).goToProductsPage();
        new ProductsPage(driver).checkIsDisplayedWomenCategory();
        new ProductsPage(driver).checkIsDisplayedDressesCategory();
        new ProductsPage(driver).checkIsDisplayedTShirtsCategory();
        Assert.assertTrue(new ProductsPage(driver).isOpened(), "There are not all categories.");
    }

    @Test
    public void checkDefaultPopularProducts() {
        new ProductsPage(driver).open()
                                .changeLanguageToEnglish()
                                .goToSignInPage()
                                .loginAsRegisteredUser();
        Assert.assertTrue(new ProductsPage(driver).isOpened(), "Product Page is not opened.");
        new ProductsPage(driver).goToProductsPage();
        new ProductsPage(driver).checkIsDisplayedPopularCategory();
        Assert.assertTrue(new ProductsPage(driver).isOpened(), "There are not all categories.");
    }

    @Test
    public void checkClickableBestSellers() {
        new ProductsPage(driver).open()
                .changeLanguageToEnglish()
                .goToSignInPage()
                .loginAsRegisteredUser();
        Assert.assertTrue(new ProductsPage(driver).isOpened(), "Product Page is not opened.");
        new ProductsPage(driver).goToProductsPage();
        new ProductsPage(driver).clickBestSellers();
        Assert.assertTrue(new ProductsPage(driver).isOpened(), "There are not all categories.");
    }
}
