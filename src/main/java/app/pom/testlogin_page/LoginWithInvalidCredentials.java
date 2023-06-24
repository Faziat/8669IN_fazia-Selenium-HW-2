package app.pom.testlogin_page;
import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
public class LoginWithInvalidCredentials extends BasePage {
        @FindBy(xpath = "//div[@class='panel header']//a[contains(.,'Sign In')]")
        public WebElement loginLink;
        @FindBy(xpath = "//input[@id='email']")
        public WebElement inputEmail;
        @FindBy(xpath = "//input[@name='login[password]']")
        public WebElement inputPassword;
        @FindBy(xpath = "//button[@class='action login primary']/span[.='Sign In']")
        public WebElement loginButton;
        @FindBy(xpath = "//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div")
        public WebElement errorMessageLogin;
        public LoginWithInvalidCredentials() {
            PageFactory.initElements(driver, this);
        }
        public void clickLoginLink() {
            safeClickOnElement(loginLink);
        }
        public void setInputInvalidEmail(String validEmail) {
            sendKeysToElement(inputEmail, validEmail);
        }
        public void setInputInvalidPassword(String validPassword) {
            sendKeysToElement(inputPassword, validPassword);
        }
        public void clickLoginButton() {
            safeClickOnElement(loginButton);
        }
    @Test(priority = 5, groups = {"BAT"})
        public void getLogIn(String invalidEmail, String invalidPassword) {
            clickLoginLink();
            setInputInvalidEmail(invalidEmail);
            setInputInvalidPassword(invalidPassword);
            clickLoginButton();
        }
    }
