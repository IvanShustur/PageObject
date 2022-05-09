package com.lab.selenium.page;

import DriverFactory.DriverProvider;
import com.lab.selenium.decorator.CustomFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    protected BasePage() {
        PageFactory.initElements(new CustomFieldDecorator(DriverProvider.getDriver()), this);
    }
}