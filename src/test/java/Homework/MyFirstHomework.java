package Homework;

import com.github.javafaker.Faker;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class MyFirstHomework {
    WebDriver driver;
    Faker faker =new Faker();
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver"); // MAC // For windows add .exe
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("http://automationpractice.com/index.php");
    }
    @Test
    public void homeWork(){
        WebElement signInButton =  driver.findElement(By.className("login"));
        signInButton.click();

        WebElement emailTextBox = driver.findElement(By.id("email_create"));
        emailTextBox.sendKeys(faker.internet().emailAddress());

        WebElement createAccBtn = driver.findElement(By.id("SubmitCreate"));
        createAccBtn.click();

        WebElement titleRadioButton = driver.findElement(By.xpath("(//input[@type='radio'])[2]"));
        titleRadioButton.click();

        WebElement firstName = driver.findElement(By.id("customer_firstname"));
        firstName.sendKeys(faker.name().firstName());

        WebElement lastName =driver.findElement(By.id("customer_lastname"));
        lastName.sendKeys(faker.name().lastName());

        WebElement passwordBox = driver.findElement(By.id("passwd"));
        passwordBox.sendKeys(faker.internet().password());

        WebElement dropDownDay = driver.findElement(By.id("days"));
        Select dayBox = new Select(dropDownDay);
        dayBox.selectByValue("15");

        WebElement dropDownMonth = driver.findElement(By.id("months"));
        Select monthBox = new Select(dropDownMonth);
        monthBox.selectByValue("1");

        WebElement dropDownYear = driver.findElement(By.id("years"));
        Select yearBox = new Select(dropDownYear);
        yearBox.selectByValue("2000");

        WebElement firstCheckBox = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        firstCheckBox.click();

        driver.findElement(By.id("firstname")).sendKeys(faker.name().firstName());
        driver.findElement(By.id("lastname")).sendKeys(faker.name().lastName());
        driver.findElement(By.id("company")).sendKeys(faker.company().name());
        driver.findElement(By.id("address1")).sendKeys(faker.address().fullAddress());
        driver.findElement(By.id("city")).sendKeys(faker.address().city());

        WebElement countryBox = driver.findElement(By.id("id_country"));
        Select country = new Select(countryBox);
        country.selectByValue("21");

        WebElement stateBox = driver.findElement(By.id("id_state"));
        Select state = new Select(stateBox);
        state.selectByValue("5");

        driver.findElement(By.id("postcode")).sendKeys(faker.address().zipCode());


        driver.findElement(By.id("phone_mobile")).sendKeys(faker.phoneNumber().cellPhone());

        WebElement addressAlias = driver.findElement(By.id("alias"));
        addressAlias.sendKeys("My Address Book");

        WebElement registerButton = driver.findElement(By.id("submitAccount"));
        registerButton.click();

        WebElement myAccountHeader = driver.findElement(By.className("page-heading"));
        Assert.assertTrue("You are not on the main page ",myAccountHeader.isDisplayed());

    }
    @After
    public void tearDown(){

        driver.quit();
    }


}
