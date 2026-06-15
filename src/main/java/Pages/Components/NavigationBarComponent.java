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
        Assert.assertTrue(driver.getCurrentUrl().contains(expUrl));
    }


    public  void navigateToSell(String expUrl){
        actionsBot.click(sellBtn);
        Assert.assertTrue(driver.getCurrentUrl().contains(expUrl));
    }

    public  void navigateToDeals(String expUrl){
        actionsBot.click(dealsBtn);
        Assert.assertTrue(driver.getCurrentUrl().contains(expUrl));

    }

    public  void navigateToMobileLabel(String expUrl){
        actionsBot.click(mobileBtn);
        Assert.assertTrue(driver.getCurrentUrl().contains(expUrl));

    }
    public  void navigateTolEctronicsLabel(String expUrl){
        actionsBot.click(electronicBtn);
        Assert.assertTrue(driver.getCurrentUrl().contains(expUrl));
    }
    public  void navigateToPrimeLabel(String expUrl){
        actionsBot.click(primeBtn);
        Assert.assertTrue(driver.getCurrentUrl().contains(expUrl));
    }

    public  void navigateToHomeLabel(String expUrl){
        actionsBot.click(homeBtn);
        Assert.assertTrue(driver.getCurrentUrl().contains(expUrl));
    }
    public  void navigateToFashionLabel(String expUrl){
        actionsBot.click(fashionBtn);
        Assert.assertTrue(driver.getCurrentUrl().contains(expUrl));
    }
    public  void navigateToAppLabel( String expUrl){
        actionsBot.click(appBtn);
        Assert.assertTrue(driver.getCurrentUrl().contains(expUrl));
    }
    public  void navigateToToysLabel(String expUrl){
        actionsBot.click(toysBtn);
        Assert.assertTrue(driver.getCurrentUrl().contains(expUrl));
    }
    public  void navigateToGroceryLabel(String expUrl){
        actionsBot.click(groceryBtn);
        Assert.assertTrue(driver.getCurrentUrl().contains(expUrl));
    }
    public  void navigateToGamesLabel(String expUrl){
        actionsBot.click(gamesBtn);
        Assert.assertTrue(driver.getCurrentUrl().contains(expUrl));
    }

}
