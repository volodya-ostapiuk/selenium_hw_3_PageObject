package com.epam.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverProvider implements Constants {
    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();

    static {
        System.setProperty(DRIVER_NAME, DRIVER_PATH);
    }

    private DriverProvider() {
        driverPool.set(new ChromeDriver());
        driverPool.get().manage()
                .timeouts()
                .implicitlyWait(TIME_WAIT, TimeUnit.SECONDS);
    }

    public static WebDriver getInstance() {
        if (driverPool == null) {
            new DriverProvider();
        }
        return driverPool.get();
    }

    public static void quit() {
        if (driverPool != null) {
            driverPool.get().quit();
            driverPool.set(null);
        }
    }
}
