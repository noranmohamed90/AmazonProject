package Pages.Components;

import bots.ActionsBot;
import bots.WaitBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

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

    public SearchComponent inputSearchData(String  product){
        actionsBot.type(searchField ,product);
        return this;
    }

    public SearchComponent clickSearchBtn(){
        actionsBot.click(searchIcon);
        return this;
    }
//    public SearchComponent productclick(){
//        actionsBot.click(firstProductLink);
//        return this;
//    }

    public void verifySearchResultsDisplayed(){
        Assert.assertTrue(driver.findElement(searchResultTxt).isDisplayed());
    }

    public void verifyNoResultsMessageDisplayed(){
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
