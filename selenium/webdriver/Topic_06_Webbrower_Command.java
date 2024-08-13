package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class Topic_06_Webbrower_Command {

    WebDriver driver;
    @BeforeClass
    public void BeforeClass(){
        //Muon dung duoc phai khoi tao
        //Neu ko khoi tao: Lỗi NullPointerException
        driver = new ChromeDriver();
        driver= new FirefoxDriver();
        driver= new EdgeDriver();
        driver= new InternetExplorerDriver();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        driver.quit();
    }
}
