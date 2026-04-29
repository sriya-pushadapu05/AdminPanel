package com.srm.utils;

import org.openqa.selenium.*;
import java.time.Duration;
import org.openqa.selenium.support.ui.FluentWait;

public class WaitUtils {

    WebDriver driver;

    public WaitUtils(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement waitForElement(By locator) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        return wait.until(d -> {
            WebElement el = d.findElement(locator);
            return el.isDisplayed() ? el : null;
        });
    }
} 