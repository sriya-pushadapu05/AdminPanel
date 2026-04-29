package com.srm.tests;

import com.srm.base.BaseTest;
import com.srm.pages.TablePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TableTest extends BaseTest {

    @Test
    public void testStaticTableHeaders() {

        TablePage page = new TablePage(driver);
        page.openStaticTable();
        Assert.assertTrue(page.isTableDisplayed(), "Table not displayed");
        List<String> headers = page.getHeaders();

        System.out.println("Headers: " + headers);

        Assert.assertTrue(headers.contains("Name"));
        Assert.assertTrue(headers.contains("Amount"));

        System.out.println("Test passed: Static Table Headers");
    }
 
    @Test
    public void testDynamicTableRefresh() {

        TablePage page = new TablePage(driver);

        page.openDynamicTable();

        String before = page.getFirstRowText();
        System.out.println("Before: " + before);

        page.refreshDynamicTable();

        String after = page.getFirstRowText();
        System.out.println("After: " + after);

        Assert.assertNotEquals(before, after);
        Assert.assertTrue(page.pageContainsText("Selenium"));

        System.out.println("Test passed: Dynamic Table Updated");
    }
}