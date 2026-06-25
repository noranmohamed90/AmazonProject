package Pages.Components;

import Pages.LoginPage;
import bots.ActionsBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationBarComponent {

    WebDriver driver;
    private  ActionsBot actionsBot;

    public  NavigationBarComponent(WebDriver driver){
        this.driver=driver;
        this.actionsBot =new ActionsBot(driver);
    }


   private final By bazaarBtn = By.cssSelector("a[href*='nav_cs_hul_disb']");
    // private final By sellBtn = By.xpath("//a[.=\"Sell\"]");
     private final By dealsBtn = By.id("nav-primeday");
     private final By mobileBtn = By.xpath("//a[.=\"Mobile Phones\"]");
     private final By electronicBtn = By.xpath("//a[.=\"Electronics\"]");
     private final By primeBtn = By.id("nav-link-amazonprime");
     private final By homeBtn = By.xpath("//a[.=\"Home\"]");
     private final By fashionBtn = By.xpath("//a[.=\"Fashion\"]");
     private final By appBtn = By.xpath("//a[.=\"Appliances\"]");
    private final By toysBtn = By.xpath("//a[.=\"Toys & Games\"]");
    private final By groceryBtn = By.xpath("//a[.=\"Grocery\"]");
    private final By gamesBtn = By.xpath("//a[.=\"Video Games\"]");
    private final By signInBtn = By.id("nav-link-accountList");





    public  void navigateToBazaarLabel(){
        actionsBot.click(bazaarBtn);

    }


//    public  void navigateToSell(){
//        actionsBot.click(sellBtn);
//    }

    public  void navigateToDeals(){
        actionsBot.click(dealsBtn);

    }

    public  void navigateToMobileLabel(){
        actionsBot.click(mobileBtn);


    }
    public  void navigateTolEctronicsLabel(){
        actionsBot.click(electronicBtn);

    }
    public  void navigateToPrimeLabel(){
        actionsBot.click(primeBtn);

    }

    public  void navigateToHomeLabel(){
        actionsBot.click(homeBtn);

    }
    public  void navigateToFashionLabel(){
        actionsBot.click(fashionBtn);

    }
    public  void navigateToAppLabel( ){
        actionsBot.click(appBtn);
    }
    public  void navigateToToysLabel(){
        actionsBot.click(toysBtn);
    }
    public  void navigateToGroceryLabel(){
        actionsBot.click(groceryBtn);
    }
    public  void navigateToGamesLabel(){
        actionsBot.click(gamesBtn);
    }

    public LoginPage navigateToSignInLabel(){
        actionsBot.click(signInBtn);
        return new LoginPage(driver);
    }

}
