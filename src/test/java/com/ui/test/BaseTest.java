package com.ui.test;

import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.constants.Browser.EDGE;

public class BaseTest {

    protected HomePage homePage;
    Logger logger = LoggerUtility.getLogger(this.getClass());

    @BeforeMethod(description = "Load the Homepage of the website")
    public void setUp() {
        logger.info("Loads the Home page of the website");
        homePage = new HomePage(EDGE, true);
    }

    public BrowserUtility getInstance() {
        return homePage;
    }

    @AfterMethod
    public void tearDown() {
        if (homePage.getDriver() != null)
            homePage.getDriver().quit();
    }
}
