package com.srm.pages;

import com.srm.base.BasePage;
import org.openqa.selenium.*;

public class FramePage extends BasePage {

    public FramePage(WebDriver driver) {
        super(driver);
    } 

    By iframe = By.tagName("iframe");
    By frame = By.tagName("frame");
    By body = By.tagName("body");
    By heading = By.tagName("h1");

    public void openIframesPage() {
        driver.get("https://testpages.eviltester.com/styled/iframes-test.html");
    }

    public void openFramesPage() {
        driver.get("https://testpages.eviltester.com/styled/frames/frames-test.html");
    }

    public boolean canReadTextInsideIframe() {
        driver.switchTo().frame(0);
        boolean visible = driver.findElement(body).isDisplayed();
        driver.switchTo().defaultContent();
        return visible;
    }

    public boolean canInteractInsideIframe() {
        driver.switchTo().frame(0);
        boolean interact = driver.findElement(body).isDisplayed();
        driver.switchTo().defaultContent();
        return interact;
    }

    public boolean canReadTextInsideNestedFrame() {
        driver.switchTo().frame(0); 
        boolean visible = driver.findElement(body).isDisplayed();
        driver.switchTo().defaultContent();
        return visible;
    }

    public boolean mainPageIsAccessible() {
        return driver.findElement(heading).isDisplayed();
    }
}