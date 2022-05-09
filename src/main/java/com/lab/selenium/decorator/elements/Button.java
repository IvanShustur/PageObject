package com.lab.selenium.decorator.elements;

import DriverFactory.DriverProvider;
import com.lab.selenium.decorator.PageElement;
import com.lab.selenium.util.WaitUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Button extends PageElement {
    private static final Logger logger = LogManager.getLogger(Button.class);

    public Button(WebElement webElement, By by) {
        super(webElement, by);
    }

    public void scriptClick() {
        JavascriptExecutor executor = (JavascriptExecutor) DriverProvider.getDriver();
        executor.executeScript("arguments[0].click();", this);
    }

    public void saveClick() {
        logger.info("Wait element with locator {} to be clickable", getLocator());
        WaitUtils.elementToBeClickable(this).click();
    }

    public void actionClick() {
        Actions action = new Actions(DriverProvider.getDriver());
        action.click(this).build().perform();
    }
}