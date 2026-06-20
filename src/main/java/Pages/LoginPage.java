package Pages;

import bots.ActionsBot;
import drivers.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private ActionsBot bot;


    private final By emailInput = By.id("ap_email_login");
    private final By continueButton = By.xpath("//input[@type='submit' and @class='a-button-input']");
    private final By passwordInput = By.id("ap_password");
    private final By signInButton = By.id("signInSubmit");

    private final By EmptyEmailOrPhoneNumber = By.xpath("//div[contains(text(), 'Enter your mobile number or email')]");
    private final By emailError = By.xpath("//div[contains(text(), 'Invalid email address')]");
    private final By phoneNumberError = By.xpath("//div[contains(text(), 'Invalid mobile number')]");
    private final By EmptyPasswordError = By.xpath("//div[contains(text(), 'Enter your password')]");
    private final By incorrectPasswordError = By.xpath("//div[@class='a-alert-content']");

    public static final String EXPECTED_EMAIL_ERROR = "Invalid email address";
    public static final String EXPECTED_PHONE_ERROR = "Invalid mobile number";
    public static final String EXPECTED_PASSWORD_ERROR = "Your password is incorrect";
    public static final String EXPECTED_EMPTY_PASSWORD_ERROR = "Enter your password";
    public static final String EXPECTED_EMPTY_EMAILORPHONE_ERROR = "Enter your mobile number or email";


    public LoginPage() {
        this.bot = new ActionsBot(WebDriverFactory.getDriver());
    }


    public LoginPage(WebDriver driver) {
        this.bot = new ActionsBot(WebDriverFactory.getDriver());
    }


    public void enterEmail(String email) {
        bot.type(emailInput, email);
    }

    public void enterPhoneNumber(String phoneNumber) {
        bot.type(emailInput, phoneNumber);
    }

    public void clickContinue() {
        bot.click(continueButton);
    }

    public void enterPassword(String password) {
        bot.type(passwordInput, password);
    }

    public void clickSignIn() {
        bot.click(signInButton);
    }


    public void loginWithValidEmail(String email, String password) {
        enterEmail(email);
        clickContinue();
       enterPassword(password);
        clickSignIn();
    }

    public void loginWithValidPhoneNumber(String PhoneNumber, String password) {
        enterPhoneNumber(PhoneNumber);
        clickContinue();
        enterPassword(password);
        clickSignIn();
    }

    public LoginPage loginWithinValidEmail(String invalidEmail) {
        bot.type(emailInput, invalidEmail);
        bot.click(continueButton);
        return this;
    }

    public LoginPage loginWithinValidPhoneNumber(String invalidPhoneNumber){
        bot.type(emailInput, invalidPhoneNumber);
        bot.click(continueButton);
        return this;

    }



    public String getEmptyEmailorphoneError() {
        return bot.getText(EmptyEmailOrPhoneNumber);
    }

    public String getExpectedEmptyPasswordError(){

        return bot.getText(EmptyPasswordError);
    }



    public String getEmailError(){

        return bot.getText(emailError);
    }

    public String getPhoneMobileError(){

        return bot.getText(phoneNumberError);
    }

    public String getPasswordError(){

        return bot.getText(incorrectPasswordError);
    }
}