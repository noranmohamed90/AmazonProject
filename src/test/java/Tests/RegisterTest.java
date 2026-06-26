package Tests;

import Base.BaseTest;
import Pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {



    @Test
    public void TC01_RegisterWithvalidDataByEmail() {
        navigateToLoginPage();
        registerPage().performFullRegisterFlow(RegisterPage.email, RegisterPage.Validname, RegisterPage.Validphone, RegisterPage.Validpassword);
        Assert.assertTrue(registerPage().isAuthenticationPageDisplayed());

    }

    @Test
    public void TC02_RegisterWithvalidDataByPhoneNumber(){

        navigateToLoginPage();
        registerPage().performFullRegisterFlowWithPhone(RegisterPage.Validphone, RegisterPage.Validname, RegisterPage.Validpassword);
        Assert.assertTrue(registerPage().isAuthenticationPageDisplayed());
    }

    @Test
    public void TC03_RegisterWithInvalidName() {
        navigateToLoginPage();
        registerPage().performFullRegisterFlow(RegisterPage.email,RegisterPage.invalidName, RegisterPage.Validphone, RegisterPage.Validpassword);
        Assert.assertTrue(registerPage().isInvalidNameCharactersErrorDisplayed());
    }

    @Test
    public void TC04_RegisterWithshortPassword() {
        navigateToLoginPage();
        registerPage().performFullRegisterFlow(RegisterPage.email,RegisterPage.Validname, RegisterPage.Validphone, RegisterPage.invalidshortPassword);
        Assert.assertTrue(registerPage().isPasswordTooShortErrorDisplayed());

    }

    @Test
    public void TC05_RegisterMismatchedPassword() {
        navigateToLoginPage();
        registerPage().preformFullRegisterFlowWithMisMatchedPassword(RegisterPage.email,RegisterPage.Validname, RegisterPage.Validphone, RegisterPage.Validpassword, RegisterPage.MismatchedPassword);
        Assert.assertTrue(registerPage().isMisMatchedPasswordErrorDisplayed());

    }

    @Test
    public void TC06_RegisterWithEmptyPhone() {
        navigateToLoginPage();
        registerPage().performFullRegisterFlow(RegisterPage.email,RegisterPage.Validname, RegisterPage.emptyPhone, RegisterPage.Validpassword);
        Assert.assertTrue(registerPage().isEmptyPhoneErrorDisplayed ());

    }



    @Test
    public void TC07_RegisterWithEmptyName() {
        navigateToLoginPage();
        registerPage().performFullRegisterFlow(RegisterPage.email,RegisterPage.emptyName, RegisterPage.Validphone, RegisterPage.Validpassword);
        Assert.assertTrue(registerPage().isEmptyNameErrorDisplayed());
    }

    @Test
    public void TC08_RegisterWithEmptyPassword() {
        navigateToLoginPage();
        registerPage().performFullRegisterFlow(RegisterPage.email,RegisterPage.Validname, RegisterPage.Validphone, RegisterPage.emptyPassword);
        Assert.assertTrue(registerPage().isEmptyPasswordErrorDisplayed());
    }

    @Test
    public void TC09_RegisterWithEmptyReEnterPassword() {
        navigateToLoginPage();
        registerPage().preformFullRegisterFlowWithMisMatchedPassword(RegisterPage.email,RegisterPage.Validname, RegisterPage.Validphone, RegisterPage.Validpassword, RegisterPage.emptyReEnterPassword);
        Assert.assertTrue(registerPage().isEmptyReEnterPasswordErrorDisplayed());
    }


}
