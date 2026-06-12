package Pages;

import bots.ActionsBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage {

    WebDriver driver;
    private ActionsBot actionBot;
    private final By addToCartBtn = By.id("add-to-cart-sauce-labs-backpack");
    private final By Cart =By.cssSelector(".shopping_cart_badge");

    public HomePage(WebDriver driver){
        this.driver=driver;
        this.actionBot = new ActionsBot(driver);
    }

    public HomePage addToCart(){
        actionBot.click(addToCartBtn);
        return this;
    }

    public HomePage CartIncrease(){
        String cartText = actionBot.getText(Cart);
        Assert.assertEquals(cartText,"1");
         return this;

    }
}
