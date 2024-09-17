package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.Alert;
import java.util.concurrent.TimeUnit;

public class Topic_11_Alert {
    WebDriver driver;

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

    // @Test
    public void TC_01_jsAlert() {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        WebElement jsAlert = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));

        //scroll
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        sleepInSecond(2);
        //click button
        jsAlert.click();

        // Verify text in Alert
        String alertText = driver.switchTo().alert().getText();
        System.out.println("alert text" + alertText);
        Assert.assertEquals(alertText, "I am a JS Alert");

        //click OK
        driver.switchTo().alert().accept();
        //verify message
        sleepInSecond(2);
        Assert.assertEquals(driver.findElement(By.cssSelector("p#result")).getText(), "You clicked an alert successfully");

    }

    // @Test
    public void TC_02_jsConfirm_Alert() {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        WebElement jsConfirm = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));


        //scroll
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        sleepInSecond(2);
        //click button
        jsConfirm.click();
        //I am a JS Confirm
        String jsPromtText = driver.switchTo().alert().getText();
        Assert.assertEquals(jsPromtText, "I am a JS Confirm");

        //Cancel alert
        driver.switchTo().alert().dismiss();
        sleepInSecond(2);
        Assert.assertEquals(driver.findElement(By.cssSelector("p#result")).getText(), "You clicked: Cancel");

    }

    //  @Test
    public void TC_03_Promt_Alert() {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        WebElement jsPromt = driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
        sleepInSecond(2);
        //Scroll
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        sleepInSecond(2);
        //click button
        jsPromt.click();
        sleepInSecond(2);
        driver.switchTo().alert().sendKeys("Ngavt");
        driver.switchTo().alert().accept();
        sleepInSecond(2);
        Assert.assertEquals(driver.findElement(By.cssSelector("p#result")).getText(), "You entered: Ngavt");
    }

  //  @Test
    public void TC_04_Alert_Frame() {
        driver.get("https://netbanking.hdfcbank.com/netbanking/");
        //switch to frame
        driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='login_page']")));

        //Click continue
        driver.findElement(By.xpath("//a[text()='CONTINUE']/parent::div")).click();
        //verify text in alert
        Assert.assertEquals(driver.switchTo().alert().getText(),"Customer ID  cannot be left blank.");
    }
@Test
    public void TC_05_Alert_Authen(){
        String username = "admin";
        String password = "admin";
        driver.get("http://the-internet.herokuapp.com/basic_auth");

        driver.switchTo().defaultContent() ;

    driver.switchTo().alert().accept();
        Assert.assertEquals(driver.findElement(By.cssSelector("div#content p")),"Congratulations! You must have the proper credentials.");

    }
    public void sleepInSecond(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
