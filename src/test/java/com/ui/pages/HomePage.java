package com.ui.pages;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BrowserUtility {

    final static  By SIGN_IN_LINK_LOCATOR = By.className("login");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void goToLoginInPage(){
        clickOn(SIGN_IN_LINK_LOCATOR);
    }
}
