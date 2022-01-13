package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.Cookie;

import java.util.Set;

public class Day08_Cookies extends TestBase {

    @Test
    public void handleCookies(){
        //Go to the amazon and print all the cookies
        driver.get("https://www.amazon.com");
        Set<Cookie> allCookies = driver.manage().getCookies();
        int numOfCookies =allCookies.size();
        System.out.println("numOfCookies = " + numOfCookies);

        for(Cookie eachCookie:allCookies){
            System.out.println("eachCookie = " + eachCookie);
            System.out.println("eachCookie.getName() = " + eachCookie.getName());
            System.out.println("eachCookie.getValue() = " + eachCookie.getValue());

        }
        System.out.println("driver.manage().getCookieNamed(\"i18n-prefs\") = " + driver.manage().getCookieNamed("i18n-prefs"));

        // Adding a new cookies
        Cookie cookie = new Cookie("My_Favorite","Starbucks_Cookie");
        driver.manage().addCookie(cookie);

        int newSize = driver.manage().getCookies().size();
        System.out.println(newSize);

        //Deleting cookies

        driver.manage().deleteCookie(cookie);
        driver.manage().deleteCookieNamed("skin");
        int  newSize_2 = driver.manage().getCookies().size();
        System.out.println("newSize_2 = " + newSize_2);

        //Delete all Cookies

        driver.manage().deleteAllCookies();
        int lastSize = driver.manage().getCookies().size();
        System.out.println("lastSize = " + lastSize);

    }




}
