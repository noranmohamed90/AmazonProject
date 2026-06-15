package Tests;

import Base.BaseTest;
import Data.Urls;
import Pages.Components.NavigationBarComponent;
import drivers.WebDriverFactory;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NavigationBarTests  {


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
                .navigateToSell(Urls.sellUrl);
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
                .navigateTolEctronicsLabel(Urls.electronicsUrl);
    }
    @Test
    public void navigateToPrimeLabel() {
        new NavigationBarComponent(driver)
                .navigateToPrimeLabel(Urls.primeUrl);
    }

    @Test
    public void navigateToHomeLabel() {
        new NavigationBarComponent(driver)
                .navigateToHomeLabel(Urls.HomeUrl);
    }
    @Test
    public void navigateToFashionLabel() {
        new NavigationBarComponent(driver)
                .navigateToFashionLabel(Urls.fashionUrl);
    }

    @Test
    public void navigateToAppLabel() {
        new NavigationBarComponent(driver)
                .navigateToAppLabel(Urls.appUrl);
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
                .navigateToGamesLabel(Urls.gamesUrl);


    }

    @AfterMethod
    public void tearDown(){
        WebDriverFactory.quitDriver();
    }
}
