package com.myfirstproject;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Day02_FirstJUnitClass {
    /*
    JUnit is a testing framework
    JUnit is one of the oldest JAVA testing framework
    Testers also use Unit Testing for creating Automation Test Framework
    Developers also use JUnit for their Unit Testing

    No more main method
    JUnit has 7 major annotation
    1. @Test annotation is used to create test cases
    NOTE: All test method will be "void"
    Because test methods are used for assertions
   2. @Before : Runs before each @Test annotation
   3. @After : Runs after each @Test annotation
   4. @BeforeClass : Runs only once before each class
   5. @AfterClass : Runs only once after each class
   6. @Ignore : To skip a test case
   ********** JUnit ASSERTION
   We use JUnit assertion if actual and expected is equal
   Instead of using if else statement , we will use JUnit assertions
   It will come from Assert class

    1. Assert.assertEquals("ACTUAL","EXPECTED");
    2. Assert.assertTrue("ACTUAL".contains("EXPECTED"));
    3. Assert.assertFalse("ACTUAL".contains("EXPECTED"));

     */

    @Before
    public void setUp(){
        System.out.println("This is Before method");
    }

    @Test
    public void test01(){
        System.out.println("Test1");

    }
    @Test
    public void test02(){
        System.out.println("Test2");


    }
    @Ignore
    @Test
    public void test03(){
        System.out.println("Test3");


    }
    @Test
    public void test04(){
        System.out.println("Test4");


    }
    @After
    public void tearDown(){
        System.out.println("This is Tear Down method");
    }

    //ASSERTION
    //if expected == actual
    @Test
    public void assertions(){
        //1. Assert.assertEquals("expected","actual"):

//        If assertion fails, then we see error message on the console
//        if assertion pass, then we see a green checkmark only
        Assert.assertEquals("java","java"); // pass
       // Assert.assertEquals("javascript","java"); // fail

       // 2. Assert.assertTrue(BOOLEAN);
        Assert.assertTrue("Selenium".contains("e")); // true - pass
      //  Assert.assertTrue("Selenium".contains("a")); // false - fail

        // 3. Assert.assertFalse(BOOLEAN);

        Assert.assertFalse("Selenium".contains("a")); //False -> will pass
        // Assert.assertFalse("Selenium".contains("e")); //True -> will fail

          //    We can add a message as well.
        //  This message will ONLY DISPLAY WHEN ASSERTION FAILS!!!!
        Assert.assertEquals("OHH NOO!","java","javascript");
    }


}
