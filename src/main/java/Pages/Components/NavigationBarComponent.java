package Pages.Components;

import bots.ActionsBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class NavigationBarComponent {

    WebDriver driver;
    private  ActionsBot actionsBot;

    public  NavigationBarComponent(WebDriver driver){
        this.driver=driver;
        this.actionsBot =new ActionsBot(driver);
    }


   private final By bazaarBtn = By.cssSelector("a[href*='nav_cs_hul_disb']");
     private final By sellBtn = By.xpath("//a[.=\"Sell\"]");
     private final By dealsBtn = By.xpath("//a[.=\"Today's Deals\"]");
     private final By mobileBtn = By.xpath("//a[.=\"Mobile Phones\"]");
     private final By electronicBtn = By.xpath("//a[.=\"Electronics\"]");
     private final By primeBtn = By.id("nav-link-amazonprime");
     private final By homeBtn = By.xpath("//a[.=\"Home\"]");
     private final By fashionBtn = By.xpath("//a[.=\"Fashion\"]");
     private final By appBtn = By.xpath("//a[.=\"Appliances\"]");
    private final By toysBtn = By.xpath("//a[.=\"Toys & Games\"]");
    private final By groceryBtn = By.xpath("//a[.=\"Grocery\"]");
    private final By gamesBtn = By.xpath("//a[.=\"Video Games\"]");




    public  void navigateToBazaarLabel(String expUrl){
        actionsBot.click(bazaarBtn);
        Assert.assertEquals(driver.getCurrentUrl(), expUrl);
    }


    public  void navigateToSell(){
        actionsBot.click(sellBtn);
        Assert.assertTrue(driver.findElement(By.cssSelector("h1.heading")).isDisplayed());
    }

    public  void navigateToDeals(String expUrl){
        actionsBot.click(dealsBtn);
        Assert.assertEquals(driver.getCurrentUrl(), expUrl);

    }

    public  void navigateToMobileLabel(String expUrl){
        actionsBot.click(mobileBtn);
        Assert.assertEquals(driver.getCurrentUrl(), expUrl);

    }
    public  void navigateTolectronicsLabel(){
        actionsBot.click(electronicBtn);
        Assert.assertTrue(driver.findElement(By.cssSelector("h1>b")).isDisplayed());
    }
    public  void navigateToPrimeLabel(){
        actionsBot.click(primeBtn);
        Assert.assertTrue(driver.findElement(By.id("plp-hero-cta-announce")).isDisplayed());
    }

    public  void navigateToHomeLabel(String expUrl){
        actionsBot.click(homeBtn);
        Assert.assertEquals(driver.getCurrentUrl(), expUrl);
    }
    public  void navigateToFashionLabel(){
        actionsBot.click(fashionBtn);
        Assert.assertTrue(driver.findElement(By.cssSelector("h1>b")).isDisplayed());
    }
    public  void navigateToAppLabel(){
        actionsBot.click(appBtn);
        Assert.assertTrue(driver.findElement(By.cssSelector("h1>b")).isDisplayed());
    }
    public  void navigateToToysLabel(String expUrl){
        actionsBot.click(toysBtn);
        Assert.assertEquals(driver.getCurrentUrl(), expUrl);
    }
    public  void navigateToGroceryLabel(String expUrl){
        actionsBot.click(groceryBtn);
        Assert.assertEquals(driver.getCurrentUrl(), expUrl);
    }
    public  void navigateToGamesLabel(String expUrl){
        actionsBot.click(gamesBtn);
        Assert.assertEquals(driver.getCurrentUrl(), expUrl);
    }

}
