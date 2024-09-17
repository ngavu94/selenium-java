package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_06_Custom_Textbox_TextArea {
    WebDriver driver;

    @BeforeClass
    public void BeforeClass() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://bipower-staging.biplus.com.vn/login");
    }

    public void TC_01_Login() throws InterruptedException {
        driver.findElement(By.id("email")).sendKeys("duongtv@biplus.com.vn");
        driver.findElement(By.id("password")).sendKeys("123456aA@");
        driver.findElement(By.xpath("//button[text()='Đăng nhập']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.tagName("app-timemanagement"));
    }

    @Test
    public void TC_01_Empty_Email_And_Password() {
        driver.findElement(By.xpath("//button[text()='Đăng nhập'")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='email']/following::div/div")).getText(),"Email không được để trống.\n");
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='password']/following::div/div")).getText(),"Mật khẩu không được để trống.\n");

    }

    @Test
    public void TC_02_Invalid_Email() {
        driver.findElement(By.cssSelector("input#email")).sendKeys("124biplus.com.vn");
        driver.findElement(By.cssSelector("input#password")).sendKeys("123456aA@");
        driver.findElement(By.xpath("//button[text()='Đăng nhập'")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div#toast-container")).getText(),"Sai tên đăng nhập hoặc mật khẩu không đúng");

    }

    @Test
    public void TC_03_Invalid_Password() {
        driver.findElement(By.cssSelector("input#email")).sendKeys("ngavt@biplus.com.vn");
        driver.findElement(By.cssSelector("input#password")).sendKeys("123456");
        driver.findElement(By.xpath("//button[text()='Đăng nhập'")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div#toast-container")).getText(),"Sai tên đăng nhập hoặc mật khẩu không đúng");

    }
    @Test
    public void TC_04_Incorrect_Email_Password() {
        driver.findElement(By.cssSelector("input#email")).sendKeys("ngavt124@biplus.com.vn");
        driver.findElement(By.cssSelector("input#password")).sendKeys("123456aA@");
        driver.findElement(By.xpath("//button[text()='Đăng nhập'")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div#toast-container")).getText(),"Sai tên đăng nhập hoặc mật khẩu không đúng");

    }
    @Test
    public void TC_05_Correct_Email_Password() {
        driver.findElement(By.cssSelector("input#email")).sendKeys("ngavt@biplus.com.vn");
        driver.findElement(By.cssSelector("input#password")).sendKeys("123456aA@");
        driver.findElement(By.xpath("//button[text()='Đăng nhập'")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div#toast-container")).getText(),"Sai tên đăng nhập hoặc mật khẩu không đúng");

    }

    @AfterTest
    public void TC_Quit_Browser() {
        driver.quit();
    }


}
