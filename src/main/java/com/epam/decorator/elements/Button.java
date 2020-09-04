package com.epam.decorator.elements;

import com.epam.decorator.BaseElement;
import com.epam.utils.DriverWaitProvider;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Button extends BaseElement {
    public Button(WebElement webElement) {
        super(webElement);
    }

    public void click() {
        waitOnElementToBeClickable();
        webElement.click();
    }

    private void waitOnElementToBeClickable() {
        DriverWaitProvider.getInstance().until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public boolean isDisplayed() {
        return webElement.isDisplayed();
    }

    public boolean isEnabled() {
        return webElement.isEnabled();
    }
}
