package com.epam.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverProvider implements Constants {
    private static WebDriver webDriver;

    static {
        System.setProperty(DRIVER_NAME, DRIVER_PATH);
    }

    private DriverProvider() {
        webDriver = new ChromeDriver();
        webDriver.manage()
                .timeouts()
                .implicitlyWait(TIME_WAIT, TimeUnit.SECONDS);
    }

    public static WebDriver getInstance() {
        if (webDriver == null) {
            new DriverProvider();
        }
        return webDriver;
    }

    public static void quit() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
