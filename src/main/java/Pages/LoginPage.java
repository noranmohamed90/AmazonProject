package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    private By emailInput = By.id("ap_email");
    private By continueButton = By.className("a-button-input");

    private By passwordInput = By.id("ap_password");
    private By signInButton = By.id("signInSubmit");

    private By emptyFieldsError = By.xpath("//div[contains(text(), 'Enter your mobile number or email')]");
    private By emailError = By.xpath("//div[contains(text(), 'Invalid email address')]");
    private By phoneNumberError = By.xpath("//div[contains(text(), 'Invalid mobile number')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    public void enterEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void clickContinue() {
        driver.findElement(continueButton).click();
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickSignIn() {
        driver.findElement(signInButton).click();
    }

    public void loginWithValidCredentials(String email, String password) {
        enterEmail(email);
        clickContinue();
        enterPassword(password);
        clickSignIn();
    }
}


