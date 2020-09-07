package com.epam.decorator.elements;

import com.epam.decorator.BaseElement;
import com.epam.utils.providers.DriverWaitProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Link extends BaseElement {
    private static Logger logger = LogManager.getLogger(Link.class);

    public Link(WebElement webElement) {
        super(webElement);
    }

    public void click() {
        logger.info("Clicking on link with location: " + webElement.getLocation());
        waitOnElementToBeClickable();
        webElement.click();
    }

    private void waitOnElementToBeClickable() {
        DriverWaitProvider.getInstance().until(ExpectedConditions.elementToBeClickable(this.webElement));
    }
}
