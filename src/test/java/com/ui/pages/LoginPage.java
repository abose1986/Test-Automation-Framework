package com.ui.pages;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BrowserUtility {

    private final static By EMAIL_TEXT_BOX_LOCATOR = By.id("email");
    private final static By PASSWORD_TEXT_BOX_LOCATOR = By.id("passwd");
    private final static By SUBMIT_LOGIN_BUTTON_LOCATOR = By.id("SubmitLogin");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public MyAccount doLoginWith(String emailAddress, String password) {
        enterText(EMAIL_TEXT_BOX_LOCATOR, emailAddress);
        enterText(PASSWORD_TEXT_BOX_LOCATOR, password);
        clickOn(SUBMIT_LOGIN_BUTTON_LOCATOR);
        MyAccount myAccountPage = new MyAccount(getDriver());
        return myAccountPage;
    }
}
