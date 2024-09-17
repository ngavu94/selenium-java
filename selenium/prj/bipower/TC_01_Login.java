package prj.bipower;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC_01_Login {
    WebDriver driver;
    @BeforeClass
    public  void BeforeClass() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://bipower-staging.biplus.com.vn/login");
        TC_01_Login();
    }
    public void TC_01_Login() throws InterruptedException {
        driver.findElement(By.id("email")).sendKeys("duongtv@biplus.com.vn");
        driver.findElement(By.id("password")).sendKeys("123456aA@");
        driver.findElement(By.xpath("//button[text()='Đăng nhập']")).click();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.findElement(By.tagName("app-timemanagement"));
    }
    @Test
    public void TC_01_Create_CFRs(){
        driver.findElement(By.xpath("//span[text()='Nhân viên']")).click();
        driver.findElement(By.xpath("//a[text()='CFRs']")).click();
        driver.findElement(By.xpath("//a[text()='Tạo kỳ CFRs']")).click();
        driver.findElement(By.xpath("//input[@placeholder='MM/YYYY']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='MM/YYYY']")).sendKeys("02/2024");
        driver.findElement(By.xpath("//label[text()='Hình thức CFRs ']/following::div/select")).click();
        driver.findElement(By.xpath("//select/option[@value='MONTHLY']")).click();
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        driver.findElement(By.xpath("//button[text()='Tiếp tục ']")).click();
        //driver.findElement(By.xpath("//button[text()='Tiếp tục ']")).click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.findElement(By.xpath("//button[text()='Xác nhận ']")).click();
        //
        driver.findElement(By.xpath("//input[@placeholder='MM']")).sendKeys("02");
        driver.findElement(By.xpath("//input[@placeholder='YYYY']")).sendKeys("2024");
        driver.findElement(By.xpath("//td[text()='T2/2024']"));
    }
    @Test
    public void TC_02_View_Detail_CFRs(){
        driver.findElement(By.xpath("//td[text()='T2/2024']")).click();
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@placeholder='Nhập tên/mã nhân viên']")).sendKeys("nga");
        driver.findElement(By.xpath("//input[@placeholder='Nhập tên/mã nhân viên']")).sendKeys(Keys.TAB);
        driver.findElement(By.xpath("//input[@placeholder='Nhập tên/mã nhân viên']")).sendKeys("nga");
        driver.findElement(By.xpath("//small[text()='B3003']/parent::div")).click();
        driver.findElement(By.xpath("//span[text()='Nhân viên: B3003 - Vũ Thị Nga new']"));

    }
    @AfterTest
    public void TC_Quit_Browser(){
        driver.quit();
    }
}
