package com.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class LambdaTestUtility {
    public static final String HUB_URL = "https://hub.lambdatest.com/wd/hub";
    private static ThreadLocal<WebDriver> driverLocal = new ThreadLocal<>();
    private static ThreadLocal<DesiredCapabilities> capabilitiesLocal = new ThreadLocal<>();

    public static WebDriver initializeLambdaTestSession(String browser, String testName) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", browser);
        capabilities.setCapability("browserVersion", "138");
        Map<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("user", "abhi123.bose");
        ltOptions.put("accessKey", "gxEbfqUBDC0zZPpiajl7finfWgNAarKNIonoRrPXI4hwGpCSLx");
        ltOptions.put("build", "Selenium 4");
        ltOptions.put("name", testName);
        ltOptions.put("platformName", "Windows 10");
        ltOptions.put("seCdp", true);
        ltOptions.put("selenium_version", "4.33.0");
        capabilities.setCapability("LT:Options", ltOptions);
        capabilitiesLocal.set(capabilities);
        WebDriver driver = null;

        try {
            driver = new RemoteWebDriver(new URL(HUB_URL), capabilitiesLocal.get());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        driverLocal.set(driver);
        return driverLocal.get();
    }

    public static void quitSession() {
        if (driverLocal.get() != null) {
            driverLocal.get().quit();
        }
    }
}
