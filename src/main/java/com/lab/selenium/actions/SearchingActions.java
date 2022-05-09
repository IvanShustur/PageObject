package com.lab.selenium.actions;

import com.lab.selenium.page.HomePage;
import io.qameta.allure.Step;

public class SearchingActions {

    private final HomePage homePage;

    public SearchingActions(){
        homePage = new HomePage();}

    @Step("Open catalog")
    public void openCatalog(){
        openCatalog();
    }


    @Step("Input [{name}] of a product")
    public void searchProduct(String name){
        homePage.searchByKeyword(name);
    }
}
