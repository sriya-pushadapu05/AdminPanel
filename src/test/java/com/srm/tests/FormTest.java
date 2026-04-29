package com.srm.tests;

import com.srm.base.BaseTest;
import com.srm.pages.FormPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FormTest extends BaseTest {

    @Test
    public void testValidForm() {
 
        FormPage page = new FormPage(driver);
        page.open();
        page.fillForm("sravya", "sravya@123", "hello everyone");

        page.selectCheckbox("cb1");     
        page.selectRadio("rd2");      
        page.selectMultiple("Selection Item 1", "Selection Item 3");

        page.selectDropdown("Drop Down Item 3"); 
        page.submit();

        String result = page.getResult();
       
        Assert.assertTrue(result.contains("sravya"));
        Assert.assertTrue(result.contains("Drop Down Item 3"));
        Assert.assertTrue(result.contains("rd2"));

        System.out.println("Test passed");
    }

    @Test
    public void testEmptyForm() {

        FormPage page = new FormPage(driver);
        page.open();
        page.submit();

        String result = page.getResult();

        Assert.assertFalse(result.isEmpty());
        System.out.println("Empty form so test failed");
    }
}