package webdriver;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_13_Handle_Popup {
    WebDriver driver;
    @BeforeClass
    public void BeforeClass(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
    //@Test
    public void TC_01_Fixed_Popup_In_Dom(){
        driver.get("https://ngoaingu24h.vn/");// Truy cap trang
        driver.findElement(By.xpath("//button[text()='Đăng nhập']")).click(); // Click button dang nhap
        Assert.assertTrue(driver.findElement(By.cssSelector("div.auth-form")).isDisplayed());  //KIem tra pop up hien thi
        driver.findElement(By.xpath("//input[@placeholder='Tài khoản đăng nhập']")).sendKeys("automationfc");
        driver.findElement(By.xpath("//input[@placeholder='Mật khẩu']")).sendKeys("automationfc");
        driver.findElement(By.xpath("(//button[text()='Đăng nhập'])[2]")).click();
        sleepInSecond(2);
        Assert.assertEquals(driver.findElement(By.cssSelector("div#notistack-snackbar.SnackbarItem-message")).getText(), "Bạn đã nhập sai tài khoản hoặc mật khẩu!");

    }
   // @Test
    public void TC_02_Fixed_Popup_In_Dom(){
        driver.get("https://skills.kynaenglish.vn/dang-nhap");// Truy cap trang
        Assert.assertTrue(driver.findElement(By.cssSelector("div.k-popup-account-mb-content")).isDisplayed());  //KIem tra pop up hien thi
        driver.findElement(By.cssSelector("input#user-login")).sendKeys("automationfc@gmail.com");
        driver.findElement(By.cssSelector("input#user-password")).sendKeys("123456");
        driver.findElement(By.cssSelector("button#btn-submit-login")).click();
        sleepInSecond(2);
        Assert.assertEquals(driver.findElement(By.cssSelector("div#password-form-login-message")).getText(), "Sai tên đăng nhập hoặc mật khẩu");

    }
   // @Test
    public void TC_04_Fixed_Popup_NotIn_Dom(){
        driver.get("https://www.facebook.com/");// Truy cap trang
        driver.findElement(By.xpath("//a[text()='Create new account']")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("div._n3")).isDisplayed());  //KIem tra pop up hien thi
        driver.findElement(By.xpath("//div[text()='Sign Up']//parent::div/parent::div/img")).click();
        sleepInSecond(3);
        Assert.assertFalse(driver.findElement(By.cssSelector("div._n3")).isDisplayed());  //KIem tra pop up ko hien thi
    }
    @Test
    public void TC_05_Random_Popup_In_Dom(){
        driver.get("https://www.kmplayer.com/home");// Truy cap trang

        if(driver.findElement(By.cssSelector("div.pop-container")).isDisplayed()){
            driver.findElement(By.cssSelector("div.close")).click();//close pop up đi
        }else{
            sleepInSecond(3);
            Assert.assertFalse(driver.findElement(By.cssSelector("div.pop-container")).isDisplayed());  //KIem tra pop up ko hien thi
            driver.findElement(By.cssSelector("a#support")).click();
        }
    }

    @Test
    public void TC_06_Random_Popup_NotIn_Dom(){
        driver.get("https://www.javacodegeeks.com/");// Truy cap trang

        if(driver.findElement(By.cssSelector("div.pop-container")).isDisplayed()){
            driver.findElement(By.cssSelector("div.close")).click();//close pop up đi
        }else{
            sleepInSecond(3);
            Assert.assertFalse(driver.findElement(By.cssSelector("div.pop-container")).isDisplayed());  //KIem tra pop up ko hien thi
            driver.findElement(By.cssSelector("a#support")).click();
        }

    }


    @Test
    public void TC_07_Random_Popup_NotIn_Dom(){
        driver.get("https://dehieu.vn/");// Truy cap trang
        Actions action = new Actions(driver);

        if(driver.findElement(By.cssSelector("div.modal-content")).isDisplayed()){
            driver.findElement(By.cssSelector("button.close")).click();//close pop up đi
        }else{
            sleepInSecond(3);
            driver.findElement(By.cssSelector("//input[@placeholder='Tìm khóa học']")).sendKeys("English");
            action.keyUp(Keys.ENTER).perform();
            Assert.assertEquals(driver.findElement(By.cssSelector("div.container h4")).getText(),"Tìm thấy 0 khóa học với từ khóa \"english\"");

        }
    }

    public void sleepInSecond(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
