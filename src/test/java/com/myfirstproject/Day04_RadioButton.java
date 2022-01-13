package com.myfirstproject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Day04_RadioButton {
    WebDriver driver;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver"); // MAC // For windows add .exe
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // WE can add a wait here
        // WE can add an implicit wait dynamic wait and if all elements are located before timeout it stops waiting
        // This form is with Selenium 4
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        // Before this with Selenium 3
        //  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.facebook.com");
        WebElement cookiesAcceptBtn = driver.findElement(By.xpath("//button[contains(text(),'Allow All Cookies')]"));
        cookiesAcceptBtn.click();
    }
    @Test
    public void radioButtonTest() throws InterruptedException {
        driver.findElement(By.linkText("Create New Account")).click();
        WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
        firstName.sendKeys("Tulin");
        Thread.sleep(3000);
        // lastname
        WebElement lastName = driver.findElement(By.xpath("//input[@name='lastname']"));
        lastName.sendKeys("Mungan");
        Thread.sleep(3000);
        ////input[@name='reg_email__']
        WebElement mobileBox = driver.findElement(By.xpath("//input[@name='reg_email__']"));
        mobileBox.sendKeys("1234567");
        Thread.sleep(3000);
        // Dynamic xpath
        //<input type="text" class="inputtext _58mg _5dba _2ph-" data-type="text" name="reg_email__" value="" aria-required="true" placeholder="
        // " aria-label="Mobile number or email address" id="u_6_g_45">
        //u_2_g_+3
        ////input[@name='reg_passwd__']
        WebElement passWord = driver.findElement(By.xpath("//input[@name='reg_passwd__']"));
        passWord.sendKeys("1234");
        Thread.sleep(3000);
        WebElement femaleRadioButton = driver.findElement(By.xpath("(//input[@type='radio'])[1]"));
        femaleRadioButton.click();
        Thread.sleep(5000);
        WebElement signUpButton = driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
        signUpButton.click();


//        NOTE: some ids might be DYNAMIC if id has NUMBER
//        It means id values can change after the next usage.
//        For this reason, we need to avoid using dynamic ids
//        HOW DO YOU HANDLE DYNAMIC ID?????
//        - Dynamic id means id value can change. In this case, i don't prefer to use id
//        If I have to use it I WRITE DYNAMIC XPATH!!!
//        I find what is the same every single time then write dynamic xpath
//        I can use contains, start-with or ends-with dynamic xpath

//        //tag[contains(@attribute,'value')]     => (//input[contains(@id,'u_')])[1]
//        //tag[starts-with(@attribute,'value')]   => (//input[starts-with(@id,'u_')])[1]  Returns the first input whose id starts with u_
//        //tag[ends-with(@attribute,'value')]    => //input[ends-with(@id,'P7')] Returns the input elements who ends with P7



    }

//    @After
//    public void tearDown(){
//        driver.quit();
//    }


}
