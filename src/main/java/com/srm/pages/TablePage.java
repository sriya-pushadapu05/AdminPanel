package com.srm.pages;

import com.srm.base.BasePage;
import org.openqa.selenium.*;
import java.util.List;
import java.util.stream.Collectors;

public class TablePage extends BasePage {

    public TablePage(WebDriver driver) {
        super(driver);
    } 

    By table = By.tagName("table");
    By headers = By.cssSelector("table th");
    By rows = By.xpath("//table//tr[td]");

    public void openStaticTable() {
        driver.get("https://testpages.eviltester.com/pages/basics/html-tag-table/");
    }

    public void openDynamicTable() {
        driver.get("https://testpages.eviltester.com/styled/tag/dynamic-table.html");
    }

    public boolean isTableDisplayed() {
        return driver.findElement(table).isDisplayed();
    }

    public List<String> getHeaders() {
        return driver.findElements(headers).stream()
                .map(e -> e.getText().trim())
                .filter(text -> !text.isEmpty())
                .collect(Collectors.toList());
    }

    public String getFirstRowText() {
        List<WebElement> rowList = driver.findElements(rows);
        for (WebElement row : rowList) {
            String text = row.getText().trim();
            if (!text.isEmpty()) {
                return text;
            }
        }
        return "";
    }

    public boolean pageContainsText(String text) {
        return driver.getPageSource().contains(text);
    }

    public void refreshDynamicTable() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "createTableFromJson('[{\"name\":\"Selenium\",\"age\":11},{\"name\":\"TestNG\",\"age\":7}]','Automation Table','automation-table');";
        js.executeScript(script);
    }
}