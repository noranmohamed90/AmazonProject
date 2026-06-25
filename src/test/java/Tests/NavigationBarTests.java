package Tests;

import Base.BaseTest;
import Data.Urls;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationBarTests extends BaseTest {


    @Test
    public void navigateToBazaarLabel(){
        navigationBar().navigateToBazaarLabel();
        Assert.assertEquals(getDriver().getCurrentUrl(),Urls.bazaarUrl);
        Assert.assertTrue(getDriver().getCurrentUrl().contains(Urls.bazaarUrl));


    }
    @Test
    public void navigateToDealsLabel(){
        navigationBar().navigateToDeals();
        Assert.assertEquals(getDriver().getCurrentUrl(),Urls.dealUrl);
        Assert.assertTrue(getDriver().getCurrentUrl().contains("primeday"));

    }
    @Test
    public void navigateToMobileLabel(){
        navigationBar().navigateToMobileLabel();
        Assert.assertEquals(getDriver().getCurrentUrl(),Urls.mobileUrl);
        Assert.assertTrue(getDriver().getCurrentUrl().contains(Urls.mobileUrl));

    }
    @Test
    public void navigateToElectronicsLabel(){
        navigationBar().navigateTolEctronicsLabel();
        Assert.assertEquals(getDriver().getCurrentUrl(),Urls.electronicsUrl);
        Assert.assertTrue(getDriver().getCurrentUrl().contains(Urls.electronicsUrl));

    }
    @Test
    public void navigateToPrimeLabel() {
        navigationBar().navigateToPrimeLabel();
        Assert.assertEquals(getDriver().getCurrentUrl(),Urls.primeUrl);
        Assert.assertTrue(getDriver().getCurrentUrl().contains(Urls.primeUrl));

    }

    @Test
    public void navigateToHomeLabel() {
        navigationBar().navigateToHomeLabel();
        Assert.assertEquals(getDriver().getCurrentUrl(),Urls.HomeUrl);
        Assert.assertTrue(getDriver().getCurrentUrl().contains(Urls.HomeUrl));

    }
    @Test
    public void navigateToFashionLabel() {
        navigationBar().navigateToFashionLabel();
        Assert.assertEquals(getDriver().getCurrentUrl(),Urls.fashionUrl);
        Assert.assertTrue(getDriver().getCurrentUrl().contains(Urls.fashionUrl));

    }

    @Test
    public void navigateToAppLabel() {
        navigationBar().navigateToAppLabel();
        Assert.assertEquals(getDriver().getCurrentUrl(),Urls.appUrl);
        Assert.assertTrue(getDriver().getCurrentUrl().contains(Urls.appUrl));


    }
    @Test
    public void navigateToToysLabel() {
        navigationBar().navigateToToysLabel();
        Assert.assertEquals(getDriver().getCurrentUrl(),Urls.ToysUrl);
        Assert.assertTrue(getDriver().getCurrentUrl().contains(Urls.ToysUrl));

    } @Test
    public void navigateToGroceryLabel() {
        navigationBar().navigateToGroceryLabel();
        Assert.assertEquals(getDriver().getCurrentUrl(),Urls.groceryUrl);
        Assert.assertTrue(getDriver().getCurrentUrl().contains(Urls.groceryUrl));
    }
    @Test
    public void navigateToGamesLabel() {
        navigationBar().navigateToGamesLabel();
        Assert.assertEquals(getDriver().getCurrentUrl(),Urls.gamesUrl);
        Assert.assertTrue(getDriver().getCurrentUrl().contains(Urls.gamesUrl));
    }
    @Test
    public void navigateToSignInLabel() {
        navigationBar().navigateToSignInLabel();
        Assert.assertNotEquals(Urls.baseUrl, Urls.signInUrl);
        Assert.assertTrue(getDriver().getCurrentUrl().contains("/ap/signin"));



    }
}
