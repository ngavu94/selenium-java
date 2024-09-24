package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Topic_21_ImplicitWait_Exercise {
    WebDriver driver;
    WebDriverWait implicitWait;

    @BeforeClass
    public void BeforeClass(){
        driver=new ChromeDriver();

        driver.manage().window().maximize();
        //driver.get("https://facebook.com");
    }
    @Test //
    public  void TC_01_Equal_5s(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://automationfc.github.io/dynamic-loading/");
        driver.findElement(By.cssSelector("div#start button")).click();
        By resultMessage = By.cssSelector("div#finish h4");
        implicitWait.until(ExpectedConditions.visibilityOfElementLocated(resultMessage));
        Assert.assertTrue(driver.findElement(resultMessage).isDisplayed());
    }
    @Test  //Fail
    public  void TC_01_LessThan_5s(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://automationfc.github.io/dynamic-loading/");
        driver.findElement(By.cssSelector("div#start button")).click();
        By resultMessage = By.cssSelector("div#finish h4");
        implicitWait.until(ExpectedConditions.visibilityOfElementLocated(resultMessage));
        Assert.assertTrue(driver.findElement(resultMessage).isDisplayed());
    }
    @Test //Pass
    public  void TC_01_MoreThan_5s(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        driver.get("https://automationfc.github.io/dynamic-loading/");
        driver.findElement(By.cssSelector("div#start button")).click();
        By resultMessage = By.cssSelector("div#finish h4");
        implicitWait.until(ExpectedConditions.visibilityOfElementLocated(resultMessage));
        Assert.assertTrue(driver.findElement(resultMessage).isDisplayed());
    }

}
