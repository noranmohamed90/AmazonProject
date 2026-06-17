package Pages;

import bots.ActionsBot;
import bots.WaitBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import utilties.FilterUtils;

import java.util.List;

public class FiltersPage {

    WebDriver driver;
    ActionsBot actionsBot;
    WaitBot waitBot;
    FilterUtils filterUtils;

    public FiltersPage(WebDriver driver) {
        this.driver = driver;
        actionsBot = new ActionsBot(driver);
        waitBot =new WaitBot(driver);
        filterUtils=new FilterUtils(driver);

    }

    private final By brandCheckBox = By.xpath("//span[text()='Apple']");
    private final By productsTitleList =By.cssSelector("h2.a-size-base-plus span");
    private final By daysList =By.cssSelector("a-row a-color-base udm-secondary-delivery-message");
    private final By deliveryCheckBox =By.xpath("//span[normalize-space()='Get It by Tomorrow']");


    public FiltersPage brandFilterVisibility() {
        waitBot.fluentWait().until(ExpectedConditions.visibilityOfElementLocated(brandCheckBox));
        Assert.assertTrue( driver.findElement(brandCheckBox).isDisplayed());
        return this;
    }
    public FiltersPage filterWithBrand() {
        brandFilterVisibility();
        actionsBot.click(brandCheckBox);
        filterUtils.productTitles(brandCheckBox,productsTitleList);
        return this;
    }


    public FiltersPage deliveryFilterVisibility() {
        waitBot.fluentWait().until(ExpectedConditions.visibilityOfElementLocated(deliveryCheckBox));
        Assert.assertTrue( driver.findElement(deliveryCheckBox).isDisplayed());
        return this;
    }
    public FiltersPage filterWithDeliveryDay() {
        deliveryFilterVisibility();
        actionsBot.click(deliveryCheckBox);
        filterUtils.deliveryDay(deliveryCheckBox,daysList);
        return this;
    }

    public boolean invalidBrandFilter() {
        return !driver.findElements(brandCheckBox).isEmpty();
    }
}


