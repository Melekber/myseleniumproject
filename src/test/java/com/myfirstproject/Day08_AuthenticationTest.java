package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Day08_AuthenticationTest extends TestBase {

    @Test
    public void auth(){
        //For verification
        //https://username:password@
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        WebElement successMessage = driver.findElement(By.xpath("//*[.='Basic Auth']"));
        String successMessageText = successMessage.getText();
        Assert.assertTrue(successMessage.isDisplayed());


        // If you see Congratulations! then test passed
        String expectedText = "Congratulations!";
        WebElement actualCongrat = driver.findElement(By.xpath("//p"));
        String actualCongratText = actualCongrat.getText();
        Assert.assertTrue(actualCongratText.contains(expectedText));
    }
}
