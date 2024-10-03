package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Topic_03_Assertions {
    WebDriver driver;
    @Test
    public void TC_01(){
        System.out.println("");
        //Equals
        //True
        //False
        String fullName ="Automation FC";
        Assert.assertEquals(fullName,"Automation fc","Actual fullName is not the same");
        isElementDisplayed(By.cssSelector(""));
        Assert.assertTrue(isElementDisplayed(By.cssSelector("")),"Element is not displayed");

    }
    private boolean isElementDisplayed(By locator){
        return driver.findElement(locator).isDisplayed();
    }
}
