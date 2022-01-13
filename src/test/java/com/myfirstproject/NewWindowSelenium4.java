package com.myfirstproject;


import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class NewWindowSelenium4 {
    @Test
    public void newWindowsTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver"); // MAC // For windows add .exe
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();


        //Open google in window 1

        driver.get("https://www.google.com");
        String googleHandle =driver.getWindowHandle();

        //Open amazon  in window 2
        //Creating a new empty window and switching it
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.amazon.com");
        String amazonHandle = driver.getWindowHandle();
        //Open linkedin in window 3
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com");
        String linkedinHandle = driver.getWindowHandle();
        Thread.sleep(3000);

        //Switch back to google window
        driver.switchTo().window(googleHandle);
        System.out.println("Google URL => " + driver.getCurrentUrl());
//Switch back to amazon window
        driver.switchTo().window(amazonHandle);
        System.out.println("Amazon URL => " + driver.getCurrentUrl());
//Switch back to linkedin window
        driver.switchTo().window(linkedinHandle);
        System.out.println("Linkedin URL => " + driver.getCurrentUrl());

    }

}
