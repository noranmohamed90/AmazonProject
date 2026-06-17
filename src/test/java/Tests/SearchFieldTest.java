package Tests;

import Base.BaseTest;
import Data.Urls;
import Pages.Components.SearchComponent;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilties.*;


public class SearchFieldTest extends BaseTest {

    @Test
    public void validSearchTc(){
        search("validProduct")
               .verifySearchResultsDisplayed(utilities.JsonUtils.getValue("validProduct"));
        Assert.assertTrue(driver.getCurrentUrl().contains(
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
        Assert.assertEquals(driver.getCurrentUrl(), Urls.baseUrl);
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
        Assert.assertTrue(driver.getCurrentUrl().contains(
                utilities.JsonUtils.getValue("numericData")));
    }
    @Test
    public void searchDropDownTc(){
       new SearchComponent(driver)
               .inputSearchData(utilities.JsonUtils.getValue("dropDownSearch"))
               .dropDownVisibility()
               .dropDownVItem();
        Assert.assertTrue(driver.getCurrentUrl().contains(
                utilities.JsonUtils.getValue("urlData")));
    }
    @Test
    public void upperCaseSearchTc(){
       search("upperCaseSearch");
        Assert.assertTrue(driver.getCurrentUrl().contains(
                utilities.JsonUtils.getValue("upperCaseSearch")));
    }
    @Test
    public void specialCharactersSearchTc(){
        search("specialCharacterSearch")
                .verifySearchResultsDisplayed(utilities.JsonUtils.getValue("specialCharacterSearch"));
        Assert.assertNotEquals((driver.getCurrentUrl()),Urls.baseUrl);
    }
    @Test
    public void invalidLongTxtTc(){
        search("invalidLongTxt")
                .verifyNoResultsMessageDisplayed();
        Assert.assertNotEquals((driver.getCurrentUrl()),Urls.baseUrl);
    }
    @Test
    public void validLongTxtTc(){
        search("validLongTxt")
                .verifySearchResultsDisplayed(utilities.JsonUtils.getValue("validLongTxt"));
        Assert.assertNotEquals((driver.getCurrentUrl()),Urls.baseUrl);
    }
    @Test
    public void mixDataSearchTc(){
        search("mixSamples")
                .verifySearchResultsDisplayed(utilities.JsonUtils.getValue("mixSamples"));
        Assert.assertNotEquals((driver.getCurrentUrl()),Urls.baseUrl);
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
        Assert.assertTrue(driver.getCurrentUrl().contains(
                utilities.JsonUtils.getValue("urlData")));
    }



}
