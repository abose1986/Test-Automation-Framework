package com.ui.listeners;

import static com.aventstack.extentreports.Status.*;
import static com.utility.ExtentReporterUtility.*;

import com.ui.test.BaseTest;
import com.utility.BrowserUtility;
import com.utility.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

public class TestListener implements ITestListener {

    Logger logger = LoggerUtility.getLogger(this.getClass());


    @Override
    public void onTestStart(ITestResult result) {
        logger.info(result.getMethod().getMethodName());
        logger.info(result.getMethod().getDescription());
        logger.info(Arrays.toString(result.getMethod().getGroups()));
        createExtentTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("{} PASSED", result.getMethod().getMethodName());
        getExtentTest().log(PASS, result.getMethod().getMethodName() + " " + "PASSED");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("{} FAILED", result.getMethod().getMethodName());
        logger.error(result.getThrowable().getMessage());
        getExtentTest().log(FAIL, result.getMethod().getMethodName() + " " + "FAILED");
        getExtentTest().log(FAIL, result.getThrowable().getMessage());
        Object testClass = result.getInstance();
        BrowserUtility browserUtility = ((BaseTest) testClass).getInstance();
        logger.info("Capturing screenshot for the failed tests.");
        String screenshotPath = browserUtility.takesScreenshot(result.getMethod().getMethodName());
        logger.info("Attaching the screenshot to the HTML file.");
        getExtentTest().addScreenCaptureFromPath(screenshotPath);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.warn("{} SKIPPED", result.getMethod().getMethodName());
        getExtentTest().log(SKIP, result.getMethod().getMethodName() + " " + "SKIPPED");
    }

    @Override
    public void onStart(ITestContext context) {
        logger.info("Test Suite Started");
        setUpSparkReporter("report.html");

    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("Test Suite Completed");
        flushReport();
    }
}
