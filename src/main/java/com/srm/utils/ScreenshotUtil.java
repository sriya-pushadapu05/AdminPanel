package com.srm.utils;

import com.srm.driver.DriverFactory;
import org.openqa.selenium.*;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.nio.file.Files;

public class ScreenshotUtil {

    public static String capture(String testName) {

        String timestamp = new SimpleDateFormat("yyyyMMdd").format(new Date());

        String path = "screenshots/" + testName + "_" + timestamp + ".png";

        try {
            File src = ((TakesScreenshot) DriverFactory.getDriver())
                    .getScreenshotAs(OutputType.FILE);

            Files.copy(src.toPath(), new File(path).toPath());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return path;
    }
} 