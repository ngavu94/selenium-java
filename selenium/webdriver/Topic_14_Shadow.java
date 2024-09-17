package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_14_Shadow {
    WebDriver driver;
    @BeforeClass
    public void BeforeClass(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
    @Test
    public void TC_08_Shadow_Dom(){
        driver.get("https://automationfc.github.io/shadow-dom/");
        WebElement shadowHostElement = driver.findElement(By.cssSelector("div#shadow_host"));
        SearchContext shadowRootContext= shadowHostElement.getShadowRoot();
        String someText= shadowRootContext.findElement(By.cssSelector("span.info")).getText();
        System.out.println(someText);
        Assert.assertEquals(someText,"some text");

        //
        WebElement checkbox = shadowRootContext.findElement(By.xpath("//input[@type='checkbox']"));
        System.out.println(checkbox.isSelected());
    }
}
