package Pages;

import bots.ActionsBot;
import drivers.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    private ActionsBot bot;


    //1.Constants

    public static final String email = "eslam_" + System.currentTimeMillis() + "@gmail.com";
    public static final String Validphone = "10" + String.valueOf(System.currentTimeMillis()).substring(5, 13);
    public static final String emptyPhone = "";
    public static final String emptyName = "";
    public static final String emptyPassword = "";
    public static final String emptyReEnterPassword = "";
    public static final String Validname = "eslam";
    public static final String Validpassword = "eslam123";
    public static final String MismatchedPassword = "eslam1234";
    public static final String invalidName = "++++";
    public static final String invalidshortPassword = "eslam";

    //  2.WebElement Locators
    private final By mobileOrEmailInput = By.id("ap_email_login");
    private final By continueButton = By.xpath("//input[@type='submit' and @class='a-button-input']");
    private final By proceedButton = By.xpath("//input[@aria-labelledby='intention-submit-button-announce']");
    private final By mobilenumberInput = By.id("ap_phone_number");
    private final By nameInput = By.id("ap_customer_name");
    private final By passwordInput = By.id("ap_password");
    private final By reEnterPasswordInput = By.id("ap_password_check");
    private final By VerifyMobilePhone = By.id("continue");
    private final By authTitle = By.xpath("//title[contains(text(), 'Authentication required')]");

    // 3. Error locators
    private final By invalidNameCharactersError = By.xpath("//div[@class='a-alert-content' and contains(normalize-space(), 'do not include the characters \"++++\" in your name')]");
    private final By emailError = By.xpath("//div[contains(text(), 'Invalid email address')]");
    private final By phoneNumberError = By.xpath("//div[contains(text(), 'Invalid mobile number')]");
    private final By missingNameError = By.xpath("//div[contains(text(), 'Enter your name')]");
    private final By emptyPhoneError = By.xpath("//div[contains(text(), 'Enter mobile number')]");
    private final By emptyPasswordError = By.xpath("//div[contains(text(), 'Enter your password')]");
    private final By emptyReEnterPasswordError = By.xpath("//div[contains(text(), 'Type your password again')]");
    private final By emptyFieldsError = By.xpath("//div[contains(text(), 'Enter your mobile number or email')]");
    private final By passwordMismatchError = By.xpath("//div[contains(text(), 'Passwords must match')]");
    private final By passwordTooShortError = By.xpath("//div[contains(text(), 'Passwords must be at least 6 characters.')]");


    // 4. Constructors
    public RegisterPage() {
        this.bot = new ActionsBot(WebDriverFactory.getDriver());
    }

    public RegisterPage(WebDriver driver) {
        this.bot = new ActionsBot(WebDriverFactory.getDriver());
    }

    //5.Step By Step Methods


    public RegisterPage enterUnregisteredEmailOrPhone(String emailOrPhone) {
        bot.type(mobileOrEmailInput, emailOrPhone);
        return this;
    }


    public RegisterPage clickContinue() {
        bot.click(continueButton);
        return this;
    }

    public RegisterPage clickProceed() {
        bot.click(proceedButton);
        return this;
    }

    public RegisterPage enterName(String name) {
        bot.type(nameInput, name);
        return this;
    }

    public RegisterPage enterMobileNumber(String mobileNumber) {
        bot.type(mobilenumberInput, mobileNumber);
        return this;
    }

    public RegisterPage enterPassword(String password) {
        bot.type(passwordInput, password);
        return this;
    }

    public RegisterPage reEnterPassword(String password) {
        bot.type(reEnterPasswordInput, password);
        return this;
    }

    public void clickVerifyMobilePhone() {
        bot.click(VerifyMobilePhone);
    }


    // 6. Business Flow Methods

    public void performFullRegisterFlow(String unregisteredEmail, String name, String mobileNumber, String password) {

        enterUnregisteredEmailOrPhone(unregisteredEmail);
        clickContinue();
        clickProceed();
        enterName(name)
                .enterMobileNumber(mobileNumber)
                .enterPassword(password)
                .reEnterPassword(password);
        clickVerifyMobilePhone();
    }

    public void performFullRegisterFlowWithPhone(String moblieNumber, String name, String password) {

        enterUnregisteredEmailOrPhone(moblieNumber);
        clickContinue();
        clickProceed();
        enterName(name)
                .enterMobileNumber(moblieNumber)
                .enterPassword(password)
                .reEnterPassword(password);
        clickVerifyMobilePhone();
    }

    public void preformFullRegisterFlowWithMisMatchedPassword(String unregisteredEmail, String name, String mobileNumber, String password,String MisMatchedPassword){

        enterUnregisteredEmailOrPhone(unregisteredEmail);
        clickContinue();
        clickProceed();
        enterName(name)
                .enterMobileNumber(mobileNumber)
                .enterPassword(password)
                .reEnterPassword(MisMatchedPassword);
        clickVerifyMobilePhone();

    }


    // 7.Navigation Verification Methods

    public boolean isAuthenticationPageDisplayed() {
        try {
            // بنقرأ الـ Title مباشرة من الـ Driver لتجنب أي مشاكل مع العناصر غير المرئية
            return WebDriverFactory.getDriver().getTitle().contains("Authentication required");
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isInvalidNameCharactersErrorDisplayed() {
        try {
            return WebDriverFactory.getDriver().findElement(invalidNameCharactersError).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isPasswordTooShortErrorDisplayed() {
        try {
            return WebDriverFactory.getDriver().findElement(passwordTooShortError).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isMisMatchedPasswordErrorDisplayed() {
        try {
            return WebDriverFactory.getDriver().findElement(passwordMismatchError).isDisplayed();
        } catch (Exception e) {
            return false;
        }

    }

    public boolean isEmptyPhoneErrorDisplayed(){
        try {
            return WebDriverFactory.getDriver().findElement(emptyPhoneError).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isEmptyNameErrorDisplayed(){
        try {
            return WebDriverFactory.getDriver().findElement(missingNameError).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isEmptyPasswordErrorDisplayed(){
        try {
            return WebDriverFactory.getDriver().findElement(emptyPasswordError).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isEmptyReEnterPasswordErrorDisplayed(){
        try {
            return WebDriverFactory.getDriver().findElement(emptyReEnterPasswordError).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


    // 8.Error Getters

    public String getInvalidNameCharactersError() {
        return bot.getText(invalidNameCharactersError);
    }

    public String getEmailError() {
        return bot.getText(emailError);
    }

    public String getPhoneNumberError() {
        return bot.getText(phoneNumberError);
    }

    public String getEmptyFieldsError() {
        return bot.getText(emptyFieldsError);
    }

    public String getMissingNameError() {
        return bot.getText(missingNameError);
    }

    public String getPasswordMismatchError() {
        return bot.getText(passwordMismatchError);
    }

    public String getPasswordTooShortError() {
        return bot.getText(passwordTooShortError);
    }
}