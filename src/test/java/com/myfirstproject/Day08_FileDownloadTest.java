package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Day08_FileDownloadTest extends TestBase {

    @Test
    public void  downloadTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/download");
        driver.findElement(By.partialLinkText("sample.png")).click();
        Thread.sleep(3000);

        String homePath =  System.getProperty("user.home");
        String  expectedPath = homePath + "/Downloads/sample.png";

        boolean isExist = Files.exists(Paths.get(expectedPath));
        Assert.assertTrue(isExist);

    }
}
