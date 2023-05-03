package by.teachmeskills;

import by.teachmeskills.page.PersonalPage;
import by.teachmeskills.page.ProductsPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PersonalPageTest extends BaseTest {

    @Test
    public void checkDisplayingCategories() {
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.open()
                    .changeLanguageToEnglish()
                    .goToSignInPage()
                    .loginAsRegisteredUser()
                    .goToPersonalPage();
        Assert.assertTrue(productsPage.isOpened(), "Personal Page is redirected.");
        PersonalPage personalPage = new PersonalPage(driver);
        personalPage.getPersonalPage();
        WebElement myOrderHistoryAndDetails = personalPage.getOrderHistoryAndDetails();
        Assert.assertTrue(myOrderHistoryAndDetails.isDisplayed(),
                "Order History and details should be displayed on the page");
        Assert.assertEquals(myOrderHistoryAndDetails.getText(),
                "ORDER HISTORY AND DETAILS", "Order History and details should be correct");

        WebElement myCreditSlips = personalPage.getMyCreditSlips();
        Assert.assertTrue(myCreditSlips.isDisplayed(), "My Credit Slips should be displayed on the page");
        Assert.assertEquals(myCreditSlips.getText(), "MY CREDIT SLIPS",
                "My Credit Slips should be correct");

        WebElement myAddresses = personalPage.getMyAddresses();
        Assert.assertTrue(myAddresses.isDisplayed(), "My Addresses should be displayed on the page");
        Assert.assertEquals(myAddresses.getText(), "MY ADDRESSES",
                "My Addresses should be correct");

        WebElement myPersonalInformation = personalPage.getMyPersonalInformation();
        Assert.assertTrue(myPersonalInformation.isDisplayed(), "My Personal Information should be displayed on the page");
        Assert.assertEquals(myPersonalInformation.getText(), "MY PERSONAL INFORMATION",
                "My Personal Information should be correct");

        WebElement myWishlists = personalPage.getMyWishLists();
        Assert.assertTrue(myWishlists.isDisplayed(), "My Wishlists should be displayed on the page");
        Assert.assertEquals(myWishlists .getText(), "MY WISHLISTS",
                "My Wishlists should be correct");
    }

        @Test
        public void checkRedirectedOnProductsPage() {
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.open()
                    .changeLanguageToEnglish()
                    .goToSignInPage()
                    .loginAsRegisteredUser()
                    .goToPersonalPage();
        PersonalPage personalPage = new PersonalPage(driver);
        personalPage.isRedirectedToHomePage();
        Assert.assertTrue(new ProductsPage(driver).isOpened(), "Error! Products page is not opened.");
    }
}
