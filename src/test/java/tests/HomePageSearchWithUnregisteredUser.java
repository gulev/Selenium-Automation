package tests;

import com.practice.webpages.BasePage;
import com.practice.webpages.ProductDetailsPage;
import org.junit.Test;
import com.practice.webpages.SearchResultPage;
import org.junit.jupiter.api.Assertions;

public class HomePageSearchWithUnregisteredUser extends BaseTest {

    @Test
    public void UsingEnter(){
        String searchCriteria = "Printed";
        String returnedItems = "5";
        BasePage basePage = new BasePage();
        SearchResultPage searchResultPage = new SearchResultPage();
        basePage.emptySearchField();
        basePage.searchAndPressEnter(searchCriteria);
        Assertions.assertEquals(returnedItems, searchResultPage.getReturnedItems());
    }

    @Test
    public  void UsingSearchButton(){
        String searchCriteria = "Printed";
        String returnedItems = "5";
        BasePage basePage = new BasePage();
        SearchResultPage searchResultPage = new SearchResultPage();
        basePage.emptySearchField();
        basePage.enterTextInSearchField(searchCriteria);
        basePage.clickSearchButton();
        Assertions.assertEquals(returnedItems, searchResultPage.getReturnedItems());
    }

    @Test
    public  void ForNonExistingItem(){
        String searchCriteria = "Pats";
        String returnedItems = "0";
        BasePage basePage = new BasePage();
        SearchResultPage searchResultPage = new SearchResultPage();
        basePage.emptySearchField();
        basePage.searchAndPressEnter(searchCriteria);
        Assertions.assertEquals(returnedItems, searchResultPage.getReturnedItems());
        Assertions.assertTrue(searchResultPage.isSearchResultEmpty(searchCriteria));
    }

    @Test
    public  void WithEmptyCriteria(){
        String resultsNumber  = "0";
        BasePage basePage = new BasePage();
        SearchResultPage searchResultPage = new SearchResultPage();
        basePage.emptySearchField();
        basePage.searchAndPressEnter(""); //String.EMPTY
        Assertions.assertEquals(resultsNumber, searchResultPage.getReturnedItems());
        Assertions.assertTrue(searchResultPage.isSearchInvalid());
    }

    @Test
    public  void ForElementsThatAppearInAutoCompleteAndClickOnOne(){
        String searchCriteria = "dress";
        BasePage basePage = new BasePage();
        basePage.emptySearchField();
        basePage.enterValueInSearchField(searchCriteria);
        Assertions.assertTrue(basePage.isAutoCompleteDisplayed ());
        basePage.clickElementFromAutoComplete(1);
        ProductDetailsPage productDetailsPage = new ProductDetailsPage();
        Assertions.assertTrue(productDetailsPage.isShortDescriptionExists());
        Assertions.assertTrue(productDetailsPage.isAddToCardButtonExist());
    }
}