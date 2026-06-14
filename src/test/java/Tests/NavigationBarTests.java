package Tests;

import Data.Urls;
import Pages.Components.NavigationBarComponent;
import drivers.WebDriverFactory;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NavigationBarTests {


    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.initDriver("edge");
        driver.get(Urls.baseUrl);
    }

    @Test
    public void navigateToBazaarLabel(){
         new NavigationBarComponent(driver)
                 .navigateToBazaarLabel(Urls.bazaarUrl);
    }
    @Test
    public void navigateToSell(){
        new NavigationBarComponent(driver)
                .navigateToSell();
    }
    @Test
    public void navigateToDealsLabel(){
        new NavigationBarComponent(driver)
                .navigateToDeals(Urls.dealUrl);
    }
    @Test
    public void navigateToMobileLabel(){
        new NavigationBarComponent(driver)
                .navigateToMobileLabel(Urls.mobileUrl);
    }
    @Test
    public void navigateToElectronicsLabel(){
        new NavigationBarComponent(driver)
                .navigateTolectronicsLabel();
    }
    @Test
    public void navigateToPrimeLabel() {
        new NavigationBarComponent(driver)
                .navigateToPrimeLabel();
    }

    @Test
    public void navigateToHomeLabel() {
        new NavigationBarComponent(driver)
                .navigateToHomeLabel(Urls.HomeUrl);
    }
    @Test
    public void navigateToFashionLabel() {
        new NavigationBarComponent(driver)
                .navigateToFashionLabel();
    }

    @Test
    public void navigateToAppLabel() {
        new NavigationBarComponent(driver)
                .navigateToAppLabel();
    }
    @Test
    public void navigateToToysLabel() {
        new NavigationBarComponent(driver)
                .navigateToToysLabel(Urls.ToysUrl);
    } @Test
    public void navigateToGroceryLabel() {
        new NavigationBarComponent(driver)
                .navigateToGroceryLabel(Urls.groceryUrl);
    }
    @Test
    public void navigateToGamesLabel() {
        new NavigationBarComponent(driver)
                .navigateToGamesLabel(Urls.gamedUrl);


    }

    @AfterMethod
    public void tearDown(){
        WebDriverFactory.quitDriver();
    }
}
