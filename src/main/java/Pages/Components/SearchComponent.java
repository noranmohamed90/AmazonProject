package Pages.Components;

import bots.ActionsBot;
import bots.WaitBot;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.security.Key;

public class SearchComponent {

    WebDriver driver;
    ActionsBot actionsBot;
    WaitBot waitBot;

    public SearchComponent(WebDriver driver){
        this.driver =driver;
        this.actionsBot = new ActionsBot(driver);
        this.waitBot = new WaitBot(driver);
    }

    private final By searchField = By.cssSelector("input[name='field-keywords']");
    private final By searchIcon = By.id("nav-search-submit-button");
//    private final By firstProductLink = By.cssSelector(
//            "[cel_widget_id=\"MAIN-SEARCH_RESULTS-3"
//    );
    private final By searchResultTxt = By.cssSelector(".a-color-state.a-text-bold");
    private final By invalidSearchTxt = By.cssSelector("[class='a-size-medium a-color-base a-text-normal']");
    private final By searchDropDown = By.id("sac-autocomplete-results-container");
    private final By dropDownItem = By.id("sac-suggestion-row-1-cell-1");

    public SearchComponent searchFieldVisibility(){
        waitBot.fluentWait().until(ExpectedConditions.visibilityOfElementLocated(searchField));
        Assert.assertTrue(driver.findElement(searchField).isDisplayed());
        return this;
    }


    public SearchComponent inputSearchData(String  product){
        actionsBot.type(searchField ,product);
        return this;
    }

    public SearchComponent clickSearchBtn(){
        actionsBot.click(searchIcon);
        return this;
    }

    public SearchComponent searchWithEnter(){
        driver.findElement(searchField).sendKeys(Keys.ENTER);
        return this;
    }
//    public SearchComponent productclick(){
//        actionsBot.click(firstProductLink);
//        return this;
//    }

    public void verifySearchResultsDisplayed(String searchData){
        waitBot.fluentWait().until(ExpectedConditions.visibilityOfElementLocated(searchResultTxt));
        Assert.assertTrue(driver.findElement(searchResultTxt).isDisplayed());
        Assert.assertTrue(driver.findElement(searchResultTxt).getText().contains(searchData));
    }

    public void verifyNoResultsMessageDisplayed(){
        waitBot.fluentWait().until(ExpectedConditions.visibilityOfElementLocated(invalidSearchTxt));
        Assert.assertTrue(driver.findElement(invalidSearchTxt).isDisplayed());
    }

    public SearchComponent dropDownVisibility(){
        waitBot.fluentWait().until(ExpectedConditions.visibilityOfElementLocated(searchDropDown));
        Assert.assertTrue(driver.findElement(searchDropDown).isDisplayed());
        return this;
    }

    public void dropDownVItem(){
        actionsBot.click(dropDownItem);
    }
}
