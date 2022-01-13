package com.myfirstproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day02_VerifyTitle {
    public static void main(String[] args) {
        /*
        2.Navigate to google homepage
        3.Verify if google title is “Google”
         */

        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https:www.google.com");

        String actualTitle = driver.getTitle();
        String expectedTitle ="google";
        if(actualTitle.equals(expectedTitle)){
            System.out.println("PASSED");
        }else{
            System.out.println("FAILED");
        }

        driver.close();

        //Verification - Validation - Assertion

        /*
        After Verification your test failed
        Expected and Actual aren't same
        Creating a bug ticket
        Bug tracking tools -- Jira
        Developers will fix the bug by debugging
         */

    }
}
