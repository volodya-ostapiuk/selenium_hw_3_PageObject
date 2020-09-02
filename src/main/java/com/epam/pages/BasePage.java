package com.epam.pages;

import com.epam.utils.Constants;
import com.epam.utils.DriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;

    public BasePage() {
        this.webDriver = DriverProvider.getInstance();
        webDriverWait = new WebDriverWait(webDriver, Constants.TIME_WAIT);
        PageFactory.initElements(webDriver, this);
    }
}
