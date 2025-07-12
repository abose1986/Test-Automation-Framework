package com.ui.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.utility.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

public class TestListener implements ITestListener {

    Logger logger = LoggerUtility.getLogger(this.getClass());
    ExtentSparkReporter extentSparkReporter;
    ExtentReports extentReports;
    ExtentTest extentTest;

    @Override
    public void onTestStart(ITestResult result) {
        logger.info(result.getMethod().getMethodName());
        logger.info(result.getMethod().getDescription());
        logger.info(Arrays.toString(result.getMethod().getGroups()));
        extentTest = extentReports.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("{} PASSED", result.getMethod().getMethodName());
        extentTest.log(Status.PASS, result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("{} FAILED", result.getMethod().getMethodName());
        logger.error(result.getThrowable().getMessage());
        extentTest.log(Status.FAIL, result.getMethod().getMethodName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.warn("{} SKIPPED", result.getMethod().getMethodName());
        extentTest.log(Status.SKIP, result.getMethod().getMethodName());
    }

    @Override
    public void onStart(ITestContext context) {
        logger.info("Test Suite Started");
        extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "//report.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);

    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("Test Suite Completed");
        extentReports.flush();
    }
}
