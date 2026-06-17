package Tests;

import Base.BaseTest;
import Pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest {


    @Test
    public void productListVisibilityTC() {
        search("validProduct");
        new ProductPage(driver)
                .listVisible();
    }

    @Test
    public void productListTitleVisibilityTC() {
        search("validProduct");
        new ProductPage(driver)
                .titleVisibility();
    }

    @Test
    public void verifyUserCanOpenProductDetailsPageTC() {
        search("validProduct");
        new ProductPage(driver)
                .listVisible()
                .titleVisibility()
                .chooseProduct();
    }
    @Test
    public void productPageWithInvalidSearchTC() {
        search("inValidProduct").verifyNoResultsMessageDisplayed();
        Assert.assertFalse(new ProductPage(driver).inValidListTitles());
    }
}
