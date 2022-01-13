package com.myfirstproject.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public abstract class TestBase {
    /*
    Making abstract , because we just want to implement methods without showing the details
    We also don't want to create an obj on TestBase,just want to use the method inside it.

    TestBase will have only two methods
    1. Before
    2.After
    Why TestBase?
    We use TestBase for Repeated Pre Condition and After Condition
    TestBase is reusable
    This will make actual test class shorter.

    Access modifier must be public or protected because they are in different packages

     */
   protected WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
       // driver.close();
    }
}
