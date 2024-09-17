package prj.bipower;

import javaTester.Topic_06_Randon;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TC_Bipower_CFRsManage {
        WebDriver driver;
        Topic_06_Randon ran = new Topic_06_Randon();
        @BeforeClass
        public  void BeforeClass() throws InterruptedException {
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.get("https://bipower-staging.biplus.com.vn/login");

        }
        public void TC_01_Login() throws InterruptedException {
            driver.findElement(By.id("email")).sendKeys("tuahralead@biplus.com.vn");
            driver.findElement(By.id("password")).sendKeys("123456aA@");
            driver.findElement(By.xpath("//button[text()='Đăng nhập']")).click();
            driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
            driver.findElement(By.tagName("app-timemanagement"));
        }
        @Test
        public void TC_01_Create_CFRs() throws InterruptedException {
            TC_01_Login();
            driver.findElement(By.xpath("//span[text()='Nhân viên']")).click();
            driver.findElement(By.xpath("//a[text()='CFRs']")).click();
            driver.findElement(By.xpath("//a[text()='Tạo kỳ CFRs']")).click();
            driver.findElement(By.xpath("//input[@placeholder='MM/YYYY']")).clear();

            Random ran = new Random();
            String month = String.valueOf(ran.nextInt(1,12));
            String year = String.valueOf(ran.nextInt(2000,2030));
            String monthOfYear =month.concat("/").concat(year);

            driver.findElement(By.xpath("//input[@placeholder='MM/YYYY']")).sendKeys(monthOfYear);
            driver.findElement(By.xpath("//label[text()='Hình thức CFRs ']/following::div/select")).click();
            //Chon value trong dropdown
            Select kyCFRs = new Select(driver.findElement(By.xpath("//label[text()='Hình thức CFRs ']/following::div/select")));
            kyCFRs.selectByVisibleText("Hàng tháng");
            //verify dropdown nay la single ko phai multiple
            Assert.assertFalse(kyCFRs.isMultiple());

            //Verify so luong item trong dropdown nay la 2
            Assert.assertEquals(kyCFRs.getOptions().size(),2);

            driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
            driver.findElement(By.xpath("//button[text()='Tiếp tục ']")).click();
            //driver.findElement(By.xpath("//button[text()='Tiếp tục ']")).click();
            driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
            driver.findElement(By.xpath("//button[text()='Xác nhận ']")).click();
            driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
            // Vrify màn hình 


            //Tim kiem lai dư lieu da tao
            driver.findElement(By.xpath("//input[@placeholder='MM']")).sendKeys(month);
            driver.findElement(By.xpath("//input[@placeholder='YYYY']")).sendKeys(year);
//          new Select(driver.findElement(By.xpath("//label[text()='Hình thức CFRs']/following::div/select")));
//            kyCFRs.selectByVisibleText("Hàng tháng");

           // driver.findElement(By.xpath("//td[text()='T{month}/2024']"));

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
        @Test
        public void TC_03_Demo_TextArea(){
            driver.findElement(By.xpath("//span[text()='Chấm công']")).click();
            driver.findElement(By.xpath("//a[text()='Ngày nghỉ & phép']")).click();
            driver.findElement(By.xpath("//button[text()='Đăng ký']")).click();
            driver.findElement(By.xpath("//label[text()='Thời gian bắt đầu ']/parent::div/div/input")).clear(); //clear time bat dau
            driver.findElement(By.xpath("//label[text()='Thời gian bắt đầu ']/parent::div/div/input")).clear(); //
        }
//        @AfterTest
//        public void TC_Quit_Browser(){
//            driver.quit();
//        }
//

}
