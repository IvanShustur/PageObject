package com.lab.selenium.asserts;

import com.lab.selenium.model.Filter;
import com.lab.selenium.page.HomePage;
import com.lab.selenium.page.ShoppingCartPage;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

public class PriceAsserter {
    private final ShoppingCartPage shoppingCartPage;
    private static final Logger logger = LogManager.getLogger(HomePage.class);

    public PriceAsserter(){shoppingCartPage = new ShoppingCartPage();}

    @Step("Verify cost of a product with given [{filter.getSum()}]")
    public void compareThatThePriceHigherThenGivenSum(Filter filter){
        Assert.assertTrue(Integer.parseInt(shoppingCartPage.getPriceOfItem()) > Integer.parseInt(filter.getSum()));
        logger.info("The price of product was compared to given price");
    }
}
