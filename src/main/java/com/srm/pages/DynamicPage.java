package com.srm.pages;

import com.srm.base.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class DynamicPage extends BasePage {

    public DynamicPage(WebDriver driver) {
        super(driver);
    } 
    By checkbox = By.cssSelector("#checkbox input");
    By removeBtn = By.xpath("//button[contains(text(),'Remove')]");
    By addBtn = By.xpath("//button[contains(text(),'Add')]");
    By redirectBtn = By.partialLinkText("Redirect");
    String startUrl;

    public void openDynamicPage() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
    }

    public void openRedirectPage() {
        driver.get("https://testpages.eviltester.com/styled/navigation/redirect.html");
    }

    public boolean isCheckboxPresent() {
        try {
            WebElement el = driver.findElement(checkbox);
            return el.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean waitForCheckboxVisible() {

        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .until(d -> {
                    try {
                        return d.findElement(checkbox).isDisplayed();
                    } catch (Exception e) {
                        return false;
                    }
                });
    }

    public void clickRemove() {
        click(removeBtn);
        waitForCheckboxToDisappear();
    }

    public void clickAdd() {
        waitForAddButtonReady();   
        click(addBtn);
        waitForCheckboxToAppear(); 
    }
    
    public boolean isRemoveButtonVisible() {
        try {
            WebElement btn = driver.findElement(By.xpath("//button[contains(text(),'Remove')]"));
            return btn.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean waitForGoneMessage() {
        By message = By.id("message");
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .until(d -> {
                    try {
                        String text = d.findElement(message).getText();
                        return text.contains("It's gone!");
                    } catch (Exception e) {
                        return false;
                    }
                });
    }
    
    public boolean waitForRemoveButton() {
        By removeBtn = By.xpath("//button[contains(text(),'Remove')]");
        return new org.openqa.selenium.support.ui.FluentWait<>(driver)
                .withTimeout(java.time.Duration.ofSeconds(10))
                .pollingEvery(java.time.Duration.ofMillis(500))
                .until(d -> {
                    try {
                        WebElement btn = d.findElement(removeBtn);
                        return btn.isDisplayed() && btn.isEnabled();
                    } catch (Exception e) {
                        return false;
                    }
                });
    }
    
    public void waitForAddButtonReady() {
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .until(d -> {
                    WebElement btn = d.findElement(addBtn);
                    return btn.isDisplayed() && btn.isEnabled() && btn.getText().contains("Add");
                });
    }

    public void waitForCheckboxToDisappear() {
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .until(d -> d.findElements(checkbox).size() == 0);
    }

    public void waitForCheckboxToAppear() {
        By message = By.id("message");
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .until(d -> {
                    try {
                        String text = d.findElement(message).getText();
                        return text.contains("It's back!");
                    } catch (Exception e) {
                        return false;
                    }
                });
    }

    public void waitForAddButton() {
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .until(d -> d.findElement(addBtn).isDisplayed());
    }    
}