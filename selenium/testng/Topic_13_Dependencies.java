package testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;

@Listeners(listeners.ExtendReport.class)
public class Topic_13_Dependencies {
    WebDriver driver;
    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void TC_01_CreateNewUser(){

    }
    @Test(dependsOnMethods = "TC_01_CreateNewUser")
    public void TC_02_ViewAndSearchUser(){

    }
    @Test(dependsOnMethods = "TC_01_CreateNewUser")
    public void TC_03_ViewAndSearchUser(){

    }
    @Test(dependsOnMethods = "TC_01_CreateNewUser")
    public void TC_04_UpdateExistUser(){
        Assert.assertTrue(false);

    }
    @Test(dependsOnMethods = "TC_04_UpdateExistUser")
    public void TC_05_MoveExistUserToOtherRole(){

    }
}
