package com.ui.pages;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BrowserUtility {

    private final static By SIGN_IN_LINK_LOCATOR = By.className("login");

    public HomePage(WebDriver driver) {
        super(driver);
        goToWebsite("http://www.automationpractice.pl/index.php");
    }

    public LoginPage goToLoginInPage() {
        clickOn(SIGN_IN_LINK_LOCATOR);
        LoginPage loginPage = new LoginPage(getDriver());
        return loginPage;
    }
}
