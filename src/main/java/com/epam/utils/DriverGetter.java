package com.epam.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverGetter implements Constants {
    private static WebDriver webDriver;

    static {
        System.setProperty(DRIVER_NAME, DRIVER_PATH);
    }

    public static WebDriver getInstance() {
        if (webDriver == null) {
            webDriver = setUp();
        }
        return webDriver;
    }

    private static WebDriver setUp() {
        webDriver = new ChromeDriver();
        webDriver.manage()
                .timeouts()
                .implicitlyWait(TIME_WAIT, TimeUnit.SECONDS);
        return webDriver;
    }
}
