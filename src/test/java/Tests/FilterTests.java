package Tests;

import Base.BaseTest;

import Pages.FiltersPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FilterTests extends BaseTest {


    @Test
    public void brandFilterTC() {
        search("validProduct");
        FilterTest()
                .brandFilterVisibility()
                .filterWithBrand();
    }

    @Test
    public void deliveryDayFilterTC() {
        search("validProduct");
        FilterTest()
                .deliveryFilterVisibility()
                .filterWithDeliveryDay();
    }

    @Test
    public void MultipleFiltersTC() {
        search("validProduct");
        FilterTest()
                .deliveryFilterVisibility()
                .filterWithDeliveryDay()
                .brandFilterVisibility()
                .filterWithBrand();

    }

    @Test
    public void filterWithoutSearchTC() {
        FiltersPage filters = new FiltersPage(driver);
        Assert.assertFalse(filters.invalidBrandFilter());

    }
    @Test
    public void InvalidSearchFilterTC() {
       search("inValidProduct");
        Assert.assertFalse(new FiltersPage(driver).invalidBrandFilter());
    }
    @Test
    public void unSelectfilterTC() {
        search("validProduct");
        FilterTest().filterWithBrand();
        String filterUrl = driver.getCurrentUrl();
        FilterTest().filterWithBrand();
        Assert.assertNotEquals(driver.getCurrentUrl(),filterUrl);
//        FiltersPage filters = new FiltersPage(driver);
//        filters.filterWithBrand();
//        filters.filterWithBrand();// toggle off
//        Assert.assertTrue(true);
    }
}



