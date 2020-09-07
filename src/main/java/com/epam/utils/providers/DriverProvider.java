package com.epam.utils.providers;

import com.epam.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class DriverProvider implements Constants {
    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();

    static {
        System.setProperty(DRIVER_NAME, DRIVER_PATH);
    }

    private DriverProvider() {
    }

    public static WebDriver getInstance() {
        if (Objects.isNull(driverPool.get())) {
            setUp();
        }
        return driverPool.get();
    }

    public static void quit() {
        if (Objects.nonNull(driverPool.get())) {
            driverPool.get().quit();
            driverPool.set(null);
        }
    }

    private static void setUp() {
        driverPool.set(new ChromeDriver());
        driverPool.get().manage()
                .timeouts()
                .implicitlyWait(TIME_WAIT, TimeUnit.SECONDS);
    }
}
