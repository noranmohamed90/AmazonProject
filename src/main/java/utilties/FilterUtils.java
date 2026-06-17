package utilties;

import bots.WaitBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class FilterUtils {
    WebDriver driver;
    WaitBot waitBot;

    public FilterUtils(WebDriver driver){
        this.driver=driver;
        waitBot =new WaitBot(driver);
    }

    public void productTitles(By locator , By listLocator) {
        waitBot.fluentWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
        List<WebElement> products = driver.findElements(listLocator);
        for (int i = 0; i < Math.min(products.size(), 5); i++) {
            String titles = products.get(i).getText().toLowerCase();
            Assert.assertTrue(
                    titles.contains("apple") || titles.contains("iphone"),
                    "Phone Brand is not apple"
            );
        }
    }
    public void deliveryDay(By locator , By listLocator){
        waitBot.fluentWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
        List<WebElement>products= driver.findElements(listLocator);
        for(int i=0;i< Math.min(products.size(),5);i++){
            String Days = products.get(i).getText();
            Assert.assertTrue(
                    Days.contains("Tomorrow")||Days.contains("fastest delivery"),
                    "Product does not have Tomorrow or Fastest Delivery"
            );
        }


    }
}

