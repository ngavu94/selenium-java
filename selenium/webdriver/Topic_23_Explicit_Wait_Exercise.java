package webdriver;

import javaTester.Topic_08_Date;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_23_Explicit_Wait_Exercise {
    WebDriver driver;
    WebDriverWait explicitWait;
    Topic_08_Date date;

    @BeforeClass
    public void BeforeClass() {
        driver = new ChromeDriver();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(3));
        date = new Topic_08_Date();
        driver.manage().window().maximize();
        //driver.get("https://facebook.com");
    }

    @Test //
    public void TC_01_Equal_5s() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://automationfc.github.io/dynamic-loading/");
        driver.findElement(By.cssSelector("div#start button")).click();
        WebElement loading = driver.findElement(By.cssSelector("div#loading"));
        explicitWait.until(ExpectedConditions.invisibilityOf(loading));
        By resultMessage = By.cssSelector("div#finish h4");
        Assert.assertTrue(driver.findElement(resultMessage).isDisplayed());
    }

    @Test  //Fail
    public void TC_01_LessThan_5s() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://automationfc.github.io/dynamic-loading/");
        driver.findElement(By.cssSelector("div#start button")).click();
        WebElement loading = driver.findElement(By.cssSelector("div#loading"));
        System.out.println("Start date: " + Topic_08_Date.getDateTimeNow());
        explicitWait.until(ExpectedConditions.invisibilityOf(loading));
        System.out.println("End date: " + Topic_08_Date.getDateTimeNow());
        By resultMessage = By.cssSelector("div#finish h4");
        Assert.assertTrue(driver.findElement(resultMessage).isDisplayed());
    }

    @Test //Pass
    public void TC_01_MoreThan_5s() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
        driver.get("https://automationfc.github.io/dynamic-loading/");
        driver.findElement(By.cssSelector("div#start button")).click();
        WebElement loading = driver.findElement(By.cssSelector("div#loading"));
        explicitWait.until(ExpectedConditions.invisibilityOf(loading));
        By resultMessage = By.cssSelector("div#finish h4");
        Assert.assertTrue(driver.findElement(resultMessage).isDisplayed());
    }
}
