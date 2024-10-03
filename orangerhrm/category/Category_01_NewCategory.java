package category;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Category_01_NewCategory {
    @BeforeClass(alwaysRun = true)
    public void beforeClass(){
        System.out.println("Before class");
        Assert.assertTrue(false);
    }
    @Test(groups = {"category"})
    public void testCreateNewCategory(){

    }
    @Test(groups = {"category"})
    public void testCreateNewCategoryNameAndDescription(){

    }
    @Test(groups = {"category"})
    public void testCreateNewCategoryWithParentName(){

    }
    @AfterClass(alwaysRun = true)
    public void afterClass(){
        System.out.println("After class");
    }
}
