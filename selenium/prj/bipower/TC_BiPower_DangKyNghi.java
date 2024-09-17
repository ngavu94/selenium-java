package prj.bipower;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TC_BiPower_DangKyNghi {
    WebDriver driver;
    Common_Function cf;
    Random ran;
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
    public void TC_01_DangKyNghiPhep() throws InterruptedException {
        cf = new Common_Function();
        ran = new Random();
        String fromDate ="04/09/2024";
        String toDate ="04/09/2024";
        String reason="Automation Test_Nghỉ để đi du lịch";
        TC_01_Login();
        driver.findElement(By.xpath("//span[text()='Chấm công']/parent::a")).click();
        driver.findElement(By.xpath("//a[text()='Ngày nghỉ & phép']")).click();
        driver.findElement(By.xpath("//button[text()='Đăng ký']")).click();
        //Chọn nhân viên *
        driver.findElement(By.xpath("span#select2-6xx8-container")).click();
        cf.selectItemInDropdown(driver,"span.select2-container--open li","B3003 - Vũ Thị Nga new");

        //Loai phep
        Select loaiPhep = new Select(driver.findElement(By.xpath("//select[@formcontrolname='leaveType']")));
        loaiPhep.selectByVisibleText("Nghỉ phép ");
        Assert.assertFalse(loaiPhep.isMultiple());

        //Thời gian bắt đầu *
        driver.findElement(By.xpath("//label[text()='Thời gian bắt đầu ']/following::div/input")).sendKeys(fromDate.concat(" ").concat("08:01"));
        //Thời gian kết thúc *
        driver.findElement(By.xpath("//label[text()='Thời gian kết thúc ']/following::div/input")).sendKeys(toDate.concat(" ").concat("12:00"));
        //Số ngày nghỉ
        String soNgayNghi= driver.findElement(By.cssSelector("input.form-control")).getText();
        System.out.println(soNgayNghi);
        //Lý do nghỉ*
        driver.findElement(By.xpath("//textarea[@placeholder='Nhập lý do nghỉ']")).sendKeys(reason);

        //Click Lưu
        driver.findElement(By.xpath("//button[text()='Lưu ']")).click();

        //verify message

        //Tim kiem dư lieu da tao
        driver.findElement(By.cssSelector("input.datetimepicker ")).sendKeys(fromDate.concat("-").concat(toDate));
        System.out.println(fromDate.concat("-").concat(toDate));
        driver.findElement(By.xpath("//a[text()='Tìm kiếm']"));

        //




    }
}
