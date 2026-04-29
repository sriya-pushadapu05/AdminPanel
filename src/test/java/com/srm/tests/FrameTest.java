package com.srm.tests;

import com.srm.base.BaseTest;
import com.srm.pages.FramePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FrameTest extends BaseTest {

    @Test
    public void testIframeContent() {

        FramePage page = new FramePage(driver);
        page.openIframesPage();
        boolean result = page.canReadTextInsideIframe();
        System.out.println("Iframe accessible: " + result);
        Assert.assertTrue(result);

        System.out.println("Test passed: Iframe Content");
    }

    @Test
    public void testIframeInteraction() {

        FramePage page = new FramePage(driver);
        page.openIframesPage();
        boolean result = page.canInteractInsideIframe();
        System.out.println("Iframe interaction: " + result);
        Assert.assertTrue(result);

        System.out.println("Test passed: Iframe Interaction");
    }

    @Test
    public void testNestedFrame() {

        FramePage page = new FramePage(driver);
        page.openFramesPage();
        boolean result = page.canReadTextInsideNestedFrame();
        System.out.println("Nested frame accessible: " + result);

        Assert.assertTrue(result);

        System.out.println("Test passed: Nested Frame");
    }
 
    @Test
    public void testSwitchBackToMainPage() {

        FramePage page = new FramePage(driver);
        page.openIframesPage();
        page.canReadTextInsideIframe(); 

        boolean result = page.mainPageIsAccessible();
        System.out.println("Main page accessible: " + result);

        Assert.assertTrue(result);

        System.out.println("Test passed: Switch Back");
    }
}