package Tests;

import Base.BaseTest;
import Data.Urls;

import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationBarTests extends BaseTest {


    @Test
    public void navigateToBazaarLabel(){
        navigationBar().navigateToBazaarLabel();
        Assert.assertEquals(driver.getCurrentUrl(),Urls.bazaarUrl);
        Assert.assertTrue(driver.getCurrentUrl().contains(Urls.bazaarUrl));


    }
    @Test
    public void navigateToSell(){
        navigationBar().navigateToSell();
        Assert.assertEquals(driver.getCurrentUrl(),Urls.sellUrl);
        Assert.assertTrue(driver.getCurrentUrl().contains(Urls.sellUrl));

    }
    @Test
    public void navigateToDealsLabel(){
        navigationBar().navigateToDeals();
        Assert.assertEquals(driver.getCurrentUrl(),Urls.dealUrl);
        Assert.assertTrue(driver.getCurrentUrl().contains(Urls.dealUrl));

    }
    @Test
    public void navigateToMobileLabel(){
        navigationBar().navigateToMobileLabel();
        Assert.assertEquals(driver.getCurrentUrl(),Urls.mobileUrl);
        Assert.assertTrue(driver.getCurrentUrl().contains(Urls.mobileUrl));

    }
    @Test
    public void navigateToElectronicsLabel(){
        navigationBar().navigateTolEctronicsLabel();
        Assert.assertEquals(driver.getCurrentUrl(),Urls.electronicsUrl);
        Assert.assertTrue(driver.getCurrentUrl().contains(Urls.electronicsUrl));

    }
    @Test
    public void navigateToPrimeLabel() {
        navigationBar().navigateToPrimeLabel();
        Assert.assertEquals(driver.getCurrentUrl(),Urls.primeUrl);
        Assert.assertTrue(driver.getCurrentUrl().contains(Urls.primeUrl));

    }

    @Test
    public void navigateToHomeLabel() {
        navigationBar().navigateToHomeLabel();
        Assert.assertEquals(driver.getCurrentUrl(),Urls.HomeUrl);
        Assert.assertTrue(driver.getCurrentUrl().contains(Urls.HomeUrl));

    }
    @Test
    public void navigateToFashionLabel() {
        navigationBar().navigateToFashionLabel();
        Assert.assertEquals(driver.getCurrentUrl(),Urls.fashionUrl);
        Assert.assertTrue(driver.getCurrentUrl().contains(Urls.fashionUrl));

    }

    @Test
    public void navigateToAppLabel() {
        navigationBar().navigateToAppLabel();
        Assert.assertEquals(driver.getCurrentUrl(),Urls.appUrl);
        Assert.assertTrue(driver.getCurrentUrl().contains(Urls.appUrl));


    }
    @Test
    public void navigateToToysLabel() {
        navigationBar().navigateToToysLabel();
        Assert.assertEquals(driver.getCurrentUrl(),Urls.ToysUrl);
        Assert.assertTrue(driver.getCurrentUrl().contains(Urls.ToysUrl));

    } @Test
    public void navigateToGroceryLabel() {
        navigationBar().navigateToGroceryLabel();
        Assert.assertEquals(driver.getCurrentUrl(),Urls.groceryUrl);
        Assert.assertTrue(driver.getCurrentUrl().contains(Urls.groceryUrl));
    }
    @Test
    public void navigateToGamesLabel() {
        navigationBar().navigateToGamesLabel();
        Assert.assertEquals(driver.getCurrentUrl(),Urls.gamesUrl);
        Assert.assertTrue(driver.getCurrentUrl().contains(Urls.gamesUrl));
    }
    @Test
    public void navigateToSignInLabel() {
        navigationBar().navigateToSignInLabel();
        Assert.assertNotEquals(Urls.baseUrl, Urls.signInUrl);
        Assert.assertTrue(driver.getCurrentUrl().contains("/ap/signin"));



    }
}
