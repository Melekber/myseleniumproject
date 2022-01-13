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

public class Day06_AlertTest {
    WebDriver driver;
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver"); // MAC // For windows add .exe
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
    }
    @Test
    public void acceptAlert(){

//        click on the first alert,
//        verify the text “I am a JS Alert” ,
//        click OK ,
//        and Verify “You successfully clicked an alert”


//        locating he first button
//        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        WebElement button1=driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
//        clicking
        button1.click();
//        verify the text “I am a JS Alert” ,
//        We cannot inspect alert elements, so we must use switchTo() function to handle alerts
        String alertText = driver.switchTo().alert().getText();
        Assert.assertEquals("TEXT DOESN'T MATCH","I am a JS Alert",alertText);
//        click OK
//        Again, we cannot inspect Ok button on the ALERT
//        so we must switch to alert and accept
        driver.switchTo().alert().accept();

        String actualResult = driver.findElement(By.id("result")).getText();
        Assert.assertEquals("You successfully clicked an alert",actualResult);

    }

    /*
    dismissAlert()=> click on the second alert,
    verify text "I am a JS Confirm”,
    click cancel,
    and Verify “You clicked: Cancel”
     */
@Test
    public void dismissAlert() {
    WebElement button2 = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
    button2.click();
    String alertText2 = driver.switchTo().alert().getText();
    Assert.assertEquals("TEXT DOESN'T MATCH", "I am a JS Confirm", alertText2);
    driver.switchTo().alert().dismiss();

    String actualResult2 = driver.findElement(By.id("result")).getText();
    Assert.assertEquals("You clicked: Cancel", actualResult2);

    //EXPECTED DATA COMES FROM THE USER STORIES/ACCEPTANCE CRITERIA
    //ACTUAL COMES FROM THE WEBSITE
}

@Test
    public void sendKeysAlert() {
    /*
    sendKeysAlert()=> click on the third alert, verify text “I am a JS prompt”,
    type “Hello World”,
    click OK,
    and Verify “You entered: Hello Word”
     */
    WebElement button3 = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
    button3.click();
    String alertText3 = driver.switchTo().alert().getText();
    Assert.assertEquals("TEXT DOESN'T MATCH", "I am a JS prompt", alertText3);
    driver.switchTo().alert().sendKeys("Hello World");
    driver.switchTo().alert().accept();

    String actualResult3 = driver.findElement(By.id("result")).getText();
    Assert.assertEquals("You entered: Hello World", actualResult3);

}
@After
    public void tearDown(){
    driver.quit();

}
}