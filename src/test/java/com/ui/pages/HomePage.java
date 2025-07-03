package com.ui.pages;

import com.constants.Browser;
import com.utility.JSONUtility;
import com.utility.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.utility.BrowserUtility;

import static com.constants.Env.*;


public final class HomePage extends BrowserUtility {

    private final static By SIGN_IN_LINK_LOCATOR = By.className("login");
    Logger logger = LoggerUtility.getLogger(this.getClass());

    public HomePage(Browser browserName) {
        super(browserName);
        //goToWebsite(readProperties(QA, "URL"));
        goToWebsite(JSONUtility.readJson(QA).getUrl());
        maximizeWindow();
    }

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public LoginPage goToLoginInPage() {
        logger.info("Trying to perform click to navigate to Sign in page");
        clickOn(SIGN_IN_LINK_LOCATOR);
        return new LoginPage(getDriver());
    }
}
