package com.epam.pages;

import com.epam.decorator.CustomFieldDecorator;
import com.epam.utils.DriverProvider;
import com.epam.utils.DriverWaitProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;

    public BasePage() {
        this.webDriver = DriverProvider.getInstance();
        webDriverWait = DriverWaitProvider.getInstance();
        PageFactory.initElements(new CustomFieldDecorator(webDriver), this);
    }
}
