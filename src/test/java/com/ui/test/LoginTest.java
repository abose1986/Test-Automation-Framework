package com.ui.test;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        BrowserUtility browserUtility = new BrowserUtility(driver);

        browserUtility.goToWebsite("http://www.automationpractice.pl/index.php");

        browserUtility.maximizeWindow();

        By signInLinkLocator = By.className("login");
        browserUtility.clickOn(signInLinkLocator);

        By emailTextBoxLocator = By.id("email");
        browserUtility.enterText(emailTextBoxLocator, "payeba8662@baxima.com");

        By passwordTextBoxLocator = By.id("passwd");
        browserUtility.enterText(passwordTextBoxLocator, "password");

        By submitLoginButtonLocator = By.id("SubmitLogin");
        browserUtility.clickOn(submitLoginButtonLocator);

    }
}
