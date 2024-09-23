package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.lang.model.element.Element;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_20_FindElement_ImplicitWait {
    WebDriver driver;
    WebDriverWait implicitWait;
    @BeforeClass
    public void BeforeClass(){
        driver=new ChromeDriver();
        // implicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://facebook.com");
    }
    @Test
    public void TC_01_FindElement(){
        //Case 1 - Element được tìm thấy chỉ có 1
        // Sẽ ko cần chờ hết time out
        //Tìm thấy sẽ trả về 1 WebElement
        //Qua step tiếp theo
        System.out.println("Start Date "+getDateTimeNow());
        driver.findElement(By.cssSelector("input#email"));
        System.out.println("End Date "+getDateTimeNow());


    }
    @Test
    public void TC_02_FindElement(){
        //Case 2- Element tìm thấy nhưng có nhiều hơn 1
        // Sẽ ko cần chờ hết time out
        //Lấy cái element đầu tiên dù có cả n node
        //Qua step tiếp theo
        System.out.println("Start Date "+getDateTimeNow());
        driver.findElement(By.cssSelector("input[type='text'],[type='password']")).sendKeys("ngavt@gmail.com");
        System.out.println("End Date "+getDateTimeNow());
    }
    @Test
    public void TC_03_FindElement(){
        //Case 3- Element ko được tìm thấy
        //Chờ hết timeouts là 10s
        //Trong time 10s này cứ mỗi nửa giây lại tìm lại 1 lần
        //Nếu tìm lại mà thấy thì trả về element và qua step tiếp theo
        //Nếu tìm lại mà ko thấy thì fail case và throw Exception
        System.out.println("Start Date "+getDateTimeNow());
        driver.findElement(By.cssSelector("input#not-found"));
        System.out.println("End Date "+getDateTimeNow());
    }
    @Test
    public void TC_04_FindElements(){
        List<WebElement> elementList;
        //Case 1 - Element được tìm thấy chỉ có 1
        // Sẽ ko cần chờ hết time out
        //Trả về list chỉ có 1 element
//        System.out.println("Start Date "+getDateTimeNow());
//        elementList = driver.findElements(By.cssSelector("input#email"));
//        System.out.println("(1) List have: "+elementList.size());
//        System.out.println("End Date "+getDateTimeNow());


        //Case 2- Element tìm thấy nhưng có nhiều hơn 1
        //Sẽ ko cần chờ hết time out
        //TRả về list chứa nhiều element
//        System.out.println("Start Date "+getDateTimeNow());
//        elementList= driver.findElements(By.cssSelector("input[type='text'],[type='password']"));
//        System.out.println("(2) List have: "+elementList.size());
//        System.out.println("End Date "+getDateTimeNow());

//Case 3 - Element ko đc tìm thấy
        //Chờ hết time là 10s
        //Mỗi nửa s lại tìm 1 lần
        // Nếu tìm thấy trả về 1 list
        // Nếu ko tìm thấy, ko đánh fail TCs, thực hiện các step tiếp theo
        System.out.println("Start Date "+getDateTimeNow());
        elementList = driver.findElements(By.cssSelector("input#not-found"));
        System.out.println("List have "+elementList.size());
        System.out.println("End Date "+getDateTimeNow());
    }
    public static String getDateTimeNow(){
        Date date = new Date();
        return date.toString();
    }
}
