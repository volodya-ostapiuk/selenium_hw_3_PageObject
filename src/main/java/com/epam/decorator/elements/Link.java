package com.epam.decorator.elements;

import com.epam.decorator.BaseElement;
import com.epam.utils.DriverWaitProvider;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Link extends BaseElement {
    public Link(WebElement webElement) {
        super(webElement);
    }

    public void click() {
        waitOnElementToBeClickable();
        webElement.click();
    }

    private void waitOnElementToBeClickable() {
        DriverWaitProvider.getInstance().until(ExpectedConditions.elementToBeClickable(webElement));
    }
}
