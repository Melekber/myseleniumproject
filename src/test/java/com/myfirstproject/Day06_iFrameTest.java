package com.myfirstproject;

import org.checkerframework.checker.units.qual.A;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day06_iFrameTest {
    WebDriver driver;
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver"); // MAC // For windows add .exe
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://the-internet.herokuapp.com/iframe");
    }
    /*
    If your test case fails , there are might be different reasons:
    1.Locator my not be correct
    2. If your locator is correct , the it can be time out issue.You can add more waits
    3. If it is not time out issue , then element might be inside the iframe.You must switch to iframe first
     */
    @Test
    public void iFrameTest(){
        /*
        Create a class: IFrameTest
    Create a method: iframeTest
    Go to https://the-internet.herokuapp.com/iframe
    Verify the Bolded text contains “Editor”
    Locate the text box
    Delete the text in the text box
    Type “This text box is inside the iframe”
    Verify the text Elemental Selenium text is displayed on the page
         */

        // Verify the Bolded text contains “Editor”
      String boldedText =  driver.findElement(By.xpath("//h3")).getText();
        Assert.assertTrue(boldedText.contains("Editor"));

      //We must switch to the iFrame to interact (or locate the elements inside the iFrame)
      //There are tree ways to switch to iFrame
      //1.Way - using "index" => index starts from 0
       // driver.switchTo().frame(0); // switching the first frame by index

        // 2. Way - Switch bi "id" or "name"
       // driver.switchTo().frame("mce_0_ifr");

        //3.Way - WebElement
        WebElement iFrameWebElement = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(iFrameWebElement);
        //   Locate the text box
     WebElement textBox = driver.findElement(By.xpath("//p"));
      //Delete the text in the text box
      textBox.clear();
        // Type “This text box is inside the iframe”
       textBox.sendKeys("This text box is inside the iframe");

       //That element is outside of the iFrame . then switch to the parent or default content

        driver.switchTo().parentFrame();
       WebElement elementalSelenium = driver.findElement(By.linkText("Elemental Selenium"));
         Assert.assertTrue(elementalSelenium.isDisplayed());


    }
    @After
    public void tearDown(){
        driver.close();
    }
}
