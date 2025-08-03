package com.utility;

import com.constants.Browser;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class BrowserUtility {

    private WebDriver driver;
    Logger logger = LoggerUtility.getLogger(this.getClass());

    public BrowserUtility(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }


    public BrowserUtility(Browser browserName) {
        logger.info("Launching browser for {}", browserName);
        if (browserName == Browser.CHROME) {
            driver = new ChromeDriver();
        } else if (browserName == Browser.FIREFOX) {
            driver = new FirefoxDriver();
        } else if (browserName == Browser.EDGE) {
            driver = new EdgeDriver();
        } else {
            logger.error("Invalid Browser Name...Please select Chrome, Edge or Firefox only");
            System.err.print("Invalid Browser Name...Please select Chrome, Edge or Firefox only");
        }
    }

    public void goToWebsite(String url) {
        logger.info("Visiting the Website {}", url);
        driver.get(url);
    }

    public void maximizeWindow() {
        logger.info("Maximizing the browser window.");
        driver.manage().window().maximize();
    }

    public void clickOn(By locator) {
        logger.info("Finding element with the locator {}", locator);
        WebElement element = driver.findElement(locator);
        logger.info("Element found and now performing click.");
        element.click();
    }

    public void enterText(By locator, String textToEnter) {
        logger.info("Finding element with the locator {}", locator);
        WebElement emailTextBoxWebElement = driver.findElement(locator);
        logger.info("Element found and now entering text : {}", textToEnter);
        emailTextBoxWebElement.sendKeys(textToEnter);
    }

    public String getVisibleText(By locator) {
        logger.info("Returning visible text");
        WebElement element = driver.findElement(locator);
        return element.getText();
    }

}
