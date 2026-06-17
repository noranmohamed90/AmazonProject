package Pages;

import bots.ActionsBot;
import bots.WaitBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class ProductPage {

    WebDriver driver;
    ActionsBot actionsBot;
    WaitBot waitBot;

    public ProductPage(WebDriver driver){
        this.driver=driver;
        actionsBot =new ActionsBot(driver);
        waitBot = new WaitBot(driver);
    }

    private final By productContainer= By.xpath("//div[@data-component-type='s-search-result']");
    private final By productTitlesList = By.xpath("//h2[@aria-label]");
    private final By productTitle =By.id("productTitle");


    public ProductPage listVisible(){
        int i;
        waitBot.fluentWait().until(ExpectedConditions.visibilityOfElementLocated(productContainer));
        List<WebElement>productsList = driver.findElements(productContainer);
        for( i =0 ;i< Math.min(productsList.size(),15);i++) {
        }
        Assert.assertFalse(productsList.isEmpty(), "No products found");
        Assert.assertTrue(productsList.get(i).isDisplayed());
       return this;
    }


    public ProductPage titleVisibility(){
        int i;
        waitBot.fluentWait().until(ExpectedConditions.visibilityOfElementLocated(productTitlesList));
        List<WebElement>titleList = driver.findElements(productTitlesList);
        for( i =0 ;i< Math.min(titleList.size(),15);i++) {
        }
        Assert.assertFalse(titleList.isEmpty(), "No products found");
        Assert.assertTrue(titleList.get(i).isDisplayed());
        return this;
    }

    public ProductPage chooseProduct(){
        List<WebElement> titles = driver.findElements(productTitlesList);
        String expectedTitle =  titles.get(0).getText();
        titles.get(0).click();
        waitBot.fluentWait().until(ExpectedConditions.visibilityOfElementLocated(productTitle));
        String actualTitle =  actionsBot.getText(productTitle);
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        Assert.assertTrue(driver.getTitle().contains(expectedTitle));
        return this;
    }

    public  boolean inValidListTitles(){
       return !driver.findElements(productTitle).isEmpty();
    }

}
