package Tests;

import Data.Urls;
import Pages.Components.SearchComponent;
import drivers.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchFieldTest {
    WebDriver driver;

    @Test
    public void validSearchTc(){
       new SearchComponent(driver)
               .inputSearchData("iphone 17 ")
               .clickSearchBtn();
        Assert.assertTrue(driver.getCurrentUrl().contains("iphone"));
    }
    @Test
    public void InvalidSearchTc(){
        new SearchComponent(driver)
                .inputSearchData("msndfknsdfk")
                .clickSearchBtn()
                .verifyNoResultsMessageDisplayed();
    }
    @Test
    public void emptySearchTc(){
        new SearchComponent(driver)
                .inputSearchData("                         ")
                .clickSearchBtn();
        Assert.assertEquals(driver.getCurrentUrl(), Urls.baseUrl);
    }
    @Test
    public void mixLangSearchTc(){
        new SearchComponent(driver)
                .inputSearchData("ايفون 17pro max")
                .clickSearchBtn()
                .verifySearchResultsDisplayed();
    }
    @Test
    public void numericDataSearchTc(){
        new SearchComponent(driver)
                .inputSearchData("123456789")
                .clickSearchBtn();
        Assert.assertTrue(driver.getCurrentUrl().contains("123456789"));
    }
    @Test
    public void searchDropDownTc(){
        new SearchComponent(driver)
                .inputSearchData("iph")
                .dropDownVisibility()
                .dropDownVItem();
        Assert.assertTrue(driver.getCurrentUrl().contains("iphone"));
    }
    @Test
    public void upperCaseSearchTc(){
        new SearchComponent(driver)
                .inputSearchData("IPHONE ")
                .clickSearchBtn();
        Assert.assertTrue(driver.getCurrentUrl().contains("IPHONE"));
    }
    @Test
    public void specialCharactersSearchTc(){
        new SearchComponent(driver)
                .inputSearchData("@#$%")
                .clickSearchBtn();
        Assert.assertTrue( driver.getCurrentUrl().contains("s?k"));
    }



    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.initDriver("edge");
        driver.get(Urls.baseUrl);
    }

    @AfterMethod
    public void tearDown(){
        WebDriverFactory.quitDriver();
    }
}
