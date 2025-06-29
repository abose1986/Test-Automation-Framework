package com.ui.test;

import static com.constants.Browser.*;

import com.ui.pages.HomePage;

import static org.testng.Assert.*;

import com.ui.pojo.User;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {

    HomePage homePage;

    @BeforeMethod(description = "Load the Homepage of the website")
    public void setUp() {
        homePage = new HomePage(EDGE);
    }

    /*
    Test Method !!!
        1. Test Script should be small
        2. Conditionals, Looping and try-catch statements are not allowed
           Test scripts should only follow the test steps
        3. Reduce the use of local variables
        4. You should have at least one assertion
     */
    @Test(description = "Verifies if the valid user is able to login into the application", groups = {"e2e", "sanity"},
            dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestDataProvider")
    public void loginTest(User user) {
        assertEquals(homePage.goToLoginInPage()
                .doLoginWith(user.getEmailAddress(), user.getPassword())
                .getUserName(), "Ricky Ponting");
    }

    @Test(description = "Verifies if the valid user is able to login into the application", groups = {"e2e", "sanity"},
            dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestCSVDataProvider")
    public void loginCSVTest(User user) {
        assertEquals(homePage.goToLoginInPage()
                .doLoginWith(user.getEmailAddress(), user.getPassword())
                .getUserName(), "Ricky Ponting");
    }

    @Test(description = "Verifies if the valid user is able to login into the application", groups = {"e2e", "sanity"},
            dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestExcelDataProvider")
    public void loginExcelTest(User user) {
        assertEquals(homePage.goToLoginInPage()
                .doLoginWith(user.getEmailAddress(), user.getPassword())
                .getUserName(), "Ricky Ponting");
    }

    @AfterMethod
    public void tearDown() {
        if (homePage.getDriver() != null)
            homePage.getDriver().quit();
    }
}
