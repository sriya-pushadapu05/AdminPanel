package com.srm.listeners;

import com.aventstack.extentreports.*;
import com.srm.utils.ExtentManager;
import com.srm.utils.ScreenshotUtil;
import org.testng.*;

public class TestListener implements ITestListener {

    ExtentReports report = ExtentManager.getReport();
    ExtentTest test;
 
    @Override
    public void onTestStart(ITestResult result) {
        test = report.createTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        String path = ScreenshotUtil.capture(result.getName());

        test.fail("Test Failed")
            .addScreenCaptureFromPath(path);
    }

    @Override
    public void onFinish(ITestContext context) {
        report.flush();
    }
}