package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_15_Iframe {
    WebDriver driver;

    @BeforeClass
    public void BeforeClass() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void TC_10_Iframe_Handle() {
        driver.get("https://toidicodedao.com/");
        driver.switchTo().frame(driver.findElement(By.cssSelector("div.fb_iframe_widget iframe")));

        WebElement folowerElement = driver.findElement(By.cssSelector("div._1drq"));
        System.out.println(folowerElement.getText());
        Assert.assertEquals(folowerElement.getText(), "405,632 followers");
    }

    @Test
    public void TC_11_Iframe_Handle() {
        Actions action = new Actions(driver);

        Topic_07_Custom_Dropdown dropdown = new Topic_07_Custom_Dropdown();
        driver.get("https://www.formsite.com/templates/education/campus-safety-survey/");
        //Click image de hien thi frame
        driver.findElement(By.cssSelector("div.details__form-image img")).click();
        sleepInSecond(3);
        //switch sang frame moi
        driver.switchTo().frame(driver.findElement(By.cssSelector("div.details__form-template iframe")));

        dropdown.selectItemInDropdown(driver, "select#RESULT_RadioButton-2", "select#RESULT_RadioButton-2 option", "Sophomore");
        dropdown.selectItemInDropdown(driver, "select#RESULT_RadioButton-3", "select#RESULT_RadioButton-3 option", "South Dorm");
        driver.findElement(By.cssSelector("#FSsubmit")).click();

        //back ve frame ban dau
        driver.switchTo().defaultContent();
//        JavascriptExecutor jse = (JavascriptExecutor)driver;
//        jse.executeScript("window.scrollBy(0,0)");
        driver.findElement(By.cssSelector("nav.header header--desktop a.menu-item-login")).click();
    }


    public void sleepInSecond(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
