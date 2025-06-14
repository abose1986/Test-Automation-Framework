package com.ui.test;

import com.ui.pages.HomePage;
import com.ui.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.goToLoginInPage();
        String username = loginPage.doLoginWith("payeba8662@baxima.com","password").getUserName();
    }
}
