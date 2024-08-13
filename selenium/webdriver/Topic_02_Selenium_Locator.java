package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_02_Selenium_Locator {

    WebDriver driver;
//    String projectPath = System.getProperty("user.dir");
//    String osName = System.getProperty("os.name");
//    @BeforeClass
//    public void beforeClass() {
//        if (osName.contains("Windows")) {
//            System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
//        } else {
//            System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
//        }
//
//        driver = new FirefoxDriver();
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        driver.get("https://demo.nopcommerce.com/register");
//    }
    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/register");
//        driver.quit();
    }
    @Test
    public void TC_01_Id() {
        driver.findElement(By.id("FirstName"));
    }
    @Test
    public void TC_02_Class() {
        driver.findElement(By.className("inputs"));
    }
    // Hoc clone va commit code
    @Test
    public void TC_03_Name() {
        driver.findElement(By.name("email"));
//        Assert.assertTrue(driver.findElement(By.cssSelector("img.fb_logo")).isDisplayed());
    }
    @Test
    public void TC_04_TagName() {
        driver.findElement(By.tagName("inputs"));
//        Assert.assertTrue(driver.findElement(By.cssSelector("img.fb_logo")).isDisplayed());
    }
    @Test
    public void TC_05_LinkText() {
        driver.findElement(By.linkText("https://demo.nopcommerce.com/computers"));
//        <a href="/computers">Computers </a>
//        Assert.assertTrue(driver.findElement(By.cssSelector("img.fb_logo")).isDisplayed());
    }
    @Test
    public void TC_06_Partial_LinkText() {
        driver.findElement(By.partialLinkText("/computers"));
//        Assert.assertTrue(driver.findElement(By.cssSelector("img.fb_logo")).isDisplayed());
    }
    @Test
    public void TC_07_CSS() {
        driver.findElement(By.cssSelector("#LastName"));
//        Assert.assertTrue(driver.findElement(By.cssSelector("img.fb_logo")).isDisplayed());
    }
    @Test
    public void TC_08_Xpath() {
        driver.findElement(By.xpath("//input[@name='LastName']"));
//        Assert.assertTrue(driver.findElement(By.cssSelector("img.fb_logo")).isDisplayed());
    }
}
