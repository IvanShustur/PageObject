package com.lab.selenium.decorator.elements;

import com.lab.selenium.decorator.PageElement;
import com.lab.selenium.util.WaitUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Label extends PageElement {
    private static final Logger logger = LogManager.getLogger(Label.class);

    public Label(WebElement webElement, By by) {
        super(webElement, by);
    }

    @Override
    public boolean isDisplayed() {
        logger.info("Wait element with locator {} to be presence", getLocator());
        WaitUtils.waitForElementPresence(getLocator());
        return this.isDisplayed();
    }

    public Label waitTextToBe(String text) {
        logger.debug("Wait text to be in element with locator {} to be presence", getLocator());
        WaitUtils.waitTextToBe(locator, text);
        return this;
    }
}
