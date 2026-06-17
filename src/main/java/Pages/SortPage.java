package Pages;

import bots.ActionsBot;
import bots.WaitBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import utilties.PriceUtils;

public class SortPage {

    WebDriver driver;
    ActionsBot actionsBot;
    WaitBot waitBot;
    PriceUtils priceUtils;

    public SortPage (WebDriver driver){
        this.driver=driver;
        actionsBot = new ActionsBot(driver);
        waitBot =new WaitBot(driver);
        priceUtils = new PriceUtils(driver);
    }

    private final By sortBtn = By.id("a-autoid-0-announce");
    private final By low2HighBtn = By.id("s-result-sort-select_1");
    private final By high2LowBtn = By.id("s-result-sort-select_2");
    private final By reviewsBtn = By.id("s-result-sort-select_3");
    private final By sellersBtn = By.id("s-result-sort-select_5");
    private final By newArrivalBtn = By.id("s-result-sort-select_4");
    private final By priceList = By.cssSelector("span.a-price-whole");
    private final By feature = By.cssSelector(".a-dropdown-prompt");






    public SortPage sortBtnVisibility(){
        waitBot.fluentWait().until(ExpectedConditions.visibilityOfElementLocated(sortBtn));
        Assert.assertTrue(driver.findElement(sortBtn).isDisplayed());
        return this;
    }

    public boolean isSortButtonDisplayed() {
        return !driver.findElements(sortBtn).isEmpty();
    }

    public SortPage sortLowToHigh(){
        actionsBot.click(sortBtn);
        actionsBot.click(low2HighBtn);
       priceUtils.low2HighPriceList(priceList);
        return this;
    }

    public SortPage sortHighToLow(){
        actionsBot.click(sortBtn);
        actionsBot.click(high2LowBtn);
        priceUtils.high2LowPriceList(priceList);
        return this;
    }

    public SortPage sortByReviews(){
        actionsBot.click(sortBtn);
        actionsBot.click(reviewsBtn);
        return this;
    }
    public SortPage sortByBestSellers(){
        actionsBot.click(sortBtn);
        actionsBot.click(sellersBtn);
        return this;
    }
    public SortPage sortByNewArrival(){
        actionsBot.click(sortBtn);
        actionsBot.click(newArrivalBtn);
        Assert.assertEquals (actionsBot.getText(feature).trim(),
                "Newest Arrivals");
        return this;
    }





}
