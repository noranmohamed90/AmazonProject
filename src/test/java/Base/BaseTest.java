package Base;

import Data.Urls;
import Pages.*;
import Pages.Components.NavigationBarComponent;
import Pages.Components.SearchComponent;
import drivers.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver getDriver() {
        return WebDriverFactory.getDriver();
    }

    @BeforeMethod
    public void setUp() {

         WebDriverFactory.initDriver("edge");
        getDriver().get(Urls.baseUrl);
    }

    protected LoginPage navigateToLoginPage() {
        getDriver().get(Urls.signInUrl);
        return new LoginPage(getDriver());
    }

    protected CartPage loginAndPrepareProduct(String product) {
        navigateToLoginPage();
        loginPage().loginWithValidEmail("eslamfathi880@gmail.com", "111111");
        new CartPage(getDriver()).clearCart();
        search(product);
        new ProductPage(getDriver()).listVisible().titleVisibility().chooseProduct();
        return new CartPage(getDriver());
    }

    protected SearchComponent search(String productKey) {
        new SearchComponent(getDriver())
                .searchFieldVisibility()
                .inputSearchData(utilities.JsonUtils.getValue(productKey))
                .clickSearchBtn();
        return new SearchComponent(getDriver());
    }
    protected SearchComponent searchWithEnter(String productKey) {
        new SearchComponent(getDriver())
                .searchFieldVisibility()
                .inputSearchData(utilities.JsonUtils.getValue(productKey))
                .searchWithEnter();
        return new SearchComponent(getDriver());
    }
    protected SortPage SortTest() {
       new SortPage(getDriver())
               .sortBtnVisibility();
       return new SortPage(getDriver());
    }

    protected FiltersPage FilterTest() {
        new FiltersPage(getDriver());
        return new FiltersPage(getDriver());
    }
    protected NavigationBarComponent navigationBar() {
        new NavigationBarComponent(getDriver());
        return new NavigationBarComponent(getDriver());
    }

    protected LoginPage loginPage() {
        new LoginPage(getDriver());
        return new LoginPage(getDriver());
    }

    protected RegisterPage registerPage() {
        return new RegisterPage(getDriver());
    }



    @AfterMethod
    public void tearDown() {
        WebDriverFactory.quitDriver();
    }

}
