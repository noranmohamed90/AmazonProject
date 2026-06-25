package Tests;

import Base.BaseTest;
import Data.Urls;
import Pages.Components.SearchComponent;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilties.*;


public class SearchFieldTest extends BaseTest {



    @Test
    public void validSearchTc(){
        search("validProduct")
               .verifySearchResultsDisplayed(utilities.JsonUtils.getValue("validProduct"));
        Assert.assertTrue(getDriver().getCurrentUrl().contains(
                utilities.JsonUtils.getValue("urlData")));
    }
    @Test
    public void InvalidSearchTc(){
        search("inValidProduct")
                .verifyNoResultsMessageDisplayed();
    }
    @Test
    public void emptySearchTc(){
        search("emptyData");
        Assert.assertEquals(getDriver().getCurrentUrl(), Urls.baseUrl);
    }
    @Test
    public void mixLangSearchTc(){
        search("mixLangue")
                .verifySearchResultsDisplayed(utilities.JsonUtils.getValue("mixLangue"));
    }

    @Test
    public void arabicLangSearchTc(){
        search("arabicLan")
                .verifySearchResultsDisplayed(utilities.JsonUtils.getValue("arabicLan"));
    }
    @Test
    public void numericDataSearchTc(){
        search("numericData");
        Assert.assertTrue(getDriver().getCurrentUrl().contains(
                utilities.JsonUtils.getValue("numericData")));
    }
    @Test
    public void searchDropDownTc(){
       new SearchComponent(getDriver())
               .inputSearchData(utilities.JsonUtils.getValue("dropDownSearch"))
               .dropDownVisibility()
               .dropDownVItem();
        Assert.assertTrue(getDriver().getCurrentUrl().contains(
                utilities.JsonUtils.getValue("urlData")));
    }
    @Test
    public void upperCaseSearchTc(){
       search("upperCaseSearch");
        Assert.assertTrue(getDriver().getCurrentUrl().contains(
                utilities.JsonUtils.getValue("upperCaseSearch")));
    }
    @Test
    public void specialCharactersSearchTc(){
        search("specialCharacterSearch")
                .verifySearchResultsDisplayed(utilities.JsonUtils.getValue("specialCharacterSearch"));
        Assert.assertNotEquals((getDriver().getCurrentUrl()),Urls.baseUrl);
    }
    @Test
    public void invalidLongTxtTc(){
        search("invalidLongTxt")
                .verifyNoResultsMessageDisplayed();
        Assert.assertNotEquals((getDriver().getCurrentUrl()),Urls.baseUrl);
    }
    @Test
    public void validLongTxtTc(){
        search("validLongTxt")
                .verifySearchResultsDisplayed(utilities.JsonUtils.getValue("validLongTxt"));
        Assert.assertNotEquals((getDriver().getCurrentUrl()),Urls.baseUrl);
    }
    @Test
    public void mixDataSearchTc(){
        search("mixSamples")
                .verifySearchResultsDisplayed(utilities.JsonUtils.getValue("mixSamples"));
        Assert.assertNotEquals((getDriver().getCurrentUrl()),Urls.baseUrl);
    }
    @Test
    public void leadingSearchTc() {
        search("trailingSpaces")
                .verifySearchResultsDisplayed(utilities.JsonUtils.getValue("trailingSpaces").trim());
    }

    @Test
    public void validSearchWithEnterTc(){
       searchWithEnter("validProduct")
               .verifySearchResultsDisplayed(utilities.JsonUtils.getValue("validProduct"));
        Assert.assertTrue(getDriver().getCurrentUrl().contains(
                utilities.JsonUtils.getValue("urlData")));
    }



}
