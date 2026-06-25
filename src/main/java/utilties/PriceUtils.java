package utilties;

import bots.ActionsBot;
import bots.WaitBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;


public class PriceUtils {

    WebDriver driver;
    WaitBot waitBot;

    public PriceUtils(WebDriver driver){
        this.driver=driver;
        waitBot =new WaitBot(driver);
    }

    public void low2HighPriceList(By locator){

        waitBot.fluentWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
        List<WebElement> prices = driver.findElements(locator);
        int firstPrice = Integer.parseInt(prices.get(9).getText().replace(",", "").trim());
        int secondPrice = Integer.parseInt(prices.get(10).getText().replace(",", "").trim());
        Assert.assertTrue(firstPrice <= secondPrice
                ,"First price " + firstPrice + " is not <= second price " + secondPrice);
        System.out.println(firstPrice +" "+secondPrice);

    }
    public void high2LowPriceList(By locator){

        waitBot.fluentWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
        List<WebElement> prices = driver.findElements(locator);
        int firstPrice = Integer.parseInt(prices.get(9).getText().replace(",", "").trim());
        int secondPrice = Integer.parseInt(prices.get(10).getText().replace(",", "").trim());
        Assert.assertTrue(firstPrice >= secondPrice
                ,"First price " + firstPrice + " is not <= second price " + secondPrice);
        System.out.println(firstPrice +" "+secondPrice);

    }
}
