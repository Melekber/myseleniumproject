package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Day08_FileUploadTest extends TestBase {

    @Test
    public void uploadTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/upload");
       WebElement chooseFile =  driver.findElement(By.id("file-upload"));
       //We have download.png on Desktop use it

        String pathOfImage = System.getProperty("user.home")+ "/Desktop/download.png";
        System.out.println("pathOfImage = " + pathOfImage);

        chooseFile.sendKeys(pathOfImage);
        Thread.sleep(2000);

       WebElement upLoadButton =  driver.findElement(By.id("file-submit"));
       upLoadButton.click();
       Thread.sleep(5000);
       String expectedMessage = "File Uploaded!";
       WebElement message = driver.findElement(By.xpath("//h3"));
       String actualMessageText = message.getText();
        Assert.assertEquals(expectedMessage,actualMessageText);



    }
}
