package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.print.attribute.standard.PrinterState;
import java.io.File;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Topic_25_Wait_Mix_Implicit_Explicit {
        WebDriver driver;
        WebDriverWait explicitWait ;


        @BeforeClass
        public void BeforeClass(){
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            //explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));

        }
        @Test
        public void TC_01_Only_Implicit_Found(){
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
            driver.get("https://facebook.com/");
            // Khi vào tìm element thì nó tìm thấy ngay
            // Ko cần chờ hết timeouts
            driver.findElement(By.cssSelector("input#email"));


        }
        @Test
        public void TC_02_Only_Implicit_NotFound(){
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.get("https://facebook.com/");
            //Khi vào tìm element ko thấy
            // Polling 0.5s tìm lại 1 lần
            //Khi hết timeout sẽ đánh fail TCS và throw exception: NoSuchELementException
            driver.findElement(By.cssSelector("input#automation"));

        }
        @Test
        public void TC_03_Only_Explicit_Found(){
          //  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.get("https://facebook.com/");
            explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));
            explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#email")));

        }
        @Test
        public void TC_04_Only_Explicit_NotFound_Param_By(){
            driver.get("https://facebook.com/");
            explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));

            //Khi vào tìm element ko thấy
            // Polling 0.5s tìm lại 1 lần
            //Khi hết timeout sẽ đánh fail TCS và throw exception: TimeOutException
            explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#automation")));
        }
    @Test
    public void TC_05_Mix_Implicit_Explicit(){
        driver.get("https://facebook.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));

        //Khi vào tìm element ko thấy
        // Polling 0.5s tìm lại 1 lần
        //Khi hết timeout sẽ đánh fail TCS và throw exception: TimeOutException
        // driver.findElement(By.cssSelector("input#automation"));
        System.out.println("Start Time: "+getDateTimeNow());
        try{
            explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#automation")));
        }catch (Exception e){
            System.out.println("End Time: "+getDateTimeNow());
            e.printStackTrace();
        }

    }
    @Test
    public void TC_06_Mix_Implicit_Explicit(){
        driver.get("https://facebook.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));

        //Khi vào tìm element ko thấy
        // Polling 0.5s tìm lại 1 lần
        //Khi hết timeout sẽ đánh fail TCS và throw exception: TimeOutException
        // driver.findElement(By.cssSelector("input#automation"));
        System.out.println("Start Time: "+getDateTimeNow());
        try{
            explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#automation")));
        }catch (Exception e){
            System.out.println("End Time: "+getDateTimeNow());
            e.printStackTrace();
        }

    }
    @AfterClass
    public void AfterClass(){
            driver.quit();
    }
    public String getDateTimeNow(){
        Date date = new Date();
        return date.toString();
    }


}
