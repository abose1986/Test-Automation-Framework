package com.ui.pages;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccount extends BrowserUtility {
    private final static By USER_NAME_LOCATOR = By.xpath("//a[@title='View my customer account']//span");
    public MyAccount(WebDriver driver) {
        super(driver);
    }

    public String getUserName(){
        return getVisibleText(USER_NAME_LOCATOR);
    }
}
