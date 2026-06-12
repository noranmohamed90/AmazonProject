package Pages;

import bots.ActionsBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Login {


    private  WebDriver driver;
    private ActionsBot actionBot;
    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By loginbtn = By.id("login-button");


    public Login(WebDriver driver){
        this.driver =driver;
        this.actionBot =new ActionsBot(driver);
    }



    public Login loginPage(String name , String pass){
       actionBot.type(username,name);
       actionBot.type(password,pass);
       actionBot.click(loginbtn);
        return  this;
    }

    public HomePage PageUrl(String expUrl){
        Assert.assertEquals(driver.getCurrentUrl(),expUrl);
        return new HomePage(driver);

    }
}
