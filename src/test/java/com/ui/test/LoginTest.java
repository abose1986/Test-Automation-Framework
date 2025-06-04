package com.ui.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.automationpractice.pl/index.php");
        driver.manage().window().maximize();

        By signInLinkLocator = By.className("login");
        WebElement signInLinkWebElement = driver.findElement(signInLinkLocator);
        signInLinkWebElement.click();

        By emailTextBoxLocator = By.id("email");
        WebElement emailTextBoxWebElement = driver.findElement(emailTextBoxLocator);
        emailTextBoxWebElement.sendKeys("payeba8662@baxima.com");

        By passwordTextBoxLocator = By.id("passwd");
        WebElement passwordTextBoxWebElement = driver.findElement(passwordTextBoxLocator);
        passwordTextBoxWebElement.sendKeys("password");

        By submitLoginButtonLocator = By.id("SubmitLogin");
        WebElement submitLoginWebElement = driver.findElement(submitLoginButtonLocator);
        submitLoginWebElement.click();

    }
}
