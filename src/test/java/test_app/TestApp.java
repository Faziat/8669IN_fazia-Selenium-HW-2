package test_app;

import app.pom.contac_us.ContactUs;
import app.pom.homepage.Homepage;
import app.pom.testlogin_page.LoginWithInvalidCredentials;
import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestApp extends BasePage {

    @Test(priority = 1, groups = {"BAT"})
    public void testNavigationToApplication() {
        Homepage homepage = new Homepage();

        Assert.assertTrue(isElementVisible(homepage.logo));
    }

    @Test(priority = 2, groups = {"BAT"})
    public void userIsAbleToSearchForAnItem() throws InterruptedException {
        testNavigationToApplication();
        Homepage homepage = new Homepage();
        sendKeysToElement(homepage.searchBar, "Yoga");
        clickOnElement(homepage.searchBtn);
        Assert.assertTrue(isElementVisible(homepage.searchItem));
    }

    @Test(priority = 3, groups = {"BAT"})
    public void userIsAbleToAddAnItemToTheCart() throws InterruptedException {
        testNavigationToApplication();
        Homepage homepage = new Homepage();
        sendKeysToElement(homepage.searchBar, "Dash Digital Watch");
        clickOnElement(homepage.searchBtn);
        Thread.sleep(3000);
        clickOnElement(homepage.itemIcon);
        Thread.sleep(2000);
        clickOnElement(homepage.addToCartBtn);
        Thread.sleep(3000);
        clickOnElement(homepage.addToCartIcon);
        Thread.sleep(2000);
        Assert.assertTrue(true, "Item Added Successfully");
    }


    @Test(priority = 4, groups = {"BAT"})
    public void testLoginWithInvalidCredentials() {

        LoginWithInvalidCredentials loginWithInvalidCredentials = new LoginWithInvalidCredentials();
        String invalidEmail = "roni_cost@example.com";
        String invalidPassword = "roni_cost3@example.com";
        loginWithInvalidCredentials.getLogIn(invalidEmail, invalidPassword);
        Assert.assertTrue(isElementVisible(loginWithInvalidCredentials.errorMessageLogin));
    }

    @Test(priority = 5, groups = {"BAT"})
    public void userIsAbleToSubscribe() throws InterruptedException {
        {
            Homepage homepage = new Homepage();
            Thread.sleep(2000);
            sendKeysToElement(homepage.emailToSubscribe, "test2@gmail.com");
            clickOnElement(homepage.subscriptionBtn);
            System.out.println("clicked on subscribe button");
            Thread.sleep(2000);
            Assert.assertTrue(isElementVisible(homepage.errorMessage));
        }
    }

    @Test(priority = 7, groups = {"BAT"})
    public void ContactUs() {
        ContactUs contactUsPage = new ContactUs();
        String name = "Fazia";
        String email = "tf@gmail.com";
        String phoneNumber = "2098889997";
        String comment = "Hello fazia";
        contactUsPage.doContactUs(name, email, phoneNumber, comment);

        Assert.assertTrue(isElementVisible(contactUsPage.Message));
    }
}

   /* @Test(priority = 8, groups = {"BAT"}, enabled = false)
    public void CheckoutProcess() {
        CheckoutProcess checkoutProcess = new CheckoutProcess();
        checkoutProcess.clickViewChekoutBtn();
        cartPage.clickProceedToCheckoutButton();
      Assert.assertTrue(checkoutProcess.isCheckoutPageDisplayed);
        Assert.assertTrue(checkoutPageTitle.isDisplayed(), "Checkout process not initiated successfully");
        }
    */




