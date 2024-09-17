package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import javaTester.Topic_06_Randon;

import java.util.concurrent.TimeUnit;

public class Topic_08_TextBox_TextArea_Demo {

    WebDriver driver;
    Topic_06_Randon random = new Topic_06_Randon();

    @BeforeClass
    public void BeforeClass() {
        //Muon dung duoc phai khoi tao
        //Neu ko khoi tao: Lỗi NullPointerException
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        //driver.get("https://www.facebook.com/");
        // driver.navigate()
    }

    @Test
    public void TC_01_Empty_Email_Password() {
        // Mo ra 1 url bat ky
        driver.get("http://live.techpanda.org/index.php/customer/account/login/");
        // Tìm ra các element có id = email,
        // Neu ko tìm thay thì step nay fail - throw exception: noSuchElementException
        driver.findElement(By.cssSelector("input#email")).clear();
        driver.findElement(By.cssSelector("input#pass")).clear();
        driver.findElement(By.cssSelector("input#pass")).sendKeys("123456aA@");
        driver.findElement(By.cssSelector("button#send2")).click();
        // Tra ve 1 element- neu tim thay nhieu hon cung chi tra ve 1
        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-required-entry-email")), "This is a required field.");

    }

    @Test
    public void TC_05_Login_Sucess() {
        //Register
        String firstName = "Nga";
        String middleName = "Thi";
        String lastName = "Vu";
        String email = random.getEmailAddress();
        String pass = "12345aA@";
        driver.get("http://live.techpanda.org/index.php/customer/account/login/");
        driver.findElement(By.xpath("//span[text()='Account']")).click();
        driver.findElement(By.xpath("//a[text()='Register']")).click();
        driver.findElement(By.cssSelector("input#firstname")).sendKeys(firstName);
        driver.findElement(By.cssSelector("input#middlename")).sendKeys(middleName);
        driver.findElement(By.cssSelector("input#lastname")).sendKeys(lastName);
        driver.findElement(By.cssSelector("input#email_address")).sendKeys(email);

        driver.findElement(By.cssSelector("input#password")).sendKeys(pass);
        driver.findElement(By.cssSelector("input#confirmation")).sendKeys(pass);
        driver.findElement(By.cssSelector("input#is_subscribed")).click();
        driver.findElement(By.xpath("//button[@title='Register']")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//            Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg")),"");

        String expectedText = "Hello, ".concat(firstName).concat(" ").concat(middleName).concat(" ").concat(lastName).concat("!");

        Assert.assertEquals(driver.findElement(By.cssSelector("p.hello")).getText(), expectedText);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        //Logout
        driver.findElement(By.xpath("//span[text()='Account']")).click();
        driver.findElement(By.xpath("//a[text()='Log Out']")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        //Login
        driver.findElement(By.xpath("//span[text()='Account']")).click();
        driver.findElement(By.xpath("//a[text()='Log In']")).click();
        driver.findElement(By.cssSelector("input#email")).clear();
        driver.findElement(By.cssSelector("input#email")).sendKeys(email);
        driver.findElement(By.cssSelector("input#pass")).clear();
        driver.findElement(By.cssSelector("input#pass")).sendKeys(pass);
        driver.findElement(By.cssSelector("button#send2")).click();
    }

//
//    @AfterClass
//public void AfterClass(){
//    //Neu co 1 tab/window thi tinh nang tu quit
//    // Neu hơn 1 tab thi dong tab dang active
//    driver.close();
//
//    // Đóng browser, ko can biet bn tab/window
//    driver.quit();
//        }


}
