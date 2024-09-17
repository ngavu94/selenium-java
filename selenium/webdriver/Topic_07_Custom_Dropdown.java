package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_07_Custom_Dropdown {
    WebDriver driver;

    @BeforeClass
    public void BeforeClass() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // driver.get("https://demo.nopcommerce.com/register");
        driver.manage().window().maximize();
    }
//@Test
    public void TC_01_JQuery_Dropdown(){
    driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
        //1. Click vao 2 thẻ để nó xổ ra het dữ liệu
        //Select a speed
        selectItemInDropdown(driver, "span#speed-button","ul#speed-menu div","Slow");
        //Select a file
        selectItemInDropdown(driver,"span#files-button","ul#files-menu div","ui.jQuery.js");
        //2.1 no xo ra hét tat cả các item
        //2.2 No chi xo ra 1 phan va dang load them
        //implicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("ul#number-menu div")));
        //3.1 Neu item can chon hien thi thi click vào

        //3.2 Neu item can chon o ben duoi thi 1 so truong hop can scroll xuong roi mói chon
        // Select a number
       selectItemInDropdown(driver,"span#number-button","ul#number-menu div","8");
        //Select a title
    selectItemInDropdown(driver,"span#salutation-button","ul#salutation-menu div","Mrs.");
        //Verify du lieu da chon
    Assert.assertEquals(driver.findElement(By.cssSelector("span#speed-button>span.ui-selectmenu-text")).getText(),"Slow");
    Assert.assertEquals(driver.findElement(By.cssSelector("span#files-button>span.ui-selectmenu-text")).getText(),"ui.jQuery.js");
    Assert.assertEquals(driver.findElement(By.cssSelector("span#number-button>span.ui-selectmenu-text")).getText(),"8");
    Assert.assertEquals(driver.findElement(By.cssSelector("span#salutation-button>span.ui-selectmenu-text")).getText(),"Mrs.");
        //4. Truoc khi chon can kiem tra neu text cua item = item can chon thi click vao

    }
    //@Test
    public void TC_02_React_Dropdown(){
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");
        selectItemInDropdown(driver,"div#root","div.item>span.text","Justen Kitsune");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider")).getText(),"Justen Kitsune");
    }

    @Test
    public void TC_03_VueJS_Dropdown(){
        driver.get("https://mikerodham.github.io/vue-dropdowns/");
        selectItemInDropdown(driver,"div.btn-group>li","ul.dropdown-menu a","Third Option");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.btn-group>li.dropdown-toggle")).getText(),"Third Option");


        selectItemInDropdown(driver,"div.btn-group>li","ul.dropdown-menu a","Third Option");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.btn-group>li.dropdown-toggle")).getText(),"Third Option");
    }

    public void selectItemInDropdown(WebDriver driver, String parentCss,String childItemCss, String option) {
        driver.findElement(By.cssSelector(parentCss)).click();
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        List<WebElement> allItems = driver.findElements(By.cssSelector(childItemCss));
        for (WebElement item : allItems) {
            String textItem = item.getText();
            System.out.println("" + textItem);
            if (textItem.equals(option)) {
                item.click();
                break; // 9-19 ko duoc kiem tra
            }
        }
    }

}
