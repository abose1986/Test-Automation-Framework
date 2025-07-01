package com.ui.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetryAnalyzer implements IRetryAnalyzer {

    private final static int MAX_NUMBER_OF_ATTEMPTS = 3;
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
