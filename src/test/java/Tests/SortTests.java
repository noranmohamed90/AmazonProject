package Tests;

import Base.BaseTest;
import Pages.SortPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SortTests extends BaseTest {


    @Test
    public void sortBtnVisibilityTC(){
        search("validProduct");
        SortTest();
    }

    @Test
    public void low2HighBtnTC(){
        search("validProduct");
        SortTest().sortLowToHigh();
        Assert.assertTrue(driver.getCurrentUrl().contains("price-asc"));
    }

    @Test
    public void high2LowBtnTC(){
        search("validProduct");
        SortTest().sortHighToLow();
        Assert.assertTrue(driver.getCurrentUrl().contains("price-desc"));
    }

    @Test
    public void reviewsBtnTC(){
        search("validProduct");
        SortTest().sortByReviews();
       Assert.assertTrue(driver.getCurrentUrl().contains("review"));
    }

    @Test
    public void sellersBtnTC(){
        search("validProduct");
       SortTest().sortByBestSellers();
        Assert.assertTrue(driver.getCurrentUrl().contains("popularity"));
    }
    @Test
    public void newArrivalsBtnTC(){
        search("validProduct");
        SortTest().sortByNewArrival();
    }

    @Test
    public void invalidSortWithoutSearch(){
        search("inValidProduct")
                .verifyNoResultsMessageDisplayed();
        SortPage sortPage = new SortPage(driver);
        Assert.assertFalse(sortPage.isSortButtonDisplayed());
    }

    @Test
    public void doubleClickSortBtnTc(){
        search("validProduct")
                .verifySearchResultsDisplayed(utilities.JsonUtils.getValue("validProduct"));
        SortTest().sortByBestSellers().sortByBestSellers();

    }
    @Test
    public void sortAfterPageRefreshTC() {
        search("validProduct");
        SortTest().sortLowToHigh();
        driver.navigate().refresh();
        Assert.assertTrue(driver.getCurrentUrl().contains("price-asc"));
    }

}
