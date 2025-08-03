package com.ui.test;

import static com.constants.Browser.EDGE;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;
import com.ui.pojo.User;
import com.utility.LoggerUtility;

@Listeners(com.ui.listeners.TestListener.class)
public class LoginTest {

    HomePage homePage;
    Logger logger = LoggerUtility.getLogger(this.getClass());

    @BeforeMethod(description = "Load the Homepage of the website")
    public void setUp() {
        logger.info("Loads the Home page of the website");
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
        Assert.assertEquals(homePage.goToLoginInPage()
                .doLoginWith(user.getEmailAddress(), user.getPassword())
                .getUserName(), "Alisha Chenoy");
    }

    @Test(description = "Verifies if the valid user is able to login into the application", groups = {"e2e", "sanity"},
            dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestCSVDataProvider")
    public void loginCSVTest(User user) {
        Assert.assertEquals(homePage.goToLoginInPage()
                .doLoginWith(user.getEmailAddress(), user.getPassword())
                .getUserName(), "Mark Waugh");
    }

    @Test(description = "Verifies if the valid user is able to login into the application", groups = {"e2e", "sanity"},
            dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestExcelDataProvider",
            retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
    public void loginExcelTest(User user) {

        Assert.assertEquals(homePage.goToLoginInPage()
                .doLoginWith(user.getEmailAddress(), user.getPassword())
                .getUserName(), "Abhishek Bose");
    }

    @AfterMethod
    public void tearDown() {
        if (homePage.getDriver() != null)
            homePage.getDriver().quit();
    }
}
