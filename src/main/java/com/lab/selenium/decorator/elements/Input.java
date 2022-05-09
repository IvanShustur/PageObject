package com.lab.selenium.decorator.elements;

import DriverFactory.DriverProvider;
import com.lab.selenium.decorator.PageElement;
import com.lab.selenium.util.WaitUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Input extends PageElement {
    private static final Logger logger = LogManager.getLogger(Input.class);

    public Input(WebElement webElement, By by) {
        super(webElement, by);
    }

    public void clearAndSendKeys(CharSequence... keys) {
        clear();
        webElement.sendKeys(keys);
    }

    public void waitForFieldReadyToInput() {
        logger.info("Wait element with locator {} to be enabled", getLocator());
        WaitUtils.waitForElementToBeEnabled(this);
    }

    public void sendKeysAction(String... keys) {
        Actions action = new Actions(DriverProvider.getDriver());
        action.sendKeys(this, keys).build().perform();
    }
}
