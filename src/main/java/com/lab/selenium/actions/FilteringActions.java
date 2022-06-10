package com.lab.selenium.actions;

import com.lab.selenium.page.SearchResultPage;
import io.qameta.allure.Step;

public class FilteringActions {
    private final SearchResultPage searchResultPage;

    public FilteringActions(){searchResultPage = new SearchResultPage();}

    @Step("Filter product by additional parameters")
    public void filteringProduct(String brand) throws InterruptedException {
        searchResultPage.searchInTheSideBarSearchBoxByKeyword(brand);
        searchResultPage.clickOnTheFirstBrandBox(brand);
        searchResultPage.sortingFromHighToLowPrice();
    }
}
