package by.teachmeskills;

import by.teachmeskills.page.AuthenticationPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AuthenticationPageStepPersonalDataTest extends BaseTest {

    @Test
    public void authenticateSuccessPersonalInformationStep() {
        AuthenticationPage authentication = new AuthenticationPage(driver);
        authentication.open()
                      .changeLanguageToEnglish()
                      .goToSignInPage();
        Assert.assertTrue(authentication.isOpened(), "Authentication page has not been opened");
        AuthenticationPage authenticationInfo = new AuthenticationPage(driver);
        authenticationInfo.getAuthenticationEmail();
        authenticationInfo.getStepPersonalInformation()
                      .getAuthenticationPersonalInformation();
        Assert.assertTrue(authenticationInfo.isOpened(), "Authentication page (step Personal Information) has not been opened");

    }

    @Test(dataProvider = "invalidData")
    public void authenticateNotPersonalInformationStep(String firstName, String lastName, String passwordName, String message) {
        AuthenticationPage authenticationNotPersonalInfo = new AuthenticationPage(driver);
        authenticationNotPersonalInfo.open()
                                     .changeLanguageToEnglish()
                                     .goToSignInPage();
        Assert.assertTrue(authenticationNotPersonalInfo.isOpened(), "Authentication page has not been opened");
        authenticationNotPersonalInfo.createAnAccount("123qwerty1234@mail.ru");
        authenticationNotPersonalInfo.getStepPersonalInformation()
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
