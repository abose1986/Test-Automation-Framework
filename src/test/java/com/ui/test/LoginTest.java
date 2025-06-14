package com.ui.test;

import static com.constants.Browser.*;
import com.ui.pages.HomePage;

public class LoginTest {

    public static void main(String[] args) {

        HomePage homePage = new HomePage(CHROME);
        String userName = homePage.goToLoginInPage()
                .doLoginWith("payeba8662@baxima.com", "password")
                .getUserName();
    }
}
