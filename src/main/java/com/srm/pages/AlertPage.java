package com.srm.pages;

import com.srm.base.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class AlertPage extends BasePage {

    public AlertPage(WebDriver driver) {
        super(driver);
    } 

    By alertBtn = By.id("alertexamples");
    By confirmBtn = By.id("confirmexample");
    By promptBtn = By.id("promptexample");
    By confirmResult = By.id("confirmreturn");
    By promptResult = By.id("promptreturn");

    public void open() {
        driver.get("https://testpages.eviltester.com/styled/alerts/alert-test.html");
    }

    private Alert waitForAlert() {
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoAlertPresentException.class)
                .until(d -> d.switchTo().alert());
    }

    private String waitForText(By locator) {
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .until(d -> {
                    String text = d.findElement(locator).getText();
                    return text.isEmpty() ? null : text;
                });
    }

    public String acceptAlertAndGetText() {
        click(alertBtn);
        Alert alert = waitForAlert();
        String text = alert.getText();
        alert.accept();
        return text;
    }

    public void acceptConfirm() {
    	clickWithJavaScript(confirmBtn);
        Alert alert = waitForAlert();
        alert.accept();
    }

    public void dismissConfirm() {
    	clickWithJavaScript(confirmBtn);
        Alert alert = waitForAlert();
        alert.dismiss();
    }

    public void enterPrompt(String value) {

        clickWithJavaScript(promptBtn);  
        Alert alert = waitForAlert();
        alert.sendKeys(value);
        alert.accept();
    }

    public String getConfirmResult() {

        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .until(d -> {
                    String text = d.findElement(confirmResult).getText();
                    return text.isEmpty() ? null : text;
                });
    }

    public String getPromptResult() {

        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .until(d -> {
                    String text = d.findElement(promptResult).getText();
                    return text.isEmpty() ? null : text;
                });
    }
}