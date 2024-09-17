package webdriver;

import javaTester.Topic_06_Randon;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.support.Color;


import java.util.concurrent.TimeUnit;

public class Topic_09_Button {
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
   // @Test
    public void TC_01_Button(){
    driver.get("https://egov.danang.gov.vn/reg");
        WebElement registerButton = driver.findElement(By.cssSelector("input.egov-button"));
        //verify button bi disable khi chua click vao checkbox
        Assert.assertFalse(registerButton.isEnabled());
        //click checkbox
        driver.findElement(By.cssSelector("input#chinhSach")).click();
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        //verify button enable sau khi click checkbox
        Assert.assertTrue(registerButton.isEnabled());

        // Lay ra ma mau nen cua button
        String registerBackgroundRGB = registerButton.getCssValue("background-color");
        System.out.println("Background color RGB = "+registerBackgroundRGB);

        //Convert tu kieu Strong ma RGB qua kieu Color
        Color registerBackgroundColor= Color.fromString(registerBackgroundRGB);

        //Convert tu kieu Color qua Hexa
        String registerBackgroundHexa = registerBackgroundColor.asHex();
        System.out.println("registerBackgroundHexa = "+registerBackgroundHexa);
        //Convert lower/ upper letter


        Assert.assertEquals(registerBackgroundHexa.toLowerCase(),"#ef5a00");
        Assert.assertEquals(registerBackgroundHexa.toUpperCase(),"#EF5A00");
    }
   // @Test
    public void TC_02_Button(){
        driver.get("https://www.fahasa.com/customer/account/create");
        driver.findElement(By.cssSelector("li.popup-login-tab-login")).click();

        //Verify button dang nhap disable
        WebElement buttonLogin = driver.findElement(By.cssSelector("button.fhs-btn-login"));
        Assert.assertFalse(buttonLogin.isEnabled());

        //Verify mau cua button
        Assert.assertEquals(Color.fromString(buttonLogin.getCssValue("background-color")).asHex().toUpperCase(),"#000000");

        //input du lieu
        driver.findElement(By.cssSelector("input#login_username")).sendKeys("ngavt@gmail.com.vn");
        driver.findElement(By.cssSelector("input#login_password")).sendKeys("123456aA@");
        //Verify button dang nhap enable
        Assert.assertTrue(buttonLogin.isEnabled());

        //Verify mau cua button

        Assert.assertEquals(Color.fromString(buttonLogin.getCssValue("background-color")).asHex().toUpperCase(),"#C92127");

    }


}
