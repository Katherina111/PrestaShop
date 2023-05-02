package by.teachmeskills;

import by.teachmeskills.page.AuthenticationPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AuthenticationPageStepEmailTest extends BaseTest {
    @Test
    public void authenticateSuccessEmailStep() {
        AuthenticationPage authentication = new AuthenticationPage(driver);
        authentication.open()
                      .changeLanguageToEnglish()
                      .goToSignInPage();
        Assert.assertTrue(authentication.isOpened(),"Authentication page has not been opened");
        authentication.getAuthenticationEmail();
        authentication.createAnAccount("qwerty@mail.ru");
        Assert.assertTrue(authentication.isOpened(),"Authentication page (step Email) has not been opened");
    }

    @Test(dataProvider = "invalidEmail")
    public void authenticateNotSuccessEmailStep(String email, String message) {
        AuthenticationPage authentication = new AuthenticationPage(driver);
        authentication.open()
                      .changeLanguageToEnglish()
                      .goToSignInPage()
                      .createAnAccount(email);
        Assert.assertFalse(driver.findElement(By.xpath("//div[@class='alert alert-danger']"))
                                .isDisplayed(), message);
    }

    @DataProvider
    public Object[][] invalidEmail() {
        return new Object[][]{
                {"qwerty@mail.ru", "An account using this email address has already been registered. Please enter a valid password or request a new one."},
                {"", "Empty fields shouldn't be accepted"},
                {" ", "Empty fields shouldn't be accepted"},
                {"1234", "Invalid email address."},
                {"1234@", "Invalid email address."},
                {"4532$^%&^#$", "Invalid email address."},
                {"12455.gmail.com", "Invalid email address."},
                {"12455@gmail", "Invalid email address."}};
    }
}