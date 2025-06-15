package com.ui.pages;

import com.constants.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.utility.BrowserUtility;

import static com.constants.Env.*;
import static com.utility.PropertiesUtil.*;


public final class HomePage extends BrowserUtility {

    private final static By SIGN_IN_LINK_LOCATOR = By.className("login");

    public HomePage(Browser browserName) {
        super(browserName);
        goToWebsite(readProperties(QA, "URL"));
        maximizeWindow();
    }

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public LoginPage goToLoginInPage() {
        clickOn(SIGN_IN_LINK_LOCATOR);
        LoginPage loginPage = new LoginPage(getDriver());
        return loginPage;
    }
}
