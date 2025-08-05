package com.ui.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pojo.User;

@Listeners(com.ui.listeners.TestListener.class)
public class LoginTest extends BaseTest {

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
                .getUserName(), "Ricky Ponting");
    }


}
