package by.teachmeskills;

import by.teachmeskills.page.Authentication;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AuthenticationStepEmailTest extends BaseTest {
    @Test
    public void authenticateSuccessEmailStep() {
        new Authentication(driver).open()
                                  .changeLanguageToEnglish()
                                  .goToSinInPage();
        Assert.assertTrue(new Authentication(driver).isOpened(),"Authentication page has not been opened");
        new Authentication(driver).getAuthenticationEmail();
        new Authentication(driver).createAnAccount("qwerty@mail.ru");
        Assert.assertTrue(new Authentication(driver).isOpened(),"Authentication page (step Email) has not been opened");
    }

    @Test(dataProvider = "invalidEmail")
    public void authenticateNotSuccessEmailStep(String email, String message) {
        new Authentication(driver).open()
                                  .changeLanguageToEnglish()
                                  .goToSinInPage()
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