package webdriver;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.util.Strings;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import static java.awt.SystemColor.text;

public class Topic_16_Window {
    WebDriver driver;

    @BeforeClass
    public void BeforeClass() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @Test
    public void TC_13_Windows() {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        //Lay ID cua tab hien tai
        String parentID = driver.getWindowHandle();
        System.out.println("parentID: " + parentID);
//        driver.switchTo().newWindow(WindowType.WINDOW);
//        driver.get("https://www.google.com.vn/");
        driver.findElement(By.xpath("//a[text()='GOOGLE']")).click();
        sleepInSecond(5);
        //Lay ra ID cua tat ca window hoac tab dang co
        Set<String> allTabID = driver.getWindowHandles();

        for (String id : allTabID) {
            //Neu 1 id nao khac voi parentId thi switch vao
            if (!id.equals(parentID)) {
                driver.switchTo().window(id);
                break;
            }
        }
        String googleTabID = driver.getWindowHandle();
        System.out.println("Google ID: " + googleTabID);
        Assert.assertEquals(driver.getTitle(), "Google");
        //switch ve tab ban dau
        driver.switchTo().window(parentID);
        // System.out.println(driver.getCurrentUrl());
        //Click vao Facebook
        driver.findElement(By.xpath("//a[text()='FACEBOOK']")).click();
        Set<String> allTabID2 = driver.getWindowHandles();
        for (String id : allTabID2) {
            if (!id.equals(parentID) && !id.equals(googleTabID)) {
                driver.switchTo().window(id);
                break;
            }
        }

        String facebookID = driver.getWindowHandle();
        System.out.println("FB ID: " + facebookID);
        //System.out.println("FB tab title"+driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Facebook – log in or sign up");
        //switch ve parent Tab
        driver.switchTo().window(parentID);

        //Click vao TIKI
        driver.findElement(By.xpath("//a[text()='TIKI']")).click();
        Set<String> allTabID3 = driver.getWindowHandles();
        for (String id : allTabID3) {
            if (!id.equals(parentID) && !id.equals(googleTabID) && !id.equals(facebookID)) {
                driver.switchTo().window(id);
                break;
            }
        }
        String tikiID = driver.getWindowHandle();
        System.out.println("TIKI ID: " + tikiID);
        // System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Tiki - Mua hàng online giá tốt, hàng chuẩn, ship nhanh");
        // DOng cac tab google, tiki, facebook
        Set<String> allTabID4 = driver.getWindowHandles();
        for (String id : allTabID4) {
            if (!id.equals(parentID)) {
                driver.switchTo().window(id);
                driver.close();
            }
        }
        //Kiem tra title tab hien tai
        Assert.assertEquals(driver.getTitle(), "Selenium Webdriver");

    }

    @Test
    public void TC_14_Windows_Tabs() {
        driver.get("http://live.techpanda.org/");
        //Sang tab mobile
        driver.findElement(By.xpath("//a[text()='Mobile']")).click();
        //Add san pham Sony de compare
        driver.findElement(By.xpath("//a[text()='Sony Xperia']/parent::h2/parent::div//a[text()='Add to Compare']")).click();
        // Kiem tra message hien thi
        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(), "The product Sony Xperia has been added to comparison list.");

        //Add san pham Samsung de compare
        driver.findElement(By.xpath("//a[text()='Samsung Galaxy']/parent::h2/parent::div//a[text()='Add to Compare']")).click();

        // Kiem tra message hien thi
        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(), "The product Samsung Galaxy has been added to comparison list.");

        String oldTabId = driver.getWindowHandle();
        System.out.println("Old ID" + oldTabId);

        //Click button Compare de mo cua so moi
        driver.findElement(By.xpath("//button[@title='Compare']")).click();

        Set<String> allTabIds = driver.getWindowHandles();

        for (String id : allTabIds) {
            if (!id.equals(oldTabId)) {
                driver.switchTo().window(id);
                break;
            }
        }
        String newTabId = driver.getWindowHandle(); // Lay ID cua tab moi
        //System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Products Comparison List - Magento Commerce");
        //Dong tab hien tai
        driver.close();
        // Tro ve tab ban dau
        driver.switchTo().window(oldTabId);
        //CLear all link
        driver.findElement(By.xpath("//a[text()='Clear All']")).click();

        //Accepted alert
        driver.switchTo().alert().accept();
        //Verify messsage hien thi
        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(), "The comparison list was cleared.");
    }

    @Test
    public void TC_15_Windows_Tabs(){
        driver.get("https://dictionary.cambridge.org/vi/");
        sleepInSecond(5);
        String oldTabId=  driver.getWindowHandle();
        System.out.println(oldTabId);
        driver.findElement(By.xpath("//span[text()='Đăng nhập']")).click();

        Set<String> allWindowIds = driver.getWindowHandles();

        for(String id:allWindowIds){
            if(!id.equals(oldTabId)){
                driver.switchTo().window(id);
                break;
            }
        }
        String newTabId = driver.getWindowHandle();
        System.out.println(newTabId);
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@value='Log in']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Email *']/parent::div/span")).getText(),"This field is required");
        Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Password *']/parent::div/span")).getText(),"This field is required");

        driver.close();
        driver.switchTo().window(oldTabId); //switch ve trang truoc
        driver.findElement(By.xpath("//input[@placeholder='Tìm kiếm Tiếng Anh']")).sendKeys("automation");
        driver.findElement(By.cssSelector("button.cdo-search-button")).click();
       // driver.findElement()
        String bodyText = driver.findElement(By.tagName("body")).getText();
        //Assert.assertTrue("automation", bodyText.contains());

    }

    @Test
    public void TC_16_Windows_Tabs(){
        driver.get("https://courses.dce.harvard.edu/");
        sleepInSecond(5);
        String oldTabId=  driver.getWindowHandle();
        System.out.println(oldTabId);
        driver.findElement(By.cssSelector("div.banner__auth a")).click();
        sleepInSecond(3);
        Set<String> allWindowIds = driver.getWindowHandles();

        for(String id:allWindowIds){
            if(!id.equals(oldTabId)){
                driver.switchTo().window(id);
                break;
            }
        } // chuyen sang window moi
        String newTabId = driver.getWindowHandle();
        System.out.println(newTabId);

        driver.manage().window().maximize();
        //Verify man hinh Login Portal hien thi
        Assert.assertEquals(driver.getTitle(),"Harvard Division of Continuing Education Login Portal");

        //Close cua so di va switch ve trang truoc
        driver.close();
        driver.switchTo().window(oldTabId); //switch ve trang truoc
        System.out.println(driver.getWindowHandle());
        Assert.assertEquals(driver.getTitle(), "DCE Course Search");
        sleepInSecond(3);
        //Shadow
        WebElement shadowHostElement = driver.findElement(By.cssSelector("div#sam-wait"));
        SearchContext shadowRootContext= shadowHostElement.getShadowRoot();
        //close pop up
        shadowRootContext.findElement(By.xpath("//div[@class='cancel']/button[text()='Cancel']")).click();
        // NHap dieu kien tim kiem
        driver.findElement(By.cssSelector("input#crit-keyword")).sendKeys("Data Science: An Artificial Ecosystem");

        Topic_07_Custom_Dropdown drop = new Topic_07_Custom_Dropdown();
        drop.selectItemInDropdown(driver,"select#crit-srcdb","select#crit-srcdb option","Harvard Summer School 2024");
        drop.selectItemInDropdown(driver, "select#crit-summer_school","select#crit-summer_school option","Harvard College");
        driver.findElement(By.cssSelector("button#search-button")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("span.result__title")).getText(),"Data Science: An Artificial Ecosystem");

    }
    public void sleepInSecond(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
