package Tests;

import Data.Urls;
import Pages.Components.SearchComponent;
import Pages.SortPage;
import drivers.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SortTests {

    WebDriver driver;

    @Test
    public void sortBtnVisibilityTC(){
          new SortPage(driver)
                  .sortBtnVisibility();
    }

    @Test
    public void low2HighBtnTC(){
        new SortPage(driver)
                .sortBtnVisibility()
                .sortLowToHigh();
        Assert.assertTrue(driver.getCurrentUrl().contains("price-asc"));
    }

    @Test
    public void high2LowBtnTC(){
        new SortPage(driver)
                .sortBtnVisibility()
                .sortHighToLow();
        Assert.assertTrue(driver.getCurrentUrl().contains("price-desc"));
    }

    @Test
    public void reviewsBtnTC(){
        new SortPage(driver)
                .sortBtnVisibility()
                .sortByReviews();
       Assert.assertTrue(driver.getCurrentUrl().contains("review"));
    }

    @Test
    public void sellersBtnTC(){
        new SortPage(driver)
                .sortBtnVisibility()
                .sortByBestSellers();
        Assert.assertTrue(driver.getCurrentUrl().contains("popularity"));
    }








    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.initDriver("edge");
        driver.get(Urls.baseUrl);
        new SearchComponent(driver)
                .inputSearchData("iphone 17")
                .clickSearchBtn();
    }

    @AfterMethod
    public void tearDown(){
        WebDriverFactory.quitDriver();
    }
}
