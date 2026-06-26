package Tests;

import Base.BaseTest;
import Pages.SortPage;
import org.testng.Assert;
import org.testng.annotations.Test;



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
        Assert.assertTrue(getDriver().getCurrentUrl().contains("price-asc"));
    }

    @Test
    public void high2LowBtnTC(){
        search("validProduct");
        SortTest().sortHighToLow();
        Assert.assertTrue(getDriver().getCurrentUrl().contains("price-desc"));
    }

    @Test
    public void reviewsBtnTC(){
        search("validProduct");
        SortTest().sortByReviews();
       Assert.assertTrue(getDriver().getCurrentUrl().contains("review"));
    }

    @Test
    public void sellersBtnTC(){
        search("validProduct");
       SortTest().sortByBestSellers();
        Assert.assertTrue(getDriver().getCurrentUrl().contains("popularity"));
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
        SortPage sortPage = new SortPage(getDriver());
        Assert.assertTrue(sortPage.isSortButtonDisplayed());
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
        SortTest().sortByBestSellers();
        getDriver().navigate().refresh();
        Assert.assertTrue(getDriver().getCurrentUrl().contains("popularity"));
    }

}
