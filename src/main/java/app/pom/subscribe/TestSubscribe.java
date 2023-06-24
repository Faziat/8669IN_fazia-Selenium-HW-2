package app.pom.subscribe;
import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class TestSubscribe extends BasePage {
   @FindBy(xpath ="//button[@title='Subscribe']")
    public WebElement subscriptionBtn;@FindBy (xpath ="//div[contains(text(), 'This email address is already subscribed.')]")
    public WebElement errorMessage;
    @FindBy (xpath ="//input[@name=\"email\"]")
    public WebElement emailToSubscribe;

    }

