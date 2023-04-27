package by.teachmeskills;

import by.teachmeskills.page.PersonalPage;
import by.teachmeskills.page.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PersonalPageTest extends BaseTest {

    @Test
    public void checkDisplayingCategories() {
        new ProductsPage(driver).open()
                .changeLanguageToEnglish()
                .goToSinInPage()
                .loginAsRegisteredUser()
                .goToPersonalPage();
        Assert.assertTrue(new ProductsPage(driver).isOpened(), "Personal Page is redirected.");
        new PersonalPage(driver).getPersonalPage().checkIsDisplayedOrderHistoryAndDetails();
        new PersonalPage(driver).checkIsDisplayedMyCreditSlips();
        new PersonalPage(driver).checkIsDisplayedMyAddresses();
        new PersonalPage(driver).checkIsDisplayedMyPersonalInformation();
        new PersonalPage(driver).checkIsDisplayedMyWishLists();
        Assert.assertTrue(new PersonalPage(driver).isOpened(), "There are not all categories.");
        new PersonalPage(driver).isRedirectedToHomePage();
        Assert.assertTrue(new PersonalPage(driver).isOpened(), "The Home Page has not been working.");
    }
}
