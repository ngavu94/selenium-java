package prj.bipower;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC_BiPower_LamNgoaiGio {
    WebDriver driver ;
    @BeforeClass
    public void BeforeClass(){
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


    }
    @Test
    public void TC_01_Dangky_TinhNghiBU(){
        Login("ngavt@biplus.com.vn","123456aA@");
        //Click button Dang ky
        driver.findElement(By.cssSelector("button.add-btn")).click();

    }


    public void sleepInSecond(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
        public void Login(String username, String password){
            // Truy cap chuc nang lam ngoai gio
            driver.get("https://bipower-staging.biplus.com.vn/login");
            //Login
            driver.findElement(By.cssSelector("input#email")).sendKeys(username);
            driver.findElement(By.cssSelector("input#password")).sendKeys(password);
            driver.findElement(By.xpath("//button[text()='Đăng nhập']")).click();
            sleepInSecond(2);
            if(driver.findElement(By.xpath("//a[text()='Làm ngoài giờ']")).isDisplayed()){
                driver.findElement(By.xpath("//a[text()='Làm ngoài giờ']")).click();
            }
            else {
                driver.findElement(By.xpath("//span[text()='Chấm công']/parent::a")).click();
                driver.findElement(By.xpath("//a[text()='Làm ngoài giờ']")).click();
            }



        }
}
