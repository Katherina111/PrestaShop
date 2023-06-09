package by.teachmeskills;

import by.teachmeskills.page.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {

    @Test
    public void checkTheButtonSignOut() {
        new ProductsPage(driver).open()
                                .changeLanguageToEnglish()
                                .goToSignInPage()
                                .loginAsRegisteredUser()
                                .goToSinOutPage()
                                .goToSignInPage();
        Assert.assertTrue(new ProductsPage(driver).isOpened(), "Logout doesn't return user on Login page");
    }
}
