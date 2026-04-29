package com.srm.tests;

import com.srm.base.BaseTest;
import com.srm.pages.DynamicPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicTest extends BaseTest {

    @Test(priority=1)
    public void testDynamicElement() {

        DynamicPage page = new DynamicPage(driver);
        page.openDynamicPage();

        boolean before = page.isCheckboxPresent();
        System.out.println("Before: " + before);

        page.clickRemove();

        boolean after = page.isCheckboxPresent();
        System.out.println("After: " + after);
        Assert.assertTrue(before && !after);

        System.out.println("Test passed: Checkbox removed");
    }

    @Test(priority=2)
    public void testAddThenRemoveFlow() {

        DynamicPage page = new DynamicPage(driver);
        page.openDynamicPage();
        page.clickRemove();
        page.clickAdd();
 
        boolean isRemoveVisible = page.isRemoveButtonVisible();

        if (isRemoveVisible) {

            System.out.println("Add successful → Remove button visible");

            page.clickRemove();
            boolean removed = page.waitForGoneMessage();
            Assert.assertTrue(removed, "Checkbox was not removed again");

            System.out.println("Test passed: Add → Remove flow working");

        } else {

            Assert.fail("Add operation failed → Remove button not visible");
        }
    }
}