package Homework;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AmazonDropdown extends TestBase {

    /*
    Create A Class: AmazonDropdown
    Create A Method dropdownTest
     */

    @Test
    public void dropdownTest() {
        // ● Go to https://www.amazon.com/
        driver.get("https://www.amazon.com");
        //● Find the element of the dropdown element. HINT: By.id(“searchDropdownBox")
        WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));

        //● Print the first selected option and assert if it equals “All Departments”
        Select select = new Select(dropDown);
        String firstOpt = select.getFirstSelectedOption().getText();
        System.out.println(firstOpt);
        Assert.assertEquals("All Departments", firstOpt);

//        ● Select the 4th option by index (index of 3) and assert if the name is “Amazon Devices”.(after you
//        select you to need to use the get first selected option method)
        String secondOpt = select.getOptions().get(3).getText();
        Assert.assertEquals("Baby", secondOpt);
        Assert.assertNotEquals("Amazon Devices", secondOpt);

        //● Print all of the dropdown options
        List<WebElement> allOpt = select.getOptions();
        for (WebElement eachOpt : allOpt) {
            System.out.println(eachOpt.getText());
        }
        //● Print the total number of options in the dropdown
        System.out.println(allOpt.size());

      //   ● Check if Appliances is a drop-down option. Print true if “Appliances” is an option. Print false otherwise.

        boolean isAppliancesAnOpt = false;
        for (WebElement appliances : allOpt) {

            if (appliances.getText().equals("Appliances")) {
                isAppliancesAnOpt = true;
                break;
            }
        }
        System.out.println(isAppliancesAnOpt);
    }
    }
