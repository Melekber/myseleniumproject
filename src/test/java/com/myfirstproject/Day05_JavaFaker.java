package com.myfirstproject;

import com.github.javafaker.Faker;
import org.junit.Test;

public class Day05_JavaFaker {
    @Test
    public void fakerTest(){
     /*    DDT -Data Driven Testing
        Test Data Generation
        Generally for negative test cases
      */
     //Java Faker we can create all test data like username,name,password,mail,address , zip code
        // mock data

        Faker faker = new Faker(); //The first condition is creating an object

        System.out.println("First Name = "+faker.name().firstName());
        System.out.println("lastName() = " + faker.name().lastName());
        System.out.println("fullName() = " + faker.name().fullName());

        System.out.println("username() = " + faker.name().username());
        System.out.println("password() = " + faker.internet().password());
        System.out.println("title() = " + faker.name().title());
        System.out.println("emailAddress() = " + faker.internet().emailAddress());
        System.out.println("digits(5) = " + faker.number().digits(5));
        System.out.println("city() = " + faker.address().city());
        System.out.println("fullAddress() = " + faker.address().fullAddress());

    }
}
