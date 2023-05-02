package by.teachmeskills;

import by.teachmeskills.page.ProductsPage;
import by.teachmeskills.page.Search;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test
    public void checkSearchWithEmptyData() {
        new ProductsPage(driver).open()
                                .changeLanguageToEnglish()
                                .goToSignInPage()
                                .loginAsRegisteredUser();
        Assert.assertTrue(new ProductsPage(driver).isOpened(), "Product Page is not opened.");
        new Search(driver).resultOfSearch("");
        Assert.assertTrue(Search.getMessageForEmpty(), "An error message should be displayed");
    }

    @Test
    public void checkSearchWithValidData() {
        new ProductsPage(driver).open()
                                .changeLanguageToEnglish()
                                .goToSignInPage()
                                .loginAsRegisteredUser();
        Assert.assertTrue(new ProductsPage(driver).isOpened(), "Product Page is not opened.");
        new Search(driver).resultOfSearch("grey");
        Assert.assertTrue(new Search(driver).isOpenedWithValid(), "The result is not found.");
    }

    @Test
    public void checkSearchWithInValidData() {
        new ProductsPage(driver).open()
                                .changeLanguageToEnglish()
                                .goToSignInPage()
                                .loginAsRegisteredUser();
        Assert.assertTrue(new ProductsPage(driver).isOpened(), "Product Page is not opened.");
        new Search(driver).resultOfSearch("lkfhjfjhjghjke;keorh5");
        Assert.assertTrue(new Search(driver).isOpenedWithInValid(), "The result is not found.");
    }
}
