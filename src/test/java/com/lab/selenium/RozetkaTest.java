package com.lab.selenium;

import com.lab.selenium.actions.BuyActions;
import com.lab.selenium.actions.FilteringActions;
import com.lab.selenium.actions.NavigationActions;
import com.lab.selenium.actions.SearchingActions;
import com.lab.selenium.model.Filter;
import com.lab.selenium.page.ShoppingCartPage;
import com.lab.selenium.util.FileReader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;


public class RozetkaTest extends  BaseTest {


    @DataProvider(parallel = true)
    public Object[] filters() {
        List<Filter> filterList = FileReader.readListOfObject("src/main/resources/filters.json", Filter.class);
        return  filterList.toArray();
    }


    @Test(dataProvider = "filters")
    public void checkThatThePriceOFProductHigherThanGivenPrice(Filter filter) {
        NavigationActions navigationActions = new NavigationActions();
        SearchingActions searchingActions = new SearchingActions();
        FilteringActions filteringActions = new FilteringActions();
        BuyActions buyActions = new BuyActions();
        //PriceAsserter priceAsserter = new PriceAsserter();
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        navigationActions.navigateToHomePage();
        searchingActions.searchProduct(filter.getName());
        filteringActions.filteringProduct(filter.getBrand());
        buyActions.buyItem();
        //priceAsserter.compareThatThePriceHigherThenGivenSum(filter);


       Assert.assertTrue(Integer.parseInt(shoppingCartPage.getPriceOfItem()) > Integer.parseInt(filter.getSum()));
    }
}







