package com.ui.listeners;

import static com.constants.Env.*;
import static com.utility.JSONUtility.*;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetryAnalyzer implements IRetryAnalyzer {

    //private final static int MAX_NUMBER_OF_ATTEMPTS = Integer.parseInt(PropertiesUtil.readProperties(QA,"MAX_NUMBER_OF_ATTEMPTS"));
    private final static int MAX_NUMBER_OF_ATTEMPTS = readJson(QA).getMaxNumberOfAttempts();
    private static int currentAttempt = 1;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (currentAttempt <= MAX_NUMBER_OF_ATTEMPTS) {
            currentAttempt++;
            return true;
        } else {
            return false;
        }
    }
}
