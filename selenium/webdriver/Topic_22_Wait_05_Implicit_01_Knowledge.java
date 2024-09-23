package webdriver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_22_Wait_05_Implicit_01_Knowledge {
    WebDriver driver;
    WebDriverWait emplicitWait; // Khai báo nhưng chưa khởi tạo
    WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    @BeforeClass
    public void BeforeClass()// Pre-condition, khởi tạo dữ liệu ở đây
    {
        driver = new ChromeDriver();
        // Khởi tạo 1 emplicit Wait có tổng thời gian là 10s - polling là 0.5s mặc định
        //500 mili Second = 0.5 second
        emplicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Khởi tạo 1 emplicit Wait có tổng thời gian là 10s - polling là 0.3s
        emplicitWait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofMillis(300));
    }
    @Test
    public void TC_01(){
        //Chờ cho 1 alert present ở trong HTML/ DOM trước khi thao tác lên
       Alert alert =  emplicitWait.until(ExpectedConditions.alertIsPresent());
        //Chờ cho 1 element còn ở trong DOM
        emplicitWait.until(ExpectedConditions.stalenessOf(driver.findElement(By.cssSelector(""))));

        //Chờ 1 element có trong DOM, ko quan tâm có trên UI ko?
        emplicitWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("")));

        //Chờ 1 list element có trong DOM, ko quan tâm có trên UI ko?
        emplicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("")));

        //Chờ 1-n element được hiển thị trong DOM
        emplicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("")));
        emplicitWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(""))));
        emplicitWait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.cssSelector(""))));
        emplicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("")));


        // Chờ cho element có thể click được như button/ link/ icon/..
        emplicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("")));

        // Chờ cho page hiện tại có title như mong đợi
        emplicitWait.until(ExpectedConditions.titleIs(""));
        driver.getTitle();

        // Kết hợp nhiều điều kiện, các điều kiện đều đúng
        emplicitWait.until(ExpectedConditions.and(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("")), ExpectedConditions.elementToBeClickable(By.cssSelector(""))
        ));

        // Kết hợp nhiều điều kiện, có ít nhất 1 đk đúng
        emplicitWait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("")), ExpectedConditions.elementToBeClickable(By.cssSelector(""))
        ));

        emplicitWait.until(ExpectedConditions.attributeContains(driver.findElement(By.cssSelector("")),"",""));

    }


}
