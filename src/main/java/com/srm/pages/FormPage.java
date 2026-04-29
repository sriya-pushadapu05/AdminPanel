package com.srm.pages;

import com.srm.base.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class FormPage extends BasePage {

    public FormPage(WebDriver driver) {
        super(driver);
    } 

    By username = By.name("username");
    By password = By.name("password");
    By comments = By.name("comments");
    By checkboxes = By.cssSelector("input[type='checkbox']");
    By radios = By.cssSelector("input[type='radio']");
    By multiSelect = By.name("multipleselect[]");
    By dropdown = By.name("dropdown");
    By submit = By.cssSelector("input[type='submit']");
    By result = By.tagName("body");

    public void open() {
        driver.get("https://testpages.eviltester.com/styled/basic-html-form-test.html");
    }

    public void fillForm(String user, String pass, String comment) {
        type(username, user);
        type(password, pass);
        type(comments, comment);
    }

    public void selectCheckbox(String value) {
        for (WebElement cb : driver.findElements(checkboxes)) {
            if (cb.getAttribute("value").equals(value)) {
                if (!cb.isSelected()) cb.click();
                break;
            }
        }
    }

    public void selectRadio(String value) {
        for (WebElement rb : driver.findElements(radios)) {
            if (rb.getAttribute("value").equals(value)) {
                rb.click();
                break;
            }
        }
    }

    public void selectDropdown(String text) {
        Select dd = new Select(wait.waitForElement(dropdown));
        dd.selectByVisibleText(text);
    }

    public void selectMultiple(String v1, String v2) {
        Select ms = new Select(wait.waitForElement(multiSelect));
        ms.selectByVisibleText(v1);
        ms.selectByVisibleText(v2);
    }

    public void submit() {
        click(submit);
    }

    public String getResult() {
        return getText(result);
    }
}