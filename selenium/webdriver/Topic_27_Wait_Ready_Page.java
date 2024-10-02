package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;
import java.util.function.Function;

public class Topic_27_Wait_Ready_Page {

    WebDriver driver;
    WebDriverWait explicitWait;


    @BeforeClass
    public void BeforeClass(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       // explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @Test
    public void TC_01_AjaxLoading(){
        driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
        //Verify text trước khi chọn ngày
        Assert.assertEquals(driver.findElement(By.cssSelector("div[id*='_Label1Panel']>span")).getText(),"No Selected Dates to display.");

        // Click vào 1 ngày bất kỳ
        driver.findElement(By.xpath("//a[text()='18']")).click();
//        //Wait cho loading icon biến mất
//        By iconLoading = By.cssSelector("div[id*='RadCalendar1']>div.raDiv");
//        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(iconLoading));

        //Wait cho page ready
        Assert.assertTrue(isPageLoadedSuccess());
//        By textDate = By.cssSelector("div[id*='_Label1Panel']");
//        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(textDate));
        Assert.assertEquals(driver.findElement(By.cssSelector("div[id*='_Label1Panel']>span")).getText(),"Wednesday, September 18, 2024");

    }
    @Test
    public void TC_02_Admin_NopCommerce(){
        driver.get("https://admin-demo.nopcommerce.com/");
        driver.findElement(By.cssSelector("input#Email")).clear();
        driver.findElement(By.cssSelector("input#Email")).sendKeys("admin@yourstore.com");
        driver.findElement(By.cssSelector("input#Password")).clear();
        driver.findElement(By.cssSelector("input#Password")).sendKeys("admin");
        driver.findElement(By.cssSelector("button.login-button")).click();
        Assert.assertTrue(waitAjaxLoadingInvisible());

        driver.findElement(By.xpath("//i[contains(@class,'fa-user')]/following-sibling::p")).click();
        driver.findElement(By.xpath("//ul[@style='display: block;']//a[@class='nav-link']/p[text()=' Customers']")).click();
        Assert.assertTrue(isPageLoadedSuccess());

        driver.findElement(By.xpath("//i[contains(@class,'fa-book')]/following-sibling::p")).click();
        driver.findElement(By.xpath("//ul[@class='nav nav-treeview']//a[@class='nav-link active']/p[text()=' Products']")).click();
        Assert.assertTrue(isPageLoadedSuccess());


        driver.findElement(By.xpath("//i[contains(@class,'fa-shopping-cart')]/following-sibling::p")).click();
        driver.findElement(By.xpath("//ul[@class='nav nav-treeview']//a[@class='nav-link active']/p[text()=' Products']")).click();
        Assert.assertTrue(isPageLoadedSuccess());
    }
    public void TC_02_OrangeHRM_API_Document()
    {
        driver.get("https://api.orangehrm.com/");
    }

    public boolean waitAjaxLoadingInvisible(){
        return explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div#ajaxBusy")));
    }

    public boolean isPageLoadedSuccess() {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        //Điều kiện 1
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return (Boolean) jsExecutor.executeScript("return (window.jQuery != null) && (jQuery.active === 0);");
            }
        };

        // Điều kiện 2
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
            }
        };
        return explicitWait.until(jQueryLoad)&& explicitWait.until(jsLoad);
    }

    @AfterClass
    public void AfterClass(){
        driver.quit();
    }
    public String getDateTimeNow(){
        Date date = new Date();
        return date.toString();
    }
    public WebElement waitAndFileElement(By locator){
        FluentWait<WebDriver> fluentDriver = new FluentWait<WebDriver>(driver);
        fluentDriver.withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchElementException.class);
        return fluentDriver.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
            }
        });
    }
}
