package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

public class Topic_26_Wait_Fluent {
    WebDriver driver;
    FluentWait<WebDriver> fluentDriver;
    FluentWait<WebElement> fluentElement;
    FluentWait<String> fluentString;

    Integer fullTimeOutInSecond = 30;
    Integer pollingTimeOutInMilisecond = 100;


    @BeforeClass
    public void BeforeClass(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        fluentDriver = new FluentWait<WebDriver>(driver);

    }
    @Test
    public void TC_00_Only_Implicit_Found(){
        fluentDriver = new FluentWait<WebDriver>(driver);
        WebElement element = driver.findElement(By.cssSelector(""));
        fluentElement = new FluentWait<WebElement>(element);
        fluentString = new FluentWait<String>("Hello world!");

        //Tổng time
        fluentDriver.withTimeout(Duration.ofSeconds(10));
        //Set Polling time
        fluentDriver.pollingEvery(Duration.ofMillis(300));
        //Ignore NoSuchElement Exception
        fluentDriver.ignoring(NoSuchElementException.class);
        //Ignore TimeOut exception
        fluentDriver.ignoring(TimeoutException.class);
        //CONDITION
        fluentDriver.until(new Function<WebDriver, Object>() {

            @Override
            public Object apply(WebDriver driver) {
                return driver.findElement(By.cssSelector("")).getText();
            }
        });
        //

        fluentDriver.withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchElementException.class)
                .until(new Function<WebDriver, Object>() {
                    public Boolean apply(WebDriver driver){
                        return driver.findElement(By.cssSelector("")).isDisplayed();
                    }
                });


    }
    @Test
    public void TC_08_Fluent_Wait(){
        driver.get("https://automationfc.github.io/dynamic-loading/");
        //Click Start button
        waitAndFileElement(By.cssSelector("div#start button")).click();
        //Muốn trả về String
         String helloText = waitAndFileElement(By.xpath("//div[@id='finish']/h4")).getText();
        Assert.assertEquals(helloText,"Hello World!");
    }
    @Test
    public void TC_07_Fluent_Wait(){
        driver.get("https://automationfc.github.io/fluent-wait/");
        WebElement countDownTime = driver.findElement(By.cssSelector("div#javascript_countdown_time"));
        fluentElement = new FluentWait<WebElement>(countDownTime);
        fluentElement.withTimeout(Duration.ofSeconds(fullTimeOutInSecond))
                .pollingEvery(Duration.ofMillis(pollingTimeOutInMilisecond))
                .ignoring(NoSuchElementException.class);

        fluentElement.until(new Function<WebElement, Boolean>() {
            public Boolean apply(WebElement webElement){
                String text = webElement.getText();
                System.out.println(text);
                return webElement.getText().endsWith("00");
            }
        });
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
