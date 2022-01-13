package com.myfirstproject;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day06_NewTabsSelenium4 {

    @Test
    public void newTabs() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver"); // MAC // For windows add .exe
       WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();

        //1. Open google in the tab 1
        driver.get("https://www.google.com");
        String googleWindowHandle = driver.getWindowHandle();

        //2. Open amazon in the tab 2
        //Creating and switching to a new Empty Tab
       WebDriver tab2 = driver.switchTo().newWindow(WindowType.TAB);
       tab2.get("https://www.amazon.com");
        String amazonWindowHandle = driver.getWindowHandle();

        //Open Linkedin in a new tab

        WebDriver tab3 = driver.switchTo().newWindow(WindowType.TAB);
        tab3.get("https://www.linkedin.com");
        String linkedinWindowHandle = driver.getWindowHandle();

        Thread.sleep(3000);
        driver.switchTo().window(googleWindowHandle);
        System.out.println("Google URL =>" +driver.getCurrentUrl());

        Thread.sleep(3000);
        driver.switchTo().window(amazonWindowHandle);
        System.out.println("Amazon URL => " + driver.getCurrentUrl());

        Thread.sleep(3000);
        driver.switchTo().window(linkedinWindowHandle);
        System.out.println("Linkedin URL => " + driver.getCurrentUrl());

    }
}
