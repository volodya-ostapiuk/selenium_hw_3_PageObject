package com.epam.decorator.elements;

import com.epam.decorator.BaseElement;
import com.epam.utils.DriverWaitProvider;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TextField extends BaseElement {
    public TextField(WebElement webElement) {
        super(webElement);
    }

    public void sendKeys(String text) {
        waitOnElementToBeClickable();
        webElement.sendKeys(text);
    }

    public void typeAndEnter(String text) {
        waitOnElementToBeClickable();
        webElement.sendKeys(text);
        webElement.sendKeys(Keys.ENTER);
    }

    public void click() {
        waitOnElementToBeClickable();
        webElement.click();
    }

    public String getText() {
        return webElement.getText();
    }

    public String getAttribute(String attribute) {
        return webElement.getAttribute(attribute);
    }

    private void waitOnElementToBeClickable() {
        DriverWaitProvider.getInstance().until(ExpectedConditions.elementToBeClickable(webElement));
    }
}
