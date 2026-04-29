package com.srm.base;

import com.srm.utils.WaitUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
 
public class BasePage {

    protected WebDriver driver;
    protected WaitUtils wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
    }

    public void waitForElement(org.openqa.selenium.By locator) {
        wait.waitForElement(locator);
    }

    public void click(By locator) {
        WebElement element = wait.waitForElement(locator);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        element.click();
    }
    
    public void type(By locator, String value) {
        WebElement element = wait.waitForElement(locator);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        element.clear();
        element.sendKeys(value);
    }
    
    public String getText(org.openqa.selenium.By locator) {
        return wait.waitForElement(locator).getText();
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }
    
    public void scrollIntoView(WebElement element) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView({block:'center'});", element);
        } catch (Exception e) {
        }
    }
    
    public void clickWithJavaScript(By locator) {
        WebElement element = wait.waitForElement(locator);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", element);
        js.executeScript("arguments[0].click();", element);
    }

    public boolean pageContainsText(String text) {
        return driver.getPageSource().contains(text);
    }
    
    public void sendAlertText(String text) {
        driver.switchTo().alert().sendKeys(text);
    }
}