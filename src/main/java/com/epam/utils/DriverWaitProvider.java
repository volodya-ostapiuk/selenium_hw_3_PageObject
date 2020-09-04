package com.epam.utils;

import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverWaitProvider implements Constants {
    private static WebDriverWait webDriverWait;

    public static WebDriverWait getInstance() {
        if (webDriverWait == null) {
            webDriverWait = new WebDriverWait(DriverProvider.getInstance(), TIME_WAIT);
        }
        return webDriverWait;
    }
}
