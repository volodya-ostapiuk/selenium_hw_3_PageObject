package com.epam.decorator.elements;

import com.epam.decorator.BaseElement;
import com.epam.utils.providers.DriverWaitProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TextField extends BaseElement {
    private static Logger logger = LogManager.getLogger(TextField.class);

    public TextField(WebElement webElement) {
        super(webElement);
    }

    public void sendKeys(String text) {
        logger.info("Typing textField value: " + text);
        waitOnElementToBeVisible();
        webElement.sendKeys(text);
    }

    public void typeAndEnter(String text) {
        logger.info("Typing and entering textField value: " + text);
        waitOnElementToBeClickable();
        webElement.sendKeys(text);
        webElement.sendKeys(Keys.ENTER);
    }

    public void click() {
        logger.info("Clicking on textField.");
        waitOnElementToBeClickable();
        webElement.click();
    }

    public String getText() {
        logger.info("Getting text from textField.");
        return webElement.getText();
    }

    public String getAttribute(String attribute) {
        logger.info("Getting attribute from textField.");
        return webElement.getAttribute(attribute);
    }

    private void waitOnElementToBeVisible() {
        DriverWaitProvider.getInstance().until(ExpectedConditions.visibilityOf(webElement));
    }

    private void waitOnElementToBeClickable() {
        DriverWaitProvider.getInstance().until(ExpectedConditions.elementToBeClickable(webElement));
    }
}
