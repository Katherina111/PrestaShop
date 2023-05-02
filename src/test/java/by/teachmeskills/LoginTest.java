package by.teachmeskills;

import by.teachmeskills.page.LoginPage;
import by.teachmeskills.page.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void checkValidCredentials() {
        new ProductsPage(driver).open()
                                .changeLanguageToEnglish()
                                .goToSignInPage()
                                .loginAsRegisteredUser();
        Assert.assertTrue(new ProductsPage(driver).isOpened(), "Wrong reaction for valid credentials");
    }

    @Test
    public void checkInvalidCredentialsWithEmptyData() {
        new ProductsPage(driver).open()
                                .changeLanguageToEnglish()
                                .goToSignInPage()
                                .loginWithEmptyData();
            Assert.assertTrue(LoginPage.getErrorMessageOfEmail(), "An error message should be displayed");
    }

    @Test
    public void checkInvalidCredentialsWithoutEmail() {
        new ProductsPage(driver).open()
                                .changeLanguageToEnglish()
                                .goToSignInPage()
                                .loginWithoutEmail();
        Assert.assertTrue(LoginPage.getErrorMessageOfEmail(), "An error message should be displayed");
    }

    @Test
    public void checkInvalidCredentialsWithoutPassword() {
        new ProductsPage(driver).open()
                                .changeLanguageToEnglish()
                                .goToSignInPage()
                                .loginWithoutPassword();
        Assert.assertTrue(LoginPage.getErrorMessageOfPassword(), "An error message should be displayed");
    }
}
