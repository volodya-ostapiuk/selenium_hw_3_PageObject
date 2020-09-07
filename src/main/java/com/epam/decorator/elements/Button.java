package com.epam.decorator.elements;

import com.epam.decorator.BaseElement;
import com.epam.utils.Wait;
import com.epam.utils.providers.DriverWaitProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Button extends BaseElement {
    private static Logger logger = LogManager.getLogger(Button.class);

    public Button(WebElement webElement) {
        super(webElement);
    }

    public void click() {
        logger.info("Clicking on button with location: " + webElement.getLocation());
        Wait.waitOnElementToBeClickable(webElement);
        webElement.click();
    }
}
