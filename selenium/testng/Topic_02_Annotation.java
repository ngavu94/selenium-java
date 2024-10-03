package testng;


import org.testng.annotations.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class Topic_02_Annotation {
    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("After Class");
    }
    @BeforeGroups
    public void beforeGroups(){
        System.out.println("Before Groups");
    }

    @AfterGroups
    public void afterGroups(){
        System.out.println("After Groups");
    }
    @BeforeSuite
    public void beforeSuites(){
        System.out.println("Before Suite");
    }
    @AfterSuite
    public void afterSuites(){
        System.out.println("After Suite");
    }

    @BeforeMethod
    public void beforeMethods(){
        System.out.println("Before Method");
    }
    @AfterMethod
    public void afterMethods(){
        System.out.println("After Method");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("After Test");
    }
    @Test
    public void test_01(){
        System.out.println("Test 01");
    }
    @Test
    public void test_02(){
        System.out.println("Test 02");
    }
    @Test
    public void test_03(){
        System.out.println("Test 03");
    }

}
