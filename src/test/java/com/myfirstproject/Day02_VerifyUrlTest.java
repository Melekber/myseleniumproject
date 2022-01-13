package com.myfirstproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day02_VerifyUrlTest {
    /*
    2.Navigate to google homepage
    3.Verify if google homepage url is “www.google.com”
     */
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");

        String actualUrl =driver.getCurrentUrl();
        String expectedUrl = "https://www.google.com/";

        System.out.println("actualUrl = " + actualUrl);
        System.out.println("expectedUrl = " + expectedUrl);

        if (actualUrl.equals(expectedUrl)){
            System.out.println("PASSED");
        }else {
            System.out.println("FAILED");
        }
        driver.close();

    }
}
