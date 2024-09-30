package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Topic_24_Emplicit_WaitExercise2 {
    WebDriver driver;
    WebDriverWait explicitWait ;
    String projectPath = System.getProperty("user.dir");
    String image1 = "WIN_20230614_10_33_01_Pro.jpg";
    String image2 ="WIN_20230614_10_33_28_Pro.jpg";
    //String image3 ="image03.png";

    String image01Path = projectPath+ File.separator+"uploadFiles"+File.separator+image1;
    String image02Path = projectPath+File.separator+"uploadFiles"+File.separator+image2;
   // String image03Path = projectPath+File.separator+"uploadFiles"+File.separator+image3;

    @BeforeClass
    public void BeforeClass(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));

    }
    @Test
    public void TC_01_AjaxLoading(){
        driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
        //Verify text trước khi chọn ngày
        Assert.assertEquals(driver.findElement(By.cssSelector("div[id*='_Label1Panel']>span")).getText(),"No Selected Dates to display.");

        // Click vào 1 ngày bất kỳ
        driver.findElement(By.xpath("//a[text()='18']")).click();
        //Wait cho loading icon biến mất
        By iconLoading = By.cssSelector("div[id*='RadCalendar1']>div.raDiv");
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(iconLoading));
        //Chờ cho text xuất hiện
        By textDate = By.cssSelector("div[id*='_Label1Panel']");
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(textDate));
        Assert.assertEquals(driver.findElement(By.cssSelector("div[id*='_Label1Panel']>span")).getText(),"Wednesday, September 18, 2024");

    }
    @Test
    public void TC_02_UploadFile(){
        driver.get("https://gofile.io/welcome");
        //Verify text trước khi chọn ngày
        //wait + verify spinner icon biến mất
        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.spinner-border"))));
        //Wait + click button Upload file
        driver.findElement(By.cssSelector("a.ajaxLink>button")).click();
        //Wait + click button Add file
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div#filesUpload button"))).click();

        driver.findElement(By.cssSelector("input[type='file']")).sendKeys(image01Path);


    }
}
