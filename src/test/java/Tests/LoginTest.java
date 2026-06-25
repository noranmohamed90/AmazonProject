package Tests;

import Base.BaseTest;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {


    @Test
    public void TC01_loginWithRegisteredEmail() {
        LoginPage loginPage = navigateToLoginPage();
        loginPage.loginWithValidEmail("eslamfathi880@gmail.com", "111111");
        Assert.assertTrue(getDriver().getCurrentUrl().contains("amazon.eg"), "Login failed or redirected to a wrong page!");
    }


    @Test
    public void TC02_loginWithRegisteredPhoneNumber() {
        LoginPage loginPage = navigateToLoginPage();
        loginPage.loginWithValidPhoneNumber("1096118744", "111111");
        Assert.assertTrue(getDriver().getCurrentUrl().contains("amazon.eg"), "Login failed or redirected to a wrong page!");
    }

    @Test
    public void TC03_loginWithInvalidEmail() {
        LoginPage loginPage = navigateToLoginPage();
        loginPage.loginWithinValidEmail("eeee.g.com");
        Assert.assertEquals(loginPage.getEmailError(), LoginPage.EXPECTED_EMAIL_ERROR);
    }

    @Test
    public void TC04_loginWithInvalidPhoneNumber() {
        LoginPage loginPage = navigateToLoginPage();
        loginPage.loginWithinValidPhoneNumber("012345");
        Assert.assertEquals(loginPage.getPhoneMobileError(), LoginPage.EXPECTED_PHONE_ERROR);
    }

    @Test
    public void TC05_loginWithInvalidPassword() {
        LoginPage loginPage = navigateToLoginPage();
        loginPage.loginWithValidEmail("eslamfathi880@gmail.com", "1111112");
        Assert.assertEquals(loginPage.getPasswordError(), LoginPage.EXPECTED_PASSWORD_ERROR);
    }

    @Test
    public void TC06_loginWithEmptyEmailorPhoneNumber() {
        LoginPage loginPage = navigateToLoginPage();
        loginPage.loginWithinValidEmail("");
        Assert.assertEquals(loginPage.getEmptyEmailorphoneError(), LoginPage.EXPECTED_EMPTY_EMAILORPHONE_ERROR);
    }

    @Test
    public void TC07_loginWithEmptyPassword() {
        LoginPage loginPage = navigateToLoginPage();
        loginPage.loginWithValidEmail("eslamfathi880@gmail.com", "");
        Assert.assertEquals(loginPage.getExpectedEmptyPasswordError(), LoginPage.EXPECTED_EMPTY_PASSWORD_ERROR);
    }
}
