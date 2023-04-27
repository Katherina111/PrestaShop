package by.teachmeskills;

import by.teachmeskills.page.Authentication;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AuthenticationStepPersonalDataTest extends BaseTest {

    @Test
    public void authenticateSuccessPersonalInformationStep() {
        new Authentication(driver).open()
                .changeLanguageToEnglish()
                .goToSinInPage();
        Assert.assertTrue(new Authentication(driver).isOpened(), "Authentication page has not been opened");
        new Authentication(driver).getAuthenticationEmail();
        new Authentication(driver).getStepPersonalInformation()
                                  .getAuthenticationPersonalInformation();
        Assert.assertTrue(new Authentication(driver)
                .isOpened(), "Authentication page (step Personal Information) has not been opened");

    }

    @Test(dataProvider = "invalidData")
    public void authenticateNotPersonalInformationStep(String firstName, String lastName, String passwordName, String message) {
        new Authentication(driver).open()
                                  .changeLanguageToEnglish()
                                  .goToSinInPage();
        Assert.assertTrue(new Authentication(driver).isOpened(), "Authentication page has not been opened");
        new Authentication(driver).createAnAccount("123qwerty1234@mail.ru");
        new Authentication(driver).getStepPersonalInformation()
                                  .createAnAccountPersonalInformation(firstName, lastName, passwordName);
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-danger']/p"))
                .isDisplayed(), message);
    }

    @DataProvider
    public Object[][] invalidData() {
        return new Object[][]{
                {"", "", "", "There are 3 errors"},
                {" ", " ", " ", "There are 3 errors"},
                {"Test", " ", " ", "There are 2 errors"},
                {"Test", "Test", "", "There is 1 error"},
                {"Test", "","Test", "There is 1 error"},
                {"","Test", "Test", "There is 1 error"}};
    }
}
