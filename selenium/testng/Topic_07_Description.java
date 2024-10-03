package testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_07_Description {
    @BeforeClass(alwaysRun = true)
    public void beforeClass(){
        System.out.println("Before class");
        //Assert.assertTrue(false);

    }
    @Test(description = "Search new user")
    public void TC_01_AlwayRun(){
        System.out.println("TC 01");
    }
    @Test(enabled = false)
    public void TC_02_AlwayRun(){
        System.out.println("TC 02");
    }
    @AfterClass(alwaysRun = true)
    public void afterClass(){
        System.out.println("After class");
    }
}
