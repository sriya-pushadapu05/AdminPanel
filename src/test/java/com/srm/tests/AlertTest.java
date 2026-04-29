package com.srm.tests;

import com.srm.base.BaseTest;
import com.srm.pages.AlertPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertTest extends BaseTest {

    @Test
    public void testAlertAccept() {

        AlertPage page = new AlertPage(driver);
        page.open();
        String text = page.acceptAlertAndGetText();

        System.out.println("Alert: " + text);
        Assert.assertFalse(text.isEmpty());
    }
 
    @Test
    public void testConfirmAccept() {

        AlertPage page = new AlertPage(driver);
        page.open();
        page.acceptConfirm();

        String result = page.getConfirmResult();
        System.out.println("Confirm Accept: " + result);

        Assert.assertTrue(result.toLowerCase().contains("true"));
    }

    @Test
    public void testConfirmDismiss() {

        AlertPage page = new AlertPage(driver);
        page.open();
        page.dismissConfirm();

        String result = page.getConfirmResult();
        System.out.println("Confirm Dismiss: " + result);

        Assert.assertTrue(result.toLowerCase().contains("false"));
    }

    @Test
    public void testPrompt() {

        AlertPage page = new AlertPage(driver);
        page.open();
        page.enterPrompt("automation");

        String result = page.getPromptResult();
        System.out.println("Prompt: " + result);

        Assert.assertTrue(result.contains("automation"));
    }
}