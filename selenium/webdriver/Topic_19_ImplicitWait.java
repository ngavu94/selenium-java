package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Topic_19_ImplicitWait {
    WebDriver driver;
    WebDriverWait implicitWait;

    @BeforeClass
    public void BeforeClass(){
        driver=new ChromeDriver();
        implicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }
    @Test //done
    public void TC_02_ImplicitWait(){
        driver.get("https://automationfc.github.io/dynamic-loading/");

        driver.findElement(By.cssSelector("div#start button")).click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish h4")).getText(),"Hello World!");
    }
    @Test //done
    public void TC_03_Static_Wait(){
        driver.get("https://automationfc.github.io/dynamic-loading/");
        driver.findElement(By.cssSelector("div#start button")).click();
        By resultMessage = By.cssSelector("div#finish h4");
        implicitWait.until(ExpectedConditions.visibilityOfElementLocated(resultMessage));
        Assert.assertTrue(driver.findElement(resultMessage).isDisplayed());

        Assert.assertEquals(driver.findElement(resultMessage).getText(),"Hello World!");

    }

    @Test //done
    public void TC_04_Invisible_In_DOM(){
        driver.get("https://automationfc.github.io/dynamic-loading/");
        By resultMessage = By.cssSelector("div#finish h4");
        By buttonStart = By.cssSelector("div#start button");
        driver.findElement(buttonStart).click();
        // Khong xuat hien tren UI va van co tren DOM
        implicitWait.until(ExpectedConditions.invisibilityOfElementLocated(buttonStart));
        Assert.assertFalse(driver.findElement(buttonStart).isDisplayed());

        //Assert.assertEquals(driver.findElement(resultMessage).getText(),"Hello World!");

    }
    @Test //done
    public void TC_04_Invisible_Not_In_DOM(){
        driver.get("https://automationfc.github.io/dynamic-loading/");
        By resultMessage = By.cssSelector("div#finish h4");
        By buttonStart = By.cssSelector("div#start button");
        driver.findElement(buttonStart).click();
        // Khong xuat hien tren UI va van co tren DOM
        implicitWait.until(ExpectedConditions.invisibilityOfElementLocated(buttonStart));
        Assert.assertFalse(driver.findElement(buttonStart).isDisplayed());

        //Assert.assertEquals(driver.findElement(resultMessage).getText(),"Hello World!");

    }

    @Test
    public void TC_01_Visible(){
        driver.get("https://facebook.com");
        driver.findElement(By.cssSelector("a[data-testid='open-registration-form-button']")).click();
        sleepInSecond(2);
        driver.findElement(By.cssSelector("input[name='reg_email__']")).sendKeys("");
        By elementConfirmEmail= By.cssSelector("acsskjs");
        //Tai thoi diem nay thi Confirm Email dang visible/ Displayed
        implicitWait.until(ExpectedConditions.visibilityOfElementLocated(elementConfirmEmail));


    }
    public void sleepInSecond(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public void TC_02_InVisible(){

    }
    public void TC_03_Presence(){

    }
}
