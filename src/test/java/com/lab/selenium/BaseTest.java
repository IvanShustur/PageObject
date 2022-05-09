package com.lab.selenium;

import DriverFactory.DriverProvider;
import com.lab.selenium.listener.RozetkaTestListener;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;

import java.util.NoSuchElementException;


@Listeners(RozetkaTestListener.class)
public class BaseTest {

    @AfterMethod
    public void tearDown() {
        DriverProvider.quitDriver();
    }

    public boolean isElementPresent(WebElement el) {
        try {
            el.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}