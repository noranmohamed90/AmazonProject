package Base;

import Data.Urls;
import Pages.Components.NavigationBarComponent;
import Pages.Components.SearchComponent;
import Pages.FiltersPage;
import Pages.LoginPage;
import Pages.RegisterPage;
import Pages.SortPage;
import drivers.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = WebDriverFactory.initDriver("edge");
        driver.get(Urls.baseUrl);
    }

    protected LoginPage navigateToLoginPage() {
        driver.get(Urls.signInUrl);
        return new LoginPage(driver);
    }

    protected SearchComponent search(String productKey) {
        new SearchComponent(driver)
                .searchFieldVisibility()
                .inputSearchData(utilities.JsonUtils.getValue(productKey))
                .clickSearchBtn();
        return new SearchComponent(driver);
    }
    protected SearchComponent searchWithEnter(String productKey) {
        new SearchComponent(driver)
                .searchFieldVisibility()
                .inputSearchData(utilities.JsonUtils.getValue(productKey))
                .searchWithEnter();
        return new SearchComponent(driver);
    }
    protected SortPage SortTest() {
       new SortPage(driver)
               .sortBtnVisibility();
       return new SortPage(driver);
    }

    protected FiltersPage FilterTest() {
        new FiltersPage(driver);
        return new FiltersPage(driver);
    }
    protected NavigationBarComponent navigationBar() {
        new NavigationBarComponent(driver);
        return new NavigationBarComponent(driver);
    }

    protected LoginPage loginPage() {
        new LoginPage(driver);
        return new LoginPage(driver);
    }

    protected RegisterPage registerPage() {
        return new RegisterPage(driver);
    }



    @AfterMethod
    public void tearDown() {
        WebDriverFactory.quitDriver();
    }

}
