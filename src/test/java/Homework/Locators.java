package Homework;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Locators extends TestBase {

    @Test
    public void locatorsTest(){
        driver.get("https://www.saucedemo.com/");
        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");
        WebElement passWord = driver.findElement(By.id("password"));
        passWord.sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        Assert.assertTrue(driver.getPageSource().contains("Products"));

        //Gets the all the price in a list
        List<WebElement> priceList=driver.findElements(By.className("inventory_item_price"));

        List<String> strListPrice=new ArrayList<>();
        for (WebElement w : priceList){
            strListPrice.add(w.getText());
            System.out.println(w.getText());
        }
        List<Double> doublePrices=new ArrayList<>();
        for (String w : strListPrice){
            w=w.substring(1);
            Double newPrice=Double.parseDouble(w);
            doublePrices.add(newPrice);
        }
        System.out.println(doublePrices);
        Collections.sort(doublePrices);
        System.out.println(doublePrices);
        Assert.assertTrue("The verifies the minimum price is greater than $5",doublePrices.get(0)>5);
        Assert.assertTrue("The verifies the maximum price is less than $50", doublePrices.get(doublePrices.size()-1)<50);


    }

}
