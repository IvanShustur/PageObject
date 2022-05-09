package com.lab.selenium.actions;

import com.lab.selenium.page.ItemPage;
import com.lab.selenium.page.SearchResultPage;
import io.qameta.allure.Step;

public class BuyActions {
    private final ItemPage itemPage;
    private final SearchResultPage searchResultPage;

    public BuyActions(){
        itemPage = new ItemPage();
        searchResultPage = new SearchResultPage();
    }
    @Step("Buy product")
    public void buyItem(){
        searchResultPage.chooseFirstItemFromTheList();
        itemPage.clickOnAddToCartButton();
    }
}
