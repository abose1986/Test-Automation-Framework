package com.ui.test;

import com.ui.pages.HomePage;
import com.utility.BrowserUtility;

import static com.utility.LambdaTestUtility.*;

import com.utility.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import static com.constants.Browser.*;

public class BaseTest {

    protected HomePage homePage;
    Logger logger = LoggerUtility.getLogger(this.getClass());
    private boolean isLambdaTest;


    @Parameters({"browser", "isLambdaTest", "isHeadless"})
    @BeforeMethod(description = "Load the Homepage of the website")

    public void setUp(
            @Optional("chrome") String browser,
            @Optional("false") boolean isLambdaTest,
            @Optional("true") boolean isHeadless,
            ITestResult result
    ) {
        this.isLambdaTest = isLambdaTest;
        WebDriver lambdaDriver;
        if (isLambdaTest) {
            lambdaDriver = initializeLambdaTestSession(browser, result.getMethod().getMethodName());
            homePage = new HomePage(lambdaDriver);
        } else {
            logger.info("Loads the Home page of the website");
            homePage = new HomePage(valueOf(browser.toUpperCase()), isHeadless);
        }
    }

    public BrowserUtility getInstance() {
        return homePage;
    }

    @AfterMethod
    public void tearDown() {
        if (isLambdaTest) {
            quitSession();
        } else {
            if (homePage.getDriver() != null)
                homePage.getDriver().quit();
        }

    }
}
